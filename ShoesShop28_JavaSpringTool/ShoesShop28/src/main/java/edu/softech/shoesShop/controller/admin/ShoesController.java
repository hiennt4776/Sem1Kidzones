package edu.softech.shoesShop.controller.admin;


import java.util.Date;
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
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import edu.softech.shoesShop.domain.Employee;
import edu.softech.shoesShop.domain.OrderDetail;
import edu.softech.shoesShop.domain.Shoes;
import edu.softech.shoesShop.domain.ShoesSize;
import edu.softech.shoesShop.domain.ShoesType;

import edu.softech.shoesShop.model.EmployeeDto;
import edu.softech.shoesShop.model.ShoesDto;
import edu.softech.shoesShop.model.ShoesSizeDto;
import edu.softech.shoesShop.model.ShoesTypeDto;
import edu.softech.shoesShop.service.EmployeeService;
import edu.softech.shoesShop.service.OrderDetailService;
import edu.softech.shoesShop.service.OrderService;
import edu.softech.shoesShop.service.ShoesService;
import edu.softech.shoesShop.service.ShoesSizeService;
import edu.softech.shoesShop.service.ShoesTypeService;


@Controller
@RequestMapping("admin/shoes")
public class ShoesController {

	@Autowired
	ShoesService shoesService;
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	ShoesTypeService shoesTypeService;
	
	@Autowired
	ShoesSizeService shoesSizeService;
	
	@Autowired
	OrderDetailService orderDetailService;
	
	@Autowired
	private HttpSession session;
	
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

	@GetMapping("add")
	public String add(Model model) {
		ShoesDto dto = new ShoesDto();
		dto.setIsEdit(false);
		model.addAttribute("shoes", dto);
		model.addAttribute("page", "shoes");
		return "admin/shoes/addOrEdit";
	}
	
