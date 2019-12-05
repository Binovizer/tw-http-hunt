package com.example.httphunt.service.impl;

import com.example.httphunt.ApplicationProperties;
import com.example.httphunt.dto.request.ChallengeOutputRequest;
import com.example.httphunt.dto.response.ChallengeInputResponse;
import com.example.httphunt.service.GameHostClient;
import com.example.httphunt.service.GameHostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * The type GameHostServiceImpl
 *
 * @author Mohd Nadeem
 */
@Service
public class GameHostServiceImpl implements GameHostService {

    @Autowired
    private GameHostClient gameHostClient;

    @Autowired
    private ApplicationProperties applicationProperties;

    @Override
    public String getQuestionText() {
        ResponseEntity<ChallengeInputResponse> input = gameHostClient.getInput(applicationProperties.getUserId());
        return Objects.requireNonNull(input.getBody()).getText();
    }

    @Override
    public ResponseEntity<?> sendOutput(ChallengeOutputRequest outputRequest) {
        return gameHostClient.sendOutput(outputRequest, applicationProperties.getUserId());
    }
}
