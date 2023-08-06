package com.portafolio.backend.portafolio_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portafolio.backend.portafolio_backend.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{
    
}
