package edu.softech.shoesShop.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.softech.shoesShop.domain.Employee;
import edu.softech.shoesShop.domain.Shoes;
import edu.softech.shoesShop.domain.ShoesSize;
import edu.softech.shoesShop.domain.ShoesType;

@Repository
public interface ShoesRepository extends JpaRepository<Shoes, Long>{
	List<Shoes> findByShoesId(Long shoesId);
	Page<Shoes> findByShoesId(Long shoesId, Pageable pageable);
	
	List<Shoes> findByIsDelete(boolean isDelete);
	Page<Shoes> findByIsDelete(boolean isDelete, Pageable pageable);
	
	List<Shoes> findByShoesTypeAndIsDelete(ShoesType shoesType, boolean isDelete);
	Page<Shoes> findByShoesTypeAndIsDelete(ShoesType shoesType, boolean isDelete, Pageable pageable);
	
	List<Shoes> findByShoesSizeAndIsDelete(ShoesSize shoesSize, boolean isDelete);
	Page<Shoes> findByShoesSizeAndIsDelete(ShoesSize shoesSize, boolean isDelete, Pageable pageable);
	
	List<Shoes> findByShoesTypeAndShoesSizeAndIsDelete(ShoesType shoesType, ShoesSize shoesSize, boolean isDelete);
	Page<Shoes> findByShoesTypeAndShoesSizeAndIsDelete(ShoesType shoesType, ShoesSize shoesSize, boolean isDelete, Pageable pageable);

	List<Shoes> findByEmployee(Employee employee);
	
	@Query(value = "SELECT SUM(quantity) FROM shoes where is_delete = 0", nativeQuery = true )
    Long totalQuantityShoes();
	
}
