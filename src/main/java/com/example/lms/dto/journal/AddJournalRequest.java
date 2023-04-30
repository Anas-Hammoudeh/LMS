package com.example.lms.dto.journal;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AddJournalRequest {
    private String title;
    private String publisher;
    private LocalDate publicationDate;
    private int quantity;
    private int availableQuantity;
}
