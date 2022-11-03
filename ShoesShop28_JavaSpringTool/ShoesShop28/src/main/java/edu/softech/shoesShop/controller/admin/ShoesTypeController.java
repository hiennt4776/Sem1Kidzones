package edu.softech.shoesShop.controller.admin;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import edu.softech.shoesShop.domain.Brand;
import edu.softech.shoesShop.domain.Shoes;
import edu.softech.shoesShop.domain.ShoesType;
import edu.softech.shoesShop.model.BrandDto;
import edu.softech.shoesShop.model.ShoesTypeDto;
import edu.softech.shoesShop.service.BrandService;
import edu.softech.shoesShop.service.ShoesService;
import edu.softech.shoesShop.service.ShoesTypeService;
import edu.softech.shoesShop.service.StorageService;


@Controller
@RequestMapping("admin/shoesTypes")
public class ShoesTypeController {
	@Autowired
	BrandService brandService;
	
	@Autowired
	ShoesTypeService shoesTypeService;
	
	@Autowired
	ShoesService shoesService;
	
	@Autowired
	StorageService storageService;
	
	
	
	@ModelAttribute("brands")
	public List<BrandDto> getBrands(){
		return brandService.findByIsDelete(false).stream().map(item -> {
			BrandDto dto = new BrandDto();
			BeanUtils.copyProperties(item, dto);
			return dto;
		}).toList();
	}
	
	@GetMapping("add")
	public String add(Model model) {
		ShoesTypeDto dto = new ShoesTypeDto();
		dto.setIsEdit(false);
		dto.setGender(true);
		model.addAttribute("shoesType", dto);
		model.addAttribute("page", "shoesType");
	
		return "admin/shoesTypes/addOrEdit";
	}
	
	@GetMapping("edit/{shoesTypeId}")
	public ModelAndView edit(ModelMap model, @PathVariable("shoesTypeId") Long shoesTypeId) {
		Optional<ShoesType> opt = shoesTypeService.findById(shoesTypeId);
		ShoesTypeDto dto = new ShoesTypeDto();
		model.addAttribute("page", "shoesType");
		if(opt.isPresent()) {
			ShoesType entity = opt.get();
			BeanUtils.copyProperties(entity, dto);
			
			//dto.setImage(entity.getImage());
			
		
			dto.setBrandId(entity.getBrand().getBrandId());
			
			dto.setIsEdit(true);
			model.addAttribute("shoesType",dto);
			return new ModelAndView("admin/shoesTypes/addOrEdit", model);
		}
		model.addAttribute("message", "Shoes Type is not existed");
		
		return new ModelAndView("forward:/admin/shoesTypes", model);
	}
	
	@GetMapping("/images/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> saveFile(@PathVariable String filename){
		Resource file = storageService.loadAsResource(filename);
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\"" + file.getFilename() + "\"").body(file);
			
	}

	@GetMapping("view/{shoesTypeId}")
	public ModelAndView view(ModelMap model, @PathVariable("shoesTypeId") Long shoesTypeId) {
		Optional<ShoesType> opt = shoesTypeService.findById(shoesTypeId);
		model.addAttribute("page", "shoesType");		
		if(opt.isPresent()) {
			ShoesType shoesType = opt.get();
			
			model.addAttribute("shoesType", shoesType);
			return new ModelAndView("admin/shoesTypes/view", model);
		}
		model.addAttribute("message", "Shoes Type is not existed");
		
		return new ModelAndView("forward:/admin/shoesTypes", model);
	}
	
	
	@GetMapping("delete/{shoesTypeId}")
	public ModelAndView delete(ModelMap model, @PathVariable("shoesTypeId") Long shoesTypeId) throws IOException{
		
		model.addAttribute("page", "shoesType");
		Optional<ShoesType> opt = shoesTypeService.findById(shoesTypeId);
		if(opt.isPresent()) {			
			ShoesType shoesType = opt.get();		
			List<Shoes> shoes = shoesService.findByShoesTypeAndIsDelete(shoesType,false);
			if(shoes.isEmpty()) {
				shoesType.setDelete(true);				
				shoesTypeService.save(shoesType);			
				model.addAttribute("message", "Shoes Type is deleted!");
			}
			else {
				model.addAttribute("message", "Shoes Type cannot delete because it's used");				
			}			
		}else{
			model.addAttribute("message", "Shoes Type is not Found!");
		}
		return new ModelAndView("forward:/admin/shoesTypes", model);
	}
	
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("shoesType") ShoesTypeDto dto, BindingResult result) {
		
		System.out.println("1");
		if(result.hasErrors()) {
			return new ModelAndView("admin/shoesTypes/addOrEdit");
		}
		System.out.println("2");
		model.addAttribute("page", "shoesType");
		ShoesType entity = new ShoesType();
		BeanUtils.copyProperties(dto, entity);
		Brand brand = new Brand();
		brand.setBrandId(dto.getBrandId());
		entity.setBrand(brand);
		if(!dto.getImageFile().isEmpty()) {
			UUID uuid = UUID.randomUUID();
			String uuString = uuid.toString();
			entity.setImage(storageService.getStoredFilename(dto.getImageFile(), uuString));
			storageService.store(dto.getImageFile(), entity.getImage());
		}
		shoesTypeService.save(entity);
		
		model.addAttribute("message","Shoes Type is saved!");
		//return new ModelAndView("redirect:/admin/ShoesTypes", model);
		return new ModelAndView("forward:/admin/shoesTypes", model);
	}
	
	@RequestMapping("")
	public String list(ModelMap model) {
		List<ShoesType> list = shoesTypeService.findByIsDelete(false);
		model.addAttribute("shoesTypes",list);
		System.out.println(list);
		model.addAttribute("page", "shoesType");
		return "admin/shoesTypes/list";
		
	}
	
	@GetMapping("search")
	public String search(ModelMap model, @RequestParam(name = "name", required = false) String name) {
		List<ShoesType> list = null;
		model.addAttribute("page", "shoesType");
		if(StringUtils.hasText(name)) {
			list = shoesTypeService.findByNameContainingAndIsDelete(name,false);
		}else {
			list = shoesTypeService.findByIsDelete(false);
		}
		model.addAttribute("shoesTypes", list);
		return "admin/shoesTypes/search";
	}
	
	@GetMapping("searchpaginated")
	public String search(ModelMap model, 
			@RequestParam(name = "name", required = false) String name,
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		model.addAttribute("page", "shoesType");
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);
		
		Pageable pageable = PageRequest.of(currentPage-1, pageSize, Sort.by("name"));
		Page<ShoesType> resultPage = null;
	
		if(StringUtils.hasText(name)) {
			resultPage = shoesTypeService.findByNameContainingAndIsDelete(name,false,pageable);
			model.addAttribute("name", name);
		}else {
			resultPage = shoesTypeService.findByIsDelete(false,pageable);
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
		
		model.addAttribute("shoesTypePage", resultPage);
		return "admin/shoesTypes/searchpaginated";
	}
}
