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

import edu.softech.shoesShop.domain.Brand;
import edu.softech.shoesShop.domain.Shoes;
import edu.softech.shoesShop.domain.ShoesSize;
import edu.softech.shoesShop.domain.ShoesType;
import edu.softech.shoesShop.model.BrandDto;

import edu.softech.shoesShop.service.BrandService;
import edu.softech.shoesShop.service.ShoesTypeService;


@Controller
@RequestMapping("admin/brands")
public class BrandController {
	@Autowired
	BrandService brandService;
	@Autowired
	ShoesTypeService shoesTypeService;

	
	@GetMapping("add")
	public String add(Model model) {
		BrandDto dto = new BrandDto();
		model.addAttribute("brand", dto);
		model.addAttribute("page", "brand");
		return "admin/brands/addOrEdit";
	}
	
	@GetMapping("edit/{brandId}")
	public ModelAndView edit(ModelMap model, @PathVariable("brandId") Long brandId) {
		Optional<Brand> opt = brandService.findById(brandId);
		BrandDto dto = new BrandDto();
		model.addAttribute("page", "brand");
		
		if(opt.isPresent()) {
			Brand entity = opt.get();
			BeanUtils.copyProperties(entity, dto);
			dto.setIsEdit(true);
			model.addAttribute("brand",dto);
			System.out.println("getIsEdit:" + dto.getIsEdit());
			return new ModelAndView("admin/brands/addOrEdit", model);
		}
		model.addAttribute("message", "Brand is not existed");
		
		return new ModelAndView("forward:/admin/brands", model);
	}
	
	@GetMapping("view/{brandId}")
	public ModelAndView view(ModelMap model, @PathVariable("brandId") Long brandId) {
		Optional<Brand> opt = brandService.findById(brandId);
		BrandDto dto = new BrandDto();
		
		if(opt.isPresent()) {
			Brand entity = opt.get();
			BeanUtils.copyProperties(entity, dto);
			model.addAttribute("brand",dto);
			return new ModelAndView("admin/brands/view", model);
		}
		model.addAttribute("message", "Brand is not existed");
		model.addAttribute("page", "brand");
		return new ModelAndView("forward:/admin/brands", model);
	}
	
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("brand") BrandDto dto, BindingResult result) {
		
		if(result.hasErrors()) {
			return new ModelAndView("admin/brands/addOrEdit");
		}
		
		Brand entity = new Brand();
		BeanUtils.copyProperties(dto, entity);
		entity.setDelete(false);
		brandService.save(entity);
		model.addAttribute("message","brand is saved!");
		model.addAttribute("page", "brand");
		return new ModelAndView("forward:/admin/brands", model);
	}
	
	
	
	@RequestMapping("")
	public String list(ModelMap model) {
		List<Brand> list = brandService.findByIsDelete(false);
		
		model.addAttribute("brands",list);
		model.addAttribute("page", "brand");
		return "admin/brands/list";
		
	}
	
	@GetMapping("delete/{brandId}")
	public ModelAndView delete(ModelMap model, @PathVariable("brandId") Long brandId) {
		Optional<Brand> opt = brandService.findById(brandId);
		model.addAttribute("page", "brand");
		if(opt.isPresent()) {
			Brand brand = opt.get();
			
			List<ShoesType> shoesType = shoesTypeService.findByBrandAndIsDelete(brand,false);
			
			if(shoesType.isEmpty()) {
				brand.setDelete(true);
				brandService.save(brand);
				model.addAttribute("message", "Brand is deleted!");
			}else {
				model.addAttribute("message", "Brand cannot delete because it's used");
			}
			
			
			
			
		}
	
		
		return new ModelAndView("forward:/admin/brands", model);
		
		

	}

	@GetMapping("search")
	public String search(ModelMap model, @RequestParam(name = "name", required = false) String name) {
		List<Brand> list = null;
		
		  System.out.println(name);
		
		if(StringUtils.hasText(name)) {
			list = brandService.findByNameContainingAndIsDelete(name, false);
			
			  System.out.println(brandService);
		}else {
			list = brandService.findByIsDelete(false);
			
		}
		
		
		model.addAttribute("brands", list);
		return "admin/brands/search";
	}
	
	
	@GetMapping("searchpaginated")
	public String search(ModelMap model, 
			@RequestParam(name = "name", required = false) String name,
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		model.addAttribute("page", "brand");
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);
		
		Pageable pageable = PageRequest.of(currentPage-1, pageSize, Sort.by("name"));
		Page<Brand> resultPage = null;
	
		if(StringUtils.hasText(name)) {
			resultPage = brandService.findByNameContainingAndIsDelete(name,false,pageable);
			model.addAttribute("name", name);
		}else {
			resultPage = brandService.findByIsDelete(false,pageable);
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
		
		model.addAttribute("brandPage", resultPage);
		return "admin/brands/searchpaginated";
	}
	

}
