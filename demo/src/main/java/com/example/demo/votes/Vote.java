package com.example.demo.votes;

import com.example.demo.auth.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "votes")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "voter_id")
    private User voter;

    private int electionId;
    private String voteChoice;
    private String answer1;
    private String answer2;
    private String answer3;

    public Vote() {
    }

    public Vote(int id, User voter, int electionId, String voteChoice, String answer1, String answer2, String answer3) {
        this.id = id;
        this.voter = voter;
        this.electionId = electionId;
        this.voteChoice = voteChoice;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
    }

    public Vote(User voter, int electionId, String voteChoice, String answer1, String answer2, String answer3) {
        this.voter = voter;
        this.electionId = electionId;
        this.voteChoice = voteChoice;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getVoter() {
        return voter;
    }

    public void setVoter(User voter) {
        this.voter = voter;
    }

    public int getElectionId() {
        return electionId;
    }

    public void setElectionId(int electionId) {
        this.electionId = electionId;
    }

    public String getVoteChoice() {
        return voteChoice;
    }

    public void setVoteChoice(String voteChoice) {
        this.voteChoice = voteChoice;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", voter=" + voter +
                ", electionId=" + electionId +
                ", voteChoice='" + voteChoice + '\'' +
                ", answer1='" + answer1 + '\'' +
                ", answer2='" + answer2 + '\'' +
                ", answer3='" + answer3 + '\'' +
                '}';
    }
}
