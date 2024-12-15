package com.laptrinhweb.backend.Service;

import com.laptrinhweb.backend.Entity.LaptopSpecification;
import com.laptrinhweb.backend.Repository.LaptopSprecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaptopSpecificationService {
    private LaptopSprecificationRepository laptopSprecificationRepository;
    @Autowired
    public LaptopSpecificationService(LaptopSprecificationRepository laptopSprecificationRepository) {
        this.laptopSprecificationRepository = laptopSprecificationRepository;
    }
    public LaptopSpecification createLaptopSpecification(LaptopSpecification laptopSpecification) {
        return  laptopSprecificationRepository.save(laptopSpecification);
    }
    public List<LaptopSpecification> createAll(List<LaptopSpecification> laptopSpecifications){
        List<LaptopSpecification> laptopSpecificationList = laptopSprecificationRepository.saveAll(laptopSpecifications);
        return laptopSpecificationList;
    }
    public List<LaptopSpecification> findAll(){
        return laptopSprecificationRepository.findAll();
    }
    public LaptopSpecification findById(int id) {
        return laptopSprecificationRepository.findById(id).orElseThrow();
    }
    public void deleteLaptopSpecification(int id){
        laptopSprecificationRepository.deleteById(id);
    }
    public LaptopSpecification findLaptopByProductId(int productId) {
        return laptopSprecificationRepository.findLaptopSpecificationByProductId(productId);
    }
}
