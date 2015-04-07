package com.itmoth.playball.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.itmoth.playball.model.Ranking;

public class LookupDao {
	private Connection conn = null;
	
	private String sql_rank = "select c.name_user as name, c.id_user as id, count(b.result_game) as 'participate', count(if(b.result_game = 'WIN',1,null)) as 'win', count(if(b.result_game='LOSE',1,null)) as lose,round(count(if(b.result_game='WIN',1,null))/count(b.result_game)*100) rate, sum(a.charge_due*d.due_game) as charge, sum(a.payment_due*d.due_game) as payment from tbl_participant a, tbl_group b, tbl_user c, tbl_game d where a.id_game = b.id_game and a.name_group = b.name_group and a.id_user = c.id_user and a.id_game = d.id_game and d.id_sport='1' group by a.id_user order by win desc, lose asc";
	
	public LookupDao() {
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

	public List<Ranking> getRanking() {
		List<Ranking> rankingList = new ArrayList<Ranking>();
		Statement statement = null;
		ResultSet rs = null;
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery(sql_rank);
			int rank = 1;
			while(rs.next()) {
				rankingList.add(map(rs, rank++));
			}
			rs.close();
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return rankingList;
	}
	
    private static Ranking map(ResultSet resultSet, int rank) throws SQLException {
        Ranking ranking = new Ranking();
        ranking.setRank(rank);
        ranking.setId(resultSet.getString("id"));
        ranking.setName(resultSet.getString("name"));
        ranking.setParticipateNum(resultSet.getInt("participate"));
        ranking.setWinNum(resultSet.getInt("win"));
        ranking.setLoseNum(resultSet.getInt("lose"));
        ranking.setRatePercent(resultSet.getInt("rate"));
        ranking.setChargeDec(resultSet.getBigDecimal("charge"));
        ranking.setPaymentDec(resultSet.getBigDecimal("payment"));
        return ranking;
    }	
}
