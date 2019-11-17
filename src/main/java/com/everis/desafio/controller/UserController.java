package com.everis.desafio.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.everis.desafio.model.User;
import com.everis.desafio.model.response.UserResponse;
import com.everis.desafio.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public UserResponse addUser(@Valid @RequestBody User user) {
		User setData = new User();
		User response = new User();
		UserResponse responseUser = new UserResponse();
		boolean emailValid = false;
		
		
		try {
			
			//Usuarios registrados
			List<User> listUsers = service.getUsers();
			
			//Validamos si el correo a registrar existe 
			emailValid = service.mailValid(user, listUsers);
			
			if (emailValid) {
                responseUser.setResponseCode(Integer.parseInt(HttpStatus.RESET_CONTENT.toString()));
				responseUser.setResponseMessage("El email ingresado ya se encuentra registrado");
                return responseUser;
			}
		
			//Registro del usuario
			setData= service.setUserData(user);
			response= service.addUser(setData);
			
			//Respuesta del api
			responseUser= service.setDataUserResponse(response);
	
		} catch (Exception e) {
			System.out.println("Se produjo un error " + e);
		}	
		return responseUser;
	}

}
