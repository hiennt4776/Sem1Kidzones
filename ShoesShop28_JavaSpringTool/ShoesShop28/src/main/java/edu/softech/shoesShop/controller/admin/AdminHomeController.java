package edu.softech.shoesShop.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.softech.shoesShop.service.CustomerService;
import edu.softech.shoesShop.service.OrderService;
import edu.softech.shoesShop.service.ShoesService;
import edu.softech.shoesShop.service.ShoesTypeService;

@Controller
@RequestMapping("admin")
public class AdminHomeController {
	@Autowired
	ShoesTypeService shoesTypeService;
	@Autowired
	CustomerService customerService;
	@Autowired
	ShoesService shoesService;
	@Autowired
	OrderService orderService;
	@RequestMapping("")
	public String index(ModelMap model){
		model.addAttribute("page", "dashboard");
		Long totalShoesType = shoesTypeService.countByIsDelete(false);
		model.addAttribute("shoesType", totalShoesType);
		
		Long totalShoes = shoesService.totalQuantityShoes();
		model.addAttribute("totalShoes", totalShoes);
		
		Long totalCustomers = customerService.count();
		model.addAttribute("totalCustomers", totalCustomers);
		
		Long totalOrders = orderService.count();
		model.addAttribute("totalOrders", totalOrders);
		
		
		
		return "admin/adminHome/index";
	}
	

}
