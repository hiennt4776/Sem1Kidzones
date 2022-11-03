package edu.softech.shoesShop.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
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
@Table(name="customers")
public class Customer{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	@Column(columnDefinition = "nvarchar(100) not null")
	private String username;
	@Column(columnDefinition = "nvarchar(100) not null")
	private String password;
	
	@Column(name="customer_name", length = 100, columnDefinition = "nvarchar(100) not null")
	private String name;
	
	private boolean gender;
	
	@Column(length = 20)
	private String email;
	
	@Column(length = 20)
	private String phone;
	
	@Column(length = 250)
	private String address;
	
	@Temporal(TemporalType.DATE)
	private Date registerDate;
	
	@Temporal(TemporalType.DATE)
	private Date lastAccessDate;
	
		
	@Column(length = 10)
	private String status;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Order> orders;
	
	@PrePersist
	public void preCreate() {
		registerDate = new Date();
	}
	
	@PreUpdate
	public void preUpdate() {
		lastAccessDate = new Date();
	}


}
