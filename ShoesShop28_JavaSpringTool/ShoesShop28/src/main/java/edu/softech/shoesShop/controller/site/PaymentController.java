package edu.softech.shoesShop.controller.site;
import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import edu.softech.shoesShop.config.PaypalPaymentIntent;
import edu.softech.shoesShop.config.PaypalPaymentMethod;
import edu.softech.shoesShop.domain.Customer;
import edu.softech.shoesShop.domain.Order;
import edu.softech.shoesShop.domain.OrderDetail;
import edu.softech.shoesShop.domain.Shipment;
import edu.softech.shoesShop.domain.Shoes;
import edu.softech.shoesShop.model.Cart;
import edu.softech.shoesShop.model.CartItem;
import edu.softech.shoesShop.model.ShipmentDto;
import edu.softech.shoesShop.repository.ShoesRepository;
import edu.softech.shoesShop.service.OrderDetailsService;
import edu.softech.shoesShop.service.OrderService;
import edu.softech.shoesShop.service.PaypalService;
import edu.softech.shoesShop.service.ShipmentService;
import edu.softech.shoesShop.util.Utils;

@Controller
public class PaymentController {
	public static final String URL_PAYPAL_SUCCESS = "pay/success";
	public static final String URL_PAYPAL_CANCEL = "pay/cancel";
	private Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private PaypalService paypalService;
	
	@Autowired
	private ShipmentService shipmentService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderDetailsService orderDetailsService;
	
	@Autowired
	private ShoesRepository shoesRepository;
	
	@Autowired
	private HttpSession session;
	
	@GetMapping("/checkout")
	public String index(){
		return "site/checkout/index";
	}
	@PostMapping("/pay")
	public String pay(HttpServletRequest request,@RequestParam("price") String price ){
		String cancelUrl = Utils.getBaseURL(request) + "/" + URL_PAYPAL_CANCEL;
		String successUrl = Utils.getBaseURL(request) + "/" + URL_PAYPAL_SUCCESS;
		
		
		double totalPrice =  Double.parseDouble(price);
		
		try {
			Payment payment = paypalService.createPayment(
					totalPrice,
					"USD",
					PaypalPaymentMethod.paypal,
					PaypalPaymentIntent.sale,
					"payment description",
					cancelUrl,
					successUrl);
			for(Links links : payment.getLinks()){
				if(links.getRel().equals("approval_url")){
					return "redirect:" + links.getHref();
				}
			}
		} catch (PayPalRESTException e) {
			log.error(e.getMessage());
		}
		return "redirect:/site/home";
	}
	@GetMapping(URL_PAYPAL_CANCEL)
	public String cancelPay(){
		return "site/checkout/cancel";
	}
	@GetMapping(URL_PAYPAL_SUCCESS)
	public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId){
		try {
			Payment payment = paypalService.executePayment(paymentId, payerId);
			if(payment.getState().equals("approved")){
				return "redirect:/shipment";
			}
		} catch (PayPalRESTException e) {
			log.error(e.getMessage());
		}
		return "redirect:/site/home";
	}
	
	@GetMapping("/shipment")
	public String shipment(ModelMap model){
		model.addAttribute("shipment", new ShipmentDto());
		
		return "site/checkout/shipment";
	}
	
	@PostMapping("saveShipment")
	public ModelAndView save(ModelMap model, @Valid @ModelAttribute("shipment") ShipmentDto dto, BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("redirect:/pay/cancel");
		}
		
		Shipment entity = new Shipment();
		BeanUtils.copyProperties(dto, entity);
		
		//brandService.save(entity);
		shipmentService.save(entity);
		model.addAttribute("message","brand is saved!");
		model.addAttribute("page", "brand");
		
		Customer customer = (Customer)session.getAttribute("customer_session");
		Cart cart = (Cart)session.getAttribute("cartSession");
		
		//them order
		Order order = new Order();
		order.setCustomer(customer);
		order.setGrandTotal(cart.total);
		order.setShipment(entity);
		order.setStatus("Processing");
		Date orderDate = new Date();
		order.setOrderDate(orderDate);
		orderService.save(order);
		
		
		//them orderDetails
		for(CartItem item : cart.getItems()) {
			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setOrder(order);
			orderDetail.setQuantity(item.getQuantity());
			orderDetail.setShoes(item.getShoes());
			orderDetail.setUnitPrice(item.getShoesType().getUnitPrice());
			
			//tru shoes quantity
			Optional<Shoes> otpShoes = shoesRepository.findById(item.getShoes().getShoesId());
			Shoes shoes = otpShoes.get();
			shoes.setQuantity(shoes.getQuantity() - item.getQuantity());
			if(shoes.getQuantity() - item.getQuantity() == 0) {
				shoes.setStatus("Out of stock");
			}
			shoesRepository.save(shoes);
			
			
			orderDetailsService.save(orderDetail);
		}
		
		
		
		
		return new ModelAndView("redirect:/paySuccess", model);
	}
	
	@GetMapping("/paySuccess")
	public String paySuccess(){
		
		
		return "site/checkout/success";
	}
}
