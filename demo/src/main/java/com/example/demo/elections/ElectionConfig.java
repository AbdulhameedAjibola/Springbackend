package com.example.demo.elections;



import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElectionConfig {

@Bean
    CommandLineRunner electioncommandLineRunner(ElectionRepository electionRepository) {
        return args -> {
            Election election1 = new Election(
                    "Presidential Election",
                    "This is the presidential election for the year 2024.",
                    "2024-11-05",
                    "John Doe",
                    45,
                    "Independent",

                    new byte[]{/* Some byte array data representing the picture */},
                    new byte[]{/* Some byte array data representing the party symbol */}
            );

            Election election2 = new Election(
                    "Senatorial Election",
                    "This is the senatorial election for the year 2024.",
                    "2024-11-05",
                    "Jane Smith",
                    50,
                    "Democratic",

                    new byte[]{/* Some byte array data representing the picture */},
                    new byte[]{/* Some byte array data representing the party symbol */}
            );

            Election election3 = new Election(
                    "Gubernatorial Election",
                    "This is the gubernatorial election for the year 2024.",
                    "2024-11-05",
                    "Alice Johnson",
                    40,
                    "Republican",

                    new byte[]{/* Some byte array data representing the picture */},
                    new byte[]{/* Some byte array data representing the party symbol */}
            );

            electionRepository.save(election1);
            electionRepository.save(election2);
            electionRepository.save(election3);
        };
    }
}
