package com.example.demo.auth;

import com.example.demo.auth.User;
import com.example.demo.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String nin) throws UsernameNotFoundException {
        com.example.demo.auth.User user = userRepository.findByNin(Integer.parseInt(nin))
                .orElseThrow(() -> new UsernameNotFoundException("User not found with NIN: " + nin));

        UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(nin);
        builder.password(user.getPassword());  // This should be the encoded password
        builder.roles("USER");

        return builder.build();
    }
}
