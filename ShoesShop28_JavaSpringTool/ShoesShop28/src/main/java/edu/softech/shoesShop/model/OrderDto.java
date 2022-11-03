package edu.softech.shoesShop.model;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class OrderDto {
	private Long orderId;
	
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	
	private double grandTotal;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date shipDate;
	private String status;
	private String note;
	private Long shipmentId;
	private Long customerId;
	private Long employeeId;
	private boolean isEdit;
}
