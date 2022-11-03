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

import edu.softech.shoesShop.domain.Employee;
import edu.softech.shoesShop.domain.Shoes;
import edu.softech.shoesShop.domain.ShoesSize;
import edu.softech.shoesShop.domain.ShoesType;
import edu.softech.shoesShop.repository.ShoesRepository;
import edu.softech.shoesShop.service.ShoesService;


@Service
public class ShoesServiceImpl implements ShoesService{
	ShoesRepository shoesRepository;

	public ShoesServiceImpl(ShoesRepository shoesRepository) {
		super();
		this.shoesRepository = shoesRepository;
	}

	@Override
	public List<Shoes> findByShoesId(Long shoesId) {
		return shoesRepository.findByShoesId(shoesId);
	}

	@Override
	public Page<Shoes> findByShoesId(Long shoesId, Pageable pageable) {
		return shoesRepository.findByShoesId(shoesId, pageable);
	}

	@Override
	public List<Shoes> findByIsDelete(boolean isDelete) {
		return shoesRepository.findByIsDelete(isDelete);
	}

	@Override
	public Page<Shoes> findByIsDelete(boolean isDelete, Pageable pageable) {
		return shoesRepository.findByIsDelete(isDelete, pageable);
	}

	@Override
	public List<Shoes> findByShoesTypeAndIsDelete(ShoesType shoesType, boolean isDelete) {
		return shoesRepository.findByShoesTypeAndIsDelete(shoesType, isDelete);
	}

	@Override
	public Page<Shoes> findByShoesTypeAndIsDelete(ShoesType shoesType, boolean isDelete, Pageable pageable) {
		return shoesRepository.findByShoesTypeAndIsDelete(shoesType, isDelete, pageable);
	}

	@Override
	public <S extends Shoes> S save(S entity) {
		return shoesRepository.save(entity);
	}

	@Override
	public List<Shoes> findByShoesSizeAndIsDelete(ShoesSize shoesSize, boolean isDelete) {
		return shoesRepository.findByShoesSizeAndIsDelete(shoesSize, isDelete);
	}

	@Override
	public Page<Shoes> findByShoesSizeAndIsDelete(ShoesSize shoesSize, boolean isDelete, Pageable pageable) {
		return shoesRepository.findByShoesSizeAndIsDelete(shoesSize, isDelete, pageable);
	}

	@Override
	public <S extends Shoes> Optional<S> findOne(Example<S> example) {
		return shoesRepository.findOne(example);
	}

	@Override
	public List<Shoes> findByShoesTypeAndShoesSizeAndIsDelete(ShoesType shoesType, ShoesSize shoesSize,
			boolean isDelete) {
		return shoesRepository.findByShoesTypeAndShoesSizeAndIsDelete(shoesType, shoesSize, isDelete);
	}

	@Override
	public Page<Shoes> findByShoesTypeAndShoesSizeAndIsDelete(ShoesType shoesType, ShoesSize shoesSize,
			boolean isDelete, Pageable pageable) {
		return shoesRepository.findByShoesTypeAndShoesSizeAndIsDelete(shoesType, shoesSize, isDelete, pageable);
	}

	@Override
	public List<Shoes> findAll() {
		return shoesRepository.findAll();
	}

	@Override
	public Page<Shoes> findAll(Pageable pageable) {
		return shoesRepository.findAll(pageable);
	}

	@Override
	public List<Shoes> findByEmployee(Employee employee) {
		return shoesRepository.findByEmployee(employee);
	}

	@Override
	public Long totalQuantityShoes() {
		return shoesRepository.totalQuantityShoes();
	}

	@Override
	public List<Shoes> findAll(Sort sort) {
		return shoesRepository.findAll(sort);
	}

	@Override
	public List<Shoes> findAllById(Iterable<Long> ids) {
		return shoesRepository.findAllById(ids);
	}

	@Override
	public Optional<Shoes> findById(Long id) {
		return shoesRepository.findById(id);
	}

	@Override
	public <S extends Shoes> List<S> saveAll(Iterable<S> entities) {
		return shoesRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		shoesRepository.flush();
	}

	@Override
	public boolean existsById(Long id) {
		return shoesRepository.existsById(id);
	}

	@Override
	public <S extends Shoes> S saveAndFlush(S entity) {
		return shoesRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends Shoes> List<S> saveAllAndFlush(Iterable<S> entities) {
		return shoesRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Shoes> Page<S> findAll(Example<S> example, Pageable pageable) {
		return shoesRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Shoes> entities) {
		shoesRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Shoes> long count(Example<S> example) {
		return shoesRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Shoes> entities) {
		shoesRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return shoesRepository.count();
	}

	@Override
	public <S extends Shoes> boolean exists(Example<S> example) {
		return shoesRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		shoesRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		shoesRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Shoes entity) {
		shoesRepository.delete(entity);
	}

	@Override
	public <S extends Shoes, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return shoesRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		shoesRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		shoesRepository.deleteAllInBatch();
	}

	@Override
	public Shoes getOne(Long id) {
		return shoesRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Shoes> entities) {
		shoesRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		shoesRepository.deleteAll();
	}

	@Override
	public Shoes getById(Long id) {
		return shoesRepository.getById(id);
	}

	@Override
	public Shoes getReferenceById(Long id) {
		return shoesRepository.getReferenceById(id);
	}

	@Override
	public <S extends Shoes> List<S> findAll(Example<S> example) {
		return shoesRepository.findAll(example);
	}

	@Override
	public <S extends Shoes> List<S> findAll(Example<S> example, Sort sort) {
		return shoesRepository.findAll(example, sort);
	}



}
