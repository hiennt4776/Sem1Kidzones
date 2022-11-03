package edu.softech.shoesShop.model;



import javax.persistence.Column;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDto {
	private Long contactId;
	@NotEmpty(message="Name must be entered")
	private String name;
	
	@Pattern(regexp = "^(0|\\+84)(\\d{9,10})$", message="Phone must be entered or not validate")
	@Column(length = 20)
	private String phone;
	
	@NotEmpty(message="Email must be entered")
	@Email(message="Email is invalid")
	@Column(length=50)
	private String email;
	
	@NotEmpty(message="Content must be entered")
	@Column(length = 500)
	private String content;
}
