package edu.softech.shoesShop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.softech.shoesShop.domain.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long>{
	Page<Contact> findAll(Pageable pageable);
	Page<Contact> findByNameContaining(String name, Pageable pageable);
}
