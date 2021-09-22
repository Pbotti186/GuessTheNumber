/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.guessthenumber.controller;

import com.sg.foundations.guessthenumber.models.Game;
import com.sg.foundations.guessthenumber.models.Round;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.sg.foundations.guessthenumber.service.GuessTheNumberServiceLayer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author pbott
 */
@RestController
@RequestMapping("/api/guessgame")
public class GuessTheNumberController {
    
    @Autowired
    private final GuessTheNumberServiceLayer service;

    public GuessTheNumberController(GuessTheNumberServiceLayer service) {
        this.service = service;
    }
    
    @RequestMapping("/begin")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Game create() {
        Game g = service.createGame();
        
        return g;
    }
    
    @RequestMapping("/guess")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Round guess(@RequestBody Round round) {
        Round r = service.createRound(round.getGameID(), round.getGuess());
        return r;
    }
    
    @RequestMapping("/game")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getAllGames() {
        List<Game> allGames = service.getAllGames();
        return allGames;
    }
    
    @RequestMapping("/game/{id}")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Game getAllGames(@PathVariable int id) {
        Game game = service.getGame(id);
        return game;
    }
    
    @RequestMapping("/rounds/{id}")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Round> getAllRounds(@PathVariable int id) {
        List<Round> allRounds = service.getAllRoundsByGameID(id);
        return allRounds;
    }
}
