package com.laptrinhweb.backend.Controller;

import com.laptrinhweb.backend.Entity.ScreenSpecification;
import com.laptrinhweb.backend.Service.ScreenSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screen")
public class ScreenSpecificationController {
    private ScreenSpecificationService screenSpecificationService;
    @Autowired
    public ScreenSpecificationController(ScreenSpecificationService screenSpecificationService) {
        this.screenSpecificationService = screenSpecificationService;
    }
    @PostMapping("/addAll")
    public List<ScreenSpecification> saveAll(@RequestBody List<ScreenSpecification> screenSpecifications){
        return screenSpecificationService.crateAllScreenSpecification(screenSpecifications);
    }
    @GetMapping("/getScreen/{productId}")
    public ScreenSpecification getProductById(@PathVariable int productId) {
        return screenSpecificationService.findProductById(productId);
    }
}
