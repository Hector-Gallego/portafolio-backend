package com.portafolio.backend.portafolio_backend.rest_controller;

import org.springframework.web.bind.annotation.RestController;

import com.portafolio.backend.portafolio_backend.model.Project;
import com.portafolio.backend.portafolio_backend.services.interfaces.IProjectService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
public class ProjectRestController {

    private final IProjectService projectService;
    public ProjectRestController(IProjectService projectService) {
        this.projectService = projectService;
    }


    @GetMapping("api/projects")
    public ResponseEntity<List<Project>> getAllProjects() {
        return new ResponseEntity<List<Project>>(projectService.findAll(), HttpStatus.OK);
    }
    
    
}
