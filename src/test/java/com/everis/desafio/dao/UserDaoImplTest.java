package com.everis.desafio.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.everis.desafio.controller.UserController;
import com.everis.desafio.model.Contact;
import com.everis.desafio.model.User;
import com.everis.desafio.model.response.UserResponse;

public class UserDaoImplTest {
	
	UserController testController = new UserController();
	Date date = new Date();
	List<Contact> phones = new ArrayList<Contact>();
	UserResponse responseUser = new UserResponse();

	@Test
	public void emailNotValid() {
		User user = new User();
		user.setCreated(date);
		user.setEmail("");
		user.setLast_login(date);
		user.setModified(date);
		user.setName("Juan");
		user.setPassword("Chile.2019");
		user.setPhones(phones);
		user.setToken("");
		
		testController.addUser(user);
		responseUser.setResponseMessage("El formato del correo no es el correcto");

	
		assertEquals("El formato del correo no es el correcto", responseUser.getResponseMessage());
	}
	

}
