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
import edu.softech.shoesShop.domain.Shoes;
import edu.softech.shoesShop.domain.ShoesSize;
import edu.softech.shoesShop.domain.ShoesType;


public interface ShoesService {

	<S extends Shoes> List<S> findAll(Example<S> example, Sort sort);

	<S extends Shoes> List<S> findAll(Example<S> example);

	Shoes getReferenceById(Long id);

	Shoes getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends Shoes> entities);

	Shoes getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends Shoes, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(Shoes entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends Shoes> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<Shoes> entities);

	<S extends Shoes> long count(Example<S> example);

	void deleteInBatch(Iterable<Shoes> entities);

	<S extends Shoes> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends Shoes> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends Shoes> S saveAndFlush(S entity);

	boolean existsById(Long id);

	void flush();

	<S extends Shoes> List<S> saveAll(Iterable<S> entities);

	Optional<Shoes> findById(Long id);

	List<Shoes> findAllById(Iterable<Long> ids);

	List<Shoes> findAll(Sort sort);

	Long totalQuantityShoes();

	List<Shoes> findByEmployee(Employee employee);

	Page<Shoes> findAll(Pageable pageable);

	List<Shoes> findAll();

	Page<Shoes> findByShoesTypeAndShoesSizeAndIsDelete(ShoesType shoesType, ShoesSize shoesSize, boolean isDelete, Pageable pageable);

	List<Shoes> findByShoesTypeAndShoesSizeAndIsDelete(ShoesType shoesType, ShoesSize shoesSize, boolean isDelete);

	<S extends Shoes> Optional<S> findOne(Example<S> example);

	Page<Shoes> findByShoesSizeAndIsDelete(ShoesSize shoesSize, boolean isDelete, Pageable pageable);

	List<Shoes> findByShoesSizeAndIsDelete(ShoesSize shoesSize, boolean isDelete);

	<S extends Shoes> S save(S entity);

	Page<Shoes> findByShoesTypeAndIsDelete(ShoesType shoesType, boolean isDelete, Pageable pageable);

	List<Shoes> findByShoesTypeAndIsDelete(ShoesType shoesType, boolean isDelete);

	Page<Shoes> findByIsDelete(boolean isDelete, Pageable pageable);

	List<Shoes> findByIsDelete(boolean isDelete);

	Page<Shoes> findByShoesId(Long shoesId, Pageable pageable);

	List<Shoes> findByShoesId(Long shoesId);


}
