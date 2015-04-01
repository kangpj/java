package com.itmoth.playball.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.itmoth.playball.model.User;


public class UserDao {
	private Connection conn = null;
	
	private String sql_selectAll = "select * from tbl_user";
	public UserDao() {
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
	
	public List<User> getList() {
		List<User> userList = null;
		userList = new ArrayList<User>();
		PreparedStatement ps = null;		
		try {			
			conn.prepareStatement(sql_selectAll);
			ResultSet rs  = ps.executeQuery();
			while(rs.next()) {
				userList.add(map(rs));
			}
			rs.close();
			ps.close();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userList;
	}
	
    private static User map(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId_user(resultSet.getString("id_user"));
        user.setName_user(resultSet.getString("name_user"));
        user.setGender_user(resultSet.getString("gender_user"));
        user.setAuthKey_user(resultSet.getString("authKey_user"));
        user.setLeague_user(resultSet.getString("league_user"));
        return user;
    }	
}
