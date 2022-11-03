package edu.softech.shoesShop.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import edu.softech.shoesShop.domain.Employee;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	List<Employee> findByNameContaining(String name);
	Page<Employee> findByNameContaining(String name, Pageable pageable);
	
	List<Employee> findByNameContainingAndIsDelete(String name, boolean isDelete);
	Page<Employee> findByNameContainingAndIsDelete(String name, boolean isDelete, Pageable pageable);
	
	List<Employee> findByStatusAndIsDelete(String status, boolean isDelete);
	Page<Employee> findByStatusAndIsDelete(String status, boolean isDelete, Pageable pageable);
	
	List<Employee> findByRoleAndIsDelete(String role, boolean isDelete);
	Page<Employee> findByRoleAndIsDelete(String role, boolean isDelete, Pageable pageable);
	
	List<Employee> findByNameContainingAndRoleAndIsDelete(String name, String role, boolean isDelete);
	Page<Employee> findByNameContainingAndRoleAndIsDelete(String name, String role, boolean isDelete, Pageable pageable);
	
	List<Employee> findByNameContainingAndStatusAndIsDelete(String name,String status, boolean isDelete);
	Page<Employee> findByNameContainingAndStatusAndIsDelete(String name,String status, boolean isDelete, Pageable pageable);
	
	List<Employee> findByRoleAndStatusAndIsDelete(String role,String status, boolean isDelete);
	Page<Employee> findByRoleAndStatusAndIsDelete(String role,String status, boolean isDelete, Pageable pageable);
	
	List<Employee> findByNameContainingAndRoleAndStatusAndIsDelete(String name, String role, String status, boolean isDelete);
	Page<Employee> findByNameContainingAndRoleAndStatusAndIsDelete(String name, String role, String status, boolean isDelete, Pageable pageable);
	
	List<Employee> findByIsDelete(boolean isDelete);
	Page<Employee> findByIsDelete(boolean isDelete, Pageable pageable);
 	Optional<Employee> findByUsername(String username);
 	
 	Optional<Employee> findByUsernameAndStatusAndIsDelete(String username, String status, boolean isDelete);
 	Optional<Employee> findByUsernameAndIsDelete(String username, boolean isDelete);
 	

	


}
