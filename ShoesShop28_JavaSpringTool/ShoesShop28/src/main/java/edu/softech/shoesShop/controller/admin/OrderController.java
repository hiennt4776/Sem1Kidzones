package edu.softech.shoesShop.controller.admin;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.softech.shoesShop.domain.Employee;
import edu.softech.shoesShop.domain.Order;
import edu.softech.shoesShop.domain.OrderDetail;
import edu.softech.shoesShop.domain.Shipment;
import edu.softech.shoesShop.domain.Shoes;
import edu.softech.shoesShop.model.EmployeeDto;
import edu.softech.shoesShop.model.OrderDto;
import edu.softech.shoesShop.model.ResetPasswordDto;
import edu.softech.shoesShop.model.ShoesSizeDto;
import edu.softech.shoesShop.model.ShoesTypeDto;
import edu.softech.shoesShop.service.CustomerService;
import edu.softech.shoesShop.service.EmployeeService;
import edu.softech.shoesShop.service.OrderDetailService;
import edu.softech.shoesShop.service.OrderService;
import edu.softech.shoesShop.service.ShipmentService;
import edu.softech.shoesShop.service.ShoesService;
import edu.softech.shoesShop.service.ShoesSizeService;
import edu.softech.shoesShop.service.ShoesTypeService;


@Controller
@RequestMapping("admin/orders")
public class OrderController {
	
	@Autowired
	ShoesService shoesService;
	@Autowired
	EmployeeService employeeService;
	@Autowired
	OrderService orderService;
	@Autowired
	CustomerService customerService;
	@Autowired
	ShipmentService shipmentService;
	@Autowired
	OrderDetailService orderDetailService;
	@Autowired
	ShoesTypeService shoesTypeService;
	@Autowired
	private HttpSession session;
	@Autowired
	ShoesSizeService shoesSizeService;
	
	@ModelAttribute("employees")
	public List<EmployeeDto> getEmployees(){
		return employeeService.findAll().stream().map(item -> {
			EmployeeDto dto = new EmployeeDto();
			BeanUtils.copyProperties(item, dto);
			return dto;
		}).toList();
	}
	@ModelAttribute("shoesSizes")
	public List<ShoesSizeDto> getShoesSizes(){
		return shoesSizeService.findAll().stream().map(item -> {
			ShoesSizeDto dto = new ShoesSizeDto();
			BeanUtils.copyProperties(item, dto);
			return dto;
		}).toList();
	}
	
	@ModelAttribute("shoesTypes")
	public List<ShoesTypeDto> getShoesTypes(){
		return shoesTypeService.findByIsDelete(false).stream().map(item -> {
			ShoesTypeDto dto = new ShoesTypeDto();
			BeanUtils.copyProperties(item, dto);
			return dto;
		}).toList();
	}

	@RequestMapping("")
	public String list(ModelMap model) {
		List<Order> list = orderService.findAll();
		model.addAttribute("orders",list);
		System.out.println("list order");
		System.out.println(list);
		
		model.addAttribute("page", "order");
		return "admin/orders/list";	
	}
	
	@GetMapping("deliver/{orderId}")
	public ModelAndView deliver(ModelMap model, @PathVariable("orderId") Long orderId) {
		Optional<Order> opt = orderService.findById(orderId);
		OrderDto dto = new OrderDto();
		model.addAttribute("page", "order");
		if(opt.isPresent()) {
			Order order = opt.get();
			BeanUtils.copyProperties(order, dto);
			
			if(order.getStatus().equals("Completed")) {
				model.addAttribute("message", "this order is completed!");
				return new ModelAndView("forward:/admin/orders", model);
			}
				
			Shipment shipment = order.getShipment();
			model.addAttribute("shipment",shipment);
			
			dto.setOrderDate(order.getOrderDate());
			System.out.println(dto.getOrderDate());
			
			dto.setShipDate(order.getShipDate());
			System.out.println(dto.getShipDate());
			
			dto.setShipmentId(order.getShipment().getShipmentId());
			System.out.println(dto.getShipmentId());
			model.addAttribute("order",dto);
			return new ModelAndView("admin/orders/deliver", model);
		}
		model.addAttribute("message", "Order is not existed");
		
		return new ModelAndView("forward:/admin/orders", model);
	}
	
