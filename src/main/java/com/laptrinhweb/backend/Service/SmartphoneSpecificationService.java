package com.laptrinhweb.backend.Service;

import com.laptrinhweb.backend.Entity.SmartPhoneSpecification;
import com.laptrinhweb.backend.Repository.SmartphoneSpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SmartphoneSpecificationService {
    private SmartphoneSpecificationRepository smartphoneSpecificationRepository;
    @Autowired
    public SmartphoneSpecificationService(SmartphoneSpecificationRepository smartphoneSpecificationRepository) {
        this.smartphoneSpecificationRepository = smartphoneSpecificationRepository;
    }
    public SmartPhoneSpecification createSmartPhoneSpecification(SmartPhoneSpecification smartPhoneSpecification){
        return smartphoneSpecificationRepository.save(smartPhoneSpecification);
    }
    public List<SmartPhoneSpecification> createAllSmartPhoneSpecification(List<SmartPhoneSpecification> smartPhoneSpecifications) {
        List<SmartPhoneSpecification> smartPhoneSpecificationList = smartphoneSpecificationRepository.saveAll(smartPhoneSpecifications);
        return smartPhoneSpecificationList;
    }
    public SmartPhoneSpecification findSmartPhoneSpecificationById(int id){
        return smartphoneSpecificationRepository.findById(id).orElseThrow();
    }
    public List<SmartPhoneSpecification> findAll(){
        return smartphoneSpecificationRepository.findAll();
    }
    public SmartPhoneSpecification findProductById(int productId){
        return smartphoneSpecificationRepository.findProductById(productId);
    }
}
