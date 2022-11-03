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

import edu.softech.shoesShop.domain.Shipment;
import edu.softech.shoesShop.repository.ShipmentRepository;
import edu.softech.shoesShop.service.ShipmentService;

@Service
public class ShipmentServiceImpl  implements ShipmentService{
	ShipmentRepository shipmentRepository;

	public ShipmentServiceImpl(ShipmentRepository shipmentRepository) {
		super();
		this.shipmentRepository = shipmentRepository;
	}

	@Override
	public Page<Shipment> findByNameContaining(String name, Pageable pageable) {
		return shipmentRepository.findByNameContaining(name, pageable);
	}

	@Override
	public <S extends Shipment> S save(S entity) {
		return shipmentRepository.save(entity);
	}

	@Override
	public <S extends Shipment> Optional<S> findOne(Example<S> example) {
		return shipmentRepository.findOne(example);
	}

	@Override
	public List<Shipment> findAll() {
		return shipmentRepository.findAll();
	}

	@Override
	public Page<Shipment> findAll(Pageable pageable) {
		return shipmentRepository.findAll(pageable);
	}

	@Override
	public List<Shipment> findAll(Sort sort) {
		return shipmentRepository.findAll(sort);
	}

	@Override
	public List<Shipment> findAllById(Iterable<Long> ids) {
		return shipmentRepository.findAllById(ids);
	}

	@Override
	public Optional<Shipment> findById(Long id) {
		return shipmentRepository.findById(id);
	}

	@Override
	public <S extends Shipment> List<S> saveAll(Iterable<S> entities) {
		return shipmentRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		shipmentRepository.flush();
	}

	@Override
	public boolean existsById(Long id) {
		return shipmentRepository.existsById(id);
	}

	@Override
	public <S extends Shipment> S saveAndFlush(S entity) {
		return shipmentRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends Shipment> List<S> saveAllAndFlush(Iterable<S> entities) {
		return shipmentRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Shipment> Page<S> findAll(Example<S> example, Pageable pageable) {
		return shipmentRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Shipment> entities) {
		shipmentRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Shipment> long count(Example<S> example) {
		return shipmentRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Shipment> entities) {
		shipmentRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return shipmentRepository.count();
	}

	@Override
	public <S extends Shipment> boolean exists(Example<S> example) {
		return shipmentRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		shipmentRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		shipmentRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Shipment entity) {
		shipmentRepository.delete(entity);
	}

	@Override
	public <S extends Shipment, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return shipmentRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		shipmentRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		shipmentRepository.deleteAllInBatch();
	}

	@Override
	public Shipment getOne(Long id) {
		return shipmentRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Shipment> entities) {
		shipmentRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		shipmentRepository.deleteAll();
	}

	@Override
	public Shipment getById(Long id) {
		return shipmentRepository.getById(id);
	}

	@Override
	public Shipment getReferenceById(Long id) {
		return shipmentRepository.getReferenceById(id);
	}

	@Override
	public <S extends Shipment> List<S> findAll(Example<S> example) {
		return shipmentRepository.findAll(example);
	}

	@Override
	public <S extends Shipment> List<S> findAll(Example<S> example, Sort sort) {
		return shipmentRepository.findAll(example, sort);
	}

	
	
}
