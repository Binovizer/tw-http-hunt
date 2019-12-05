package com.example.httphunt.service;

import com.example.httphunt.dto.response.ChallengeOutputResponse;

/**
 * The type SolverService
 *
 * @author Mohd Nadeem
 */
public interface QuestionSolverService {

    /**
     * Solves the given question number
     * @param questionNumber the question number
     * @return output response
     */
    ChallengeOutputResponse solveQuestion(Integer questionNumber);

}
