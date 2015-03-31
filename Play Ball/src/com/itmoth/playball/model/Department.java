package com.itmoth.playball.model;

import java.io.Serializable;

public class Department implements Serializable {
	private long id_dept;
	private String name_dept;
	public long getId_dept() {
		return id_dept;
	}
	public void setId_dept(long id_dept) {
		this.id_dept = id_dept;
	}
	public String getName_dept() {
		return name_dept;
	}
	public void setName_dept(String name_dept) {
		this.name_dept = name_dept;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_dept ^ (id_dept >>> 32));
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
		Department other = (Department) obj;
		if (id_dept != other.id_dept)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Department [id_dept=" + id_dept + ", name_dept=" + name_dept
				+ "]";
	}
	
}
