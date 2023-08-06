package com.portafolio.backend.portafolio_backend.services.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.portafolio.backend.portafolio_backend.model.User;
import com.portafolio.backend.portafolio_backend.repository.UserRepository;
import com.portafolio.backend.portafolio_backend.services.interfaces.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new NoSuchElementException());
    }
    
}
