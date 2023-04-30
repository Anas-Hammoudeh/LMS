package com.example.lms.service;

import com.example.lms.dto.journal.AddJournalRequest;
import com.example.lms.dto.journal.UpdateJournalRequest;
import com.example.lms.entity.Journal;
import com.example.lms.exception.ResourceNotFoundException;
import com.example.lms.repo.impl.JournalRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalService {


    private final JournalRepositoryImpl journalRepository;

    public JournalService(JournalRepositoryImpl journalRepository) {
        this.journalRepository = journalRepository;
    }

    public List<Journal> getAllJournals() {

        return journalRepository.getAllJournals();
    }

    public Journal getJournalById(int id) throws ResourceNotFoundException {
        Optional<Journal> journal = journalRepository.getJournalById(id);
        if (!journal.isPresent()) {

            throw new ResourceNotFoundException("Journal does not exsit with id  " + id);
        }
        return journal.get();
    }

    public void addJournal(AddJournalRequest addJournalRequest) {
        Journal journal = new Journal();
        journal.setAvailableQuantity(addJournalRequest.getAvailableQuantity());
        journal.setPublicationDate(addJournalRequest.getPublicationDate());
        journal.setTitle(addJournalRequest.getTitle());
        journal.setQuantity(addJournalRequest.getQuantity());
        journal.setPublisher(addJournalRequest.getPublisher());
        journalRepository.addJournal(journal);
    }

    public void updateJournal(int id, UpdateJournalRequest updateJournalRequest) throws ResourceNotFoundException {
        Optional<Journal> optionalJournal = journalRepository.getJournalById(id);
        if (optionalJournal.isPresent()) {
            journalRepository.updateJournal(
                    id,
                    updateJournalRequest.getPublisher(),
                    updateJournalRequest.getPublicationDate(),
                    updateJournalRequest.getQuantity(),
                    updateJournalRequest.getAvailableQuantity()
            );
        } else {
            throw new ResourceNotFoundException("Journal with does not exist  with id  " + id);
        }
    }

    public void deleteJournal(int id) {
        journalRepository.deleteJournal(id);
    }
}

