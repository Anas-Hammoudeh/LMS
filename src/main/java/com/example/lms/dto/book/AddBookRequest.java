package com.example.lms.dto.book;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AddBookRequest {
    private String title;
    private String author;
    private String isbn;
    private String publisher;
    private LocalDate publicationDate;
    private int quantity;
    private int availableQuantity;
}
