package com.itmoth.playball.model;

import java.io.Serializable;

public class Sport implements Serializable {
	private long id_sport;
	private String name_sport;
	private long counter_sport;
	
	public long getId_sport() {
		return id_sport;
	}
	public void setId_sport(long id_sport) {
		this.id_sport = id_sport;
	}
	public String getName_sport() {
		return name_sport;
	}
	public void setName_sport(String name_sport) {
		this.name_sport = name_sport;
	}
	public long getCounter_sport() {
		return counter_sport;
	}
	public void setCounter_sport(long counter_sport) {
		this.counter_sport = counter_sport;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_sport ^ (id_sport >>> 32));
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
		if (getClass() != obj.getClass())
			return false;
		Sport other = (Sport) obj;
		if (id_sport != other.id_sport)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Sport [id_sport=" + id_sport + ", name_sport=" + name_sport
				+ ", counter_sport=" + counter_sport + "]";
	}

	
}
