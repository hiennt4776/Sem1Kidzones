package edu.softech.shoesShop.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.apache.groovy.parser.antlr4.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.softech.shoesShop.domain.Customer;
import edu.softech.shoesShop.domain.Employee;
import edu.softech.shoesShop.repository.CustomerRepository;
import edu.softech.shoesShop.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public <S extends Customer> S save(S entity) {
		Optional<Customer> optExist = findByUsername(entity.getUsername());
		if(optExist.isPresent()) {//edit account
			if(StringUtils.isEmpty(entity.getPassword())) {
				entity.setPassword(optExist.get().getPassword());
			}else {
				entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
			}
		}else {//create account
			entity.setPassword(bCryptPasswordEncoder.encode(entity.getPassword()));
		}
		
		return customerRepository.save(entity);
	}
	
	@Override
	public <S extends Customer> S saveNoPass(S entity) {
		return customerRepository.save(entity);
	}
	
	
	@Override
	public Customer login(String username, String password) {
		Optional<Customer> optExist = findByUsername(username);
		if(optExist.isPresent() && bCryptPasswordEncoder.matches(password, optExist.get().getPassword())) {
			optExist.get().setPassword("");
			return optExist.get();
		}
		return null;
	}


	@Override
	public Optional<Customer> findByUsername(String username) {
		return customerRepository.findByUsername(username);
	}


	@Override
	public List<Customer> findByNameContaining(String name) {
		return customerRepository.findByNameContaining(name);
	}


	@Override
	public Page<Customer> findByNameContaining(String name, Pageable pageable) {
		return customerRepository.findByNameContaining(name, pageable);
	}


	@Override
	public List<Customer> findByStatus(String status) {
		return customerRepository.findByStatus(status);
	}


	@Override
	public Page<Customer> findByStatus(String status, Pageable pageable) {
		return customerRepository.findByStatus(status, pageable);
	}


	@Override
	public Long countCustomerActive() {
		return customerRepository.countCustomerActive();
	}


	@Override
	public void updateCustomerInfo(String name, String phone, String address, String email, Long customerId) {
		customerRepository.updateCustomerInfo(name, phone, address, email, customerId);
	}


	@Override
	public <S extends Customer> Optional<S> findOne(Example<S> example) {
		return customerRepository.findOne(example);
	}


	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}


	@Override
	public Page<Customer> findAll(Pageable pageable) {
		return customerRepository.findAll(pageable);
	}


	@Override
	public List<Customer> findAll(Sort sort) {
		return customerRepository.findAll(sort);
	}


	@Override
	public List<Customer> findAllById(Iterable<Long> ids) {
		return customerRepository.findAllById(ids);
	}


	@Override
	public Optional<Customer> findById(Long id) {
		return customerRepository.findById(id);
	}


	@Override
	public <S extends Customer> List<S> saveAll(Iterable<S> entities) {
		return customerRepository.saveAll(entities);
	}


	@Override
	public void flush() {
		customerRepository.flush();
	}


	@Override
	public boolean existsById(Long id) {
		return customerRepository.existsById(id);
	}


	@Override
	public <S extends Customer> S saveAndFlush(S entity) {
		return customerRepository.saveAndFlush(entity);
	}


	@Override
	public <S extends Customer> List<S> saveAllAndFlush(Iterable<S> entities) {
		return customerRepository.saveAllAndFlush(entities);
	}


	@Override
	public <S extends Customer> Page<S> findAll(Example<S> example, Pageable pageable) {
		return customerRepository.findAll(example, pageable);
	}


	@Override
	public void deleteInBatch(Iterable<Customer> entities) {
		customerRepository.deleteInBatch(entities);
	}


	@Override
	public <S extends Customer> long count(Example<S> example) {
		return customerRepository.count(example);
	}


	@Override
	public void deleteAllInBatch(Iterable<Customer> entities) {
		customerRepository.deleteAllInBatch(entities);
	}


	@Override
	public long count() {
		return customerRepository.count();
	}


	@Override
	public <S extends Customer> boolean exists(Example<S> example) {
		return customerRepository.exists(example);
	}


	@Override
	public void deleteById(Long id) {
		customerRepository.deleteById(id);
	}


	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		customerRepository.deleteAllByIdInBatch(ids);
	}


	@Override
	public void delete(Customer entity) {
		customerRepository.delete(entity);
	}


	@Override
	public <S extends Customer, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return customerRepository.findBy(example, queryFunction);
	}


	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		customerRepository.deleteAllById(ids);
	}


	@Override
	public void deleteAllInBatch() {
		customerRepository.deleteAllInBatch();
	}


	@Override
	public Customer getOne(Long id) {
		return customerRepository.getOne(id);
	}


	@Override
	public void deleteAll(Iterable<? extends Customer> entities) {
		customerRepository.deleteAll(entities);
	}


	@Override
	public void deleteAll() {
		customerRepository.deleteAll();
	}


	@Override
	public Customer getById(Long id) {
		return customerRepository.getById(id);
	}


	@Override
	public Customer getReferenceById(Long id) {
		return customerRepository.getReferenceById(id);
	}


	@Override
	public <S extends Customer> List<S> findAll(Example<S> example) {
		return customerRepository.findAll(example);
	}


	@Override
	public <S extends Customer> List<S> findAll(Example<S> example, Sort sort) {
		return customerRepository.findAll(example, sort);
	}


}
