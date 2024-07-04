package com.example.demo.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.security.SecureRandom;
import java.util.Base64;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public String authenticateUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getNin().toString(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);

        User user = userRepository.findByNin(loginRequest.getNin()).get();

        if (user.getAnonymousId() == null || user.getTenDigitCode() == null) {
            String anonymousId = generateAnonymousId();
            String tenDigitCode = generateTenDigitCode();

            user.setAnonymousId(anonymousId);
            user.setTenDigitCode(tenDigitCode);
            userRepository.save(user);
        }

        return jwt;
    }




    @PostMapping("/register")
    public String registerUser(@RequestBody RegisterRequest registerRequest) {


        return authService.registerUser(registerRequest);
    }

    private String generateAnonymousId() {
        SecureRandom random = new SecureRandom();
        byte[] bytes = new byte[6];
        random.nextBytes(bytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes).replaceAll("-", ""); // Remove unsafe characters
    }

    private String generateTenDigitCode() {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(10);
        for (int i = 0; i < 10; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
}


class LoginRequest {
    private Integer nin;
    private String password;

    public Integer getNin() {
        return nin;
    }

    public void setNin(Integer nin) {
        this.nin = nin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

class RegisterRequest {
    private String email;
    private int age;
    private String gender;
    private int nin;
    private String password;
    private String localGovernment;
    private String state;
    private String phoneNumber;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getNin() {
        return nin;
    }

    public void setNin(int nin) {
        this.nin = nin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocalGovernment() {
        return localGovernment;
    }

    public void setLocalGovernment(String localGovernment) {
        this.localGovernment = localGovernment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}



