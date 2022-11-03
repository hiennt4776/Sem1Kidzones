package edu.softech.shoesShop.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="shipments")

public class Shipment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long shipmentId;
	
	@Column(name="shipment_name", length = 100, columnDefinition = "nvarchar(100) not null")
	private String name;
	
	@Column(length = 20)
	private String phone;
	
	@Column(length = 250)
	private String province;
	
	@Column(length = 250)
	private String addressLine;
	
	@OneToMany(mappedBy = "shipment", cascade = CascadeType.ALL)
	private Set<Order> orders;
	

}
