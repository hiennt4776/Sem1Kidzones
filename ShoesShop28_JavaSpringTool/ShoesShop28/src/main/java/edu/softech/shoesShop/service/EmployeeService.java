package edu.softech.shoesShop.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import edu.softech.shoesShop.domain.Employee;

public interface EmployeeService {

	<S extends Employee> List<S> findAll(Example<S> example, Sort sort);

	<S extends Employee> List<S> findAll(Example<S> example);

	Employee getReferenceById(Long id);

	Employee getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Employee> entities);

	Employee getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends Employee, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Employee entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends Employee> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Employee> entities);

	<S extends Employee> long count(Example<S> example);

	void deleteInBatch(Iterable<Employee> entities);

	<S extends Employee> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Employee> List<S> saveAllAndFlush(Iterable<S> entities);

	Optional<Employee> findByUsernameAndIsDelete(String username, boolean isDelete);

	Optional<Employee> findByUsernameAndStatusAndIsDelete(String username, String status, boolean isDelete);

	Optional<Employee> findByUsername(String username);

	<S extends Employee> S saveAndFlush(S entity);

	boolean existsById(Long id);

	Page<Employee> findByIsDelete(boolean isDelete, Pageable pageable);

	void flush();

	List<Employee> findByIsDelete(boolean isDelete);

	<S extends Employee> List<S> saveAll(Iterable<S> entities);

	Page<Employee> findByNameContainingAndRoleAndStatusAndIsDelete(String name, String role, String status, boolean isDelete,
			Pageable pageable);

	Optional<Employee> findById(Long id);

	List<Employee> findByNameContainingAndRoleAndStatusAndIsDelete(String name, String role, String status, boolean isDelete);

	List<Employee> findAllById(Iterable<Long> ids);

	Page<Employee> findByRoleAndStatusAndIsDelete(String role, String status, boolean isDelete, Pageable pageable);

	List<Employee> findByRoleAndStatusAndIsDelete(String role, String status, boolean isDelete);

	List<Employee> findAll(Sort sort);

	Page<Employee> findAll(Pageable pageable);

	Page<Employee> findByNameContainingAndStatusAndIsDelete(String name, String status, boolean isDelete, Pageable pageable);

	List<Employee> findAll();

	List<Employee> findByNameContainingAndStatusAndIsDelete(String name, String status, boolean isDelete);

	Page<Employee> findByNameContainingAndRoleAndIsDelete(String name, String role, boolean isDelete, Pageable pageable);

	<S extends Employee> Optional<S> findOne(Example<S> example);

	List<Employee> findByNameContainingAndRoleAndIsDelete(String name, String role, boolean isDelete);

	Page<Employee> findByRoleAndIsDelete(String role, boolean isDelete, Pageable pageable);

	<S extends Employee> S save(S entity);

	List<Employee> findByRoleAndIsDelete(String role, boolean isDelete);

	Page<Employee> findByStatusAndIsDelete(String status, boolean isDelete, Pageable pageable);

	List<Employee> findByStatusAndIsDelete(String status, boolean isDelete);

	Page<Employee> findByNameContainingAndIsDelete(String name, boolean isDelete, Pageable pageable);

	List<Employee> findByNameContainingAndIsDelete(String name, boolean isDelete);

	Page<Employee> findByNameContaining(String name, Pageable pageable);

	List<Employee> findByNameContaining(String name);

	Employee login(String username, String password);

}
