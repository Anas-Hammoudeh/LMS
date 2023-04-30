package com.example.lms.service;

import com.example.lms.dto.book.AddBookRequest;
import com.example.lms.dto.book.UpdateBookRequest;
import com.example.lms.entity.Book;
import com.example.lms.entity.Borrow;
import com.example.lms.exception.ItemBorrowedException;
import com.example.lms.exception.ResourceNotFoundException;
import com.example.lms.repo.impl.BookRepositoryImpl;
import com.example.lms.repo.impl.BorrowRepositoryImpl;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepositoryImpl bookRepository;
    private final BorrowRepositoryImpl borrowRepository;

    public BookService(BookRepositoryImpl bookRepository, BorrowRepositoryImpl borrowRepository) {
        this.bookRepository = bookRepository;
        this.borrowRepository = borrowRepository;
    }

    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.getAllBooks();
        return books;
    }

    public Book getBookById(int id) throws ResourceNotFoundException {
        Optional<Book> book = bookRepository.getBookById(id);
        if (book.isEmpty()) {
            throw new ResourceNotFoundException("Book not found wiht id" + id);
        }
        return book.get();
    }

    public Book addBook(AddBookRequest bookRequest) {
        Book book = new Book();
        book.setAuthor(bookRequest.getAuthor());
        book.setIsbn(bookRequest.getIsbn());
        book.setQuantity(bookRequest.getQuantity());
        book.setPublisher(bookRequest.getPublisher());
        book.setTitle(bookRequest.getTitle());
        book.setAvailableQuantity(bookRequest.getAvailableQuantity());
        book.setPublicationDate(bookRequest.getPublicationDate());

        return bookRepository.addBook(book);
    }

    @Transactional
    public void updateBook(int id, UpdateBookRequest updateBookRequest) throws Exception {
        Optional<Book> optionalBook = bookRepository.getBookById(id);
        if (optionalBook.isPresent()) {
            bookRepository.updateBook(id,
                    updateBookRequest.getTitle(),
                    updateBookRequest.getIsbn(),
                    updateBookRequest.getAuthor(),
                    updateBookRequest.getPublisher(),
                    updateBookRequest.getPublicationDate(),
                    updateBookRequest.getQuantity(),
                    updateBookRequest.getAvailableQuantity());
        } else {
            throw new ResourceNotFoundException("Book not found with id " + id);
        }

    }

    public void deleteBook(int id) throws Exception {
        Optional<Book> optionalBook = bookRepository.getBookById(id);
        if (optionalBook.isPresent()) {
            if (isBookBorrowed(id)) {
                throw new ItemBorrowedException("Book with id " + id + " is borrowed, it cannot be deleted");

            } else {
                bookRepository.deleteBook(id);
            }

        } else {
            throw new ResourceNotFoundException("Book not found with id " + id);
        }
    }

    public boolean isBookBorrowed(int bookId) {

        Optional<Borrow> borrowdBook = borrowRepository.findBorrowByBookId(bookId);
        if (borrowdBook.isPresent()) {

            return true;

        }
        return false;

    }


}
