package com.example.lms.repo.impl;

import com.example.lms.entity.Borrow;
import com.example.lms.entity.LibraryItem;
import com.example.lms.entity.User;
import com.example.lms.repo.interfaces.BookRepository;
import com.example.lms.repo.interfaces.BorrowRepository;
import com.example.lms.repo.interfaces.JournalRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowRepositoryImpl {

    private final BorrowRepository borrowRepository;

    private final BookRepository bookRepository;

    private final JournalRepository journalRepository;

    public BorrowRepositoryImpl(@Lazy BorrowRepository borrowRepository,@Lazy BookRepository bookRepository,@Lazy JournalRepository journalRepository) {
        this.borrowRepository = borrowRepository;
        this.bookRepository = bookRepository;
        this.journalRepository = journalRepository;
    }


    public List<Borrow> getAllBorrows() {
        return borrowRepository.findAll();
    }

    public Borrow getBorrowById(int id) {
        return borrowRepository.findById(id).orElse(null);
    }

    public Borrow saveBorrow(Borrow borrow) {
        return borrowRepository.save(borrow);
    }

    public void deleteBorrowById(int id) {
        borrowRepository.deleteById(id);
    }
    public Optional<Borrow> findBorrowByBookId(int bookId){
        return borrowRepository.findBookItem(bookId);
    }
    public Optional<Borrow> findBorrowByJournalId(int journalId){
        return borrowRepository.findJournalItem(journalId);
    }

    public int borrowItem(LibraryItem item, String itemType, User borrower, LocalDate borrowDate, LocalDate returnDate) throws Exception {
//            Book book = optionalBook.get();
//            int availableQuantity = book.getAvailableQuantity();
//            if (availableQuantity > 0) {
//                book.setAvailableQuantity(availableQuantity - 1);
//                bookRepository.save(book);
//                Borrow borrow = new Borrow();
//                borrow.setItemId(itemId);
//                borrow.setBorrower(borrower);
//                borrow.setBorrowDate(borrowDate);
//                borrow.setReturnDate(returnDate);
//                // Save the borrow record to the database
//                // Return the borrow ID as confirmation
//                return borrow.getId();
//            } else {
//                throw new Exception("Book not available for borrowing");
//            }

        return 0;
    }

    public void returnBook(int borrowId) throws Exception {
//        Optional<Borrow> optionalBorrow = borrowRepository.findById(borrowId);
//        if (optionalBorrow.isPresent()) {
//            Borrow borrow = optionalBorrow.get();
//            int bookId = borrow.getItemId();
//            Optional<Book> optionalBook = bookRepository.findById(bookId);
//            if (optionalBook.isPresent()) {
//                Book book = optionalBook.get();
//                int availableQuantity = book.getAvailableQuantity();
//                book.setAvailableQuantity(availableQuantity + 1);
//                bookRepository.save(book);
//                borrowRepository.deleteById(borrowId);
//            } else {
//                throw new Exception("Book not found with id " + bookId);
//            }
//        } else {
//            throw new Exception("Borrow record not found with id " + borrowId);
//        }
    }
}
