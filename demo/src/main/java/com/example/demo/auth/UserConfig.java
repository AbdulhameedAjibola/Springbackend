package com.example.demo.auth;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig {



    @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            User user1 = new User("ajibolaabdulhameed11@gmail.com", 25, "Male", 33482248, passwordEncoder.encode("password1"), "Ikeja", "Lagos", null, "08031234567", null);
            User user2 = new User("maryjane@example.com", 30, "Female", 49684573, passwordEncoder.encode("password2"), "Yaba", "Lagos", null, "08022334455", null);
            User user3 = new User("user3@example.com", 28, "Male", 38435739, passwordEncoder.encode("password3"), "Nsukka", "Enugu", null, "08033445566", null);
            User user4 = new User("user4@example.com", 35, "Female", 10383193, passwordEncoder.encode("password4"), "Onitsha South", "Anambra", null, "08044556677", null);
            User user5 = new User("user5@example.com", 22, "Male", 15352482, passwordEncoder.encode("password5"), "Ifako-Ijaiye", "Lagos", null, "08055667788", null);
            User user6 = new User("user6@example.com", 26, "Female", 55439248, passwordEncoder.encode("password6"), "Karu", "Nasarawa", null, "08066778899", null);
            User user7 = new User("user7@example.com", 29, "Male", 19282843, passwordEncoder.encode("password7"), "Mushin", "Lagos", null, "08077889900", null);
            User user8 = new User("user8@example.com", 24, "Female", 28478242, passwordEncoder.encode("password8"), "Abeokuta South", "Ogun", null, "08088990011", null);
            User user9 = new User("user9@example.com", 27, "Male", 24792248, passwordEncoder.encode("password9"), "Oshimili South", "Delta", null, "08099001122", null);
            User user10 = new User("user10@example.com", 31, "Female", 27472433, passwordEncoder.encode("password10"), "Uyo", "Akwa Ibom", null, "08001122334", null);

            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
            userRepository.save(user4);
            userRepository.save(user5);
            userRepository.save(user6);
            userRepository.save(user7);
            userRepository.save(user8);
            userRepository.save(user9);
            userRepository.save(user10);
        };
    }
}
