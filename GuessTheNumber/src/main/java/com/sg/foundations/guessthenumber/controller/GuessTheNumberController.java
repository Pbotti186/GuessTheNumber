/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.guessthenumber.controller;

import com.sg.foundations.guessthenumber.models.Game;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.sg.foundations.guessthenumber.service.GuessTheNumberServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;

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
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Game create(@RequestBody Game game) {
        Game g = service.createGame();
        
        return g;
    }
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Game create(@RequestBody Game game) {
//        return dao.add(game);
//    }
}
