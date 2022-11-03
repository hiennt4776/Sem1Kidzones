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

import edu.softech.shoesShop.domain.Employee;
import edu.softech.shoesShop.repository.EmployeeRepository;
import edu.softech.shoesShop.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	
	@Override
	public Employee login(String username, String password) {
		Optional<Employee> optExist = findByUsernameAndStatusAndIsDelete(username,"Working",false);
		if(optExist.isPresent() && bCryptPasswordEncoder.matches(password, optExist.get().getPassword())) {
			optExist.get().setPassword("");
			return optExist.get();
		}
		return null;
	}


	@Override
	public List<Employee> findByNameContaining(String name) {
		return employeeRepository.findByNameContaining(name);
	}


	@Override
	public Page<Employee> findByNameContaining(String name, Pageable pageable) {
		return employeeRepository.findByNameContaining(name, pageable);
	}


	@Override
	public List<Employee> findByNameContainingAndIsDelete(String name, boolean isDelete) {
		return employeeRepository.findByNameContainingAndIsDelete(name, isDelete);
	}


	@Override
	public Page<Employee> findByNameContainingAndIsDelete(String name, boolean isDelete, Pageable pageable) {
		return employeeRepository.findByNameContainingAndIsDelete(name, isDelete, pageable);
	}


	@Override
	public List<Employee> findByStatusAndIsDelete(String status, boolean isDelete) {
		return employeeRepository.findByStatusAndIsDelete(status, isDelete);
	}


	@Override
	public Page<Employee> findByStatusAndIsDelete(String status, boolean isDelete, Pageable pageable) {
		return employeeRepository.findByStatusAndIsDelete(status, isDelete, pageable);
	}


	@Override
	public List<Employee> findByRoleAndIsDelete(String role, boolean isDelete) {
		return employeeRepository.findByRoleAndIsDelete(role, isDelete);
	}


	@Override
	public <S extends Employee> S save(S entity) {
		return employeeRepository.save(entity);
	}


	@Override
	public Page<Employee> findByRoleAndIsDelete(String role, boolean isDelete, Pageable pageable) {
		return employeeRepository.findByRoleAndIsDelete(role, isDelete, pageable);
	}


	@Override
	public List<Employee> findByNameContainingAndRoleAndIsDelete(String name, String role, boolean isDelete) {
		return employeeRepository.findByNameContainingAndRoleAndIsDelete(name, role, isDelete);
	}


	@Override
	public <S extends Employee> Optional<S> findOne(Example<S> example) {
		return employeeRepository.findOne(example);
	}


	@Override
	public Page<Employee> findByNameContainingAndRoleAndIsDelete(String name, String role, boolean isDelete,
			Pageable pageable) {
		return employeeRepository.findByNameContainingAndRoleAndIsDelete(name, role, isDelete, pageable);
	}


	@Override
	public List<Employee> findByNameContainingAndStatusAndIsDelete(String name, String status, boolean isDelete) {
		return employeeRepository.findByNameContainingAndStatusAndIsDelete(name, status, isDelete);
	}


	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}


	@Override
	public Page<Employee> findByNameContainingAndStatusAndIsDelete(String name, String status, boolean isDelete,
			Pageable pageable) {
		return employeeRepository.findByNameContainingAndStatusAndIsDelete(name, status, isDelete, pageable);
	}


	@Override
	public Page<Employee> findAll(Pageable pageable) {
		return employeeRepository.findAll(pageable);
	}


	@Override
	public List<Employee> findAll(Sort sort) {
		return employeeRepository.findAll(sort);
	}


	@Override
	public List<Employee> findByRoleAndStatusAndIsDelete(String role, String status, boolean isDelete) {
		return employeeRepository.findByRoleAndStatusAndIsDelete(role, status, isDelete);
	}


	@Override
	public Page<Employee> findByRoleAndStatusAndIsDelete(String role, String status, boolean isDelete,
			Pageable pageable) {
		return employeeRepository.findByRoleAndStatusAndIsDelete(role, status, isDelete, pageable);
	}


	@Override
	public List<Employee> findAllById(Iterable<Long> ids) {
		return employeeRepository.findAllById(ids);
	}


	@Override
	public List<Employee> findByNameContainingAndRoleAndStatusAndIsDelete(String name, String role, String status,
			boolean isDelete) {
		return employeeRepository.findByNameContainingAndRoleAndStatusAndIsDelete(name, role, status, isDelete);
	}


	@Override
	public Optional<Employee> findById(Long id) {
		return employeeRepository.findById(id);
	}


	@Override
	public Page<Employee> findByNameContainingAndRoleAndStatusAndIsDelete(String name, String role, String status,
			boolean isDelete, Pageable pageable) {
		return employeeRepository.findByNameContainingAndRoleAndStatusAndIsDelete(name, role, status, isDelete,
				pageable);
	}


	@Override
	public <S extends Employee> List<S> saveAll(Iterable<S> entities) {
		return employeeRepository.saveAll(entities);
	}


	@Override
	public List<Employee> findByIsDelete(boolean isDelete) {
		return employeeRepository.findByIsDelete(isDelete);
	}


	@Override
	public void flush() {
		employeeRepository.flush();
	}


	@Override
	public Page<Employee> findByIsDelete(boolean isDelete, Pageable pageable) {
		return employeeRepository.findByIsDelete(isDelete, pageable);
	}


	@Override
	public boolean existsById(Long id) {
		return employeeRepository.existsById(id);
	}


	@Override
	public <S extends Employee> S saveAndFlush(S entity) {
		return employeeRepository.saveAndFlush(entity);
	}


	@Override
	public Optional<Employee> findByUsername(String username) {
		return employeeRepository.findByUsername(username);
	}


	@Override
	public Optional<Employee> findByUsernameAndStatusAndIsDelete(String username, String status, boolean isDelete) {
		return employeeRepository.findByUsernameAndStatusAndIsDelete(username, status, isDelete);
	}


	@Override
	public Optional<Employee> findByUsernameAndIsDelete(String username, boolean isDelete) {
		return employeeRepository.findByUsernameAndIsDelete(username, isDelete);
	}


	@Override
	public <S extends Employee> List<S> saveAllAndFlush(Iterable<S> entities) {
		return employeeRepository.saveAllAndFlush(entities);
	}


	@Override
	public <S extends Employee> Page<S> findAll(Example<S> example, Pageable pageable) {
		return employeeRepository.findAll(example, pageable);
	}


	@Override
	public void deleteInBatch(Iterable<Employee> entities) {
		employeeRepository.deleteInBatch(entities);
	}


	@Override
	public <S extends Employee> long count(Example<S> example) {
		return employeeRepository.count(example);
	}


	@Override
	public void deleteAllInBatch(Iterable<Employee> entities) {
		employeeRepository.deleteAllInBatch(entities);
	}


	@Override
	public long count() {
		return employeeRepository.count();
	}


	@Override
	public <S extends Employee> boolean exists(Example<S> example) {
		return employeeRepository.exists(example);
	}


	@Override
	public void deleteById(Long id) {
		employeeRepository.deleteById(id);
	}


	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		employeeRepository.deleteAllByIdInBatch(ids);
	}


	@Override
	public void delete(Employee entity) {
		employeeRepository.delete(entity);
	}


	@Override
	public <S extends Employee, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return employeeRepository.findBy(example, queryFunction);
	}


	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		employeeRepository.deleteAllById(ids);
	}


	@Override
	public void deleteAllInBatch() {
		employeeRepository.deleteAllInBatch();
	}


	@Override
	public Employee getOne(Long id) {
		return employeeRepository.getOne(id);
	}


	@Override
	public void deleteAll(Iterable<? extends Employee> entities) {
		employeeRepository.deleteAll(entities);
	}


	@Override
	public void deleteAll() {
		employeeRepository.deleteAll();
	}


	@Override
	public Employee getById(Long id) {
		return employeeRepository.getById(id);
	}


	@Override
	public Employee getReferenceById(Long id) {
		return employeeRepository.getReferenceById(id);
	}


	@Override
	public <S extends Employee> List<S> findAll(Example<S> example) {
		return employeeRepository.findAll(example);
	}


	@Override
	public <S extends Employee> List<S> findAll(Example<S> example, Sort sort) {
		return employeeRepository.findAll(example, sort);
	}


	

	
}


