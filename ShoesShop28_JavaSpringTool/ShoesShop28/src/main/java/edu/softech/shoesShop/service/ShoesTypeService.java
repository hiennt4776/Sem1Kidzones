package edu.softech.shoesShop.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;

import edu.softech.shoesShop.domain.Brand;
import edu.softech.shoesShop.domain.ShoesType;

public interface ShoesTypeService {

	<S extends ShoesType> List<S> findAll(Example<S> example, Sort sort);

	<S extends ShoesType> List<S> findAll(Example<S> example);

	ShoesType getReferenceById(Long id);

	ShoesType getById(Long id);

	void deleteAll();

	void deleteAll(Iterable<? extends ShoesType> entities);

	ShoesType getOne(Long id);

	void deleteAllInBatch();

	void deleteAllById(Iterable<? extends Long> ids);

	<S extends ShoesType, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction);

	void delete(ShoesType entity);

	void deleteAllByIdInBatch(Iterable<Long> ids);

	void deleteById(Long id);

	<S extends ShoesType> boolean exists(Example<S> example);

	long count();

	void deleteAllInBatch(Iterable<ShoesType> entities);

	<S extends ShoesType> long count(Example<S> example);

	void deleteInBatch(Iterable<ShoesType> entities);

	<S extends ShoesType> Page<S> findAll(Example<S> example, Pageable pageable);

	<S extends ShoesType> List<S> saveAllAndFlush(Iterable<S> entities);

	<S extends ShoesType> S saveAndFlush(S entity);

	boolean existsById(Long id);

	void flush();

	<S extends ShoesType> List<S> saveAll(Iterable<S> entities);

	Optional<ShoesType> findById(Long id);

	List<ShoesType> findAllById(Iterable<Long> ids);

	List<ShoesType> findWomenShoes();

	List<ShoesType> findAll(Sort sort);

	List<ShoesType> findMenShoes();

	Page<ShoesType> findAll(Pageable pageable);

	List<ShoesType> findAll();

	List<ShoesType> findRelatedShoes();

	<S extends ShoesType> Optional<S> findOne(Example<S> example);

	List<ShoesType> findBestSellerShoes();

	Page<ShoesType> findByIsDeleteAndGender(boolean isDelete, boolean gender, Pageable pageable);

	long countByIsDelete(boolean isDelete);

	<S extends ShoesType> S save(S entity);

	Page<ShoesType> findByIsDelete(boolean isDelete, Pageable pageable);

	List<ShoesType> findByIsDelete(boolean isDelete);

	Page<ShoesType> findByBrandAndIsDelete(Brand brand, boolean isDelete, Pageable pageable);

	List<ShoesType> findByBrandAndIsDelete(Brand brand, boolean isDelete);

	Page<ShoesType> findByNameContainingAndIsDelete(String name, boolean isDelete, Pageable pageable);

	List<ShoesType> findByNameContainingAndIsDelete(String name, boolean isDelete);


}
