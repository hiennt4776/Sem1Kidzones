package edu.softech.shoesShop.model;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerInfoDto {
	
	private Long customerId;
	
	private String username;
	
	private String password;
	
	private String phone;
	
	private boolean gender;
	
	private String address;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String email;
	
}
