package org.launchcode.rootstar.controllers;

import org.launchcode.rootstar.models.Journal;
import org.launchcode.rootstar.models.Soil;
import org.launchcode.rootstar.service.JournalService;
import org.launchcode.rootstar.service.SoilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("journal")
@CrossOrigin
public class JournalController {

    @Autowired
    private JournalService journalService;

    // GET MAPPING
    @GetMapping("/{id}")
    // Returns 200 OK HTTP Response (headers, status, and body) for soil if found, 404 if not
    public ResponseEntity<Journal> getJournalById(@PathVariable int id) {
        Optional<Journal> journal = journalService.getJournalById(id);
        return journal.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("view-journal")
    // Returns all soils in repository
    public List<Journal> viewSoils() {
        return journalService.getAllJournals();
    }

    // POST MAPPING
    @PostMapping("/add")
    // Returns a response entity with Uniform Resource Identifier with new soil ID and Body
    public ResponseEntity<Journal> addJournal(@RequestBody Journal journal) throws URISyntaxException {
        Journal savedJournal = journalService.addJournal(journal);
        return ResponseEntity.created(new URI("/journal/" + savedJournal.getId())).body(savedJournal);
    }

    // DELETE MAPPING
    @DeleteMapping("/{id}")
    public ResponseEntity deleteJournal(@PathVariable int id) {
        journalService.deleteJournal(id);
        return ResponseEntity.ok().build();
    }
}
