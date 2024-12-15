package com.laptrinhweb.backend.Repository;

import com.laptrinhweb.backend.Entity.LaptopSpecification;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


@Repository
public interface LaptopSprecificationRepository extends JpaRepository<LaptopSpecification, Integer> {

    LaptopSpecification findLaptopSpecificationByProductId(int productId);
}
