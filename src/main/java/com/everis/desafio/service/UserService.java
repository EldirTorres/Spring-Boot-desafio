package com.everis.desafio.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.desafio.dao.UserDao;
import com.everis.desafio.model.User;

@Service("userService")
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	@Transactional
	public User addUser(User user) {
		return  userDao.addUser(user);
	}

}
