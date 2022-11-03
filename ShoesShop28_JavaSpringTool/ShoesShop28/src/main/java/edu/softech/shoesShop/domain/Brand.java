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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="brands")
public class Brand implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long brandId;
	
	@Column(name="brand_name", length = 100, columnDefinition = "nvarchar(100) not null")
	private String name;
	
	@Column(length = 30)
	private String email;
	
	
	@Column(length = 20)
	private String phone;
	
	@Column(length = 250)
	private String address;
	

	@Column(columnDefinition = "nvarchar(500) not null")
	private String description;
	
	private boolean isDelete;
	
	@OneToMany(mappedBy = "brand", cascade = CascadeType.ALL)
	private Set<ShoesType> shoestypes;
	

}
