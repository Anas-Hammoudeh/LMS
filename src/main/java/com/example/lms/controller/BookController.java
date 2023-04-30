package com.example.lms.controller;

import com.example.lms.dto.book.AddBookRequest;
import com.example.lms.dto.book.UpdateBookRequest;
import com.example.lms.entity.Book;
import com.example.lms.exception.ResourceNotFoundException;
import com.example.lms.service.BookService;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/book")
@ResponseBody
public class BookController {

    private final BookService bookService;

    public BookController(@Lazy BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @SneakyThrows
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable int id) {
        Book book = bookService.getBookById(id);
        return ResponseEntity.ok().body(book);

    }

    @PostMapping("/add")
    @SneakyThrows
    public ResponseEntity addBook(@RequestBody AddBookRequest book) {
        Book savedBook = bookService.addBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @SneakyThrows
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody UpdateBookRequest updateBookRequest) {
        bookService.updateBook(id, updateBookRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @SneakyThrows
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
