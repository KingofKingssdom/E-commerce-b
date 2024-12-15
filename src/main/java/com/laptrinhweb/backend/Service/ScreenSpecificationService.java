package com.laptrinhweb.backend.Service;

import com.laptrinhweb.backend.Entity.ScreenSpecification;
import com.laptrinhweb.backend.Repository.ScreenSpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScreenSpecificationService {
    private ScreenSpecificationRepository screenSpecificationRepository;
    @Autowired
    public ScreenSpecificationService(ScreenSpecificationRepository screenSpecificationRepository) {
        this.screenSpecificationRepository = screenSpecificationRepository;
    }
    public ScreenSpecification createScreenSpecification(ScreenSpecification screenSpecification){
        return screenSpecificationRepository.save(screenSpecification);
    }
    public List<ScreenSpecification> crateAllScreenSpecification(List<ScreenSpecification> screenSpecifications){
        List<ScreenSpecification> screenSpecificationList = screenSpecificationRepository.saveAll(screenSpecifications);
        return screenSpecificationList;
    }
    public ScreenSpecification findScreenSpecificationById(int id){
        return screenSpecificationRepository.findById(id).orElseThrow();
    }
    public List<ScreenSpecification> findAll() {
        return screenSpecificationRepository.findAll();
    }
    public ScreenSpecification findProductById(int productId){
        return screenSpecificationRepository.findProductById(productId);
    }

}
