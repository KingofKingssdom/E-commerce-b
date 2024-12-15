package com.laptrinhweb.backend.Repository;

import com.laptrinhweb.backend.Entity.TabletSpecification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TabletSpecificationRepository extends JpaRepository<TabletSpecification, Integer> {
    TabletSpecification findTabletSpecificationProductById (int productId);
}
