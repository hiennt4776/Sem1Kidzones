package edu.softech.shoesShop.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomerLoginDto{
	
	private String username;
	
	private String password;
	
	private Boolean rememberMe = false;
	
	private Boolean isReadAndAccept_Term = false;
}
