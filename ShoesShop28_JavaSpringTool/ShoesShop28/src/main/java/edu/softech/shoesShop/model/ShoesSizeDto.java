package edu.softech.shoesShop.model;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ShoesSizeDto {
	private Long shoesSizeId;
	
	@NotNull(message = "Price must be entered")
	@Min(value = 1, message = "Size must large zero")
	private double sizeNumber;
	@NotNull(message = "Price must be entered")
	@Min(value = 1, message = "Size must large zero")
	private double centimeter;
	
	private Boolean isEdit = false;
	
	
}
