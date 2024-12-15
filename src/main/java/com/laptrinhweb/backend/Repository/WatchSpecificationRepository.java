package com.laptrinhweb.backend.Repository;

import com.laptrinhweb.backend.Entity.WatchSpecification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WatchSpecificationRepository extends JpaRepository<WatchSpecification, Integer> {
    WatchSpecification findProductById (int productId);
}
