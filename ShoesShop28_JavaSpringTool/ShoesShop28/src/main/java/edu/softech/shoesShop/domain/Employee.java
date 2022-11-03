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
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employees")
public class Employee{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	@Column(columnDefinition = "nvarchar(100) not null")
	private String username;
	@Column(columnDefinition = "nvarchar(100) not null")
	private String password;
	
	@Column(name="fullname", length = 100, columnDefinition = "nvarchar(100) not null")
	private String name;
	
	private boolean gender;
	
	@Column(length = 12)
	private String identityCard;
	
	@Column(length = 20)
	private String email;
	
	@Column(length = 20)
	private String phone;
	
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;
	
	@Temporal(TemporalType.DATE)
	private Date lastAccessDate;

	@Column(length = 10)
	private String status;
	
	@Column(length = 10)
	private String role;
	
	@Column(length = 250)
	private String address;
	
	private boolean isDelete;
	
	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
	private Set<Order> orders;
	
	@PreUpdate
	public void preUpdate() {
		lastAccessDate = new Date();
	}

}
