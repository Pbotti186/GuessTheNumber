/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.guessthenumber.controller;

import com.sg.foundations.guessthenumber.data.GuessTheNumberDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pbott
 */
@RestController
@RequestMapping("/begin")
public class GuessTheNumberController {
    private final GuessTheNumberDao dao;

    public GuessTheNumberController(GuessTheNumberDao dao) {
        this.dao = dao;
    }
}
