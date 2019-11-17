package com.everis.desafio.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.everis.desafio.dao.UserDao;
import com.everis.desafio.model.Contact;
import com.everis.desafio.model.User;

@RunWith(MockitoJUnitRunner.Silent.class)
public class UserServiceTest {

	@InjectMocks
	private static UserService UserServiceTest;
	@Mock
	private static UserDao userDao;
	
	@Test
	public void addUser() {
		System.out.println("Inicio del metodo addUser");
		
		//Objeto de entrada 
		User user = new User();
		Date date = new Date();
		Contact contact = new Contact();
		List<Contact> listPhone = new ArrayList<Contact>();
		
		contact.setCitycode("01");
		contact.setConuntrycode("001");
		contact.setNumber("009876543");
		
		//Llenamos la lista
		listPhone.add(contact);
		
		
		
		user.setCreated(date);
		user.setEmail("testadduser@junit.com");
		user.setId(1);
		user.setIsactive('1');
		user.setLast_login(date);
		user.setModified(date);
		user.setName("Test addUser");
		user.setPassword("Santiago2019++");
		user.setPhones(listPhone);
		user.setToken("");
		
		try {
			
			Mockito.when(userDao.addUser(user)).thenReturn(user);
			
		} catch (Exception e) {
			fail(e.getCause().toString());
			e.printStackTrace();
		}
		
		
	}

}
