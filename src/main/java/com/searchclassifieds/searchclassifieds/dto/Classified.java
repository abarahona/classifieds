package com.searchclassifieds.searchclassifieds.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
public class Classified implements Serializable {

    private static final long serialVersionUID = 45345344547747L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    String description;

    public Classified() {
    }

    public Classified(Long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

}
