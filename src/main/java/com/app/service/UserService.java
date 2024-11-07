package com.app.service;

import com.app.dto.UserRegistrationDto;
import com.app.model.user.User;
import com.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public String registerUser(UserRegistrationDto registrationDto) {
        // Check if the user already exists with the given email
        Optional<User> existingUser = userRepository.findByEmail(registrationDto.getEmail());
        if (existingUser.isPresent()) {
            throw new IllegalStateException("Email already in use");
        }

        // Encode the password
        String encodedPassword = passwordEncoder.encode(registrationDto.getPassword());

        // Create a new user from the DTO data
        User newUser = new User(registrationDto.getName(), registrationDto.getEmail(), encodedPassword);

        // Save the user to the MongoDB database
        userRepository.save(newUser);

        return "User registered successfully";
    }
}
