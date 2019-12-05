package com.example.httphunt.service;

import com.example.httphunt.dto.request.ChallengeOutputRequest;
import org.springframework.http.ResponseEntity;

/**
 * The type GameHostService
 *
 * @author Mohd Nadeem
 */
public interface GameHostService {

    /**
     * Gets the question text from game host
     * @return returns the question text
     */
    String getQuestionText();

    /**
     * Sends the output via post request to game host
     * @param outputRequest the output request to be sent
     * @return returns the response entity
     */
    ResponseEntity<?> sendOutput(ChallengeOutputRequest outputRequest);

}
