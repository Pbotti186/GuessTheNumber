/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.guessthenumber.service;

import com.sg.foundations.guessthenumber.models.Game;
import com.sg.foundations.guessthenumber.models.Round;
import java.util.List;

/**
 *
 * @author pbott
 */
public interface GuessTheNumberServiceLayer {
    Game createGame();
    
    Round createRound(int gameID, int guess);
    
    Game getGame(int gameID);
    
    List<Game> getAllGames();
    
    List<Round> getAllRoundsByGameID(int gameID);
    
    int generateRandomGuess();
    
    int exactMatches(int guess, Game game);
    
    int partialMatches(int guess, Game game);
}
