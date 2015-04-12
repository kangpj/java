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

import com.itmoth.playball.model.Funding;
import com.itmoth.playball.model.Ranking;

public class LookupDao {
	private Connection conn = null;
	
	private String sql_rank = "select c.name_user as name, c.id_user as id, count(b.result_game) as 'participate', count(if(b.result_game = 'WIN',1,null)) as 'win', count(if(b.result_game='LOSE',1,null)) as lose,round(count(if(b.result_game='WIN',1,null))/count(b.result_game)*100) rate, sum(a.charge_due*d.due_game) as charge, sum(a.payment_due*d.due_game) as payment from tbl_participant a, tbl_group b, tbl_user c, tbl_game d where a.id_game = b.id_game and a.name_group = b.name_group and a.id_user = c.id_user and a.id_game = d.id_game and d.id_sport='1' group by a.id_user order by win desc, lose asc";
	private String sql_perf = "select c.id_game, c.date_game, GROUP_CONCAT(if(b.result_game='WIN', a.name_user, null) SEPARATOR ', ') as 'winner', GROUP_CONCAT(if(b.result_game='lose', a.name_user, null) SEPARATOR ', ') as 'LOSER'  from (select a.*, b.name_user, b.league_user from tbl_participant a, tbl_user b where a.id_user = b.id_user) a, tbl_group b, tbl_game c where a.id_game = b.id_game and b.id_game = c.id_game and a.name_group = b.name_group group by id_game, date_game";
	private String sql_fund = "select e.*, @acc:=@acc+e.sum_invest - e.sum_withdraw as balance from (select a.date_fund as 'date', sum(a.invest_fund) as sum_invest, sum(a.withdraw_fund) as sum_withdraw, GROUP_CONCAT(d.name_user SEPARATOR ', ') as 'investor' from tbl_fund a left join ( select b.*, c.name_user from tbl_participant b, tbl_user c where b.id_user=c.id_user) d  on a.id_participant = d.id_participant group by a.date_fund) e, (select @acc:=0) f";
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
				rankingList.add(mapRank(rs, rank++));
			}
			rs.close();
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return rankingList;
	}

	public List<Funding> getFunding() {
		List<Funding> fundingList = new ArrayList<Funding>();
		Statement statement = null;
		ResultSet rs = null;
		try {
			statement = conn.createStatement();
			rs = statement.executeQuery(sql_fund);
			int rank = 1;
			while(rs.next()) {
				fundingList.add(mapFund(rs, rank++));
			}
			rs.close();
			statement.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return fundingList;
	}
	
    private static Funding mapFund(ResultSet resultSet, int rank) throws SQLException {
        Funding instance = new Funding();
        instance.setRank(rank);
        instance.setDate(resultSet.getDate("date"));
        instance.setSum_invest(resultSet.getBigDecimal("sum_invest"));
        instance.setSum_withdraw(resultSet.getBigDecimal("sum_withdraw"));
        instance.setInvestor(resultSet.getString("investor"));
        instance.setBalance(resultSet.getBigDecimal("balance"));
        return instance;
    }	
	
    private static Ranking mapRank(ResultSet resultSet, int rank) throws SQLException {
        Ranking instance = new Ranking();
        instance.setRank(rank);
        instance.setId(resultSet.getString("id"));
        instance.setName(resultSet.getString("name"));
        instance.setParticipateNum(resultSet.getInt("participate"));
        instance.setWinNum(resultSet.getInt("win"));
        instance.setLoseNum(resultSet.getInt("lose"));
        instance.setRatePercent(resultSet.getInt("rate"));
        instance.setChargeDec(resultSet.getBigDecimal("charge"));
        instance.setPaymentDec(resultSet.getBigDecimal("payment"));
        return instance;
    }	
}
