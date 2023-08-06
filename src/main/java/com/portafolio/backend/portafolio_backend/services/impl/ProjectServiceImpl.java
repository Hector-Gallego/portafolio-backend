package com.portafolio.backend.portafolio_backend.services.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.portafolio.backend.portafolio_backend.model.Project;
import com.portafolio.backend.portafolio_backend.repository.ProjectRepository;
import com.portafolio.backend.portafolio_backend.services.interfaces.ICategoryService;

import com.portafolio.backend.portafolio_backend.services.interfaces.IProjectService;
import com.portafolio.backend.portafolio_backend.services.interfaces.IRoleProjectService;
import com.portafolio.backend.portafolio_backend.services.interfaces.ITechnologyService;

@Service
public class ProjectServiceImpl implements IProjectService {

    private final ProjectRepository projectRepository;
    private final ICategoryService categoryService;
    private final IRoleProjectService roleProjectService;
    private final ITechnologyService technologyService;

    public ProjectServiceImpl(ProjectRepository projectRepository, ICategoryService categoryService,
             IRoleProjectService roleProjectService,
            ITechnologyService technologyService) {
        this.projectRepository = projectRepository;
        this.categoryService = categoryService;
        this.roleProjectService = roleProjectService;
        this.technologyService = technologyService;
    }

    @Override
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project findById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }

    @Override
    public Project updateById(Long id, Project project) {
        Project projectPersist = findById(id);
        BeanUtils.copyProperties(project, projectPersist, "id");
        return create(projectPersist);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        projectRepository.deleteById(id);
    }

    @Override
    public Project create(Project project) {


        project.setCategories(project.getCategories()
        .stream()
        .map((category) -> categoryService.findById(category.getId()))
        .collect(Collectors.toList()));

         project.setRoleProjects(project.getRoleProjects()
        .stream()
        .map((roleProject) -> roleProjectService.findById(roleProject.getId()))
        .collect(Collectors.toList()));

        
        project.setTechnologies(project.getTechnologies()
        .stream()
        .map((technology) -> technologyService.findById(technology.getId()))
        .collect(Collectors.toList()));



        return projectRepository.save(project);

    }


}
