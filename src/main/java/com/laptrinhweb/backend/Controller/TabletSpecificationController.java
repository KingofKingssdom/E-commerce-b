package com.laptrinhweb.backend.Controller;

import com.laptrinhweb.backend.Entity.TabletSpecification;
import com.laptrinhweb.backend.Service.TabletSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tablet")
public class TabletSpecificationController {
    private TabletSpecificationService tabletSpecificationService;
    @Autowired
    public TabletSpecificationController(TabletSpecificationService tabletSpecificationService) {
        this.tabletSpecificationService = tabletSpecificationService;
    }
    @PostMapping("/addAll")
    public List<TabletSpecification> saveAllTabletSpecification(@RequestBody List<TabletSpecification> tabletSpecifications) {
        return tabletSpecificationService.createAllTabletSpecification(tabletSpecifications);
    }
    @GetMapping("{id}")
    public TabletSpecification getAllTabletSpecification(@PathVariable int id){
        return tabletSpecificationService.findTabletSpecificationById(id);
    }

    @GetMapping("/getTablet/{productId}")
    public ResponseEntity <TabletSpecification> getTabletSpecification(@PathVariable int productId){
        TabletSpecification tabletSpecification = tabletSpecificationService.findTabletProductById(productId);
        return ResponseEntity.ok(tabletSpecification);
    }
}
