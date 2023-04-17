package com.searchclassifieds.searchclassifieds.Exception;

import javax.persistence.EntityNotFoundException;

public class ClassifiedNotFoundException extends EntityNotFoundException {
    public ClassifiedNotFoundException(String message) {
        super(message);
    }
}
