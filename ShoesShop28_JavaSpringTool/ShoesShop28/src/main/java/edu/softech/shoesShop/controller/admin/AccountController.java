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
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import edu.softech.shoesShop.model.AdminLoginDto;
import edu.softech.shoesShop.model.ChangePasswordDto;
import edu.softech.shoesShop.model.EmployeeDto;
import edu.softech.shoesShop.model.ResetPasswordDto;
import edu.softech.shoesShop.service.EmployeeService;

@Controller
@RequestMapping("admin/accounts")
public class AccountController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private HttpSession session;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping("")
	public String list(ModelMap model) {
		List<Employee> list = employeeService.findByIsDelete(false);
		model.addAttribute("page", "resetPassword");
		model.addAttribute("employees",list);
		return "admin/accounts/listResetPassword";
		
	}
	
	@GetMapping("searchResetPassword")
	public String search(ModelMap model, 
			@RequestParam(name = "name", required = false) String name,
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		
		model.addAttribute("page", "resetPassword");
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);
		
				
		Pageable pageable = PageRequest.of(currentPage-1, pageSize, Sort.by("name"));
		Page<Employee> resultPage = null;
		
	
		if(StringUtils.hasText(name)) {
			model.addAttribute("name", name);
		}
		
		resultPage = employeeService.findByIsDelete(false,pageable);
		
				
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
		return "admin/accounts/searchResetPassword";
	}
	
	@GetMapping("resetPassword/{employeeId}")
	public ModelAndView resetPassword(ModelMap model, @PathVariable("employeeId") Long employeeId) {
		Optional<Employee> opt = employeeService.findById(employeeId);
		ResetPasswordDto dto = new ResetPasswordDto();
		model.addAttribute("page", "resetPassword");
		if(opt.isPresent()) {
			//Employee entity = opt.get();
			dto.setEmployeeId(employeeId);
//			BeanUtils.copyProperties(entity, dto);
			System.out.println("getNewPassword: " + dto.getNewPassword());
			model.addAttribute("resetPassword",dto);
			
			
			
			return new ModelAndView("admin/accounts/resetPassword", model);
		}
		model.addAttribute("message", "Employee is not existed");
		
		return new ModelAndView("forward:/admin/accounts", model);
	}
	
	
	
	@PostMapping("saveResetPassword")
	public ModelAndView saveResetPassword(ModelMap model, @Valid @ModelAttribute("resetPassword") ResetPasswordDto dto, BindingResult result) {
		if(result.hasErrors()) {
			return new ModelAndView("admin/accounts/resetPassword");
		}
		
		
		System.out.println("saveResetPassword");		
		System.out.println("dto.getEmployeeId()" + dto.getEmployeeId());
		Optional<Employee> opt = employeeService.findById(dto.getEmployeeId());		
		System.out.println(opt);		
		Employee entity = opt.get();		
		System.out.println(entity);		
		entity.setPassword(bCryptPasswordEncoder.encode(dto.getNewPassword()));
		System.out.println(entity);		
		employeeService.save(entity);
		model.addAttribute("message","password is reset!");
		model.addAttribute("page", "resetPassword");
		return new ModelAndView("forward:/admin/accounts", model);
	}
	

	@RequestMapping("changePassword")
	public String changePassword(ModelMap model) {
		
		ChangePasswordDto dto = new ChangePasswordDto();
//		dto.setOldPassword("");
//		dto.setNewPassword("");
//		dto.setConfirmPassword("");
//		
		model.addAttribute("changePassword", dto);
		model.addAttribute("page", "changePassword");
		return "admin/accounts/changePassword";
	}
	@PostMapping("saveChangePassword")
	public String saveChangePassword(ModelMap model, @Valid @ModelAttribute("employee") ChangePasswordDto dto, BindingResult result) {
		
		model.addAttribute("page", "changePassword");
		Object employeeIdObj = session.getAttribute("employeeId");
		Long employeeIdLong =  ((Long)employeeIdObj).longValue();
		
		dto.setEmployeeId(employeeIdLong);
		Optional<Employee> optExist = employeeService.findById(dto.getEmployeeId());		
		System.out.println( "dto.getEmployeeId():" + dto.getEmployeeId());
		System.out.println( "dto.getOldPassword():" + dto.getOldPassword() );
		System.out.println( "dto.getNewPassword():" + dto.getNewPassword() );
		System.out.println( "dto.getConfirmPassword():" + dto.getConfirmPassword() );
		
		
		if(optExist.isPresent() && bCryptPasswordEncoder.matches(dto.getOldPassword(), optExist.get().getPassword())) {
		
			String newPassword = dto.getNewPassword();
			String confirmPassword = dto.getConfirmPassword();
			if(newPassword.equals(confirmPassword)) {
		
				Employee entity = optExist.get();		
				entity.setPassword(bCryptPasswordEncoder.encode(dto.getNewPassword()));
				employeeService.save(entity);
				model.addAttribute("message","Password is reset!");
				
				return "forward:/admin/accounts/changePassword";
				
			}
			else {
				
				model.addAttribute("message","Password not match!");
				return "forward:/admin/accounts/changePassword";
			}
			
			
		}else {
			System.out.println( "4");
			model.addAttribute("message","Old Password Invalid!");
			return "forward:/admin/accounts/changePassword";
		}
		
	}

}
