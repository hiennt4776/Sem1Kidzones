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

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="shoesTypes")

public class ShoesType implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long shoesTypeId;
	
	@Column(name="shoes_type_name", length = 100, columnDefinition = "nvarchar(100) not null")
	private String name;
	
	@Column(length = 200)
	private String image;
	
	@Column(nullable = false)
	private double unitPrice;
	
	private boolean gender;
	
	@Column(columnDefinition = "nvarchar(500) not null")
	private String description;
	
	@Column(columnDefinition = "nvarchar(15) not null")
	private String status;
	

	private boolean bestSeller;
	
	
	@ManyToOne
	@JoinColumn(name = "brandId")
	private Brand brand;

	private boolean isDelete;
	
	@OneToMany(mappedBy = "shoesType", cascade = CascadeType.ALL)
	private Set<Shoes> shoes;	

}
