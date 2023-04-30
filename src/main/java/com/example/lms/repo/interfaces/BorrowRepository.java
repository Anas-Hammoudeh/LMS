package com.example.lms.repo.interfaces;

import com.example.lms.entity.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Integer> {
    @Query("select itemId from Borrow where itemId = :item_id and itemType = 'book'")
    Optional<Borrow> findBookItem(int item_id);
    @Query("select itemId from Borrow where itemId = :item_id and itemType = 'journal'")
    Optional<Borrow>  findJournalItem(int item_id);
}
