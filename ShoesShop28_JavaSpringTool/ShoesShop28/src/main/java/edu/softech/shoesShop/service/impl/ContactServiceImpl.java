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

import edu.softech.shoesShop.domain.Contact;
import edu.softech.shoesShop.repository.ContactRepository;
import edu.softech.shoesShop.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService{
	ContactRepository contactRepository;

	public ContactServiceImpl(ContactRepository contactRepository) {
		super();
		this.contactRepository = contactRepository;
	}

	@Override
	public Page<Contact> findAll(Pageable pageable) {
		return contactRepository.findAll(pageable);
	}

	@Override
	public Page<Contact> findByNameContaining(String name, Pageable pageable) {
		return contactRepository.findByNameContaining(name, pageable);
	}

	@Override
	public <S extends Contact> S save(S entity) {
		return contactRepository.save(entity);
	}

	@Override
	public <S extends Contact> Optional<S> findOne(Example<S> example) {
		return contactRepository.findOne(example);
	}

	@Override
	public List<Contact> findAll() {
		return contactRepository.findAll();
	}

	@Override
	public List<Contact> findAll(Sort sort) {
		return contactRepository.findAll(sort);
	}

	@Override
	public List<Contact> findAllById(Iterable<Long> ids) {
		return contactRepository.findAllById(ids);
	}

	@Override
	public Optional<Contact> findById(Long id) {
		return contactRepository.findById(id);
	}

	@Override
	public <S extends Contact> List<S> saveAll(Iterable<S> entities) {
		return contactRepository.saveAll(entities);
	}

	@Override
	public void flush() {
		contactRepository.flush();
	}

	@Override
	public boolean existsById(Long id) {
		return contactRepository.existsById(id);
	}

	@Override
	public <S extends Contact> S saveAndFlush(S entity) {
		return contactRepository.saveAndFlush(entity);
	}

	@Override
	public <S extends Contact> List<S> saveAllAndFlush(Iterable<S> entities) {
		return contactRepository.saveAllAndFlush(entities);
	}

	@Override
	public <S extends Contact> Page<S> findAll(Example<S> example, Pageable pageable) {
		return contactRepository.findAll(example, pageable);
	}

	@Override
	public void deleteInBatch(Iterable<Contact> entities) {
		contactRepository.deleteInBatch(entities);
	}

	@Override
	public <S extends Contact> long count(Example<S> example) {
		return contactRepository.count(example);
	}

	@Override
	public void deleteAllInBatch(Iterable<Contact> entities) {
		contactRepository.deleteAllInBatch(entities);
	}

	@Override
	public long count() {
		return contactRepository.count();
	}

	@Override
	public <S extends Contact> boolean exists(Example<S> example) {
		return contactRepository.exists(example);
	}

	@Override
	public void deleteById(Long id) {
		contactRepository.deleteById(id);
	}

	@Override
	public void deleteAllByIdInBatch(Iterable<Long> ids) {
		contactRepository.deleteAllByIdInBatch(ids);
	}

	@Override
	public void delete(Contact entity) {
		contactRepository.delete(entity);
	}

	@Override
	public <S extends Contact, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
		return contactRepository.findBy(example, queryFunction);
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		contactRepository.deleteAllById(ids);
	}

	@Override
	public void deleteAllInBatch() {
		contactRepository.deleteAllInBatch();
	}

	@Override
	public Contact getOne(Long id) {
		return contactRepository.getOne(id);
	}

	@Override
	public void deleteAll(Iterable<? extends Contact> entities) {
		contactRepository.deleteAll(entities);
	}

	@Override
	public void deleteAll() {
		contactRepository.deleteAll();
	}

	@Override
	public Contact getById(Long id) {
		return contactRepository.getById(id);
	}

	@Override
	public Contact getReferenceById(Long id) {
		return contactRepository.getReferenceById(id);
	}

	@Override
	public <S extends Contact> List<S> findAll(Example<S> example) {
		return contactRepository.findAll(example);
	}

	@Override
	public <S extends Contact> List<S> findAll(Example<S> example, Sort sort) {
		return contactRepository.findAll(example, sort);
	}

	
}
