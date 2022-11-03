package edu.softech.shoesShop.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import edu.softech.shoesShop.domain.Brand;
import edu.softech.shoesShop.repository.BrandRepository;
import edu.softech.shoesShop.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService{
	BrandRepository brandRepository;
	
	public BrandServiceImpl(BrandRepository brandRepository) {
		super();
		this.brandRepository = brandRepository;
	}

	@Override
	public List<Brand> findByNameContainingAndIsDelete(String name, boolean isDelete) {
		return brandRepository.findByNameContainingAndIsDelete(name, isDelete);
	}

	@Override
	public Page<Brand> findByNameContainingAndIsDelete(String name, boolean isDelete, Pageable pageable) {
		return brandRepository.findByNameContainingAndIsDelete(name, isDelete, pageable);
	}

	@Override
	public List<Brand> findByIsDelete(boolean isDelete) {
		return brandRepository.findByIsDelete(isDelete);
	}

	@Override
	public Page<Brand> findByIsDelete(boolean isDelete, Pageable pageable) {
		return brandRepository.findByIsDelete(isDelete, pageable);
	}

	@Override
	public <S extends Brand> S save(S entity) {
		return brandRepository.save(entity);
	}

	@Override
	public <S extends Brand> Optional<S> findOne(Example<S> example) {
		return brandRepository.findOne(example);
	}

	@Override
	public List<Brand> findAll() {
		return brandRepository.findAll();
	}

	@Override
	public Page<Brand> findAll(Pageable pageable) {
		return brandRepository.findAll(pageable);
	}

	@Override
	public List<Brand> findAll(Sort sort) {
		return brandRepository.findAll(sort);
	}

	@Override
	public List<Brand> findAllById(Iterable<Long> ids) {
		return brandRepository.findAllById(ids);
	}

	@Override
	public Optional<Brand> findById(Long id) {
		return brandRepository.findById(id);
	}

	@Override
	public <S extends Brand> List<S> saveAll(Iterable<S> entities) {
		return brandRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		brandRepository.flush();
	}

	@Override
	public boolean existsById(Long id) {
		return brandRepository.existsById(id);
	}

	@Override
	public <S extends Brand> S saveAndFlush(S entity) {
		return brandRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends Brand> List<S> saveAllAndFlush(Iterable<S> entities) {
		return brandRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Brand> Page<S> findAll(Example<S> example, Pageable pageable) {
		return brandRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Brand> entities) {
		brandRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Brand> long count(Example<S> example) {
		return brandRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Brand> entities) {
		brandRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return brandRepository.count();
	}

	@Override
	public <S extends Brand> boolean exists(Example<S> example) {
		return brandRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		brandRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		brandRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Brand entity) {
		brandRepository.delete(entity);
	}

	@Override
	public <S extends Brand, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return brandRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		brandRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		brandRepository.deleteAllInBatch();
	}

	@Override
	public Brand getOne(Long id) {
		return brandRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Brand> entities) {
		brandRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		brandRepository.deleteAll();
	}

	@Override
	public Brand getById(Long id) {
		return brandRepository.getById(id);
	}

	@Override
	public Brand getReferenceById(Long id) {
		return brandRepository.getReferenceById(id);
	}

	@Override
	public <S extends Brand> List<S> findAll(Example<S> example) {
		return brandRepository.findAll(example);
	}

	@Override
	public <S extends Brand> List<S> findAll(Example<S> example, Sort sort) {
		return brandRepository.findAll(example, sort);
	}


}
