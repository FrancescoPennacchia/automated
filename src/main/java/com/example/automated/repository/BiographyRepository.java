package com.example.automated.repository;

import com.example.automated.model.biography.Biography;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BiographyRepository extends JpaRepository<Biography, Long> {

}
