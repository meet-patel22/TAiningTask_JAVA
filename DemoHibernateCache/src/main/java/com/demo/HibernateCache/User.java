package com.demo.HibernateCache;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "user_table")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class User // POJO
{
	@Id
	private int userId;
	@Column(name = "user_userName") // change column name to user_firstName

	private UserName userName;
	// @Transient //not to store values in dbtable

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public UserName getUserName() {
		return userName;
	}

	public void setUserName(UserName userName) {
		this.userName = userName;
	}

}
