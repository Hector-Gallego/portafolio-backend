package com.portafolio.backend.portafolio_backend.mvc_controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.portafolio.backend.portafolio_backend.model.RoleProject;
import com.portafolio.backend.portafolio_backend.services.interfaces.IRoleProjectService;


@Controller
public class RoleProjectController {

    private final IRoleProjectService roleProjectService;

   

    public RoleProjectController(IRoleProjectService roleProjectService) {
        this.roleProjectService = roleProjectService;
    }

    @GetMapping("/roleprojects")
    public String listroleprojects(Model model) {
        List<RoleProject> roleProjects = roleProjectService.findAll();
        model.addAttribute("roleprojects", roleProjects);
        return "role_projects/list_roleprojects";
    }

    @GetMapping("/roleprojects/new")
    public String newCreateForm(Model model) {
        RoleProject roleProject = new RoleProject();
        model.addAttribute("roleproject", roleProject);
        return "role_projects/form_roleprojects";
    }

    @PostMapping("/roleprojects/new")
    public String createRoleProject(@ModelAttribute RoleProject roleProject) {
        roleProjectService.create(roleProject);
        return "redirect:/roleprojects";
    }

    @GetMapping("/roleprojects/update/{id}")
    public String newUpdateForm(@PathVariable Long id, Model model) {
        RoleProject roleProject = roleProjectService.findById(id);
        model.addAttribute("roleproject", roleProject);
        return "role_projects/form_roleprojects";
    }

    @PostMapping("/roleprojects/update/{id}")
    public String updateRoleProject(@PathVariable Long id, @ModelAttribute RoleProject RoleProject) {
        roleProjectService.updateById(id, RoleProject);
        return "redirect:/roleprojects";
    }

    @GetMapping("/roleprojects/delete/{id}")
    public String deleteRoleProject(@PathVariable Long id) {
        roleProjectService.deleteById(id);
        return "redirect:/roleprojects";
    }

    
}
