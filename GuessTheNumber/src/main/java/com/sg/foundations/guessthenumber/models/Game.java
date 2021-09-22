/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.guessthenumber.models;

/**
 *
 * @author pbott
 */
public class Game {
    private int gameID;
    private int state; // Int to accomodate tinyint in , 1 = in progress, 0 = not in progress
    private int answer;

    public Game(int gameID, int state, int answer) {
        this.gameID = gameID;
        this.state = state;
        this.answer = answer;
    }

    public Game() {
        
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int getGameID() {
        return gameID;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getAnswer() {
        return answer;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.gameID;
        hash = 37 * hash + this.state;
        hash = 37 * hash + this.answer;
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
        final Game other = (Game) obj;
        if (this.gameID != other.gameID) {
            return false;
        }
        if (this.state != other.state) {
            return false;
        }
        if (this.answer != other.answer) {
            return false;
        }
        return true;
    }
    
    
}
