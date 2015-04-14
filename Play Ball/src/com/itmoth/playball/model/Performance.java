package com.itmoth.playball.model;

import java.util.Date;

public class Performance {
	private int id_seq;
	private int id_game;
	private Date date;
	private String winner;
	private String loser;
	public int getId_game() {
		return id_game;
	}
	public void setId_game(int id_game) {
		this.id_game = id_game;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public String getLoser() {
		return loser;
	}
	public void setLoser(String loser) {
		this.loser = loser;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_game;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Performance))
			return false;
		Performance other = (Performance) obj;
		if (id_game != other.id_game)
			return false;
		return true;
	}
	public int getId_seq() {
		return id_seq;
	}
	public void setId_seq(int id_seq) {
		this.id_seq = id_seq;
	}
	
}
