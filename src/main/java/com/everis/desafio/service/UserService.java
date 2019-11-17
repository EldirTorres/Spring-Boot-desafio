package com.everis.desafio.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.everis.desafio.dao.UserDao;
import com.everis.desafio.model.User;
import com.everis.desafio.model.response.UserResponse;

@Service("userService")
public class UserService {
	
	@Autowired
	UserDao userDao;
	
	@Transactional
	public User addUser(User user) {
		return  userDao.addUser(user);
	}
	
	@Transactional
	public List<User> getUsers (){
		return userDao.getUser();
	}
	
	public User setUserData(User user) {
		
		Date date= new Date();
		User response = new User();
		
		response.setCreated(date);
		response.setEmail(user.getEmail());
		response.setIsactive('1');
		response.setLast_login(date);
		response.setModified(date);
		response.setName(user.getName());
		response.setPassword(user.getPassword());
		response.setPhones(user.getPhones());
		
		return response;	
	}
	
	public UserResponse setDataUserResponse(User user) {
		
		UserResponse response = new UserResponse();
		
		response.setId(user.getId());
		response.setName(user.getName());
		response.setEmail(user.getEmail());
		response.setPassword(user.getPassword());
		response.setCreated(user.getCreated());
		response.setModified(user.getModified());
		response.setLast_login(user.getLast_login());
		response.setToken(user.getToken());
		response.setIsactive(user.getIsactive());
		
		//Seteamos data al objeto base
		response.setResponseCode(Integer.parseInt(HttpStatus.OK.toString()));
		response.setResponseMessage("Proceso exitoso");
		
		return response;
	}
	
	public boolean mailValid(User user, List<User> listUsers) {
		
		boolean response = false;
		
		for (User match : listUsers) {
			
			if (user.getEmail().equalsIgnoreCase(match.getEmail())) {
				response = true;
				break;
			}
		}
		
		return response;
	}

}
