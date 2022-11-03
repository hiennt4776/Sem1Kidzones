package edu.softech.shoesShop.model;
import java.util.Set;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import edu.softech.shoesShop.domain.Brand;
import edu.softech.shoesShop.domain.Shoes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor


public class ShoesTypeDto {
	
	private Long shoesTypeId;
	@NotEmpty(message="Name must be entered")
	private String name;
	private String image;
	private MultipartFile imageFile;
	private boolean gender;
	@NotEmpty(message="Description must be entered")
	private String description;
	private String status;
	@NotNull(message = "Price must be entered")
	@Min(value = 1, message = "Size must large zero")
	private double unitPrice;
	private boolean bestSeller;
	private Long brandId;
	private Boolean isDelete;
	private Boolean isEdit = false;
	
}
