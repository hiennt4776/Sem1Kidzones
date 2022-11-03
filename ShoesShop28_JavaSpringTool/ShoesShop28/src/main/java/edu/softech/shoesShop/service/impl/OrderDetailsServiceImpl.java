package edu.softech.shoesShop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.softech.shoesShop.domain.OrderDetail;
import edu.softech.shoesShop.repository.OrderDetailsRepository;
import edu.softech.shoesShop.service.OrderDetailsService;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService{
	@Autowired
	private OrderDetailsRepository detailsRepository;

	@Override
	public <S extends OrderDetail> S save(S entity) {
		return detailsRepository.save(entity);
	}
	
	
}