	@PostMapping("saveDeliver")
	public ModelAndView saveDeliver(ModelMap model, @Valid @ModelAttribute("order") OrderDto dto,  BindingResult result) {
		System.out.println(dto.getShipDate());
	

		Optional<Order> opt = orderService.findById(dto.getOrderId());		
		Order order = opt.get();
		
		Object employeeIdObj = session.getAttribute("employeeId");
		Long employeeIdLong =  ((Long)employeeIdObj).longValue();
		
		Employee employee = new Employee();
		employee.setEmployeeId(employeeIdLong);
		order.setEmployee(employee);
		
		order.setShipDate(dto.getShipDate());
		order.setStatus("Delivering");
		orderService.save(order);
		return new ModelAndView("forward:/admin/orders", model);
	}
	
	
	@GetMapping("completed/{orderId}")
	public ModelAndView completed(ModelMap model, @PathVariable("orderId") Long orderId) {
		Optional<Order> opt = orderService.findById(orderId);
		
		
		Object employeeIdObj = session.getAttribute("employeeId");
		Long employeeIdLong =  ((Long)employeeIdObj).longValue();
		if(opt.isPresent()) {
			Order order = opt.get();
			Employee employee = new Employee();
			employee.setEmployeeId(employeeIdLong);
			order.setEmployee(employee);
			order.setStatus("Completed");
			orderService.save(order);
			model.addAttribute("message", "Order is completed!");
			
		}
		else {
			model.addAttribute("message", "Order is not existed");
		}
		
		
		return new ModelAndView("forward:/admin/orders", model);
	}
	
	@GetMapping("unCompleted/{orderId}")
	public ModelAndView unCompleted(ModelMap model, @PathVariable("orderId") Long orderId) {
		Optional<Order> opt = orderService.findById(orderId);
		
		
		Object employeeIdObj = session.getAttribute("employeeId");
		Long employeeIdLong =  ((Long)employeeIdObj).longValue();
		if(opt.isPresent()) {
			Order order = opt.get();
			
			if(order.getStatus().equals("Delivering")) {
				model.addAttribute("message", "this order not completed!");
				return new ModelAndView("forward:/admin/orders", model);
			}
			
			Employee employee = new Employee();
			employee.setEmployeeId(employeeIdLong);
			order.setEmployee(employee);
			order.setStatus("Delivering");
			orderService.save(order);
			model.addAttribute("message", "Order is Delivering!");
			
		}
		else {
			model.addAttribute("message", "Order is not existed");
		}
		
		
		return new ModelAndView("forward:/admin/orders", model);
	}

	
	@GetMapping("view/{orderId}")
	public ModelAndView view(ModelMap model, @PathVariable("orderId") Long orderId) {
		Optional<Order> opt = orderService.findById(orderId);
		
		if(opt.isPresent()) {
			Order order = opt.get();
			model.addAttribute("order",order);
			
			List<OrderDetail> orderDetails = orderDetailService.findByOrder(order);
			model.addAttribute("orderDetails",orderDetails);
			return new ModelAndView("admin/orders/view", model);
		}
		model.addAttribute("message", "Order is not existed");
		model.addAttribute("page", "order");
		return new ModelAndView("forward:/admin/orders", model);
	}
	
	@GetMapping("filterpaginated")
	public String filter(ModelMap model,
			@RequestParam("status") Optional<String> status,		
			@RequestParam("employeeId") Optional<Long> employeeId,
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size
		) {
			model.addAttribute("page", "order");
			
			int currentPage = page.orElse(1);
			int pageSize = size.orElse(5);
			String statusFilter = status.orElse("");
			
			Pageable pageable = PageRequest.of(currentPage-1, pageSize);
			Page<Order> resultPage = null;
	
			
			Long LongEmployeeId = 0l;
		
			if(!employeeId.isEmpty()) LongEmployeeId = employeeId.get();
		
			
			System.out.println("status = " + statusFilter);
			System.out.println("Long employee = " + LongEmployeeId);
			
			if(LongEmployeeId == -1) {
		
				if(StringUtils.hasText(statusFilter))
					resultPage = orderService.findEmployeeNullAndStatus(statusFilter,pageable);
				else 
					resultPage = orderService.findEmployeeNull(pageable);
					 
			}
			else {
				if((LongEmployeeId == 0) && StringUtils.hasText(statusFilter)) {
					resultPage = orderService.findByStatus(statusFilter, pageable);
				}
				else if((LongEmployeeId != 0) && !StringUtils.hasText(statusFilter)) {
				
					Employee employee = employeeService.findById(LongEmployeeId).get();
					resultPage = orderService.findByEmployee(employee, pageable);
				}
				else if((LongEmployeeId != 0) && StringUtils.hasText(statusFilter)) {
					Employee employee = employeeService.findById(LongEmployeeId).get();
					resultPage = orderService.findByStatusAndEmployee(statusFilter,employee, pageable);
				}
				else {
					resultPage = orderService.findAll(pageable);
				}
			}

			int totalPages = resultPage.getTotalPages();
			if(totalPages > 0) {
				int start = Math.max(1,currentPage - 2);
				int end = Math.min(currentPage + 2, totalPages);
				
				if(totalPages > 5) {
					if(end == totalPages) start = end - 5;
					else if(start == 1) end = start + 5;
				}
				
				List<Integer> pageNumbers = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
				
				model.addAttribute("pageNumbers", pageNumbers);
			}

			
			model.addAttribute("orderPage", resultPage);
	
			return "admin/orders/filterpaginated";
	}
}
	
	

