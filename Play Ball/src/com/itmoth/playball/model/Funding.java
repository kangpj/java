package com.itmoth.playball.model;

import java.math.BigDecimal;
import java.util.Date;


public class Funding {
	private int rank;
	private Date date;
	private BigDecimal sum_invest;
	private BigDecimal sum_withdraw;
	private String investor;
	private BigDecimal balance;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public BigDecimal getSum_invest() {
		return sum_invest;
	}
	public void setSum_invest(BigDecimal sum_invest) {
		this.sum_invest = sum_invest;
	}
	public BigDecimal getSum_withdraw() {
		return sum_withdraw;
	}
	public void setSum_withdraw(BigDecimal sum_withdraw) {
		this.sum_withdraw = sum_withdraw;
	}
	public String getInvestor() {
		return investor;
	}
	public void setInvestor(String investor) {
		this.investor = investor;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((investor == null) ? 0 : investor.hashCode());
		result = prime * result
				+ ((sum_invest == null) ? 0 : sum_invest.hashCode());
		result = prime * result
				+ ((sum_withdraw == null) ? 0 : sum_withdraw.hashCode());
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
		if (!(obj instanceof Funding))
			return false;
		Funding other = (Funding) obj;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (investor == null) {
			if (other.investor != null)
				return false;
		} else if (!investor.equals(other.investor))
			return false;
		if (sum_invest == null) {
			if (other.sum_invest != null)
				return false;
		} else if (!sum_invest.equals(other.sum_invest))
			return false;
		if (sum_withdraw == null) {
			if (other.sum_withdraw != null)
				return false;
		} else if (!sum_withdraw.equals(other.sum_withdraw))
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Funding [date=" + date + ", sum_invest=" + sum_invest
				+ ", sum_withdraw=" + sum_withdraw + ", investor=" + investor
				+ ", balance=" + balance + "]";
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
}
