package edu.softech.shoesShop.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="orderDetails")
public class OrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderDetailId;
	
	@Column(nullable = false)
	private int quantity;
	
	@Column(nullable = false)
	private double unitPrice;
	
	@ManyToOne
	@JoinColumn(name = "shoesId")
	private Shoes shoes;
	
	@ManyToOne
	@JoinColumn(name = "orderId")
	private Order order;
	
	

}
