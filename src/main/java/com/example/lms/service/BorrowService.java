//package com.example.lms.service;
//
//import com.example.lms.entity.Book;
//import com.example.lms.entity.Borrow;
//import com.example.lms.entity.User;
//import com.example.lms.repo.BookRepository;
//import com.example.lms.repo.BorrowRepository;
//import com.example.lms.repo.JournalRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class BorrowService {
//    @Autowired
//    private BorrowRepository borrowRepository;
//    @Autowired
//    private BookRepository bookRepository;
//    @Autowired
//    private JournalRepository journalRepository;
//
//
//    public List<Borrow> getAllBorrows() {
//        return borrowRepository.findAll();
//    }
//
//    public Borrow getBorrowById(int id) {
//        return borrowRepository.findById(id).orElse(null);
//    }
//
//    public Borrow saveBorrow(Borrow borrow) {
//        return borrowRepository.save(borrow);
//    }
//
//    public void deleteBorrowById(int id) {
//        borrowRepository.deleteById(id);
//    }
//
//    public int borrowItem(int itemId, String itemType, User borrower, LocalDate borrowDate, LocalDate returnDate) throws Exception {
//        Optional<Book> optionalBook = bookRepository.findById(itemId);
//        if (optionalBook.isPresent()) {
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
//        } else {
//            throw new Exception("Book not found with id " + itemId);
//        }
//    }
//
//    public void returnBook(int borrowId) throws Exception {
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
//    }
//}
