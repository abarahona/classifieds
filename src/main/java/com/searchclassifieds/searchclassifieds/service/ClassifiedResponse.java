package com.searchclassifieds.searchclassifieds.service;

import com.searchclassifieds.searchclassifieds.model.Classified;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class ClassifiedResponse {
    private List<Classified> classifiedList;
}
