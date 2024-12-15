package com.laptrinhweb.backend.Service;

import com.laptrinhweb.backend.Entity.Brand;
import com.laptrinhweb.backend.Entity.Category;
import com.laptrinhweb.backend.Repository.BrandRepository;
import com.laptrinhweb.backend.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandService {
    private BrandRepository brandRepository;
    private CategoryRepository categoryRepository;
    @Autowired
    public BrandService(BrandRepository brandRepository, CategoryRepository categoryRepository) {
        this.brandRepository = brandRepository;
        this.categoryRepository =categoryRepository;
    }
    public Brand createBrand(Brand brand){
        return brandRepository.save(brand);
    }
    public List<Brand> createAllBrand(List<Brand> brands) {
        List<Brand> brandList = brandRepository.saveAll(brands);
        return brandList;
    }
    public List<Brand> findBrand() {
        return  brandRepository.findAll();
    }
    public Brand findBrandById(int id) {
        return  brandRepository.findById(id).orElseThrow();
    }

    public void clearBrand(Brand brand){
        brandRepository.delete(brand);
    }

}
