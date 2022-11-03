package edu.softech.shoesShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.softech.shoesShop.domain.OrderDetail;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetail, Long>{

}
