package com.example.lms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "books")
@Data
public class Book extends LibraryItem {
    private String author;
    private String isbn;
}
