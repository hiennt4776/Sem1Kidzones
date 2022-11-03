package edu.softech.shoesShop.model;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResetPasswordDto {

	private Long employeeId;
	@NotEmpty(message="new Password must be entered")
	private String newPassword;
}
