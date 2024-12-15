package com.laptrinhweb.backend.Controller;

import com.laptrinhweb.backend.Entity.TvSpecification;
import com.laptrinhweb.backend.Service.TvSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tv")
public class TvSpecificationController {
    private TvSpecificationService tvSpecificationService;
    @Autowired
    public TvSpecificationController(TvSpecificationService tvSpecificationService) {
        this.tvSpecificationService = tvSpecificationService;
    }
    @PostMapping("/addAll")
    public List<TvSpecification> saveAll(@RequestBody List<TvSpecification> tvSpecifications){
        return tvSpecificationService.createAllTvSpecification(tvSpecifications);
    }
    @GetMapping("/getTv/{productId}")
    public TvSpecification getProductById(@PathVariable int productId){
        return tvSpecificationService.findTiviProductById(productId);
    }
}
