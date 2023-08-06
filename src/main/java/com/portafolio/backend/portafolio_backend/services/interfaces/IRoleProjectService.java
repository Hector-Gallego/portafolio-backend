package com.portafolio.backend.portafolio_backend.services.interfaces;

import java.util.List;
import com.portafolio.backend.portafolio_backend.model.RoleProject;

public interface IRoleProjectService {



    List<RoleProject> findAllById(List<Long> ids);
    RoleProject create(RoleProject roleProject);
    List<RoleProject> findAll();
    RoleProject findById(Long id);
    RoleProject updateById(Long id, RoleProject collaborator);
    void deleteById(Long id);

}
