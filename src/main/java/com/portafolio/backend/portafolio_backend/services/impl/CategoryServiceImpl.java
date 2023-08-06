package com.portafolio.backend.portafolio_backend.services.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.portafolio.backend.portafolio_backend.model.Category;
import com.portafolio.backend.portafolio_backend.repository.CategoryRepository;
import com.portafolio.backend.portafolio_backend.services.interfaces.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {


    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return  categoryRepository.findById(id).orElseThrow(()-> new NoSuchElementException());
    }

    @Override
    public Category updateById(Long id, Category category) {

        Category categoryPersist = findById(id);
        BeanUtils.copyProperties(category, categoryPersist, "id");
        return create(categoryPersist);

    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        categoryRepository.deleteById(id);
        
    }

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAllById(List<Long> ids) {
        return categoryRepository.findAllById(ids);
    }
    
}
