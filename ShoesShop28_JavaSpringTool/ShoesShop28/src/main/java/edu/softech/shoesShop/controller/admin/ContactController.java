package edu.softech.shoesShop.controller.admin;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.softech.shoesShop.domain.Brand;
import edu.softech.shoesShop.domain.Contact;
import edu.softech.shoesShop.domain.ShoesType;
import edu.softech.shoesShop.service.ContactService;


@Controller
@RequestMapping("admin/contacts")
public class ContactController {
	
	@Autowired
	ContactService contactService;
	
	@GetMapping("searchpaginated")
	public String search(ModelMap model, 
			@RequestParam(name = "name", required = false) String name,
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {
		model.addAttribute("page", "contact");
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);
		
		Pageable pageable = PageRequest.of(currentPage-1, pageSize, Sort.by("name"));
		Page<Contact> resultPage = null;
	
		if(StringUtils.hasText(name)) {
			resultPage = contactService.findByNameContaining(name,pageable);
			model.addAttribute("name", name);
		}else {
			resultPage = contactService.findAll(pageable);
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
		
		model.addAttribute("contactPage", resultPage);
		return "admin/contacts/searchpaginated";
	}
	
	@GetMapping("delete/{contactId}")
	public ModelAndView delete(ModelMap model, @PathVariable("contactId") Long contactId) {
		Optional<Contact> opt = contactService.findById(contactId);
		model.addAttribute("page", "contact");
		
		
		if(opt.isPresent()) {
			contactService.deleteById(contactId);
			model.addAttribute("message", "Contact is deleted!");	
		}
		else {
			model.addAttribute("message", "Contact not exist!");
			}
		
		return new ModelAndView("forward:/admin/contacts/searchpaginated", model);
	
	}
}