package com.portafolio.backend.portafolio_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portafolio.backend.portafolio_backend.model.Technology;

public interface  TechologyRepository extends JpaRepository< Technology, Long>{
    
}
