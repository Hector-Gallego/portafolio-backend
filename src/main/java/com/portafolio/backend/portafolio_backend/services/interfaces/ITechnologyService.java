package com.portafolio.backend.portafolio_backend.services.interfaces;

import java.util.List;

import com.portafolio.backend.portafolio_backend.model.Technology;

public interface ITechnologyService {
    

    List<Technology> findAllById(List<Long> ids);
    Technology create(Technology technology);
    List<Technology> findAll();
    Technology findById(Long id);
    Technology updateById(Long id, Technology collaborator);
    void deleteById(Long id);
}
