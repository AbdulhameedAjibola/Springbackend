package com.example.demo.votes;

import com.example.demo.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Integer> {

    Optional<Vote> findByVoterIdAndElectionId(int voterId, int electionId);
}


