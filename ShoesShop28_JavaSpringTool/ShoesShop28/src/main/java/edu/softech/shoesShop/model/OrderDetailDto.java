package edu.softech.shoesShop.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto {
	private Long orderDetailId;	
	private int quantity;	
	private double unitPrice;
	private String note;
	private Long ShoesId;
	private Long OrderId;
}
