package com.laptrinhweb.backend.Controller;

import com.laptrinhweb.backend.Entity.SmartPhoneSpecification;
import com.laptrinhweb.backend.Service.SmartphoneSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/smartphone")
public class SmartPhoneSpecificationController {
    private SmartphoneSpecificationService smartphoneSpecificationService;
    @Autowired
    public SmartPhoneSpecificationController(SmartphoneSpecificationService smartphoneSpecificationService) {
        this.smartphoneSpecificationService = smartphoneSpecificationService;
    }
    @PostMapping("/addAll")
    public List<SmartPhoneSpecification> saveAllSmartPhoneSpecification(@RequestBody List<SmartPhoneSpecification> smartPhoneSpecifications){
        return smartphoneSpecificationService.createAllSmartPhoneSpecification(smartPhoneSpecifications);
    }
    @GetMapping("{id}")
    public SmartPhoneSpecification getSmartPhoneSpecificationById(@PathVariable int id){
        return smartphoneSpecificationService.findSmartPhoneSpecificationById(id);
    }
    @GetMapping("/getPhone/{productId}")
    public SmartPhoneSpecification getProductById(@PathVariable int productId){
        return smartphoneSpecificationService.findProductById(productId);
    }
}
