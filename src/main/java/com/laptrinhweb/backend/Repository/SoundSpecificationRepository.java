package com.laptrinhweb.backend.Repository;

import com.laptrinhweb.backend.Entity.SoundSpecification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoundSpecificationRepository extends JpaRepository<SoundSpecification,Integer> {
    SoundSpecification findSoundSpecificationProductById(int productId);
}
