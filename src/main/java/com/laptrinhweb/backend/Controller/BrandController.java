package com.laptrinhweb.backend.Controller;

import com.laptrinhweb.backend.Entity.Brand;
import com.laptrinhweb.backend.Service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    private BrandService brandService;
    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }
    @PostMapping("/add")
    public Brand saveBrand (@RequestBody Brand brand) {
        return brandService.createBrand(brand);
    }
    @PostMapping("/addAll")
    public List<Brand> saveAll(@RequestBody List<Brand> brands){
        return brandService.createAllBrand(brands);
    }
    @GetMapping("/getAll")
    public List<Brand> getAll (Brand brand) {
        return  brandService.findBrand();
    }
    @GetMapping("{id}")
    public ResponseEntity<Brand> getBrandById(@PathVariable int id){
        Brand brand = brandService.findBrandById(id);
        return ResponseEntity.ok(brand);
    }

    @PutMapping("{id}")
    public ResponseEntity<Brand> updateBrandById(@PathVariable int id, @RequestBody Brand brandDetails) {
        Brand brandUpdate = brandService.findBrandById(id);
        brandUpdate.setDescription(brandDetails.getDescription());
        brandService.createBrand(brandUpdate);
        return ResponseEntity.ok(brandUpdate);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteBrand (@PathVariable int id) {
        Brand brand =brandService.findBrandById(id);
        brandService.clearBrand(brand);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