	@GetMapping("edit/{shoesId}")
	public ModelAndView edit(ModelMap model, @PathVariable("shoesId") Long shoesId) {
		
		Optional<Shoes> opt = shoesService.findById(shoesId);
		
		ShoesDto dto = new ShoesDto();
		model.addAttribute("page", "shoes");
		if(opt.isPresent()) {
			Shoes entity = opt.get();
			System.out.println(entity.getStatus());

			System.out.println("username=" + session.getAttribute("username"));
			
			BeanUtils.copyProperties(entity, dto);
			dto.setEmployeeId(entity.getEmployee().getEmployeeId());
			dto.setShoesSizeId(entity.getShoesSize().getShoesSizeId());
			dto.setShoesTypeId(entity.getShoesType().getShoesTypeId());
	
			dto.setIsEdit(true);
			model.addAttribute("shoes",dto);
			return new ModelAndView("admin/shoes/addOrEdit", model);
		}
		model.addAttribute("message", "Shoes is not existed");
		
		
		return new ModelAndView("forward:/admin/shoes", model);
	}
	
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("shoes") ShoesDto dto, BindingResult result) {
		
		Optional<ShoesSize> optShoesSize = shoesSizeService.findById(dto.getShoesSizeId());
		ShoesSize entityShoesSize = optShoesSize.get();
		
		System.out.println("entityShoesSize = " + entityShoesSize.getShoesSizeId());
		
		Optional<ShoesType> optShoesType = shoesTypeService.findById(dto.getShoesTypeId());
		ShoesType entityShoesType = optShoesType.get();
		
		System.out.println("entityShoesType = " + entityShoesType.getShoesTypeId());
		
		List<Shoes> shoesCheckDouble = shoesService.findByShoesTypeAndShoesSizeAndIsDelete(entityShoesType,entityShoesSize, false);
		
		System.out.println("shoesCheckDouble.isEmpty() = " + shoesCheckDouble.isEmpty());
		System.out.println("dto.getIsEdit() = " + dto.getIsEdit());
		
		if(!shoesCheckDouble.isEmpty() && !dto.getIsEdit()) {

			model.addAttribute("message", "this shoes already exists!");
			return new ModelAndView("admin/shoes/addOrEdit");	
		}
		if(dto.getIsEdit()) {
			System.out.println("dto.getIsEdit() = " + dto.getIsEdit());
		
				
				if( shoesCheckDouble.get(0).getShoesId() != dto.getShoesId()) {
					model.addAttribute("message", "this shoes already exists!");
					return new ModelAndView("admin/shoes/addOrEdit");
				}
				
		}
			
		
		
		Object employeeIdObj = session.getAttribute("employeeId");
		Long employeeIdLong =  ((Long)employeeIdObj).longValue();
		model.addAttribute("page", "shoes");
		if(result.hasErrors()) {
			return new ModelAndView("admin/shoes/addOrEdit");
		}
		

		
		Shoes entity = new Shoes();
		BeanUtils.copyProperties(dto, entity);
		
		Employee employee = new Employee();
		employee.setEmployeeId(employeeIdLong);
		entity.setEmployee(employee);

		ShoesType shoesType = new ShoesType();
		shoesType.setShoesTypeId(dto.getShoesTypeId());
		entity.setShoesType(shoesType);
		
		ShoesSize shoesSize = new ShoesSize();
		shoesSize.setShoesSizeId(dto.getShoesSizeId());
		entity.setShoesSize(shoesSize);
		
		Date date = new Date();
		System.out.println(date);
		
		entity.setUpdatedDate(date);
		
		if(dto.getIsEdit()) {
			Optional<Shoes> opt = shoesService.findById(dto.getShoesId());
			Date createDate = opt.get().getCreatedDate();
			entity.setCreatedDate(createDate);
		}
		else {
			entity.setCreatedDate(date);
			
		}
	
		//entity.setDelete(false);
		shoesService.save(entity);
		model.addAttribute("message","shoes is saved!");

		return new ModelAndView("forward:/admin/shoes", model);
	}
	
	@RequestMapping("")
	public String list(ModelMap model) {
		List<Shoes> list = shoesService.findByIsDelete(false);
		model.addAttribute("shoes",list);
		model.addAttribute("page", "shoes");
		return "admin/shoes/list";
		
	}
	
	
	@GetMapping("view/{shoesId}")
	public ModelAndView view(ModelMap model, @PathVariable("shoesId") Long shoesId) {
		Optional<Shoes> opt = shoesService.findById(shoesId);
		model.addAttribute("page", "shoes");		
		if(opt.isPresent()) {
			Shoes shoes = opt.get();
			
			model.addAttribute("shoes", shoes);
			return new ModelAndView("admin/shoes/view", model);
		}
		model.addAttribute("message", "Shoes is not existed");
		
		return new ModelAndView("forward:/admin/shoes", model);
	}
	
	@GetMapping("delete/{shoesId}")
	public ModelAndView delete(ModelMap model, @PathVariable("shoesId") Long shoesId) {
		Optional<Shoes> opt = shoesService.findById(shoesId);
		model.addAttribute("page", "shoes");
		if(opt.isPresent()) {
			Shoes entity = opt.get();
			List<OrderDetail> orderDetail = orderDetailService.findByShoes(entity);
			
			if(orderDetail.isEmpty()) {
				entity.setDelete(true);
				shoesService.save(entity);
				model.addAttribute("message", "Shoes is deleted!");
			}else {
				model.addAttribute("message", "Shoes cannot delete because it's used");
			}
			
			
		}
		//model.addAttribute("message", "Brand is not existed");		
		return new ModelAndView("forward:/admin/shoes", model);
	}
	
	
	
	@GetMapping("filterpaginated")
	public String filter(ModelMap model,
			@RequestParam("shoesSizeId") Optional<Long> shoesSizeId,
			@RequestParam("shoesTypeId") Optional<Long> shoesTypeId,
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size
		) {
			model.addAttribute("page", "shoes");
			
			int currentPage = page.orElse(1);
			int pageSize = size.orElse(5);
			
			Pageable pageable = PageRequest.of(currentPage-1, pageSize);
			Page<Shoes> resultPage = null;
	
			Long LongShoesSizeId = 0l;
			Long LongShoesTypeId = 0l;
		
			if(!shoesSizeId.isEmpty()) LongShoesSizeId = shoesSizeId.get();
			if(!shoesTypeId.isEmpty()) LongShoesTypeId = shoesTypeId.get();
			
			System.out.println("LongShoesSizeId = " + LongShoesSizeId);
			System.out.println("LongShoesTypeId = " + LongShoesTypeId);
	
			if((LongShoesSizeId != 0)&&(LongShoesTypeId != 0)) {
				System.out.println("(LongShoesSizeId != 0)&&(LongShoesTypeId != 0)");
				Optional<ShoesSize> optShoesSize = shoesSizeService.findById(LongShoesSizeId);
				ShoesSize entityShoesSize = optShoesSize.get();
				
				Optional<ShoesType> optShoesType = shoesTypeService.findById(LongShoesTypeId);
				ShoesType entityShoesType = optShoesType.get();
				
				resultPage = shoesService.findByShoesTypeAndShoesSizeAndIsDelete(entityShoesType, entityShoesSize, false, pageable);	
			} else if((LongShoesSizeId != 0)&&(LongShoesTypeId == 0)) {
				System.out.println("(LongShoesSizeId != 0)&&(LongShoesTypeId == 0)");
				
				Optional<ShoesSize> optShoesSize = shoesSizeService.findById(LongShoesSizeId);
				ShoesSize entityShoesSize = optShoesSize.get();
				resultPage = shoesService.findByShoesSizeAndIsDelete(entityShoesSize, false, pageable);
			} else if((LongShoesSizeId == 0)&&(LongShoesTypeId != 0)) {
				System.out.println("(LongShoesSizeId == 0)&&(LongShoesTypeId != 0)");
				Optional<ShoesType> optShoesType = shoesTypeService.findById(LongShoesTypeId);
				ShoesType entityShoesType = optShoesType.get();
				
				resultPage = shoesService.findByShoesTypeAndIsDelete(entityShoesType, false, pageable);
			} else 
				{
					System.out.println("else");
					resultPage = shoesService.findByIsDelete(false, pageable);
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

			
			model.addAttribute("shoesPage", resultPage);
			return "admin/shoes/filterpaginated";
	}
}
