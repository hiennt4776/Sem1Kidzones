package edu.softech.shoesShop.controller.site;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.softech.shoesShop.domain.Shoes;
import edu.softech.shoesShop.domain.ShoesSize;
import edu.softech.shoesShop.domain.ShoesType;
import edu.softech.shoesShop.model.Cart;
import edu.softech.shoesShop.model.CartItem;
import edu.softech.shoesShop.model.CartManager;
import edu.softech.shoesShop.model.ShoesSizeDto;
import edu.softech.shoesShop.model.ShoesTypeDto;
import edu.softech.shoesShop.service.ShoesService;
import edu.softech.shoesShop.service.ShoesSizeService;
import edu.softech.shoesShop.service.ShoesTypeService;

@Controller
@RequestMapping("site/shoes")
public class ShoesSiteController {
	

	@Autowired
	ShoesService shoesService;
	
	@Autowired
	private ShoesTypeService shoesTypeService;
	
	@Autowired
	ShoesSizeService shoesSizeService;
	
	@Autowired
	private CartManager cartManager;
	
	@RequestMapping("shoesDetail/{shoesTypeId}")
	public ModelAndView detail(ModelMap model, @PathVariable("shoesTypeId") Long shoesTypeId ) {
		Optional<ShoesType> opt = shoesTypeService.findById(shoesTypeId);
		ShoesTypeDto dto = new ShoesTypeDto();
		
		List<ShoesSizeDto> listShoesSizes = shoesSizeService.findShoesSizesByShoesTypeId(shoesTypeId).stream().map(item -> {
			ShoesSizeDto shoesSizeDto = new ShoesSizeDto();
			BeanUtils.copyProperties(item, shoesSizeDto);
			return shoesSizeDto;
		}).toList();
		
		if(opt.isPresent()) {
			ShoesType entity = opt.get();
			BeanUtils.copyProperties(entity, dto);
			dto.setBrandId(entity.getBrand().getBrandId());
			
			dto.setIsEdit(true);
			model.addAttribute("shoesType",dto);
			model.addAttribute("shoesSizes", listShoesSizes);
			return new ModelAndView("site/shoes/shoesDetail", model);
		}
		model.addAttribute("message", "Shoes Type is not existed");
		
		return new ModelAndView("forward:site/home/index", model);
	}
	
	@RequestMapping("cart")
	public String cart(HttpSession session,  ModelMap model) {
		model.addAttribute("page", "cart");
		model.addAttribute("otherShoes", shoesTypeService.findRelatedShoes());
		return "site/shoes/cart";
	}
	
	@RequestMapping("/add")
	public String addCart(HttpSession session, 		
			@RequestParam(value = "shoesTypeId", required = false) Long shoesTypeId,
			@RequestParam(value = "shoesSizeId", required = false) Long shoesSizeId,
			@RequestParam(value = "quantity", required = false) int quantity
		) 
		{
			System.out.println("shoesTypeId = " + shoesTypeId);
			System.out.println("shoesSizeId = " + shoesSizeId);
			System.out.println("quantity = " + quantity);
						
			Optional<ShoesSize> optShoesSize = shoesSizeService.findById(shoesSizeId);
			ShoesSize entityShoesSize = optShoesSize.get();
			
			System.out.println("entityShoesSize = " + entityShoesSize.getShoesSizeId());
			
			Optional<ShoesType> optShoesType = shoesTypeService.findById(shoesTypeId);
			ShoesType entityShoesType = optShoesType.get();
			
			System.out.println("entityShoesType = " + entityShoesType.getShoesTypeId());
			
			List<Shoes> listShoes = shoesService.findByShoesTypeAndShoesSizeAndIsDelete(entityShoesType, entityShoesSize, false);
			Shoes shoes = listShoes.get(0);
			
			System.out.println("entityShoes = " + shoes.getShoesId());
			
			Cart cart = cartManager.getCart(session);
			cart.addItem(shoes,quantity);
			return "site/shoes/cart";
		
		}
	
	@RequestMapping("/update")
	public String update(HttpSession session, @RequestParam("id") Shoes shoes, @RequestParam("quantity") int quantity) {
		
		System.out.println("entityShoes update = " + shoes.getShoesId());
		
		System.out.println("quantity update= " + quantity);
		
		Cart cart = cartManager.getCart(session);
		cart.updateItem(shoes, quantity);
		return "site/shoes/cart";
	}
	
	@RequestMapping("/remove")
	public String remove(HttpSession session, @RequestParam("id") Shoes shoes) {
		Cart cart = cartManager.getCart(session);
		cart.removeItem(shoes);
		return "site/shoes/cart";
	}
	
	
}
