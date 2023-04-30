package com.example.lms.repo.impl;

import com.example.lms.entity.Book;
import com.example.lms.repo.interfaces.BookRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookRepositoryImpl {
    private final BookRepository bookRepository;


    public BookRepositoryImpl(@Lazy BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(int id) {

        return bookRepository.findById(id);
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(int id) throws Exception {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            bookRepository.deleteById(id);
        } else {
            throw new Exception("Book not found with id " + id);
        }
    }

    public void updateBook(
            int id,
            String title,
            String isbn,
            String author,
            String publisher,
            LocalDate publicationDate,
            int quantity,
            int availableQuantity
    ) {
        bookRepository.updateBook(id,title,isbn,author,publisher,publicationDate,quantity,availableQuantity);

    }


}
