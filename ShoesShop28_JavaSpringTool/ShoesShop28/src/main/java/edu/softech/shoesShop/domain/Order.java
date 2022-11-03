package edu.softech.shoesShop.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name="orders")
public class Order{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	@Temporal(TemporalType.DATE)
	private Date orderDate;
	@Column(nullable = false)
	private double grandTotal;
	@Temporal(TemporalType.DATE)
	private Date shipDate;
	@Column(length = 15)
	private String status;
	
	@ManyToOne
	@JoinColumn(name = "shipmentId")
	private Shipment shipment;
	
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name = "employeeId")
	private Employee employee;
	
	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
	private Set<OrderDetail> orderDetails;
	

}
