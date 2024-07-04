package com.example.demo.results;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/results")
public class ResultController {

    @Autowired
    private ResultService resultService;

    @GetMapping("/{electionId}")
    public ResponseEntity<List<Result>> getResultsByElectionId(@PathVariable int electionId) {
        List<Result> results = resultService.getResultsByElectionId(electionId);
        return ResponseEntity.ok(results);
    }

    @PostMapping
    public ResponseEntity<Result> addResult(@RequestBody ResultRequest resultRequest) {
        Result result = resultService.addResult(resultRequest.getElectionId(), resultRequest.getVoteChoice());
        return ResponseEntity.ok(result);
    }
}
