package edu.softech.shoesShop.model;


import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordDto {
	
	private Long employeeId;
	@NotEmpty(message="old Password must be entered")
	private String oldPassword;
	@NotEmpty(message="new Password must be entered")
	private String newPassword;
	@NotEmpty(message="confirm Password must be entered")
	private String confirmPassword;
}
