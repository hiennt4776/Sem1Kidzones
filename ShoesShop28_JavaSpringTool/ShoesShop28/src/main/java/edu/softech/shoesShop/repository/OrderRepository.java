package edu.softech.shoesShop.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.softech.shoesShop.domain.Employee;
import edu.softech.shoesShop.domain.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	List<Order> findByStatus(String status);
	List<Order> findByEmployee(Employee employee);
	List<Order> findByStatusAndEmployee(String status,Employee employee);

	Page<Order> findByStatus(String status, Pageable pageable);
	Page<Order> findByEmployee(Employee employee, Pageable pageable);
	Page<Order> findByStatusAndEmployee(String status,Employee employee, Pageable pageable);

	
	@Query(value = "SELECT * FROM orders WHERE employee_id IS NULL", nativeQuery = true )
	Page<Order> findEmployeeNull(Pageable pageable);
	@Query(value = "SELECT * FROM orders WHERE employee_id IS NULL and status = ?", nativeQuery = true )
	Page<Order> findEmployeeNullAndStatus(String status, Pageable pageable);
}
