package com.portafolio.backend.portafolio_backend.services.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.portafolio.backend.portafolio_backend.model.RoleProject;
import com.portafolio.backend.portafolio_backend.repository.RoleProjectRepository;
import com.portafolio.backend.portafolio_backend.services.interfaces.IRoleProjectService;

@Service
public class RoleProjectServiceImpl implements IRoleProjectService {

    private final RoleProjectRepository roleProjectRepository;

    public RoleProjectServiceImpl(RoleProjectRepository roleProjectRepository) {
        this.roleProjectRepository = roleProjectRepository;
    }

    @Override
    public List<RoleProject> findAll() {
        return roleProjectRepository.findAll();
    }

    @Override
    public RoleProject findById(Long id) {
        return roleProjectRepository.findById(id).orElseThrow(()-> new NoSuchElementException());
    }

    @Override
    public RoleProject updateById(Long id, RoleProject collaborator) {
        RoleProject roleProjectPersist = findById(id);
        BeanUtils.copyProperties(collaborator, roleProjectPersist, "id");
        return create(roleProjectPersist);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        roleProjectRepository.deleteById(id);
    }

    @Override
    public RoleProject create(RoleProject roleProject) {
        return roleProjectRepository.save(roleProject);
    }

    @Override
    public List<RoleProject> findAllById(List<Long> ids) {
        return roleProjectRepository.findAllById(ids);
    }

}
