package edu.softech.shoesShop.service.impl;


import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import edu.softech.shoesShop.domain.Brand;
import edu.softech.shoesShop.domain.ShoesType;
import edu.softech.shoesShop.repository.ShoesTypeRepository;
import edu.softech.shoesShop.service.ShoesTypeService;

@Service
public class ShoesTypeServiceImpl implements ShoesTypeService{
	@Autowired
	private ShoesTypeRepository shoesTypeRepository;

	public ShoesTypeServiceImpl(ShoesTypeRepository shoesTypeRepository) {
		super();
		this.shoesTypeRepository = shoesTypeRepository;
	}

	@Override
	public List<ShoesType> findByNameContainingAndIsDelete(String name, boolean isDelete) {
		return shoesTypeRepository.findByNameContainingAndIsDelete(name, isDelete);
	}

	@Override
	public Page<ShoesType> findByNameContainingAndIsDelete(String name, boolean isDelete, Pageable pageable) {
		return shoesTypeRepository.findByNameContainingAndIsDelete(name, isDelete, pageable);
	}

	@Override
	public List<ShoesType> findByBrandAndIsDelete(Brand brand, boolean isDelete) {
		return shoesTypeRepository.findByBrandAndIsDelete(brand, isDelete);
	}

	@Override
	public Page<ShoesType> findByBrandAndIsDelete(Brand brand, boolean isDelete, Pageable pageable) {
		return shoesTypeRepository.findByBrandAndIsDelete(brand, isDelete, pageable);
	}

	@Override
	public List<ShoesType> findByIsDelete(boolean isDelete) {
		return shoesTypeRepository.findByIsDelete(isDelete);
	}

	@Override
	public Page<ShoesType> findByIsDelete(boolean isDelete, Pageable pageable) {
		return shoesTypeRepository.findByIsDelete(isDelete, pageable);
	}

	@Override
	public <S extends ShoesType> S save(S entity) {
		return shoesTypeRepository.save(entity);
	}

	@Override
	public long countByIsDelete(boolean isDelete) {
		return shoesTypeRepository.countByIsDelete(isDelete);
	}

	@Override
	public Page<ShoesType> findByIsDeleteAndGender(boolean isDelete, boolean gender, Pageable pageable) {
		return shoesTypeRepository.findByIsDeleteAndGender(isDelete, gender, pageable);
	}

	@Override
	public List<ShoesType> findBestSellerShoes() {
		return shoesTypeRepository.findBestSellerShoes();
	}

	@Override
	public <S extends ShoesType> Optional<S> findOne(Example<S> example) {
		return shoesTypeRepository.findOne(example);
	}

	@Override
	public List<ShoesType> findRelatedShoes() {
		return shoesTypeRepository.findRelatedShoes();
	}

	@Override
	public List<ShoesType> findAll() {
		return shoesTypeRepository.findAll();
	}

	@Override
	public Page<ShoesType> findAll(Pageable pageable) {
		return shoesTypeRepository.findAll(pageable);
	}

	@Override
	public List<ShoesType> findMenShoes() {
		return shoesTypeRepository.findMenShoes();
	}

	@Override
	public List<ShoesType> findAll(Sort sort) {
		return shoesTypeRepository.findAll(sort);
	}

	@Override
	public List<ShoesType> findWomenShoes() {
		return shoesTypeRepository.findWomenShoes();
	}

	@Override
	public List<ShoesType> findAllById(Iterable<Long> ids) {
		return shoesTypeRepository.findAllById(ids);
	}

	@Override
	public Optional<ShoesType> findById(Long id) {
		return shoesTypeRepository.findById(id);
	}

	@Override
	public <S extends ShoesType> List<S> saveAll(Iterable<S> entities) {
		return shoesTypeRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		shoesTypeRepository.flush();
	}

	@Override
	public boolean existsById(Long id) {
		return shoesTypeRepository.existsById(id);
	}

	@Override
	public <S extends ShoesType> S saveAndFlush(S entity) {
		return shoesTypeRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends ShoesType> List<S> saveAllAndFlush(Iterable<S> entities) {
		return shoesTypeRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends ShoesType> Page<S> findAll(Example<S> example, Pageable pageable) {
		return shoesTypeRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<ShoesType> entities) {
		shoesTypeRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends ShoesType> long count(Example<S> example) {
		return shoesTypeRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<ShoesType> entities) {
		shoesTypeRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return shoesTypeRepository.count();
	}

	@Override
	public <S extends ShoesType> boolean exists(Example<S> example) {
		return shoesTypeRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		shoesTypeRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		shoesTypeRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(ShoesType entity) {
		shoesTypeRepository.delete(entity);
	}

	@Override
	public <S extends ShoesType, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return shoesTypeRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		shoesTypeRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		shoesTypeRepository.deleteAllInBatch();
	}

	@Override
	public ShoesType getOne(Long id) {
		return shoesTypeRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends ShoesType> entities) {
		shoesTypeRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		shoesTypeRepository.deleteAll();
	}

	@Override
	public ShoesType getById(Long id) {
		return shoesTypeRepository.getById(id);
	}

	@Override
	public ShoesType getReferenceById(Long id) {
		return shoesTypeRepository.getReferenceById(id);
	}

	@Override
	public <S extends ShoesType> List<S> findAll(Example<S> example) {
		return shoesTypeRepository.findAll(example);
	}

	@Override
	public <S extends ShoesType> List<S> findAll(Example<S> example, Sort sort) {
		return shoesTypeRepository.findAll(example, sort);
	}


}
