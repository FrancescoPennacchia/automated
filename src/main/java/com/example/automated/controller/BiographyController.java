package com.example.automated.controller;


import com.example.automated.model.biography.Biography;
import com.example.automated.repository.BiographyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/biographies")
public class BiographyController {

    @Autowired
    private BiographyRepository biographyRepository;

    // Endpoint per ottenere tutte le biografie
    @GetMapping
    public ResponseEntity<List<Biography>> getAllBiographies() {
        List<Biography> biographies = biographyRepository.findAll();
        return new ResponseEntity<>(biographies, HttpStatus.OK);
    }

    // Endpoint per ottenere una singola biografia per ID
    @GetMapping("/{id}")
    public ResponseEntity<Biography> getBiographyById(@PathVariable Long id) {
        Optional<Biography> biography = biographyRepository.findById(id);
        return biography.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint per creare una nuova biografia
    @PostMapping
    public ResponseEntity<Biography> createBiography(@RequestBody Biography biography) {
        Biography savedBiography = biographyRepository.save(biography);
        return new ResponseEntity<>(savedBiography, HttpStatus.CREATED);
    }

    // Endpoint per aggiornare una biografia esistente
    @PutMapping("/{id}")
    public ResponseEntity<Biography> updateBiography(@PathVariable Long id, @RequestBody Biography biography) {
        Optional<Biography> existingBiographyOptional = biographyRepository.findById(id);
        if (existingBiographyOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        biography.setId(id);
        Biography updatedBiography = biographyRepository.save(biography);
        return new ResponseEntity<>(updatedBiography, HttpStatus.OK);
    }

    // Endpoint per eliminare una biografia
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBiography(@PathVariable Long id) {
        Optional<Biography> biographyOptional = biographyRepository.findById(id);
        if (biographyOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        biographyRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
