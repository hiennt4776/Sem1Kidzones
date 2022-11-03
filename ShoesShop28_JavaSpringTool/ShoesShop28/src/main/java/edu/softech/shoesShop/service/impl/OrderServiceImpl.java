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
import edu.softech.shoesShop.domain.Order;
import edu.softech.shoesShop.domain.ShoesType;
import edu.softech.shoesShop.repository.OrderRepository;
import edu.softech.shoesShop.repository.ShoesRepository;
import edu.softech.shoesShop.service.OrderService;

@Service
public class OrderServiceImpl  implements OrderService {
	OrderRepository orderRepository;

	public OrderServiceImpl(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
	}

	@Override
	public List<Order> findByStatus(String status) {
		return orderRepository.findByStatus(status);
	}

	@Override
	public List<Order> findByEmployee(Employee employee) {
		return orderRepository.findByEmployee(employee);
	}

	@Override
	public List<Order> findByStatusAndEmployee(String status, Employee employee) {
		return orderRepository.findByStatusAndEmployee(status, employee);
	}

	@Override
	public Page<Order> findByStatus(String status, Pageable pageable) {
		return orderRepository.findByStatus(status, pageable);
	}

	@Override
	public Page<Order> findByEmployee(Employee employee, Pageable pageable) {
		return orderRepository.findByEmployee(employee, pageable);
	}

	@Override
	public <S extends Order> S save(S entity) {
		return orderRepository.save(entity);
	}

	@Override
	public Page<Order> findByStatusAndEmployee(String status, Employee employee, Pageable pageable) {
		return orderRepository.findByStatusAndEmployee(status, employee, pageable);
	}

	@Override
	public Page<Order> findEmployeeNull(Pageable pageable) {
		return orderRepository.findEmployeeNull(pageable);
	}

	@Override
	public <S extends Order> Optional<S> findOne(Example<S> example) {
		return orderRepository.findOne(example);
	}

	@Override
	public Page<Order> findEmployeeNullAndStatus(String status, Pageable pageable) {
		return orderRepository.findEmployeeNullAndStatus(status, pageable);
	}

	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public Page<Order> findAll(Pageable pageable) {
		return orderRepository.findAll(pageable);
	}

	@Override
	public List<Order> findAll(Sort sort) {
		return orderRepository.findAll(sort);
	}

	@Override
	public List<Order> findAllById(Iterable<Long> ids) {
		return orderRepository.findAllById(ids);
	}

	@Override
	public Optional<Order> findById(Long id) {
		return orderRepository.findById(id);
	}

	@Override
	public <S extends Order> List<S> saveAll(Iterable<S> entities) {
		return orderRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		orderRepository.flush();
	}

	@Override
	public boolean existsById(Long id) {
		return orderRepository.existsById(id);
	}

	@Override
	public <S extends Order> S saveAndFlush(S entity) {
		return orderRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends Order> List<S> saveAllAndFlush(Iterable<S> entities) {
		return orderRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Order> Page<S> findAll(Example<S> example, Pageable pageable) {
		return orderRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Order> entities) {
		orderRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Order> long count(Example<S> example) {
		return orderRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Order> entities) {
		orderRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return orderRepository.count();
	}

	@Override
	public <S extends Order> boolean exists(Example<S> example) {
		return orderRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		orderRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		orderRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Order entity) {
		orderRepository.delete(entity);
	}

	@Override
	public <S extends Order, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return orderRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		orderRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		orderRepository.deleteAllInBatch();
	}

	@Override
	public Order getOne(Long id) {
		return orderRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Order> entities) {
		orderRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		orderRepository.deleteAll();
	}

	@Override
	public Order getById(Long id) {
		return orderRepository.getById(id);
	}

	@Override
	public Order getReferenceById(Long id) {
		return orderRepository.getReferenceById(id);
	}

	@Override
	public <S extends Order> List<S> findAll(Example<S> example) {
		return orderRepository.findAll(example);
	}

	@Override
	public <S extends Order> List<S> findAll(Example<S> example, Sort sort) {
		return orderRepository.findAll(example, sort);
	}



}
