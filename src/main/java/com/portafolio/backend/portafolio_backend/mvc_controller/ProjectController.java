package com.portafolio.backend.portafolio_backend.mvc_controller;



import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.portafolio.backend.portafolio_backend.model.Category;
import com.portafolio.backend.portafolio_backend.model.Project;
import com.portafolio.backend.portafolio_backend.model.RoleProject;
import com.portafolio.backend.portafolio_backend.model.Technology;
import com.portafolio.backend.portafolio_backend.services.interfaces.ICategoryService;
import com.portafolio.backend.portafolio_backend.services.interfaces.IProjectService;
import com.portafolio.backend.portafolio_backend.services.interfaces.IRoleProjectService;
import com.portafolio.backend.portafolio_backend.services.interfaces.ITechnologyService;

@Controller
public class ProjectController {

    private final IProjectService projectService;
    private final ICategoryService categoryService;
    private final IRoleProjectService roleProjectService;
    private final ITechnologyService technologyService;

    public ProjectController(IProjectService projectService, ICategoryService categoryService,
            IRoleProjectService roleProjectService, ITechnologyService technologyService) {
        this.projectService = projectService;
        this.categoryService = categoryService;
        this.roleProjectService = roleProjectService;
        this.technologyService = technologyService;
    }

    @GetMapping("/projects")
    public String listProjects(Model model) {
        List<Project> projects = projectService.findAll();
        model.addAttribute("projects", projects);
        return "projects/list_projects";
    }

    @GetMapping("/projects/new")
    public String newCreateForm(Model model) {
        Project project = new Project();
        List<Category> categories = categoryService.findAll();
        List<RoleProject> roleProjects = roleProjectService.findAll();
        List<Technology> technologies = technologyService.findAll();

        model.addAttribute("project", project);
        model.addAttribute("categories", categories);
        model.addAttribute("roleprojects", roleProjects);
        model.addAttribute("technologies", technologies);

        return "projects/form_projects";
    }

    @PostMapping("/projects/new")
    public String createProject(@ModelAttribute Project project) {

        projectService.create(project);
        return "redirect:/projects";
    }

    @GetMapping("/projects/update/{id}")
    public String newUpdateForm(@PathVariable Long id, Model model) {
        Project project = projectService.findById(id);
        List<Category> categories = categoryService.findAll();
        List<RoleProject> roleProjects = roleProjectService.findAll();
        List<Technology> technologies = technologyService.findAll();

        model.addAttribute("categories", categories);
        model.addAttribute("roleprojects", roleProjects);
        model.addAttribute("technologies", technologies);

        model.addAttribute("project", project);
        return "projects/form_projects";
    }

    @PostMapping("/projects/update/{id}")
    public String updateProject(@PathVariable Long id, @ModelAttribute Project project) {
        projectService.updateById(id, project);
        return "redirect:/projects";
    }

    @GetMapping("/projects/delete/{id}")
    public String deleteProject(@PathVariable Long id) {
        projectService.deleteById(id);
        return "redirect:/projects";
    }

}
