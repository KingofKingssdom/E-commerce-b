package com.laptrinhweb.backend.Controller;

import com.laptrinhweb.backend.Entity.LaptopSpecification;
import com.laptrinhweb.backend.Service.LaptopSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/laptop")
public class LaptopSpecificationController {
    private LaptopSpecificationService laptopSpecificationService;
    @Autowired
    public LaptopSpecificationController(LaptopSpecificationService laptopSpecificationService) {
        this.laptopSpecificationService = laptopSpecificationService;
    }
    @PostMapping("/add")
    public LaptopSpecification saveLaptopSpecification(@RequestBody LaptopSpecification laptopSpecification) {
        return laptopSpecificationService.createLaptopSpecification(laptopSpecification);
    }
    @PostMapping("/addAll")
    public List<LaptopSpecification> saveAllLaptopSpecification(@RequestBody List<LaptopSpecification> laptopSpecifications){
        return laptopSpecificationService.createAll(laptopSpecifications);
    }
    @GetMapping("/getLaptop/{productId}")
    public ResponseEntity<LaptopSpecification> getLaptopSpecification(@PathVariable int productId) {
        LaptopSpecification laptopSpecification = laptopSpecificationService.findLaptopByProductId(productId);
        return ResponseEntity.ok(laptopSpecification);
    }
    @PutMapping("{id}")
    public ResponseEntity<LaptopSpecification> updateById(@PathVariable int id, @RequestBody LaptopSpecification laptopSpecificationDetail){
        LaptopSpecification laptopSpecification = laptopSpecificationService.findById(id);
        laptopSpecification.setCpu(laptopSpecificationDetail.getCpu());
        laptopSpecification.setGpu(laptopSpecificationDetail.getGpu());
        laptopSpecification.setGateConnection(laptopSpecificationDetail.getGateConnection());
        laptopSpecification.setPin(laptopSpecificationDetail.getPin());
        laptopSpecification.setHardDrive(laptopSpecificationDetail.getHardDrive());
        laptopSpecification.setOperatingSystem(laptopSpecificationDetail.getOperatingSystem());
        laptopSpecification.setRam(laptopSpecificationDetail.getRam());
        laptopSpecification.setRamCapacity(laptopSpecificationDetail.getRamCapacity());
        laptopSpecification.setScreen(laptopSpecificationDetail.getScreen());
        laptopSpecification.setScreenResolution(laptopSpecificationDetail.getScreenResolution());
        laptopSpecification.setScreenSize(laptopSpecificationDetail.getScreenSize());
        laptopSpecification.setSound(laptopSpecificationDetail.getSound());
        laptopSpecification.setSource(laptopSpecificationDetail.getSource());
        laptopSpecificationService.createLaptopSpecification(laptopSpecification);
        return ResponseEntity.ok(laptopSpecification);
    }




}
