/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.guessthenumber.data;

import com.sg.foundations.guessthenumber.models.Game;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author pbott
 */
public class GameDaoDBImplTest {
    
    public GameDaoDBImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of createGame method, of class GameDaoDBImpl.
     */
    @Test
    public void testCreateGame() {
        System.out.println("createGame");
        int guess = 0;
        GameDaoDBImpl instance = new GameDaoDBImpl();
        Game expResult = null;
        Game result = instance.createGame(guess);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGame method, of class GameDaoDBImpl.
     */
    @Test
    public void testGetGame() {
        System.out.println("getGame");
        int gameID = 0;
        GameDaoDBImpl instance = new GameDaoDBImpl();
        Game expResult = null;
        Game result = instance.getGame(gameID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllGames method, of class GameDaoDBImpl.
     */
    @Test
    public void testGetAllGames() {
        System.out.println("getAllGames");
        GameDaoDBImpl instance = new GameDaoDBImpl();
        List<Game> expResult = null;
        List<Game> result = instance.getAllGames();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gameWon method, of class GameDaoDBImpl.
     */
    @Test
    public void testGameWon() {
        System.out.println("gameWon");
        int gameID = 0;
        GameDaoDBImpl instance = new GameDaoDBImpl();
        instance.gameWon(gameID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
