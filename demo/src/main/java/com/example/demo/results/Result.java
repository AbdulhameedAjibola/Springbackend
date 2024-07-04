package com.example.demo.results;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "results")
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int electionId;
    private String voteChoice;
    private int tally;

    public Result() {
    }

    public Result(int electionId, String voteChoice, int tally) {
        this.electionId = electionId;
        this.voteChoice = voteChoice;
        this.tally = tally;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getTally() {
        return tally;
    }

    public void setTally(int tally) {
        this.tally = tally;
    }
}
