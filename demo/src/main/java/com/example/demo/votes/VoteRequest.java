package com.example.demo.votes;

public class VoteRequest {
    private int voterId;
    private int electionId;
    private String voteChoice;
    private String answer1;
    private String answer2;
    private String answer3;

    // Getters and Setters

    public int getVoterId() {
        return voterId;
    }

    public void setVoterId(int voterId) {
        this.voterId = voterId;
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
}
