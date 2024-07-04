package com.example.demo.votes;

import com.example.demo.auth.User;
import com.example.demo.auth.UserRepository;
import com.example.demo.votes.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    public List<Vote> getAllVotes() {
        return voteRepository.findAll();
    }

    public Optional<Vote> getVoteById(int id) {
        return voteRepository.findById(id);
    }

    public Vote createVote(int voterId, int electionId, String voteChoice, String answer1, String answer2, String answer3) {
        User voter = userRepository.findById((long) voterId).orElseThrow(() -> new IllegalStateException("User not found"));

//        // Check if a vote by the same voter in the same election already exists
//        Optional<Vote> existingVote = voteRepository.findByVoterIdAndElectionId(voterId, electionId);
//        if (existingVote.isPresent()) {
//            throw new IllegalStateException("This user has already voted in this election");
//        }

        Vote vote = new Vote(voter, electionId, voteChoice, answer1, answer2, answer3);
        Vote savedVote = voteRepository.save(vote);

        // Send email after successful vote creation
        String toEmail = voter.getEmail();
        String subject = "Vote Confirmation";
        String body = "Thank you for voting in the election. Your vote has been recorded.";
        emailService.sendEmail(toEmail, subject, body);

        return savedVote;
    }

    // Other service methods...
}
