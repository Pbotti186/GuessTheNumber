/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.foundations.guessthenumber.data;

import com.sg.foundations.guessthenumber.models.Round;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
public class RoundDaoDBImpl implements RoundDao{
    
    @Autowired
    JdbcTemplate jdbc;

    @Override
    @Transactional
    public Round createRound(int gameID, int partial, int exact, int guess) {
        Round round = new Round();
        round.setGameID(gameID);
        round.setTimeOfGuess(Date.valueOf(LocalDate.now()));
        round.setPartial(partial);
        round.setExact(exact);
        round.setGuess(guess);
        final String INSERT_EMPLOYEE = "INSERT INTO Round(gameID, dtGuess, exactGuesses, partialGuesses, guess) "
                + "VALUES(?,?,?,?,?)";
        jdbc.update(INSERT_EMPLOYEE, 
                round.getGameID(),
                round.getTimeOfGuess(),
                round.getExact(),
                round.getPartial(),
                round.getGuess());
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        round.setRoundID(newId);
        return round;
    }

    @Override
    public List<Round> getAllRoundsByGameID(int gameID) {
        final String SELECT_ALL_ROUNDS_BY_GAMEID = "SELECT Round.* FROM Round JOIN Game "
                + "ON Round.gameID = Game.gameID WHERE Game.gameID = ?";
        return jdbc.query(SELECT_ALL_ROUNDS_BY_GAMEID, new RoundDaoDBImpl.RoundMapper(), gameID);
    }
    
    public static final class RoundMapper implements RowMapper<Round> {

        @Override
        public Round mapRow(ResultSet rs, int index) throws SQLException {
            Round round = new Round();
            round.setRoundID(rs.getInt("roundID"));
            round.setGameID(rs.getInt("gameID"));
            round.setTimeOfGuess(rs.getDate("dtGuess"));
            round.setExact(rs.getInt("exactGuesses"));
            round.setPartial(rs.getInt("partialGuesses"));
            return round;
        }
    }
    
}
