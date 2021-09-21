/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.guessthenumber.data;

import com.sg.foundations.guessthenumber.models.Round;
import java.util.List;

/**
 *
 * @author pbott
 */
public interface RoundDao {
    Round createRound(int gameID, int partial, int exact, int guess);
    List<Round> getAllRoundsByGameID(int gameID);
}
