package com.example.lms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@MappedSuperclass
@Data
public abstract class LibraryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String publisher;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    private int quantity;

    @Column(name = "available_quantity")
    private int availableQuantity;

}
