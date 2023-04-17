package com.searchclassifieds.searchclassifieds.dao;

import com.searchclassifieds.searchclassifieds.model.Classified;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassifiedRepository extends JpaRepository<Classified, Integer> {
}
