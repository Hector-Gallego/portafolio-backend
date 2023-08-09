package com.portafolio.backend.portafolio_backend.rest_controller;

import org.springframework.web.bind.annotation.RestController;

import com.portafolio.backend.portafolio_backend.model.Project;
import com.portafolio.backend.portafolio_backend.services.interfaces.IProjectService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@CrossOrigin(origins ={"http://localhost:4200", "https://hector-gallego.github.io"})
@RestController
@RequestMapping("api/projects")
public class ProjectRestController {

    private final IProjectService projectService;
    public ProjectRestController(IProjectService projectService) {
        this.projectService = projectService;
    }


    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        return new ResponseEntity<List<Project>>(projectService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectByID(@PathVariable Long id) {
        return new ResponseEntity<Project>(projectService.findById(id), HttpStatus.OK);
    } 
}
