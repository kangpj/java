package com.itmoth.playball.model;

import java.math.BigDecimal;

public class Ranking {
	private int rank;
	private String name;
	private String id;
	private int participateNum;
	private int winNum;
	private int loseNum;
	private int ratePercent;
	private BigDecimal chargeDec;
	private BigDecimal paymentDec;
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getParticipateNum() {
		return participateNum;
	}
	public void setParticipateNum(int participateNum) {
		this.participateNum = participateNum;
	}
	public int getWinNum() {
		return winNum;
	}
	public void setWinNum(int winNum) {
		this.winNum = winNum;
	}
	public int getLoseNum() {
		return loseNum;
	}
	public void setLoseNum(int loseNum) {
		this.loseNum = loseNum;
	}
	public int getRatePercent() {
		return ratePercent;
	}
	public void setRatePercent(int ratePercent) {
		this.ratePercent = ratePercent;
	}
	public BigDecimal getChargeDec() {
		return chargeDec;
	}
	public void setChargeDec(BigDecimal chargeDec) {
		this.chargeDec = chargeDec;
	}
	public BigDecimal getPaymentDec() {
		return paymentDec;
	}
	public void setPaymentDec(BigDecimal paymentDec) {
		this.paymentDec = paymentDec;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (!(obj instanceof Ranking))
			return false;
		Ranking other = (Ranking) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Ranking [rank=" + rank + ", name=" + name + ", id=" + id
				+ ", participateNum=" + participateNum + ", winNum=" + winNum
				+ ", loseNum=" + loseNum + ", ratePercent=" + ratePercent
				+ ", chargeDec=" + chargeDec + ", paymentDec=" + paymentDec
				+ "]";
	}
	
	
}
