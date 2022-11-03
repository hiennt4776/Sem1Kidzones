package edu.softech.shoesShop.controller.admin;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

import edu.softech.shoesShop.domain.Customer;
import edu.softech.shoesShop.domain.Employee;
import edu.softech.shoesShop.domain.Order;
import edu.softech.shoesShop.domain.Shoes;
import edu.softech.shoesShop.model.EmployeeDto;
import edu.softech.shoesShop.service.EmployeeService;
import edu.softech.shoesShop.service.OrderService;
import edu.softech.shoesShop.service.ShoesService;


@Controller
@RequestMapping("admin/employees")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	OrderService orderService;
	@Autowired
	ShoesService shoesService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("add")
	public String add(Model model) {
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setGender(true);
		employeeDto.getPassword();
		System.out.println("getPassword: " + employeeDto.getPassword());
		model.addAttribute("employee", employeeDto);
		
		model.addAttribute("page", "employee");
		return "admin/employees/addOrEdit";
	}
	
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("employee") EmployeeDto dto, BindingResult result) {	
		if(result.hasErrors()) {
			return new ModelAndView("admin/employees/addOrEdit");
		}
		Optional<Employee> employeeCheckDouble = employeeService.findByUsernameAndIsDelete(dto.getUsername(), false);
		if(employeeCheckDouble.isPresent()) {
			if(dto.getIsEdit()) {
				if(employeeCheckDouble.get().getEmployeeId() != dto.getEmployeeId()) {
					model.addAttribute("message", "username already exists!");
					return new ModelAndView("admin/employees/addOrEdit");
				}
					
			}
			else {
				model.addAttribute("message", "username already exists!");
				return new ModelAndView("admin/employees/addOrEdit");
			}
		}
		
		Employee entity = new Employee();
		BeanUtils.copyProperties(dto, entity);
		if(dto.getIsEdit()) {
			Optional<Employee> opt = employeeService.findById(dto.getEmployeeId());
			String password = opt.get().getPassword();
			entity.setPassword(password);
		}
		else {
			entity.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
		}
		
		employeeService.save(entity);
		model.addAttribute("message","employees is saved!");
		model.addAttribute("page", "employee");
		return new ModelAndView("forward:/admin/employees", model);
	}
	
	
	@GetMapping("edit/{employeeId}")
	public ModelAndView edit(ModelMap model, @PathVariable("employeeId") Long employeeId) {
		Optional<Employee> opt = employeeService.findById(employeeId);
		EmployeeDto dto = new EmployeeDto();
		
		if(opt.isPresent()) {
			Employee entity = opt.get();
			BeanUtils.copyProperties(entity, dto);
			dto.setIsEdit(true);
			model.addAttribute("employee",dto);
			System.out.println("getPassword:" + dto.getPassword());
			return new ModelAndView("admin/employees/addOrEdit", model);
		}
		model.addAttribute("message", "Employee is not existed");
		model.addAttribute("page", "employee");
		return new ModelAndView("forward:/admin/employees", model);
	}
	
	@RequestMapping("")
	public String list(ModelMap model) {
		List<Employee> list = employeeService.findByIsDelete(false);
		model.addAttribute("page", "employee");
		model.addAttribute("employees",list);
		return "admin/employees/list";	
	}
	
	@GetMapping("delete/{employeeId}")
	public ModelAndView delete(ModelMap model, @PathVariable("employeeId") Long employeeId) {
		Optional<Employee> opt = employeeService.findById(employeeId);
		
		if(opt.isPresent()) {
			Employee entity = opt.get();
			List<Order> order = orderService.findByEmployee(entity);
			List<Shoes> shoes = shoesService.findByEmployee(entity);
			if(order.isEmpty() && shoes.isEmpty()) {
				entity.setDelete(true);
				employeeService.save(entity);
				model.addAttribute("message", "Employee is deleted!");
			}
			else {
				model.addAttribute("message", "Employee cannot delete because it's used");
			}
			
		}
		else
		model.addAttribute("message", "Employee is not existed");
		
		return new ModelAndView("forward:/admin/employees", model);
	}
	
	@GetMapping("view/{employeeId}")
	public ModelAndView view(ModelMap model, @PathVariable("employeeId") Long employeeId) {
		Optional<Employee> opt = employeeService.findById(employeeId);
		model.addAttribute("page", "employee");
		
		if(opt.isPresent()) {
			Employee employee = opt.get();
			model.addAttribute("employee", employee);
			return new ModelAndView("admin/employees/view", model);
		}
		model.addAttribute("message", "Customer is not existed");
		return new ModelAndView("forward:/admin/employees", model);
	}
	
	@GetMapping("search")
	public String search(ModelMap model, @RequestParam(name = "name", required = false) String name) {
		List<Employee> list = null;
		model.addAttribute("page", "employee");
		if(StringUtils.hasText(name)) {
			list = employeeService.findByNameContainingAndIsDelete(name,false);
		}else {
			list = employeeService.findByIsDelete(false);
		}
		model.addAttribute("shoesTypes", list);
		return "admin/shoesTypes/search";
	}
	
	@GetMapping("searchpaginated")
	public String search(ModelMap model, 
			@RequestParam(name = "name", required = false) String name,
			@RequestParam("status") Optional<String> status,
			@RequestParam("role") Optional<String> role,
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		
		model.addAttribute("page", "employee");
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);
		String roleFilter = role.orElse("");
		String statusFilter = status.orElse("");
				
		Pageable pageable = PageRequest.of(currentPage-1, pageSize, Sort.by("name"));
		Page<Employee> resultPage = null;
		
		System.out.println("roleFilter:" + roleFilter);
		System.out.println("statusFilter:" + statusFilter);
		
		if(StringUtils.hasText(name)) {
			model.addAttribute("name", name);
		}

		resultPage = employeeService.findByIsDelete(false,pageable);
		
		if(StringUtils.hasText(name) && StringUtils.hasText(roleFilter) && StringUtils.hasText(statusFilter)) {
			resultPage = employeeService.findByNameContainingAndRoleAndStatusAndIsDelete(name, roleFilter, statusFilter, false, pageable);
		}else if(StringUtils.hasText(name) && StringUtils.hasText(roleFilter) && !StringUtils.hasText(statusFilter)) {
			resultPage = employeeService.findByNameContainingAndRoleAndIsDelete(name, roleFilter, false, pageable);
		}else if(StringUtils.hasText(name) && !StringUtils.hasText(roleFilter) && StringUtils.hasText(statusFilter)) {
			resultPage = employeeService.findByNameContainingAndStatusAndIsDelete(name, statusFilter, false, pageable);
		}else if(StringUtils.hasText(name) && !StringUtils.hasText(roleFilter) && !StringUtils.hasText(statusFilter)) {
			resultPage = employeeService.findByNameContainingAndIsDelete(name, false, pageable);
		}else if(!StringUtils.hasText(name) && StringUtils.hasText(roleFilter) && StringUtils.hasText(statusFilter)) {
			resultPage = employeeService.findByRoleAndStatusAndIsDelete(roleFilter, statusFilter, false, pageable);
		}else if(!StringUtils.hasText(name) && StringUtils.hasText(roleFilter) && !StringUtils.hasText(statusFilter)) {
			resultPage = employeeService.findByRoleAndIsDelete(statusFilter, false, pageable);
		}else if(!StringUtils.hasText(name) && !StringUtils.hasText(roleFilter) && StringUtils.hasText(statusFilter)) {
			resultPage = employeeService.findByStatusAndIsDelete(statusFilter, false, pageable);
		}else {
			resultPage = employeeService.findByIsDelete(false, pageable);
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
		
		model.addAttribute("employeePage", resultPage);
		return "admin/employees/searchpaginated";
	}

}
