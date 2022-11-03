package edu.softech.shoesShop.model;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShipmentDto {
	private Long shipmentId;
	
	@NotNull
	private String name;
	
	@NotNull
	private String phone;
	
	private String province;
	
	@NotNull
	private String addressLine;
	private Long orderId;
}
