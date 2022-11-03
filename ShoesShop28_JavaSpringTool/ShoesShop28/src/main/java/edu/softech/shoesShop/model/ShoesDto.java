package edu.softech.shoesShop.model;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoesDto {
	
	private Long shoesId;
	private Date createdDate;;
	private Date updatedDate;
	private int quantity;
	private String status;
	private Long employeeId;
	private boolean isDelete;
	private Long shoesSizeId;
	private Long shoesTypeId;
	private Boolean isEdit;
}
