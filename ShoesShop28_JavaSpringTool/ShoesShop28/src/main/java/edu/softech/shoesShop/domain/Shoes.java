package edu.softech.shoesShop.domain;

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

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="shoes")
public class Shoes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long shoesId;
	
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Temporal(TemporalType.DATE)
	private Date updatedDate;
	
	@Column(nullable = false)
	private int quantity;
	
	@Column(length = 20)
	private String status;

	private boolean isDelete;
	
	@OneToMany(mappedBy = "shoes", cascade = CascadeType.ALL)
	private Set<OrderDetail> orderDetails;
	
	@ManyToOne
	@JoinColumn(name = "employeeId")
	private Employee employee;
	
	@ManyToOne
	@JoinColumn(name = "shoesSizeId")
	private ShoesSize shoesSize;
	
	@ManyToOne
	@JoinColumn(name = "shoesTypeId")
	private ShoesType shoesType;
	

}
