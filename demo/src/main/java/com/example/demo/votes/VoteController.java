package com.example.demo.votes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/votes")
public class VoteController {

    @Autowired
    private VoteService voteService;
    @Autowired
    private JavaMailSender mailSender;

    @GetMapping
    public List<Vote> getAllVotes() {
        return voteService.getAllVotes();
    }



    @PostMapping
    public ResponseEntity<Vote> createVote(@RequestBody VoteRequest voteRequest) {
        Vote vote = voteService.createVote(voteRequest.getVoterId(), voteRequest.getElectionId(), voteRequest.getVoteChoice(), voteRequest.getAnswer1(), voteRequest.getAnswer2(), voteRequest.getAnswer3());
        return ResponseEntity.ok(vote);
    }

    // Other endpoints...
}
