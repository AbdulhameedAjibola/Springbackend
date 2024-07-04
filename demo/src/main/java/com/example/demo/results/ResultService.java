package com.example.demo.results;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    @Autowired
    private ResultRepository resultRepository;

    public List<Result> getResultsByElectionId(int electionId) {
        return resultRepository.findByElectionId(electionId);
    }

    public Result addResult(int electionId, String voteChoice) {
        Result existingResult = resultRepository.findByElectionIdAndVoteChoice(electionId, voteChoice);
        if (existingResult != null) {
            existingResult.setTally(existingResult.getTally() + 1);
            return resultRepository.save(existingResult);
        } else {
            Result newResult = new Result(electionId, voteChoice, 1);
            return resultRepository.save(newResult);
        }
    }
}
