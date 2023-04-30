package com.example.lms.service;

import com.example.lms.entity.Book;
import com.example.lms.entity.Borrow;
import com.example.lms.entity.User;
import com.example.lms.repo.impl.BookRepositoryImpl;
import com.example.lms.repo.impl.BorrowRepositoryImpl;
import com.example.lms.repo.impl.JournalRepositoryImpl;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowService {

    private final BorrowRepositoryImpl borrowRepository;

    private final BookRepositoryImpl bookRepository;

    private final JournalRepositoryImpl journalRepository;

    public BorrowService(@Lazy BorrowRepositoryImpl borrowRepository, @Lazy BookRepositoryImpl bookRepository, @Lazy JournalRepositoryImpl journalRepository) {
        this.borrowRepository = borrowRepository;
        this.bookRepository = bookRepository;
        this.journalRepository = journalRepository;
    }


    public List<Borrow> getAllBorrows() {
        return borrowRepository.getAllBorrows();
    }

    public Borrow getBorrowById(int id) {
        return borrowRepository.getBorrowById(id);
    }

    public Borrow saveBorrow(Borrow borrow) {
        return borrowRepository.saveBorrow(borrow);
    }

    public void deleteBorrowById(int id) {
        borrowRepository.deleteBorrowById(id);
    }

    public int borrowItem(int itemId, String itemType, User borrower, LocalDate borrowDate, LocalDate returnDate) throws Exception {
        Optional<Book> optionalBook = bookRepository.getBookById(itemId);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            int availableQuantity = book.getAvailableQuantity();
            if (availableQuantity > 0) {
                book.setAvailableQuantity(availableQuantity - 1);
                Borrow borrow = new Borrow();
                borrow.setItemId(itemId);
                borrow.setBorrower(borrower);
                borrow.setBorrowDate(borrowDate);
                borrow.setReturnDate(returnDate);
                // Save the borrow record to the database
                // Return the borrow ID as confirmation
                return borrow.getId();
            } else {
                throw new Exception("Book not available for borrowing");
            }
        } else {
            throw new Exception("Book not found with id " + itemId);
        }
    }

    public void returnBook(int borrowId) throws Exception {
        Optional<Borrow> optionalBorrow = borrowRepository.findBorrowByBookId(borrowId);
        if (optionalBorrow.isPresent()) {
            Borrow borrow = optionalBorrow.get();
            int bookId = borrow.getItemId();
            Optional<Book> optionalBook = bookRepository.getBookById(bookId);
            if (optionalBook.isPresent()) {
                Book book = optionalBook.get();
                int availableQuantity = book.getAvailableQuantity();
                book.setAvailableQuantity(availableQuantity + 1);
                bookRepository.addBook(book);
                borrowRepository.deleteBorrowById(borrowId);
            } else {
                throw new Exception("Book not found with id " + bookId);
            }
        } else {
            throw new Exception("Borrow record not found with id " + borrowId);
        }
    }
}
