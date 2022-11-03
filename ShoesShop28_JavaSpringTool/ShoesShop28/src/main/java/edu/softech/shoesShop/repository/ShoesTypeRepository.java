package edu.softech.shoesShop.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.softech.shoesShop.domain.Brand;
import edu.softech.shoesShop.domain.ShoesType;

@Repository
public interface ShoesTypeRepository extends JpaRepository<ShoesType, Long>{
	
	List<ShoesType> findByNameContainingAndIsDelete(String name, boolean isDelete);
	Page<ShoesType> findByNameContainingAndIsDelete(String name, boolean isDelete, Pageable pageable);
	
	List<ShoesType> findByBrandAndIsDelete(Brand brand, boolean isDelete);
	Page<ShoesType> findByBrandAndIsDelete(Brand brand, boolean isDelete, Pageable pageable);

	
	List<ShoesType> findByIsDelete(boolean isDelete);
	Page<ShoesType> findByIsDelete(boolean isDelete, Pageable pageable);

	
	long countByIsDelete(boolean isDelete);
	
	Page<ShoesType> findByIsDeleteAndGender(boolean isDelete, boolean gender, Pageable pageable);

	@Query(value = "SELECT TOP 7 * FROM shoes_types WHERE best_seller = 1 AND is_delete=0 order by newid()", nativeQuery = true )
	List<ShoesType> findBestSellerShoes ();
	
	@Query(value = "SELECT TOP 4 * FROM shoes_types WHERE 1 = 1 AND is_delete=0 order by newid()", nativeQuery = true )
	List<ShoesType> findRelatedShoes ();
	
	@Query(value = "SELECT * FROM shoes_types WHERE gender = 1 AND is_delete=0", nativeQuery = true )
	List<ShoesType> findMenShoes ();
	
	@Query(value = "SELECT * FROM shoes_types WHERE gender = 0 AND is_delete=0", nativeQuery = true )
	List<ShoesType> findWomenShoes ();
}
