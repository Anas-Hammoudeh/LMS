package com.example.lms.repo.interfaces;

import com.example.lms.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Modifying
    @Query("UPDATE Book b SET b.title = :title, b.author = :author, b.isbn = :isbn,  b.publisher = :publisher, b.publicationDate = :publicationDate, b.quantity = :quantity, b.availableQuantity = :availableQuantity WHERE b.id = :id")
    void updateBook(@Param("id") int id, @Param("title") String title,@Param("isbn") String isbn, @Param("author") String author, @Param("publisher") String publisher, @Param("publicationDate") LocalDate publicationDate, @Param("quantity") int quantity, @Param("availableQuantity") int availableQuantity);
}
