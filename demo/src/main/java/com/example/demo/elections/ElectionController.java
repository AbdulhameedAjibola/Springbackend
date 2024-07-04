package com.example.demo.elections;



import com.example.demo.elections.Election;
import com.example.demo.elections.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/elections")
public class ElectionController {

    @Autowired
    private ElectionService electionService;

    public ElectionController(ElectionService electionService) {
        this.electionService = electionService;
    }

    @PostMapping(consumes = "multipart/form-data")
    public Election createElection(@RequestParam("electionTitle") String electionTitle,
                                   @RequestParam("electionDescription") String electionDescription,
                                   @RequestParam("electionDate") String electionDate,
                                   @RequestParam("candidateName") String candidateName,
                                   @RequestParam("candidateAge") int candidateAge,
                                   @RequestParam("candidateParty") String candidateParty,
                                   @RequestParam("candidatePicture") MultipartFile candidatePicture,
                                   @RequestParam("candidatePartySymbol") MultipartFile candidatePartySymbol) throws IOException {

        Election election = new Election();
        election.setElectionTitle(electionTitle);
        election.setElectionDescription(electionDescription);
        election.setElectionDate(electionDate);
        election.setCandidateName(candidateName);
        election.setCandidateAge(candidateAge);
        election.setCandidateParty(candidateParty);
        election.setCandidatePicture(candidatePicture.getBytes());
        election.setCandidatePartySymbol(candidatePartySymbol.getBytes());

        return electionService.saveElection(election);
    }

    @GetMapping
    public List<Election> getElections(){
        return electionService.getElections();
    }


    @GetMapping("/{id}")
    public Election getElectionById(@PathVariable Long id) {
        return electionService.getElectionById(id).orElseThrow(() -> new RuntimeException("Election not found"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateElection(@PathVariable Long id,
                                            @RequestParam(required = false) String electionTitle,
                                            @RequestParam(required = false) String electionDescription,
                                            @RequestParam(required = false) String electionDate,
                                            @RequestParam(required = false) String candidateName,
                                            @RequestParam(required = false) Integer candidateAge,
                                            @RequestParam(required = false) String candidateParty,
                                            @RequestParam(required = false) MultipartFile candidatePicture,
                                            @RequestParam(required = false) MultipartFile candidatePartySymbol) throws IOException {
        electionService.updateElection(id, electionTitle, electionDescription, electionDate, candidateName, candidateAge, candidateParty, candidatePicture, candidatePartySymbol);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public void deleteElection(@PathVariable Long id) {
        electionService.deleteElection(id);
    }

}

