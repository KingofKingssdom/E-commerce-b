package com.laptrinhweb.backend.Repository;

import com.laptrinhweb.backend.Entity.TvSpecification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TvSpecificationRepository extends JpaRepository<TvSpecification, Integer> {
    TvSpecification findTvSpecificationProductById(int productId);
}
