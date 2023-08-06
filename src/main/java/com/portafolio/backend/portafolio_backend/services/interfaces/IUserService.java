package com.portafolio.backend.portafolio_backend.services.interfaces;

import com.portafolio.backend.portafolio_backend.model.User;

public interface IUserService {

    User findByUsername(String username);
    
}
