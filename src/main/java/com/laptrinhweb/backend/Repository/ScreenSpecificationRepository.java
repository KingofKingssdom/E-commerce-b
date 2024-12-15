package com.laptrinhweb.backend.Repository;

import com.laptrinhweb.backend.Entity.ScreenSpecification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScreenSpecificationRepository extends JpaRepository<ScreenSpecification, Integer> {
    ScreenSpecification findProductById(int productId);
}
