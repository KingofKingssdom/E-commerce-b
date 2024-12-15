package com.laptrinhweb.backend.Repository;

import com.laptrinhweb.backend.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    Page<Product> findByCategoryId(int categoryId, Pageable pageable);
    @Query("SELECT p FROM Product p WHERE p.brand.id = :brandId AND p.category.id = :categoryId")
    List<Product> findByBrandIdAndCategoryId(@Param("brandId") int brandId, @Param("categoryId") int categoryId);
    List<Product> findProductByCategoryId(int categoryId);
}
