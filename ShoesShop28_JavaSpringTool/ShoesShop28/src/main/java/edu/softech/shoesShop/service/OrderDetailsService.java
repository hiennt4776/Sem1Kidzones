package edu.softech.shoesShop.service;

import edu.softech.shoesShop.domain.OrderDetail;

public interface OrderDetailsService {

	<S extends OrderDetail> S save(S entity);

}
