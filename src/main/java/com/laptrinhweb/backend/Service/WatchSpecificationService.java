package com.laptrinhweb.backend.Service;

import com.laptrinhweb.backend.Entity.WatchSpecification;
import com.laptrinhweb.backend.Repository.WatchSpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchSpecificationService {
    private WatchSpecificationRepository watchSpecificationRepository;
    @Autowired
    public WatchSpecificationService(WatchSpecificationRepository watchSpecificationRepository) {
        this.watchSpecificationRepository = watchSpecificationRepository;
    }
    public List<WatchSpecification>  createAllWatchSpecification(List<WatchSpecification> watchSpecifications){
        List<WatchSpecification> watchSpecificationList = watchSpecificationRepository.saveAll(watchSpecifications);
        return watchSpecificationList;
    }
    public WatchSpecification findById(int id){
        return watchSpecificationRepository.findById(id).orElseThrow();
    }
    public List<WatchSpecification> findAll() {
        return watchSpecificationRepository.findAll();
    }
    public WatchSpecification findProductById(int productId){
        return watchSpecificationRepository.findProductById(productId);
    }
}
