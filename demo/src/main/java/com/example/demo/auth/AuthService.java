package com.example.demo.auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {


     UserRepository userRepository;



    private PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public String registerUser(RegisterRequest registerRequest) {

        if (userRepository.existsByNin(registerRequest.getNin())) {
            return "NIN is already taken!";
        }

        // Create new user's account
        User user = new User(
                registerRequest.getEmail(),
                registerRequest.getAge(),
                registerRequest.getGender(),
                registerRequest.getNin(),
                passwordEncoder.encode(registerRequest.getPassword()),
                registerRequest.getLocalGovernment(),
                registerRequest.getState(),
                null,
                registerRequest.getPhoneNumber(),
                null
        );

        userRepository.save(user);

        return "User registered successfully!";
    }
}
