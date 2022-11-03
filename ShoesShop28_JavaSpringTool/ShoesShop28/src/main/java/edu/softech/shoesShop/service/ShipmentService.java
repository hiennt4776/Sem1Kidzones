package edu.softech.shoesShop.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import edu.softech.shoesShop.domain.Shipment;

public interface ShipmentService {

	<S extends Shipment> List<S> findAll(Example<S> example, Sort sort);

	<S extends Shipment> List<S> findAll(Example<S> example);

	Shipment getReferenceById(Long id);

	Shipment getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Shipment> entities);

	Shipment getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends Shipment, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Shipment entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends Shipment> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Shipment> entities);

	<S extends Shipment> long count(Example<S> example);

	void deleteInBatch(Iterable<Shipment> entities);

	<S extends Shipment> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Shipment> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Shipment> S saveAndFlush(S entity);

	boolean existsById(Long id);

	void flush();

	<S extends Shipment> List<S> saveAll(Iterable<S> entities);

	Optional<Shipment> findById(Long id);

	List<Shipment> findAllById(Iterable<Long> ids);

	List<Shipment> findAll(Sort sort);

	Page<Shipment> findAll(Pageable pageable);

	List<Shipment> findAll();

	<S extends Shipment> Optional<S> findOne(Example<S> example);

	<S extends Shipment> S save(S entity);

	Page<Shipment> findByNameContaining(String name, Pageable pageable);

}
