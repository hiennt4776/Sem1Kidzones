package edu.softech.shoesShop.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import edu.softech.shoesShop.domain.Contact;

public interface ContactService {

	<S extends Contact> List<S> findAll(Example<S> example, Sort sort);

	<S extends Contact> List<S> findAll(Example<S> example);

	Contact getReferenceById(Long id);

	Contact getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Contact> entities);

	Contact getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends Contact, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Contact entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends Contact> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Contact> entities);

	<S extends Contact> long count(Example<S> example);

	void deleteInBatch(Iterable<Contact> entities);

	<S extends Contact> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Contact> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Contact> S saveAndFlush(S entity);

	boolean existsById(Long id);

	void flush();

	<S extends Contact> List<S> saveAll(Iterable<S> entities);

	Optional<Contact> findById(Long id);

	List<Contact> findAllById(Iterable<Long> ids);

	List<Contact> findAll(Sort sort);

	List<Contact> findAll();

	<S extends Contact> Optional<S> findOne(Example<S> example);

	<S extends Contact> S save(S entity);

	Page<Contact> findByNameContaining(String name, Pageable pageable);

	Page<Contact> findAll(Pageable pageable);



}
