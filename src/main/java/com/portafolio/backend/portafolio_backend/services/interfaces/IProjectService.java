package com.portafolio.backend.portafolio_backend.services.interfaces;

import java.util.List;
import com.portafolio.backend.portafolio_backend.model.Project;

public interface IProjectService {

    Project create(Project project);
    List<Project> findAll();
    Project findById(Long id);
    Project updateById(Long id, Project project);
    void deleteById(Long id);
    
}
