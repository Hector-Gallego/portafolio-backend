package com.portafolio.backend.portafolio_backend.mvc_controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.portafolio.backend.portafolio_backend.model.Technology;
import com.portafolio.backend.portafolio_backend.services.interfaces.ITechnologyService;

@Controller
public class TechnologyController {

    private final ITechnologyService technologyService;

   

    public TechnologyController(ITechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping("/technologies")
    public String listTechnologies(Model model) {
        List<Technology> technologies = technologyService.findAll();
        model.addAttribute("technologies", technologies);
        return "technologies/list_technologies";
    }

    @GetMapping("/technologies/new")
    public String newCreateForm(Model model) {
        Technology technology = new Technology();
        model.addAttribute("technology", technology);
        return "technologies/form_technologies";
    }

    @PostMapping("/technologies/new")
    public String createTechnology(@ModelAttribute Technology technology) {
        technologyService.create(technology);
        return "redirect:/technologies";
    }

    @GetMapping("/technologies/update/{id}")
    public String newUpdateForm(@PathVariable Long id, Model model) {
        Technology technology = technologyService.findById(id);
        model.addAttribute("technology", technology);
        return "technologies/form_technologies";
    }

    @PostMapping("/technologies/update/{id}")
    public String updateTechnology(@PathVariable Long id, @ModelAttribute Technology technology) {
        technologyService.updateById(id, technology);
        return "redirect:/technologies";
    }

    @GetMapping("/technologies/delete/{id}")
    public String deleteTechnology(@PathVariable Long id) {
        technologyService.deleteById(id);
        return "redirect:/technologies";
    }
    
}
