package com.laptrinhweb.backend.Service;

import com.laptrinhweb.backend.Entity.TabletSpecification;
import com.laptrinhweb.backend.Repository.TabletSpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TabletSpecificationService {
    private TabletSpecificationRepository tabletSpecificationRepository;
    @Autowired
    public TabletSpecificationService(TabletSpecificationRepository tabletSpecificationRepository) {
        this.tabletSpecificationRepository = tabletSpecificationRepository;
    }
    public TabletSpecification createTabletSpecification(TabletSpecification tabletSpecification){
        return tabletSpecificationRepository.save(tabletSpecification);
    }
    public List<TabletSpecification> createAllTabletSpecification(List<TabletSpecification> tabletSpecifications) {
        List<TabletSpecification> tabletSpecificationList = tabletSpecificationRepository.saveAll(tabletSpecifications);
        return tabletSpecificationList;
    }
    public TabletSpecification findTabletSpecificationById(int id){
        return tabletSpecificationRepository.findById(id).orElseThrow();
    }
    public List<TabletSpecification> findAll() {
        return tabletSpecificationRepository.findAll();
    }
    public TabletSpecification findTabletProductById(int productId){
        return tabletSpecificationRepository.findTabletSpecificationProductById(productId);
    }
}
