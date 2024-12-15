package com.laptrinhweb.backend.Service;

import com.laptrinhweb.backend.Entity.SoundSpecification;
import com.laptrinhweb.backend.Repository.SoundSpecificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SoundSpecificationService {
    private SoundSpecificationRepository soundSpecificationRepository;

    public SoundSpecificationService(SoundSpecificationRepository soundSpecificationRepository) {
        this.soundSpecificationRepository = soundSpecificationRepository;
    }
    public List<SoundSpecification> createAll(List<SoundSpecification> soundSpecifications) {
        List<SoundSpecification> soundSpecificationList = soundSpecificationRepository.saveAll(soundSpecifications);
        return soundSpecificationList;
    }
    public SoundSpecification create(SoundSpecification soundSpecification){
        return soundSpecificationRepository.save(soundSpecification);
    }
    public SoundSpecification findById(int id) {
        return soundSpecificationRepository.findById(id).orElseThrow();
    }
    public List<SoundSpecification> findAll(){
        return soundSpecificationRepository.findAll();
    }
    public SoundSpecification findSoundProductById(int productId){
        return soundSpecificationRepository.findSoundSpecificationProductById(productId);
    }
}
