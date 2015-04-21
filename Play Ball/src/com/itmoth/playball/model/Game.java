package com.itmoth.playball.model;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Date;


public class Game {
	private long id_game;
	private long id_sport;
	private Date date_game;
	private byte winning_group;
	private BigDecimal due_game;
	private Time time_game;
	public long getId_game() {
		return id_game;
	}
	public void setId_game(long id_game) {
		this.id_game = id_game;
	}
	public long getId_sport() {
		return id_sport;
	}
	public void setId_sport(long id_sport) {
		this.id_sport = id_sport;
	}
	public Date getDate_game() {
		return date_game;
	}
	public void setDate_game(Date date_game) {
		this.date_game = date_game;
	}
	public byte getWinning_group() {
		return winning_group;
	}
	public void setWinning_group(byte winning_group) {
		this.winning_group = winning_group;
	}
	public BigDecimal getDue_game() {
		return due_game;
	}
	public void setDue_game(BigDecimal due_game) {
		this.due_game = due_game;
	}
	public Time getTime_game() {
		return time_game;
	}
	public void setTime_game(Time time_game) {
		this.time_game = time_game;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_game ^ (id_game >>> 32));
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Game))
			return false;
		Game other = (Game) obj;
		if (id_game != other.id_game)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Game [id_game=" + id_game + ", id_sport=" + id_sport
				+ ", date_game=" + date_game + ", winning_group="
				+ winning_group + ", due_game=" + due_game + ", time_game="
				+ time_game + "]";
	}
	
	
}
