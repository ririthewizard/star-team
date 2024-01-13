package org.launchcode.rootstar.service;

import org.launchcode.rootstar.models.Journal;
import org.launchcode.rootstar.models.Soil;
import org.launchcode.rootstar.models.data.JournalRepository;
import org.launchcode.rootstar.models.data.SoilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JournalService {

    private final JournalRepository journalRepository;

    @Autowired
    public JournalService(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    // CRUD operations for Soil class

    // CREATE
    public Journal addJournal(Journal journal) {
        return journalRepository.save(journal);
    }

    // READ
    public Optional<Journal> getJournalById(int id) {
        return journalRepository.findById(id);
    }

    public List<Journal> getAllJournals() {
        return journalRepository.findAll();
    }

    // TODO: make UPDATE functionality for Soil

    // DELETE

    public void deleteJournal(int id) {
        journalRepository.deleteById(id);
    }
}
