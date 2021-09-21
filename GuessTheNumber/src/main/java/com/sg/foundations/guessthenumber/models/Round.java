/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.guessthenumber.models;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author pbott
 */
public class Round {
    private int roundID;
    private int gameID;
    private Date timeOfGuess;
    private int exact;
    private int partial;
    private int guess;

    public Round(int roundID, int gameID, Date timeOfGuess, int exact, int partial, int guess) {
        this.roundID = roundID;
        this.gameID = gameID;
        this.timeOfGuess = timeOfGuess;
        this.exact = exact;
        this.partial = partial;
        this.guess = guess;
    }
    
    public Round(int gameID, int guess) {
        this.gameID = gameID;
        this.guess = guess;
    }
    
    public Round() {

    }

    public int getRoundID() {
        return roundID;
    }

    public int getGameID() {
        return gameID;
    }

    public Date getTimeOfGuess() {
        return timeOfGuess;
    }

    public int getExact() {
        return exact;
    }

    public int getPartial() {
        return partial;
    }

    public void setRoundID(int roundID) {
        this.roundID = roundID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public void setTimeOfGuess(Date timeOfGuess) {
        this.timeOfGuess = timeOfGuess;
    }

    public void setExact(int exact) {
        this.exact = exact;
    }

    public void setPartial(int partial) {
        this.partial = partial;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public int getGuess() {
        return guess;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.roundID;
        hash = 29 * hash + this.gameID;
        hash = 29 * hash + Objects.hashCode(this.timeOfGuess);
        hash = 29 * hash + this.exact;
        hash = 29 * hash + this.partial;
        hash = 29 * hash + this.guess;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Round other = (Round) obj;
        if (this.roundID != other.roundID) {
            return false;
        }
        if (this.gameID != other.gameID) {
            return false;
        }
        if (this.exact != other.exact) {
            return false;
        }
        if (this.partial != other.partial) {
            return false;
        }
        if (this.guess != other.guess) {
            return false;
        }
        if (!Objects.equals(this.timeOfGuess, other.timeOfGuess)) {
            return false;
        }
        return true;
    }
    
}
