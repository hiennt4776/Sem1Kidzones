package edu.softech.shoesShop.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotEmpty;
import edu.softech.shoesShop.domain.ShoesType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BrandDto {

	private Long brandId;

	@NotEmpty(message="Name must be entered")
	private String name;

	@NotEmpty(message="Email must be entered")
	@Email(message="Email is invalid")
	@Column(length=50)
	private String email;
	
	@Pattern(regexp = "^(0|\\+84)(\\d{9,10})$", message="Phone must be entered or not validate")
	@Column(length = 20)
	private String phone;
	
	@NotEmpty(message="Address must be entered")
	@Column(length = 250)
	private String address;
	
	@NotEmpty(message="Description must be entered")
	@Column(length = 500)
	private String description;
	
	private boolean isDelete;
	
	private Boolean isEdit = false;
	
	@OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
	private Set<ShoesType> shoestypes;
}
