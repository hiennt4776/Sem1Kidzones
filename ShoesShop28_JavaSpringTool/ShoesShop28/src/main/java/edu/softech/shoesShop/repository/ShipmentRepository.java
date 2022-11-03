package edu.softech.shoesShop.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import edu.softech.shoesShop.domain.Shipment;


@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long>{

	Page<Shipment> findByNameContaining(String name, Pageable pageable);
}
