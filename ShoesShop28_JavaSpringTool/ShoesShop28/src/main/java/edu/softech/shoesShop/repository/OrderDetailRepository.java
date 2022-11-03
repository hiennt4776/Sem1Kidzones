package edu.softech.shoesShop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.softech.shoesShop.domain.Order;
import edu.softech.shoesShop.domain.OrderDetail;
import edu.softech.shoesShop.domain.Shoes;

@Repository
public interface OrderDetailRepository  extends JpaRepository<OrderDetail, Long>{
	List<OrderDetail> findByOrder(Order order);
	List<OrderDetail> findByShoes(Shoes shoes);
	
	
}
