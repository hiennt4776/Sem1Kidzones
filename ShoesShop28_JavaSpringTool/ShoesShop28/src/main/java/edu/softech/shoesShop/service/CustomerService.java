package edu.softech.shoesShop.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import edu.softech.shoesShop.domain.Customer;

public interface CustomerService {

	<S extends Customer> List<S> findAll(Example<S> example, Sort sort);

	<S extends Customer> List<S> findAll(Example<S> example);

	Customer getReferenceById(Long id);

	Customer getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Customer> entities);

	Customer getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends Customer, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Customer entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends Customer> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Customer> entities);

	<S extends Customer> long count(Example<S> example);

	void deleteInBatch(Iterable<Customer> entities);

	<S extends Customer> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Customer> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Customer> S saveAndFlush(S entity);

	boolean existsById(Long id);

	void flush();

	<S extends Customer> List<S> saveAll(Iterable<S> entities);

	Optional<Customer> findById(Long id);

	List<Customer> findAllById(Iterable<Long> ids);

	List<Customer> findAll(Sort sort);

	Page<Customer> findAll(Pageable pageable);

	List<Customer> findAll();

	<S extends Customer> Optional<S> findOne(Example<S> example);

	void updateCustomerInfo(String name, String phone, String address, String email, Long customerId);

	Long countCustomerActive();

	Page<Customer> findByStatus(String status, Pageable pageable);

	List<Customer> findByStatus(String status);

	Page<Customer> findByNameContaining(String name, Pageable pageable);

	List<Customer> findByNameContaining(String name);

	Optional<Customer> findByUsername(String username);

	Customer login(String username, String password);

	<S extends Customer> S save(S entity);
	<S extends Customer> S saveNoPass(S entity);

	
}
