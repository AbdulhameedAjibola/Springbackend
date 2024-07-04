package com.example.demo.auth;

import com.example.demo.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
        Optional<User> findByNin(Integer nin);


        boolean existsByNin(Integer nin);
    }


