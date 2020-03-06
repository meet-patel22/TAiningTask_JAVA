package com.dao;

import com.model.User;

public interface UserDao 
{

	public int registerUser(User user);
	public String loginUser(User user);
}
