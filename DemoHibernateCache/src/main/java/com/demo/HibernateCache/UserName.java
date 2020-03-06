package com.demo.HibernateCache;

import javax.persistence.Embeddable;

@Embeddable
public class UserName {

	private String Fname;
	private String lname;
	private String mname;

	@Override
	public String toString() {
		return "UserName [Fname=" + Fname + ", lname=" + lname + ", mname=" + mname + "]";
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

}
