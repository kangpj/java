package com.itmoth.playball.model;

public class Participant {
	private long id_participant;
	private String id_user;
	private String name_user;
	private long id_game;
	private char name_group;
	private String position_participant;
	private long point_participant;
	private boolean charge_due;
	private boolean payment_due;
	public long getId_participant() {
		return id_participant;
	}
	public void setId_participant(long id_participant) {
		this.id_participant = id_participant;
	}
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	public long getId_game() {
		return id_game;
	}
	public void setId_game(long id_game) {
		this.id_game = id_game;
	}
	public char getName_group() {
		return name_group;
	}
	public void setName_group(char name_group) {
		this.name_group = name_group;
	}
	public String getPosition_participant() {
		return position_participant;
	}
	public void setPosition_participant(String position_participant) {
		this.position_participant = position_participant;
	}
	public long getPoint_participant() {
		return point_participant;
	}
	public void setPoint_participant(long point_participant) {
		this.point_participant = point_participant;
	}
	public boolean isCharge_due() {
		return charge_due;
	}
	public void setCharge_due(boolean charge_due) {
		this.charge_due = charge_due;
	}
	public boolean isPayment_due() {
		return payment_due;
	}
	public void setPayment_due(boolean payment_due) {
		this.payment_due = payment_due;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_game ^ (id_game >>> 32));
		result = prime * result
				+ (int) (id_participant ^ (id_participant >>> 32));
		result = prime * result + ((id_user == null) ? 0 : id_user.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Participant))
			return false;
		Participant other = (Participant) obj;
		if (id_game != other.id_game)
			return false;
		if (id_participant != other.id_participant)
			return false;
		if (id_user == null) {
			if (other.id_user != null)
				return false;
		} else if (!id_user.equals(other.id_user))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Participant [id_participant=" + id_participant + ", id_user="
				+ id_user + ", id_game=" + id_game + ", name_group="
				+ name_group + ", position_participant=" + position_participant
				+ ", point_participant=" + point_participant + ", charge_due="
				+ charge_due + ", payment_due=" + payment_due + "]";
	}
	public String getName_user() {
		return name_user;
	}
	public void setName_user(String name_user) {
		this.name_user = name_user;
	}
	
	
}
