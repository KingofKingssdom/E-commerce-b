package com.laptrinhweb.backend.Controller;

import com.laptrinhweb.backend.Entity.Category;
import com.laptrinhweb.backend.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/add")
    public Category addCategory (@RequestBody Category category) {
        return categoryService.createCategory(category);
    }
    @PostMapping("/addAll")
    public List<Category> saveAllCategory(@RequestBody List<Category> categories){
        return  categoryService.createAllCategory(categories);
    }
    @GetMapping("/getAll")
    public List<Category> findAll () {
        return categoryService.findAllCategory();
    }
    @GetMapping("{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable int id){
        Category category = categoryService.findCategoryById(id);
        return ResponseEntity.ok(category);
    }

    @PutMapping("{id}")
    public ResponseEntity<Category> updateCateroy(@PathVariable int id, @RequestBody Category categoryDetails) {
        Category category = categoryService.findCategoryById(id);
        category.setCategoryName(categoryDetails.getCategoryName());
        categoryService.createCategory(category);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteCategory (@PathVariable int id){
        Category category = categoryService.findCategoryById(id);
        categoryService.deleteCategory(category);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
