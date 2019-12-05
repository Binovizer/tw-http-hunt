package com.example.httphunt.service.impl;

import com.example.httphunt.dto.request.ChallengeOutputRequest;
import com.example.httphunt.dto.response.ChallengeOutputResponse;
import com.example.httphunt.dto.response.Question1Output;
import com.example.httphunt.dto.response.Question2Output;
import com.example.httphunt.dto.response.Question3Output;
import com.example.httphunt.service.GameHostService;
import com.example.httphunt.service.QuestionSolverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * The type SolverServiceImpl
 *
 * @author Mohd Nadeem
 */
@Service
public class QuestionSolverServiceImpl implements QuestionSolverService {

    @Autowired
    private GameHostService gameHostService;

    @Override
    public ChallengeOutputResponse solveQuestion(Integer questionNumber) {
        String text = gameHostService.getQuestionText();
        Object output = getOutput(text, questionNumber);
        ChallengeOutputRequest outputRequest = ChallengeOutputRequest.builder()
                .output(output)
                .build();
        gameHostService.sendOutput(outputRequest);
        return ChallengeOutputResponse.from(outputRequest);
    }

    private Object getOutput(String text, Integer questionNumber) {
        Object output = null;
        switch (questionNumber) {
            case 1:
                int charCount = countCharacters(text);
                output = Question1Output.builder().count(charCount).build();
                break;
            case 2:
                int wordCount = countWords(text);
                output = Question2Output.builder().count(wordCount).build();
                break;
            case 3:
                int sentencesCount = countSentences(text);
                output = Question3Output.builder().count(sentencesCount).build();
                break;
            case 4:
                output = getVowelsMap(text);
                break;
        }
        return output;
    }

    private Map<Character, Integer> getVowelsMap(String text) {
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : text.toCharArray()){
            if(isVowel(c)){
                Integer count = map.getOrDefault(c, 0);
                map.put(c, ++count);
            }
        }
        return map;
    }

    private boolean isVowel(Character c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

    private int countSentences(String text) {
        String[] split = text.trim().split("[?.]");
        return split.length;
    }

    private static int countWords(String text){
        StringTokenizer stringTokenizer = new StringTokenizer(text);
        return stringTokenizer.countTokens();
    }

    private int countCharacters(String text) {
        return text.length();
    }
}
