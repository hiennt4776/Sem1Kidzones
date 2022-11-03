package edu.softech.shoesShop.controller.site;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.softech.shoesShop.domain.Brand;
import edu.softech.shoesShop.domain.Customer;
import edu.softech.shoesShop.model.BrandDto;
import edu.softech.shoesShop.model.ChangePasswordDto;
import edu.softech.shoesShop.model.CustomerChangePassword;
import edu.softech.shoesShop.model.CustomerInfoDto;
import edu.softech.shoesShop.model.CustomerLoginDto;
import edu.softech.shoesShop.model.CustomerRegisterDto;
import edu.softech.shoesShop.service.CustomerService;

@Controller
public class SiteCustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private HttpSession session;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("slogin")
	public String login(ModelMap model) {
		model.addAttribute("customer", new CustomerLoginDto());
		return "/site/login";
	}
	
	@PostMapping("slogin")
	public ModelAndView login(ModelMap model, @Valid @ModelAttribute("customer") CustomerLoginDto dto, BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("/site/login", model);
		}
		Customer customer = customerService.login(dto.getUsername(), dto.getPassword());
		
		if(customer == null) {
			model.addAttribute("message", "Invalid username or password");
			return new ModelAndView("/site/login", model);
		}
		session.setAttribute("customer_session", customer);
		

		return new ModelAndView("redirect:/site/home", model);
	}
	
	@GetMapping("sRegister")
	public String register(ModelMap model) {
		model.addAttribute("customer", new CustomerRegisterDto());
		return "/site/register";
	}
	
	@PostMapping("sRegister")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("customer") CustomerRegisterDto dto,
			BindingResult result, RedirectAttributes re) {
		
		if(result.hasErrors() ) {
			return new ModelAndView("/site/register");
		}
		
		Customer entity = new Customer();
		
		BeanUtils.copyProperties(dto, entity);
				
		customerService.save(entity);		
		return new ModelAndView("redirect:/slogin");
		//return "";
	}
	
	@GetMapping("customerInfo")
	public ModelAndView customerInfo(ModelMap model) {
		Customer customer = (Customer)session.getAttribute("customer_session");
		CustomerInfoDto customerInfoDto = new CustomerInfoDto();
		
		BeanUtils.copyProperties(customer, customerInfoDto);
		
		model.addAttribute("customerInfo",customerInfoDto);
		
		return new ModelAndView("site/customer/customerInfo", model);
	}
	
	@PostMapping("saveCustomerInfo")
	public ModelAndView saveCustomerInfo(ModelMap model, @Valid @ModelAttribute("customer") CustomerInfoDto dto, BindingResult result) {
		
		if(result.hasErrors()) {
			return new ModelAndView("site/customer/customerInfo");
		}
		Customer customer = (Customer)session.getAttribute("customer_session");
		Long customerId = customer.getCustomerId();
		System.out.println(customerId);
		
		customerService.updateCustomerInfo(dto.getName(), dto.getPhone(), dto.getAddress(), dto.getEmail(), customerId);
		session.removeAttribute("customer_session");
		Customer cusChange = customerService.findById(customerId).get();
		session.setAttribute("customer_session", cusChange);
		model.addAttribute("message","Customer is saved!");
		
		return new ModelAndView("redirect:/site/home", model);
	}
	
	
	@RequestMapping("changeCustomerPassword")
	public String changeCustomerPassword(ModelMap model) {
		
		CustomerChangePassword dto = new CustomerChangePassword();
		model.addAttribute("changePassword", dto);
		model.addAttribute("page", "changePassword");
		
		return "site/customer/changePassword";
	}
	
	@PostMapping("changeCustomerPassword")
	public String saveChangePassword(ModelMap model, @Valid @ModelAttribute("customer") CustomerChangePassword dto, BindingResult result) {
		Customer customerSS = (Customer)session.getAttribute("customer_session");
		
		Customer customer = customerService.findById(customerSS.getCustomerId()).get();
		
		if(bCryptPasswordEncoder.matches(dto.getOldPassword(), customer.getPassword())) {
			customer.setPassword(bCryptPasswordEncoder.encode(dto.getNewPassword()));
			customerService.save(customer);
			
			model.addAttribute("message","Password is reset!");
			
			return "forward:/changeCustomerPassword";
		}
		model.addAttribute("message","Old Password Invalid!!");
		return "forward:/changeCustomerPassword";
	}

	@GetMapping("sLogout")
	public String logout(ModelMap model) {
		session.removeAttribute("customer_session");
		return "redirect:/slogin";
	}
}
