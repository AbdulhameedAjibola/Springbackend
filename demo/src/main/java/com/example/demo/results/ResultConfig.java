package com.example.demo.results;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResultConfig {

    @Bean
    CommandLineRunner resultCommandLineRunner(ResultRepository repository) {
        return args -> {
            Result result1 = new Result(1, "choice1", 10);
            Result result2 = new Result(1, "choice2", 20);
            repository.save(result1);
            repository.save(result2);
        };
    }
}
