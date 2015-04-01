package com.itmoth.playball.model;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id_user;
	private String name_user;
	private String gender_user;
	private String authKey_user;
	private String league_user;
	private boolean participant_user;
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	public String getName_user() {
		return name_user;
	}
	public void setName_user(String name_user) {
		this.name_user = name_user;
	}
	public String getGender_user() {
		return gender_user;
	}
	public void setGender_user(String gender_user) {
		this.gender_user = gender_user;
	}
	public String getAuthKey_user() {
		return authKey_user;
	}
	public void setAuthKey_user(String authKey_user) {
		this.authKey_user = authKey_user;
	}
	public String getLeague_user() {
		return league_user;
	}
	public void setLeague_user(String league_user) {
		this.league_user = league_user;
	}
	public boolean isParticipant_user() {
		return participant_user;
	}
	public void setParticipant_user(boolean participant_user) {
		this.participant_user = participant_user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_user == null) ? 0 : id_user.hashCode());
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
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (id_user == null) {
			if (other.id_user != null)
				return false;
		} else if (!id_user.equals(other.id_user))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id_user=" + id_user + ", name_user=" + name_user
				+ ", gender_user=" + gender_user + ", authKey_user="
				+ authKey_user + ", league_user=" + league_user
				+ ", participant_user=" + participant_user + "]";
	}

}