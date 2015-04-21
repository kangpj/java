package com.itmoth.playball.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


import com.itmoth.playball.model.Game;
import com.itmoth.playball.model.Sport;

public class GameDao {
	private Connection conn = null;
	
	private String sql_sport = "select * from tbl_sport";
	private String sql_insertGame = "insert into tbl_game(id_game, id_sport, date_game, winning_group, due_game) values(?, ?, ?, ?, ?)";
	private String sql_deleteGame = "delete from tbl_game where id_game=?";
	private String sql_modifyGameBefore = "update tbl_game set id_sport=?, date_game=?, due_game=? where id_game=?";
	private String sql_modifyGameAfter = "update tbl_game set winning_group=?, time_game=? where id_game=?";	
	public GameDao() {
		Context initContext;
		Context envContext;
		DataSource ds;
		try {
			initContext = new InitialContext();
			envContext = (Context)initContext.lookup("java:/comp/env");
			ds = (DataSource)envContext.lookup("jdbc/erii");
			conn = ds.getConnection();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public List<Sport> getSport() {
		List<Sport> sportList = new ArrayList<Sport>();
		Statement statement = null;
		ResultSet rs = null;
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery(sql_sport);
			int rank = 1;
			while(rs.next()) {
				sportList.add(mapSport(rs, rank++));
			}
			rs.close();
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return sportList;
	}
	
    private static Sport mapSport(ResultSet resultSet, int rank) throws SQLException {
        Sport instance = new Sport();
        instance.setId_sport(resultSet.getLong("id_sport")); 
        instance.setName_sport(resultSet.getString("name_sport"));
        instance.setCounter_sport(resultSet.getLong("counter_sport"));
        return instance;
    }	
	
    public void addGame(Game game) {
		PreparedStatement ps = null;
		int result=0;
		try {
			ps = conn.prepareStatement(sql_insertGame);
			ps.setLong(1, game.getId_game());
			ps.setLong(2, game.getId_sport());
			ps.setDate(3, game.getDate_game());
			ps.setByte(4, game.getWinning_group());
			ps.setBigDecimal(5, game.getDue_game());
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Insert result = " + result);
    }
}
