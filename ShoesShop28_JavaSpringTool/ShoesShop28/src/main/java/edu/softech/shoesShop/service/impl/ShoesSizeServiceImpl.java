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

import edu.softech.shoesShop.domain.ShoesSize;
import edu.softech.shoesShop.repository.ShoesSizeRepository;
import edu.softech.shoesShop.service.ShoesSizeService;

@Service
public class ShoesSizeServiceImpl implements ShoesSizeService{
	ShoesSizeRepository shoesSizeRepository;

	public ShoesSizeServiceImpl(ShoesSizeRepository shoesSizeRepository) {
		super();
		this.shoesSizeRepository = shoesSizeRepository;
	}

	@Override
	public List<ShoesSize> findShoesSizesByShoesTypeId(Long shoesTypeId) {
		return shoesSizeRepository.findShoesSizesByShoesTypeId(shoesTypeId);
	}

	@Override
	public <S extends ShoesSize> S save(S entity) {
		return shoesSizeRepository.save(entity);
	}

	@Override
	public <S extends ShoesSize> Optional<S> findOne(Example<S> example) {
		return shoesSizeRepository.findOne(example);
	}

	@Override
	public List<ShoesSize> findAll() {
		return shoesSizeRepository.findAll();
	}

	@Override
	public Page<ShoesSize> findAll(Pageable pageable) {
		return shoesSizeRepository.findAll(pageable);
	}

	@Override
	public List<ShoesSize> findAll(Sort sort) {
		return shoesSizeRepository.findAll(sort);
	}

	@Override
	public List<ShoesSize> findAllById(Iterable<Long> ids) {
		return shoesSizeRepository.findAllById(ids);
	}

	@Override
	public Optional<ShoesSize> findById(Long id) {
		return shoesSizeRepository.findById(id);
	}

	@Override
	public <S extends ShoesSize> List<S> saveAll(Iterable<S> entities) {
		return shoesSizeRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		shoesSizeRepository.flush();
	}

	@Override
	public boolean existsById(Long id) {
		return shoesSizeRepository.existsById(id);
	}

	@Override
	public <S extends ShoesSize> S saveAndFlush(S entity) {
		return shoesSizeRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends ShoesSize> List<S> saveAllAndFlush(Iterable<S> entities) {
		return shoesSizeRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends ShoesSize> Page<S> findAll(Example<S> example, Pageable pageable) {
		return shoesSizeRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<ShoesSize> entities) {
		shoesSizeRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends ShoesSize> long count(Example<S> example) {
		return shoesSizeRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<ShoesSize> entities) {
		shoesSizeRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return shoesSizeRepository.count();
	}

	@Override
	public <S extends ShoesSize> boolean exists(Example<S> example) {
		return shoesSizeRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		shoesSizeRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		shoesSizeRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(ShoesSize entity) {
		shoesSizeRepository.delete(entity);
	}

	@Override
	public <S extends ShoesSize, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return shoesSizeRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		shoesSizeRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		shoesSizeRepository.deleteAllInBatch();
	}

	@Override
	public ShoesSize getOne(Long id) {
		return shoesSizeRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends ShoesSize> entities) {
		shoesSizeRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		shoesSizeRepository.deleteAll();
	}

	@Override
	public ShoesSize getById(Long id) {
		return shoesSizeRepository.getById(id);
	}

	@Override
	public ShoesSize getReferenceById(Long id) {
		return shoesSizeRepository.getReferenceById(id);
	}

	@Override
	public <S extends ShoesSize> List<S> findAll(Example<S> example) {
		return shoesSizeRepository.findAll(example);
	}

	@Override
	public <S extends ShoesSize> List<S> findAll(Example<S> example, Sort sort) {
		return shoesSizeRepository.findAll(example, sort);
	}



}
