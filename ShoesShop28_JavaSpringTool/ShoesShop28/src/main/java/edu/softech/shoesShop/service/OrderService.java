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
import edu.softech.shoesShop.domain.Order;


public interface OrderService {

	<S extends Order> List<S> findAll(Example<S> example, Sort sort);

	<S extends Order> List<S> findAll(Example<S> example);

	Order getReferenceById(Long id);

	Order getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Order> entities);

	Order getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends Order, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Order entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends Order> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Order> entities);

	<S extends Order> long count(Example<S> example);

	void deleteInBatch(Iterable<Order> entities);

	<S extends Order> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Order> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Order> S saveAndFlush(S entity);

	boolean existsById(Long id);

	void flush();

	<S extends Order> List<S> saveAll(Iterable<S> entities);

	Optional<Order> findById(Long id);

	List<Order> findAllById(Iterable<Long> ids);

	List<Order> findAll(Sort sort);

	Page<Order> findAll(Pageable pageable);

	List<Order> findAll();

	Page<Order> findEmployeeNullAndStatus(String status, Pageable pageable);

	<S extends Order> Optional<S> findOne(Example<S> example);

	Page<Order> findEmployeeNull(Pageable pageable);

	Page<Order> findByStatusAndEmployee(String status, Employee employee, Pageable pageable);

	<S extends Order> S save(S entity);

	Page<Order> findByEmployee(Employee employee, Pageable pageable);

	Page<Order> findByStatus(String status, Pageable pageable);

	List<Order> findByStatusAndEmployee(String status, Employee employee);

	List<Order> findByEmployee(Employee employee);

	List<Order> findByStatus(String status);

	}
