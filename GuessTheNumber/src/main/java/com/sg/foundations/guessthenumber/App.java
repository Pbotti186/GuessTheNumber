/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.guessthenumber;

/**
 *
 * @author pbott
 */
import com.sg.foundations.guessthenumber.controller.GuessTheNumberController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    
    @Autowired
    private GuessTheNumberController controller;
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
