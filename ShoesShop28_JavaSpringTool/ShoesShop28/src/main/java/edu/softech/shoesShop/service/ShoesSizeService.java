package edu.softech.shoesShop.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import edu.softech.shoesShop.domain.ShoesSize;

public interface ShoesSizeService {

	<S extends ShoesSize> List<S> findAll(Example<S> example, Sort sort);

	<S extends ShoesSize> List<S> findAll(Example<S> example);

	ShoesSize getReferenceById(Long id);

	ShoesSize getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends ShoesSize> entities);

	ShoesSize getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends ShoesSize, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(ShoesSize entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends ShoesSize> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<ShoesSize> entities);

	<S extends ShoesSize> long count(Example<S> example);

	void deleteInBatch(Iterable<ShoesSize> entities);

	<S extends ShoesSize> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends ShoesSize> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends ShoesSize> S saveAndFlush(S entity);

	boolean existsById(Long id);

	void flush();

	<S extends ShoesSize> List<S> saveAll(Iterable<S> entities);

	Optional<ShoesSize> findById(Long id);

	List<ShoesSize> findAllById(Iterable<Long> ids);

	List<ShoesSize> findAll(Sort sort);

	Page<ShoesSize> findAll(Pageable pageable);

	List<ShoesSize> findAll();

	<S extends ShoesSize> Optional<S> findOne(Example<S> example);

	<S extends ShoesSize> S save(S entity);

	List<ShoesSize> findShoesSizesByShoesTypeId(Long shoesTypeId);

	

}
