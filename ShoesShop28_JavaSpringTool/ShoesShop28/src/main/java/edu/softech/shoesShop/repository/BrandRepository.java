package edu.softech.shoesShop.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.softech.shoesShop.domain.Brand;
@Repository
public interface BrandRepository extends JpaRepository<Brand, Long>{
//	List<Brand> findByNameContaining(String name);
//	Page<Brand> findByNameContaining(String name, Pageable pageable);
	
	List<Brand> findByNameContainingAndIsDelete(String name, boolean isDelete);
	Page<Brand> findByNameContainingAndIsDelete(String name, boolean isDelete, Pageable pageable);
	
	List<Brand> findByIsDelete(boolean isDelete);
	Page<Brand> findByIsDelete(boolean isDelete, Pageable pageable);

}
