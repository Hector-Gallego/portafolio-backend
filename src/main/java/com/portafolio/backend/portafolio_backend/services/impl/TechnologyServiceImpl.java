package com.portafolio.backend.portafolio_backend.services.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.portafolio.backend.portafolio_backend.model.Technology;
import com.portafolio.backend.portafolio_backend.repository.TechologyRepository;
import com.portafolio.backend.portafolio_backend.services.interfaces.ITechnologyService;

@Service
public class TechnologyServiceImpl implements ITechnologyService {

    private final TechologyRepository techologyRepository;

    public TechnologyServiceImpl(TechologyRepository techologyRepository) {
        this.techologyRepository = techologyRepository;
    }

    @Override
    public List<Technology> findAll() {
        return techologyRepository.findAll();
    }

    @Override
    public Technology findById(Long id) {
        return techologyRepository.findById(id).orElseThrow(() -> new NoSuchElementException());
    }

    @Override
    public Technology updateById(Long id, Technology technology) {
        Technology technologyPersist = findById(id);
        BeanUtils.copyProperties(technology, technologyPersist, "id");
        return create(technologyPersist);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        techologyRepository.deleteById(id);
    }

    @Override
    public Technology create(Technology technology) {
        return techologyRepository.save(technology);
    }

    @Override
    public List<Technology> findAllById(List<Long> ids) {
        return techologyRepository.findAllById(ids);
    }
    
}
