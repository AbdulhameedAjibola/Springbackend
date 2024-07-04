package com.example.demo.results;



import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultRepository extends JpaRepository<Result, Long> {
    List<Result> findByElectionId(int electionId);

    Result findByElectionIdAndVoteChoice(int electionId, String voteChoice);
}

