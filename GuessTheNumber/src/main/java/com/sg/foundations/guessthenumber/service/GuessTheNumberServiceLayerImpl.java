/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.guessthenumber.service;

import com.sg.foundations.guessthenumber.models.Game;
import com.sg.foundations.guessthenumber.models.Round;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sg.foundations.guessthenumber.data.GameDao;
import com.sg.foundations.guessthenumber.data.RoundDao;

/**
 *
 * @author pbott
 */
@Component
public class GuessTheNumberServiceLayerImpl implements GuessTheNumberServiceLayer{
    @Autowired
    private RoundDao roundDao;
    @Autowired
    private GameDao gameDao;
    
    @Override
    public Game createGame() {
        Game game = gameDao.createGame(generateRandomGuess());
        return game;
    }

    @Override
    public Round createRound(int gameID, int guess) {
        int partial = partialMatches(guess, gameDao.getGame(gameID));
        int exact = exactMatches(guess, gameDao.getGame(gameID));
        return roundDao.createRound(gameID, partial, exact, guess);
    }

    @Override
    public Game getGame(int gameID) {
        Game game = gameDao.getGame(gameID);
        return game;
    }

    @Override
    public List<Game> getAllGames() {
        List<Game> games = gameDao.getAllGames();
        return games;
    }

    @Override
    public List<Round> getAllRoundsByGameID(int gameID) {
        List<Round> rounds = roundDao.getAllRoundsByGameID(gameID);
        
        return rounds;
    }

    @Override
    //TODO FIX
    public int generateRandomGuess() {
        Random rand = new Random();
        int randomDigit = rand.nextInt(9);
        if(randomDigit == 0)
            randomDigit ++;
        int guess = randomDigit*1000;
        guess += ((randomDigit + 2)%10) * 100;
        guess += ((randomDigit^2 + 2)%10) * 10;
        guess += ((randomDigit^3 + 2)%10);
        return guess;
    }

    @Override
    public int exactMatches(int guess, Game game) {
        int gameGuess = game.getAnswer();
        int counter = 0;
        
        if(gameGuess%1000/100 == guess%1000/100) //Checking the second digit
            counter++;
        if(gameGuess%100/10 == guess%100/10) //Checking the third digit
            counter++;
        if(gameGuess%10/100 == guess%10/100) //Checking the last digit
            counter++;
        if(gameGuess/1000 == guess/1000) //Checking the first digit
            counter++;
        
        return counter;
    }

    @Override
    public int partialMatches(int guess, Game game) {
        int gameGuess = game.getAnswer();
        int counter = 0;
        Map<String, Integer> gameGuesses = new HashMap<>();
        gameGuesses.put("Second", gameGuess%1000/100);
        gameGuesses.put("Third", gameGuess%100/10);
        gameGuesses.put("Last", gameGuess%10/100);
        gameGuesses.put("First", gameGuess/1000);
        
        if(gameGuesses.containsValue(guess%1000/100)) //Checking the second digit
            counter++;
        if(gameGuesses.containsValue(guess%100/10)) //Checking the third digit
            counter++;
        if(gameGuesses.containsValue(guess%10/100)) //Checking the last digit
            counter++;
        if(gameGuesses.containsValue(guess/1000)) //Checking the first digit
            counter++;
        
        return counter;
    }
    
}
