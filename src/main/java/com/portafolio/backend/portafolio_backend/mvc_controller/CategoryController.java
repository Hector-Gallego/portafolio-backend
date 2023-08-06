package com.portafolio.backend.portafolio_backend.mvc_controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.portafolio.backend.portafolio_backend.model.Category;
import com.portafolio.backend.portafolio_backend.services.interfaces.ICategoryService;

@Controller
public class CategoryController {

    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public String listCategories(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "categories/list_categories";
    }

    @GetMapping("/categories/new")
    public String newCreateForm(Model model) {
        Category category = new Category();
        model.addAttribute("category", category);
        return "categories/form_category";
    }

    @PostMapping("/categories/new")
    public String createCategory(@ModelAttribute Category category) {
        categoryService.create(category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/update/{id}")
    public String newUpdateForm(@PathVariable Long id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "categories/form_category";
    }

    @PostMapping("/categories/update/{id}")
    public String updateCategory(@PathVariable Long id, @ModelAttribute Category category) {
        categoryService.updateById(id, category);
        return "redirect:/categories";
    }

    @GetMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteById(id);
        return "redirect:/categories";
    }
    
}
