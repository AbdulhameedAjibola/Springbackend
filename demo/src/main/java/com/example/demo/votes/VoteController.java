package com.example.demo.votes;

import com.example.demo.votes.AESUtil;
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
        List<Vote> votes = voteService.getAllVotes();
        // Decrypt vote data here
        votes.forEach(vote -> {
            try {
                vote.setVoteChoice(AESUtil.decrypt(vote.getVoteChoice()));
                vote.setAnswer1(AESUtil.decrypt(vote.getAnswer1()));
                vote.setAnswer2(AESUtil.decrypt(vote.getAnswer2()));
                vote.setAnswer3(AESUtil.decrypt(vote.getAnswer3()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return votes;
    }

    @PostMapping
    public ResponseEntity<Vote> createVote(@RequestBody VoteRequest voteRequest) {
        try {
            // Encrypt vote data here
            String encryptedVoteChoice = AESUtil.encrypt(voteRequest.getVoteChoice());
            String encryptedAnswer1 = AESUtil.encrypt(voteRequest.getAnswer1());
            String encryptedAnswer2 = AESUtil.encrypt(voteRequest.getAnswer2());
            String encryptedAnswer3 = AESUtil.encrypt(voteRequest.getAnswer3());

            Vote vote = voteService.createVote(
                    voteRequest.getVoterId(),
                    voteRequest.getElectionId(),
                    encryptedVoteChoice,
                    encryptedAnswer1,
                    encryptedAnswer2,
                    encryptedAnswer3
            );
            return ResponseEntity.ok(vote);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }

    // Other endpoints...
}
