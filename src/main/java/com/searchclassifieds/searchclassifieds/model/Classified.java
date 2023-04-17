package com.searchclassifieds.searchclassifieds.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Classified implements Serializable {

    private static final long serialVersionUID = 45345344547747L;
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    Integer id;
    String title;
    String description;

    @Column(name = "created_at")
    LocalDateTime createdAt;
    BigDecimal price;

    public Classified() {
    }

    public Classified(Integer id, String title, String description, BigDecimal price) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
    }

}
