package com.everis.desafio.dao;

import java.util.List;

import com.everis.desafio.model.User;

public interface UserDao {
	
	public User addUser(User user);
	public List<User> getUser();
}
