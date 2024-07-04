package com.example.demo.votes;

import com.example.demo.auth.User;
import com.example.demo.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VoteConfig {

    private UserRepository userRepository;

    @Autowired
    public VoteConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Bean
    CommandLineRunner votingCommandLineRunner(VoteRepository repository) {
        return args -> {
            Long voterID = 1L;
            // Fetch user with id 1 from the database
            User voter = userRepository.findById(voterID).orElseThrow(() -> new IllegalStateException("User not found"));
            Vote vote1 = new Vote(
                    voter, // Pass the User object
                    1, // electionId
                    "choice1", // voteChoice
                    "answer1", // answer1
                    "answer2", // answer2
                    "answer3" // answer3
            );
            repository.save(vote1);
        };
    }
}
