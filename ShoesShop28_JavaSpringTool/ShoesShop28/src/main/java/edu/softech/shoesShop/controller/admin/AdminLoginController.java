package edu.softech.shoesShop.controller.admin;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.softech.shoesShop.domain.Employee;
import edu.softech.shoesShop.model.AdminLoginDto;
import edu.softech.shoesShop.service.EmployeeService;

@Controller
public class AdminLoginController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private HttpSession session;
	
	@GetMapping("alogin")
	public String login(ModelMap model) {
		model.addAttribute("employee", new AdminLoginDto());
		session.removeAttribute("username");
		session.removeAttribute("employeeId");
		return "admin/employees/login";
	}
	
	@PostMapping("alogin")
	public ModelAndView login(ModelMap model, @Valid @ModelAttribute("employee") AdminLoginDto dto, BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("admin/employees/login", model);
		}
		Employee employee = employeeService.login(dto.getUsername(), dto.getPassword());
		
		if(employee == null) {
			model.addAttribute("message", "Invalid username or password");
			return new ModelAndView("admin/employees/login", model);
		}
		session.setAttribute("username", employee.getUsername());
		session.setAttribute("employeeId", employee.getEmployeeId());
		session.setAttribute("fullname", employee.getName());
		model.addAttribute("fullname", employee.getName());
		
		Object ruri = session.getAttribute("redirect-uri");
		
		if(ruri != null) {
			session.removeAttribute("redirect-uri");
			return new ModelAndView("redirect:" + ruri);
		}
		

		return new ModelAndView("forward:admin", model);
	}
	
	
}
