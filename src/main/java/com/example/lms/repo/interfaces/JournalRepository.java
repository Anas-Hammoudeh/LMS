package com.example.lms.repo.interfaces;

import com.example.lms.entity.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Integer> {
    @Modifying
    @Query("UPDATE Journal b SET b.title = :title,  b.publisher = :publisher, b.publicationDate = :publicationDate, b.quantity = :quantity, b.availableQuantity = :availableQuantity WHERE b.id = :id")
    void updateBook(@Param("id") int id, @Param("publisher") String publisher, @Param("publicationDate") LocalDate publicationDate, @Param("quantity") int quantity, @Param("availableQuantity") int availableQuantity);
}