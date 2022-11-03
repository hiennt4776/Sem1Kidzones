//1

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
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="shoesSizes")

public class ShoesSize {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long shoesSizeId;
	
	@Column(nullable = false)
	private double sizeNumber;
	
	@Column(nullable = false)
	private double centimeter;
	
	
	

	@OneToMany(mappedBy = "shoesSize", cascade = CascadeType.ALL)
	private Set<Shoes> shoes;

}
