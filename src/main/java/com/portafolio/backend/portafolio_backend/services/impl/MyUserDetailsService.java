package com.portafolio.backend.portafolio_backend.services.impl;

import java.util.NoSuchElementException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.portafolio.backend.portafolio_backend.model.MyUserDetails;
import com.portafolio.backend.portafolio_backend.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).map(MyUserDetails::new)
        .orElseThrow(() -> new NoSuchElementException());
        
    }
    
}
