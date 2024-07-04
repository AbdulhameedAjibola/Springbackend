package com.example.demo.elections;



import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ElectionService {

    @Autowired
    private ElectionRepository electionRepository;

    public ElectionService(ElectionRepository electionRepository) {
        this.electionRepository = electionRepository;
    }

    public Election saveElection(Election election) {
        return electionRepository.save(election);
    }

    public Optional<Election> getElectionById(Long id) {
        return electionRepository.findById(id);
    }

    public List<Election> getElections() {
        return electionRepository.findAll();
    }

    @Transactional
    public void updateElection(Long electionId, String electionTitle, String electionDescription, String electionDate, String candidateName, Integer candidateAge, String candidateParty, MultipartFile candidatePicture, MultipartFile candidatePartySymbol) throws IOException {
        Election election = electionRepository.findById(electionId).orElseThrow(() -> new IllegalStateException("Election not found"));

        if (electionTitle != null && !electionTitle.isEmpty() && !electionTitle.equals(election.getElectionTitle())) {
            election.setElectionTitle(electionTitle);
        }

        if (electionDescription != null && !electionDescription.isEmpty() && !electionDescription.equals(election.getElectionDescription())) {
            election.setElectionDescription(electionDescription);
        }

        if (electionDate != null && !electionDate.isEmpty() && !electionDate.equals(election.getElectionDate())) {
            election.setElectionDate(electionDate);
        }

        if (candidateName != null && !candidateName.isEmpty() && !candidateName.equals(election.getCandidateName())) {
            election.setCandidateName(candidateName);
        }

        if (candidateAge != null && candidateAge > 0 && candidateAge != election.getCandidateAge()) {
            election.setCandidateAge(candidateAge);
        }

        if (candidateParty != null && !candidateParty.isEmpty() && !candidateParty.equals(election.getCandidateParty())) {
            election.setCandidateParty(candidateParty);
        }

        if (candidatePicture != null && !candidatePicture.isEmpty()) {
            election.setCandidatePicture(candidatePicture.getBytes());
        }

        if (candidatePartySymbol != null && !candidatePartySymbol.isEmpty()) {
            election.setCandidatePartySymbol(candidatePartySymbol.getBytes());
        }

        electionRepository.save(election);
    }

    public void deleteElection(Long id) {
    boolean exists = electionRepository.existsById(id);

    if (exists) {
        electionRepository.deleteById(id);
    }
    else {
        throw new IllegalStateException("Election not found");
    }
    }


    // Other service methods...
}
