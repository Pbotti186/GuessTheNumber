/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.guessthenumber.data;

import com.sg.foundations.guessthenumber.models.Game;
import java.util.List;

/**
 *
 * @author pbott
 */
public interface GameDao {
    Game createGame(int guess);
    List<Game> getAllGames();
    Game getGame(int gameID);
    void gameWon(int gameID);

}
