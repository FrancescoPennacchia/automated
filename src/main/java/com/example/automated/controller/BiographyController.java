package com.example.automated.controller;


import com.example.automated.model.biography.Biography;
import com.example.automated.repository.BiographyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/biographies")
public class BiographyController {

    @Autowired
    private BiographyRepository biographyRepository;

    // Endpoint per ottenere tutte le biografie
    @GetMapping("/allBiography")
    public ResponseEntity<List<Biography>> getAllBiographies() {
        List<Biography> biographies = biographyRepository.findAll();
        return new ResponseEntity<>(biographies, HttpStatus.OK);
    }

    // Endpoint per ottenere una singola biografia per ID
    @GetMapping("/getBiography/{id}")
    public ResponseEntity<Biography> getBiographyById(@PathVariable Long id) {
        Optional<Biography> biography = biographyRepository.findById(id);
        return biography.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint per creare una nuova biografia
    @PostMapping("/addBiography")
    public ResponseEntity<Biography> createBiography(@RequestBody Biography biography) {
        Biography savedBiography = biographyRepository.save(biography);
        return new ResponseEntity<>(savedBiography, HttpStatus.CREATED);
    }

    // Endpoint per aggiornare una biografia esistente
    @PutMapping("/updateBiography/{id}")
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
    @DeleteMapping("/deleteBiography/{id}")
    public ResponseEntity<Void> deleteBiography(@PathVariable Long id) {
        Optional<Biography> biographyOptional = biographyRepository.findById(id);
        if (biographyOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        biographyRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
