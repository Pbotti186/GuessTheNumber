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
        final String INSERT_EMPLOYEE = "INSERT INTO Game(state, answer) "
                + "VALUES(?,?)";
        jdbc.update(INSERT_EMPLOYEE, 
                game.getState(),
                game.getAnswer());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        game.setGameID(newId);
        return game;
    }

    @Override
    public Game getGame(int gameID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Game> getAllGames() {
        final String SELECT_ALL_EMPLOYEES = "SELECT * FROM Game";
        return jdbc.query(SELECT_ALL_EMPLOYEES, new GameMapper());
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
