package com.portafolio.backend.portafolio_backend.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.portafolio.backend.portafolio_backend.model.User;
import com.portafolio.backend.portafolio_backend.repository.UserRepository;

@Component
public class ConfigUserTest implements ApplicationRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public ConfigUserTest(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User();

        if (userRepository.findByUsername("admin").isEmpty()) {

            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("7501920005"));

            userRepository.save(user);

            System.out.println("Username: admin");
            System.out.println("Password: 7501920005");

        }
        ;

    }

}
