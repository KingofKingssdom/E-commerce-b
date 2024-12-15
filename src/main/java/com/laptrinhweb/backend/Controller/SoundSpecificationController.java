package com.laptrinhweb.backend.Controller;

import com.laptrinhweb.backend.Entity.SoundSpecification;
import com.laptrinhweb.backend.Service.SoundSpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sound")
public class SoundSpecificationController {
    private SoundSpecificationService soundSpecificationService;
    @Autowired
    public SoundSpecificationController(SoundSpecificationService soundSpecificationService) {
        this.soundSpecificationService = soundSpecificationService;
    }
    @PostMapping("/addAll")
    public List<SoundSpecification> saveAll(@RequestBody List<SoundSpecification> soundSpecifications){
        List<SoundSpecification> soundSpecificationList = soundSpecificationService.createAll(soundSpecifications);
        return soundSpecificationList;
    }

    @GetMapping("getAll")
    public List<SoundSpecification> getAll(){
        return soundSpecificationService.findAll();
    }
    @PutMapping("{id}")
    public ResponseEntity<SoundSpecification> updateById(@PathVariable int id, @RequestBody SoundSpecification soundSpecificationDetail){
        SoundSpecification soundSpecification = soundSpecificationService.findById(id);
        soundSpecification.setBluetooth(soundSpecificationDetail.getBluetooth());
        soundSpecification.setFeature(soundSpecificationDetail.getFeature());
        soundSpecification.setSoundTechnology(soundSpecificationDetail.getSoundTechnology());
        soundSpecification.setPin(soundSpecificationDetail.getPin());
        soundSpecification.setMicro(soundSpecification.getMicro());
        soundSpecification.setSize(soundSpecificationDetail.getSize());
        soundSpecification.setScope(soundSpecification.getScope());
        soundSpecification.setWeight(soundSpecification.getWeight());
        soundSpecificationService.create(soundSpecification);
        return ResponseEntity.ok(soundSpecification);
    }
    @GetMapping("/getSound/{productId}")
    public SoundSpecification getProductById(@PathVariable int productId){
        return soundSpecificationService.findSoundProductById(productId);
    }
}
