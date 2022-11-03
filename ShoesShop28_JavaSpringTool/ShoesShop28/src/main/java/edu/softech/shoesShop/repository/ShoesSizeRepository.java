//2

package edu.softech.shoesShop.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.softech.shoesShop.domain.ShoesSize;

@Repository
public interface ShoesSizeRepository extends JpaRepository<ShoesSize, Long> {
	@Query(value = "SELECT * FROM shoes_sizes WHERE shoes_size_id IN "
			+ "(SELECT s.shoes_size_id From shoes s where shoes_type_id = ?1)", nativeQuery = true )
	List<ShoesSize> findShoesSizesByShoesTypeId (Long shoesTypeId);
}
