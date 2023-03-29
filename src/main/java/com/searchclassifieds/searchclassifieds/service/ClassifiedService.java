package com.searchclassifieds.searchclassifieds.service;

import com.searchclassifieds.searchclassifieds.dao.ClassifiedRepository;
import com.searchclassifieds.searchclassifieds.dto.Classified;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassifiedService {
    @Autowired
    ClassifiedRepository classifiedRepository;

    public Classified save(Classified classified) {
        return classifiedRepository.saveAndFlush(classified);
    }

    public List<Classified> getClassifieds() {
        return classifiedRepository.findAll();
    }
}
