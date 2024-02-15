package com.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.backend.Dtos.ProductsDto;
import com.backend.Entities.Category;
import com.backend.Entities.Products;

@Repository
public interface ProductsRepo extends JpaRepository<Products, Long> {
    List<Products> findByCategory(Category category);
//    List<Products> findByServiceNameContainingIgnoreCase(String serviceName);
//    List<Products> findByProductsNameContainingIgnoreCase(String name);
//    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))")
//    List<Products> searchProductByName(@Param("name") String name);
//    @Query("SELECT P FROM Products P WHERE  LOWER(p.name) =:   ORDER BY s.productId ASC")
//	List<Services> findBySubCategory(SubCategory subCategory);

	List<Products> findByProductsNameContainingIgnoreCase(String name);



}
