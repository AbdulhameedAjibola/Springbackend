package com.example.demo.elections;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

import java.util.Arrays;

@Entity
@Table(name = "elections")
public class Election {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String electionTitle;
    private String electionDescription;
    private String electionDate;
    private String candidateName;
    private int candidateAge;
    private String candidateParty;

    @Lob
    private byte[] candidatePicture;
    @Lob
    private byte[] candidatePartySymbol;

    public Election() {
    }

    public Election(String electionTitle, String electionDescription, String electionDate, String candidateName, int candidateAge, String candidateParty, byte[] candidatePicture, byte[] candidatePartySymbol) {
        this.electionTitle = electionTitle;
        this.electionDescription = electionDescription;
        this.electionDate = electionDate;
        this.candidateName = candidateName;
        this.candidateAge = candidateAge;
        this.candidateParty = candidateParty;

        this.candidatePicture = candidatePicture;
        this.candidatePartySymbol = candidatePartySymbol;
    }

    public Election(Long id, String electionTitle, String electionDescription, String electionDate, String candidateName, int candidateAge, String candidateParty, String voterID, byte[] candidatePicture, byte[] candidatePartySymbol) {
        this.id = id;
        this.electionTitle = electionTitle;
        this.electionDescription = electionDescription;
        this.electionDate = electionDate;
        this.candidateName = candidateName;
        this.candidateAge = candidateAge;
        this.candidateParty = candidateParty;

        this.candidatePicture = candidatePicture;
        this.candidatePartySymbol = candidatePartySymbol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getElectionTitle() {
        return electionTitle;
    }

    public void setElectionTitle(String electionTitle) {
        this.electionTitle = electionTitle;
    }

    public String getElectionDescription() {
        return electionDescription;
    }

    public void setElectionDescription(String electionDescription) {
        this.electionDescription = electionDescription;
    }

    public String getElectionDate() {
        return electionDate;
    }

    public void setElectionDate(String electionDate) {
        this.electionDate = electionDate;
    }

    public String getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(String candidateName) {
        this.candidateName = candidateName;
    }

    public int getCandidateAge() {
        return candidateAge;
    }

    public void setCandidateAge(int candidateAge) {
        this.candidateAge = candidateAge;
    }

    public String getCandidateParty() {
        return candidateParty;
    }

    public void setCandidateParty(String candidateParty) {
        this.candidateParty = candidateParty;
    }



    public byte[] getCandidatePicture() {
        return candidatePicture;
    }

    public void setCandidatePicture(byte[] candidatePicture) {
        this.candidatePicture = candidatePicture;
    }

    public byte[] getCandidatePartySymbol() {
        return candidatePartySymbol;
    }

    public void setCandidatePartySymbol(byte[] candidatePartySymbol) {
        this.candidatePartySymbol = candidatePartySymbol;
    }

    @Override
    public String toString() {
        return "Election{" +
                "id=" + id +
                ", electionTitle='" + electionTitle + '\'' +
                ", electionDescription='" + electionDescription + '\'' +
                ", electionDate='" + electionDate + '\'' +
                ", candidateName='" + candidateName + '\'' +
                ", candidateAge=" + candidateAge +
                ", candidateParty='" + candidateParty + '\'' +

                ", candidatePicture=" + Arrays.toString(candidatePicture) +
                ", candidatePartySymbol=" + Arrays.toString(candidatePartySymbol) +
                '}';
    }
}
