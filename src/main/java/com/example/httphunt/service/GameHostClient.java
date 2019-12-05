package com.example.httphunt.service;

import com.example.httphunt.dto.request.ChallengeOutputRequest;
import com.example.httphunt.dto.response.ChallengeInputResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 * The type GameHostClient
 *
 * @author Mohd Nadeem
 */
@Service
@FeignClient(name = "game-host", url = "${game.host}")
public interface GameHostClient {

    @GetMapping(path = "/challenge/input")
    ResponseEntity<ChallengeInputResponse> getInput(@RequestHeader("userId") String userId);

    @PostMapping(path = "/challenge/output")
    @Headers("Content-Type: application/json")
    ResponseEntity<?> sendOutput(@RequestBody ChallengeOutputRequest output,
                                                      @RequestHeader("userId") String userId);

}
