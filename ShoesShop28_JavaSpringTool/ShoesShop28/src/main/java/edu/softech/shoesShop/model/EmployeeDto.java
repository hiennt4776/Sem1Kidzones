package edu.softech.shoesShop.model;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto{
	private Long employeeId;
	
	@NotEmpty(message="username must be entered")
	private String username;
	@NotEmpty(message="password must be entered")
	private String password;
	
	@NotEmpty(message="Name must be entered")
	private String name;
	private boolean gender;
	
	@Pattern(regexp = "[0-9]{12}", message="Indetity must be entered or not valid")
	private String identityCard;
	
	@NotEmpty(message="Email must be entered")
	@Email(message="Email is invalid")
	private String email;
	

	@Pattern(regexp = "^(0|\\+84)(\\d{9,10})$", message="Phone must be entered or not valid")
	private String phone;
	
	@NotNull(message="date of birth must be entered")
	@Past(message = "date of birth invalid")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	
	
	@Temporal(TemporalType.DATE)
	private Date lastAccessDate;
	
	private boolean isDelete;
	
	private String status;
	
	private String role;
	
	@NotEmpty(message="Address must be entered")
	private String address;
	
	private Boolean isEdit = false;
	
}


