package com.laptrinhweb.backend.Service;

import com.laptrinhweb.backend.Entity.Brand;
import com.laptrinhweb.backend.Entity.Category;
import com.laptrinhweb.backend.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private CategoryRepository categoryRepository;
    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }
    public List<Category> createAllCategory (List<Category> categories) {
        return categoryRepository.saveAll(categories);
    }
    public Category findCategoryById (int id) {
        return  categoryRepository.findById(id).orElseThrow();
    }
    public List<Category> findAllCategory(){
        return categoryRepository.findAll();
    }
    public void deleteCategory(Category category) {
        categoryRepository.delete(category);
    }
}
