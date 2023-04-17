package com.searchclassifieds.searchclassifieds.service;

import com.searchclassifieds.searchclassifieds.Exception.ClassifiedNotFoundException;
import com.searchclassifieds.searchclassifieds.dao.ClassifiedRepository;
import com.searchclassifieds.searchclassifieds.model.Classified;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ClassifiedService {
    @Autowired
    ClassifiedRepository classifiedRepository;

    static final String classifiedNotFound = "no existe clasificado";

    public Classified save(Classified classified) {
        return classifiedRepository.saveAndFlush(classified);
    }

    public List<Classified> getClassifieds() {
        return classifiedRepository.findAll();
    }

    public Classified getClassifiedById(Integer id) {
        log.info("trying to get classfied by id: {}", id );
        final Optional<Classified> classified = classifiedRepository.findById(id);
        if(classified.isEmpty() || !classified.isPresent()) {
            throw new ClassifiedNotFoundException(classifiedNotFound + " classified : " + id);
        }
        return classified.get();
    }
}
