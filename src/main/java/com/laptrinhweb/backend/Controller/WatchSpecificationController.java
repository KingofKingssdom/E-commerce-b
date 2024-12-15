package com.laptrinhweb.backend.Controller;

import com.laptrinhweb.backend.Entity.WatchSpecification;
import com.laptrinhweb.backend.Service.WatchSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/watch")
public class WatchSpecificationController {
    private WatchSpecificationService watchSpecificationService;
    @Autowired
    public WatchSpecificationController(WatchSpecificationService watchSpecificationService) {
        this.watchSpecificationService = watchSpecificationService;
    }
    @PostMapping("addAll")
    public List<WatchSpecification> saveAll(@RequestBody List<WatchSpecification> watchSpecifications){
        return watchSpecificationService.createAllWatchSpecification(watchSpecifications);
    }
    @GetMapping("/getWatch/{productId}")
    public WatchSpecification getProductById(@PathVariable int productId){
        return watchSpecificationService.findProductById(productId);
    }
}
