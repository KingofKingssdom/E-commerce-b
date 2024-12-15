package com.laptrinhweb.backend.Service;

import com.laptrinhweb.backend.Entity.Product;
import com.laptrinhweb.backend.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product createProduct (Product product) {
        return productRepository.save(product);
    }
    public Product createProductImage(MultipartFile image) {
        Product productImage = new Product();
        try {
            productImage.setProductImage(image.getBytes());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return productRepository.save(productImage);
    }

    public List<Product> createAll(List<Product> product) {
        List<Product> products = productRepository.saveAll(product);
        return products;
    }
    public Product findProducById (int id) {
        return productRepository.findById(id).orElseThrow();
    }

    public Product updateProductImageById(int id, MultipartFile newProductImage) {
        Product existingImage = productRepository.findById(id).orElseThrow();
        try {
            existingImage.setProductImage(newProductImage.getBytes());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return productRepository.save(existingImage);
    }

    public List<Product> findAll () {
        return productRepository.findAll();
    }
    public void deleteProduct (Product product) {
        productRepository.delete(product);
    }
    // Thêm phương thức phân trang
    public Page<Product> findProductsByPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return productRepository.findAll(pageable);
    }
    // Phương thức phân trang theo categoryId
    public Page<Product> findProductsByCategoryId(int categoryId, int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return productRepository.findByCategoryId(categoryId, pageable);
    }
    // Phuong thuc truy van theo brandId và categoryId
    public List<Product> findProductByBrandIdAndCategoryId(int brandId, int categoryId){
        return productRepository.findByBrandIdAndCategoryId(brandId, categoryId);
    }

    // Phuong thuc truy van theo categoryId
    public List<Product> findProductByCategoryId (int categoryId) {
        return productRepository.findProductByCategoryId(categoryId);
    }
}
