package edu.softech.shoesShop.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.softech.shoesShop.domain.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	Optional<Customer> findByUsername(String username);
	List<Customer> findByNameContaining(String name);
	Page<Customer> findByNameContaining(String name, Pageable pageable);
	
	List<Customer> findByStatus(String status);
	Page<Customer> findByStatus(String status, Pageable pageable);

	@Query(value = "SELECT COUNT(status) FROM customers where status = 'Active'", nativeQuery = true )
	Long countCustomerActive();
	
	
	@Transactional
	@Modifying
	@Query(value = "update customers set customer_name = ?1, phone=?2, address=?3, email=?4 where customer_id = ?5",
			nativeQuery = true )
	void updateCustomerInfo(String name, String phone, String address, String email, Long customerId);
  
}
