package com.laptrinhweb.backend.Repository;

import com.laptrinhweb.backend.Entity.SmartPhoneSpecification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmartphoneSpecificationRepository extends JpaRepository<SmartPhoneSpecification,Integer> {
    SmartPhoneSpecification findProductById (int productId);
}
