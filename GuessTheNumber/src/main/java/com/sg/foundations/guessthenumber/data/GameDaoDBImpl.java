/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.guessthenumber.data;

import com.sg.foundations.guessthenumber.models.Game;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pbott
 */
@Repository
public class GameDaoDBImpl implements GameDao{
    
    @Autowired
    JdbcTemplate jdbc;

    @Override
    @Transactional
    public Game createGame(int guess) {
        Game game = new Game();
        game.setState(1);
        game.setAnswer(guess);
        final String INSERT_GAME = "INSERT INTO Game(state, answer) "
                + "VALUES(?,?)";
        jdbc.update(INSERT_GAME, 
                game.getState(),
                game.getAnswer());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        game.setGameID(newId);
        return game;
    }

    @Override
    public Game getGame(int gameID) {
        final String INSERT_GAME = "SELECT * FROM Game WHERE game.gameID = ?";
        
        return jdbc.queryForObject(INSERT_GAME, new GameMapper(), gameID);
    }

    @Override
    public List<Game> getAllGames() {
        final String SELECT_ALL_EMPLOYEES = "SELECT * FROM Game";
        return jdbc.query(SELECT_ALL_EMPLOYEES, new GameMapper());
    }
    
    @Override
    public void gameWon(int gameID) {
        final String WIN_GAME = "UPDATE Game SET state = ? WHERE Game.gameID = ?;";
        jdbc.update(WIN_GAME, 0, gameID);
    }
    
    public static final class GameMapper implements RowMapper<Game> {

        @Override
        public Game mapRow(ResultSet rs, int index) throws SQLException {
            Game game = new Game();
            game.setGameID(rs.getInt("gameID"));
            game.setAnswer(rs.getInt("answer"));
            game.setState(rs.getInt("state"));
            return game;
        }
    }
    
}
