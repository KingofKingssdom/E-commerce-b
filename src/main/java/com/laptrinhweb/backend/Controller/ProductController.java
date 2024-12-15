package com.laptrinhweb.backend.Controller;

import com.laptrinhweb.backend.Entity.Product;
import com.laptrinhweb.backend.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @PostMapping("/addProductWithImage")
    public ResponseEntity<Product> addProductWithImage(
            @RequestPart("product") Product product,
            @RequestPart("image") MultipartFile productImage) {

        try {
            // Chuyển đổi file ảnh thành mảng byte và đặt vào đối tượng Product
            if (productImage != null && !productImage.isEmpty()) {
                product.setProductImage(productImage.getBytes());
            }
            // Lưu sản phẩm vào database
            Product savedProduct = productService.createProduct(product);
            return ResponseEntity.ok(savedProduct);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @PostMapping("/addAll")
    public List<Product> addAll(@RequestBody List<Product> products){
        return productService.createAll(products);
    }
    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = productService.findProducById(id);
        return ResponseEntity.ok(product);
    }
    @GetMapping("/getAll")
    public List<Product> getAll() {
        return productService.findAll();
    }
    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct (@PathVariable int id, @RequestBody Product productDetails){
        Product product = productService.findProducById(id);
        product.setBrand(productDetails.getBrand());
        product.setCategory(productDetails.getCategory());
        product.setCreateAtTime(productDetails.getCreateAtTime());
        product.setDiscountPrice(productDetails.getDiscountPrice());
        product.setProductName(productDetails.getProductName());
        product.setPricePrevious(productDetails.getPricePrevious());
        product.setPriceCurrent(productDetails.getPriceCurrent());
        product.setDescription(productDetails.getDescription());
        product.setQuantity(productDetails.getQuantity());
        product.setStatus(productDetails.getStatus());
        productService.createProduct(product);
        return ResponseEntity.ok(product);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable int id) {
        Product product = productService.findProducById(id);
        productService.deleteProduct(product);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/products")
    public Page<Product> getProductsByPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return productService.findProductsByPage(page, size);
    }
    // Endpoint phân trang theo categoryId
    @GetMapping("/products/category/{categoryId}")
    public Page<Product> getProductsByCategoryId(
            @PathVariable int categoryId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {
        return productService.findProductsByCategoryId(categoryId, page, size);
    }
    // Lay san phâm theo brandId và categoryId

    @GetMapping
    public ResponseEntity<?> findProductsByBrandAndCategory(
            @RequestParam("brandId") int brandId,
            @RequestParam("categoryId") int categoryId) {
        try {
            List<Product> products = productService.findProductByBrandIdAndCategoryId(brandId, categoryId);
            if (products.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy sản phẩm nào với brandId = " + brandId + " và categoryId = " + categoryId);
            }
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Lỗi khi tìm kiếm sản phẩm.");
        }
    }


    @GetMapping("/productImage/{id}")
    public ResponseEntity<byte []> getProductImageById(@PathVariable int id) {
        Product productImage = productService.findProducById(id);
        if(productImage != null) {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.IMAGE_JPEG);
            return new ResponseEntity<>(productImage.getProductImage(),httpHeaders, HttpStatus.OK);
        }
     else {
        return ResponseEntity.notFound().build();
    }
    }
    @PutMapping("/productImage/{id}")
    public ResponseEntity<Product> updateProductImage(@PathVariable int id, @RequestParam("image") MultipartFile image) {
        try {
            Product updatedImage = productService.updateProductImageById(id, image);
            return new ResponseEntity<>(updatedImage, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // Hoặc trả về ResponseEntity với thông báo lỗi chi tiết hơn
        }
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> getProductByCategoryId(@PathVariable int categoryId) {
       return  productService.findProductByCategoryId(categoryId);

    }
}
