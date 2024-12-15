package com.laptrinhweb.backend.Service;

import com.laptrinhweb.backend.Entity.TvSpecification;
import com.laptrinhweb.backend.Repository.TvSpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TvSpecificationService {
   private TvSpecificationRepository tvSpecificationRepository;
    @Autowired
    public TvSpecificationService(TvSpecificationRepository tvSpecificationRepository) {
        this.tvSpecificationRepository = tvSpecificationRepository;
    }
    public TvSpecification createTvSpecification(TvSpecification tvSpecification) {
        return tvSpecificationRepository.save(tvSpecification);
    }
    public List<TvSpecification> createAllTvSpecification(List<TvSpecification> tvSpecifications){
        List<TvSpecification> tvSpecificationList = tvSpecificationRepository.saveAll(tvSpecifications);
        return tvSpecificationList;
    }
    public TvSpecification findTvSpecificationById(int id){
        return tvSpecificationRepository.findById(id).orElseThrow();
    }

    public List<TvSpecification> findAll() {
        return tvSpecificationRepository.findAll();
    }

    public TvSpecification findTiviProductById(int productId){
        return tvSpecificationRepository.findTvSpecificationProductById(productId);
    }
}
