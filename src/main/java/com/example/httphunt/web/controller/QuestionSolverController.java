package com.example.httphunt.web.controller;

import com.example.httphunt.dto.response.ChallengeOutputResponse;
import com.example.httphunt.service.QuestionSolverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type QuestionSolverController
 *
 * @author Mohd Nadeem
 */
@RestController
@RequestMapping("/solve")
public class QuestionSolverController {

    @Autowired
    private QuestionSolverService questionSolverService;

    @GetMapping("/{question_number}")
    public ResponseEntity<?> solveQuestion1(@PathVariable(name = "question_number") Integer questionNumber){
        ChallengeOutputResponse challengeOutputResponse = questionSolverService.solveQuestion(questionNumber);
        return ResponseEntity.ok(challengeOutputResponse);
    }

}
