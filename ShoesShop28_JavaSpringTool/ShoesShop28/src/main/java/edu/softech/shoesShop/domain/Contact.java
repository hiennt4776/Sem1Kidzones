package edu.softech.shoesShop.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="contacts")
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contactId;

	@Column(columnDefinition = "nvarchar(100) not null")
	private String name;
	
	@Column(length = 20)
	private String phone;
	
	@Column(length = 20)
	private String email;
	
	@Column(length = 500)
	private String content;
	

}
