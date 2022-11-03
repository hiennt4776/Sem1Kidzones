package edu.softech.shoesShop.controller.admin;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.softech.shoesShop.domain.Shoes;
import edu.softech.shoesShop.domain.ShoesSize;
import edu.softech.shoesShop.model.ShoesSizeDto;
import edu.softech.shoesShop.service.ShoesService;
import edu.softech.shoesShop.service.ShoesSizeService;


@Controller
@RequestMapping("admin/shoesSizes")
public class ShoesSizeController {
	@Autowired
	ShoesSizeService shoesSizeService;
	@Autowired
	ShoesService shoesService;
	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("shoesSize", new ShoesSizeDto());
		model.addAttribute("page", "shoesSize");
		return "admin/shoesSizes/addOrEdit";
	}
	
	@GetMapping("edit/{shoesSizeId}")
	public ModelAndView edit(ModelMap model, @PathVariable("shoesSizeId") Long shoesSizeId) {
		Optional<ShoesSize> opt = shoesSizeService.findById(shoesSizeId);
		ShoesSizeDto dto = new ShoesSizeDto();
		model.addAttribute("page", "shoesSize");
		if(opt.isPresent()) {
			ShoesSize entity = opt.get();
			BeanUtils.copyProperties(entity, dto);
			dto.setIsEdit(true);
			model.addAttribute("shoesSize",dto);
			return new ModelAndView("admin/shoesSizes/addOrEdit", model);
		}
		model.addAttribute("message", "Shoes Size is not existed");
		
		return new ModelAndView("forward:/admin/shoesSizes", model);
	}


	
	@PostMapping("saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("shoesSize") ShoesSizeDto dto, BindingResult result) {
		
		if(result.hasErrors()) {
			return new ModelAndView("admin/shoesSizes/addOrEdit");
		}
		
		ShoesSize entity = new ShoesSize();
		BeanUtils.copyProperties(dto, entity);
		shoesSizeService.save(entity);
		model.addAttribute("message","shoes size is saved!");
		model.addAttribute("page", "shoesSize");
		return new ModelAndView("forward:/admin/shoesSizes", model);
	}
	
	
	@RequestMapping("")
	public String list(ModelMap model) {
		List<ShoesSize> list = shoesSizeService.findAll();
		model.addAttribute("shoesSizes",list);
		model.addAttribute("page", "shoesSize");
		return "admin/shoesSizes/list";
		
	}
	
	@GetMapping("delete/{shoesSizeId}")
	public ModelAndView delete(ModelMap model, @PathVariable("shoesSizeId") Long shoesSizeId) {
		Optional<ShoesSize> optShoesSize = shoesSizeService.findById(shoesSizeId);
		model.addAttribute("page", "shoesSize");
		if(optShoesSize.isPresent()) {		
				ShoesSize entityShoesSize = optShoesSize.get();
			
				List<Shoes> shoes = shoesService.findByShoesSizeAndIsDelete(entityShoesSize, false);
				if(shoes.isEmpty()) {
					shoesSizeService.deleteById(shoesSizeId);
					model.addAttribute("message", "Shoes Size is deleted!");
				}else {
					model.addAttribute("message", "Shoes Size cannot delete because it's used");
				}
			}else{
				model.addAttribute("message", "Shoes Size is not Found!");
		}
		
		return new ModelAndView("forward:/admin/shoesSizes", model);
	}
}
