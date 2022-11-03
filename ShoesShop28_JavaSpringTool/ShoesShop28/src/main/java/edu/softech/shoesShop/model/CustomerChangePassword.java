package edu.softech.shoesShop.model;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerChangePassword {
	
	
	@NotEmpty
	private String oldPassword;
	@NotEmpty
	private String newPassword;
	
}
