package com.example.lms.repo.impl;

import com.example.lms.entity.Journal;
import com.example.lms.repo.interfaces.JournalRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class JournalRepositoryImpl {


    private final JournalRepository journalRepository;

    public JournalRepositoryImpl(@Lazy JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    public List<Journal> getAllJournals() {
        return journalRepository.findAll();
    }

    public Optional<Journal> getJournalById(int id) {
        return journalRepository.findById(id);
    }

    public void addJournal(Journal journal) {
        journalRepository.save(journal);
    }

    public void updateJournal(
            int id,
            String publisher,
            LocalDate publicationDate,
            int quantity,
            int availableQuantity
    ) {
        journalRepository.updateBook(id,publisher,publicationDate,quantity,availableQuantity);

    }

    public void deleteJournal(int id) {
        journalRepository.deleteById(id);
    }
}

