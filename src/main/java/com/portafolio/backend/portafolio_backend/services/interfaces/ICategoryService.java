package com.portafolio.backend.portafolio_backend.services.interfaces;

import java.util.List;

import com.portafolio.backend.portafolio_backend.model.Category;


public interface ICategoryService {

    List<Category> findAllById(List<Long> ids);
    Category create(Category category);
    List<Category> findAll();
    Category findById(Long id);
    Category updateById(Long id, Category category);
    void deleteById(Long id);
    
}
