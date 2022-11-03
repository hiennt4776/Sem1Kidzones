package edu.softech.shoesShop.controller.site;

import java.util.List;
import java.util.Optional;
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
import edu.softech.shoesShop.domain.Contact;
import edu.softech.shoesShop.domain.ShoesType;
import edu.softech.shoesShop.model.BrandDto;
import edu.softech.shoesShop.model.ContactDto;
import edu.softech.shoesShop.service.ContactService;
import edu.softech.shoesShop.service.ShoesTypeService;
import edu.softech.shoesShop.service.StorageService;

@Controller
@RequestMapping("site/home")
public class HomeController {
	@Autowired
	private ShoesTypeService shoesTypeService;
	
	@Autowired
	StorageService storageService;
	
	@Autowired
	ContactService contactService;
	
	@GetMapping("")
	public String index(Model model){
		model.addAttribute("bestSeller", shoesTypeService.findBestSellerShoes());
		model.addAttribute("shoesTypes", shoesTypeService.findAll());
		return "site/home/index";
	}
	
	@GetMapping("images/{filename:.+}")
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename){
		Resource file = storageService.loadAsResource(filename);
		
		
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + 
					file.getFilename() + "\""  ).body(file);
	}
	
	@GetMapping("contact")
	public String contact(ModelMap model){
		ContactDto dto = new ContactDto();
		model.addAttribute("contact", dto);
		model.addAttribute("page", "contact");
		return "site/home/contact";
	}
	
	@PostMapping("saveContact")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("contact") ContactDto dto, BindingResult result) {
		
		if(result.hasErrors()) {
			return new ModelAndView("site/home/contact");
		}
		
		Contact entity = new Contact();
		BeanUtils.copyProperties(dto, entity);
		
		contactService.save(entity);
		
		return new ModelAndView("site/home/index", model);
	}
	
	
	@GetMapping("about")
	public String about(ModelMap model){
		model.addAttribute("page", "about");
		return "site/home/about";
	}
	
	/*
	 * @GetMapping("men") public String menPage(ModelMap model){
	 * model.addAttribute("page", "contact"); model.addAttribute("shoesMen",
	 * shoesTypeService.findMenShoes()); return "site/home/men"; }
	 */
	
	@GetMapping("men")
	public String menPage(ModelMap model,@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size){
		
		model.addAttribute("page", "men");
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);
		
		Pageable pageable = PageRequest.of(currentPage-1, pageSize);
		
		Page<ShoesType> resultPage = shoesTypeService.findByIsDeleteAndGender(false, true, pageable);
		
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
		model.addAttribute("shoesMen", resultPage);
		return "site/home/men";
	}
	
	@GetMapping("women")
	public String womenPage(ModelMap model,@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size){
		
		model.addAttribute("page", "women");
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);
		
		Pageable pageable = PageRequest.of(currentPage-1, pageSize, Sort.by("name"));
		
		Page<ShoesType> resultPage = shoesTypeService.findByIsDeleteAndGender(false, false, pageable);
		
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
		model.addAttribute("shoesWomen", resultPage);
		return "site/home/women";
	}
	
}
