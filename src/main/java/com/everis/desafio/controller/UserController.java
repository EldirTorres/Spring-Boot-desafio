package com.everis.desafio.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	
	@RequestMapping(value = "/addUser", method = RequestMethod.POST, headers = "Accept=application/json")
	public UserResponse addUser(@RequestBody User user) {
		User response = new User();
		UserResponse responseUser = new UserResponse();
		Date date= new Date();
		
		try {
			// Validamos el email
			Pattern emailRegex = Pattern.compile("\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,4})+");
			Matcher emailValid = emailRegex.matcher(user.getEmail());
			
			// Validamos la contraseña
			Pattern passRegex = Pattern.compile("^(?=.*\\d)(?=.*[!\\/\\\\@#\\$%\\^&\\*\\(\\)-\\+=_\\?\\.])(?=.*[A-Z])(?=.*[a-z])\\S{8,16}$");
			Matcher passValid = passRegex.matcher(user.getPassword());
			
			if (emailValid.matches() != true) {
				responseUser.setResponseCode(Integer.parseInt(HttpStatus.RESET_CONTENT.toString()));
				responseUser.setResponseMessage("El formato del correo no es el correcto, ".concat("debe cumplir con el siguiente EJ: prueba@gmail.com"));
				return responseUser;
			} 
			
			if (passValid.matches() != true) {
				responseUser.setResponseCode(Integer.parseInt(HttpStatus.RESET_CONTENT.toString()));
				responseUser.setResponseMessage("Contraseña insegura, ".concat("debe cumplir con lo siguienete EJ: Chile.2019"));
				return responseUser;
			}
		
			//Registro del usuario
			user.setCreated(date);
			user.setModified(date);
			user.setLast_login(date);
			user.setIsactive('1');
			response= service.addUser(user);
			
			//Respuesta del api
			responseUser.setId(response.getId());
			responseUser.setName(response.getName());
			responseUser.setEmail(response.getEmail());
			responseUser.setPassword(response.getPassword());
			responseUser.setCreated(response.getCreated());
			responseUser.setModified(response.getModified());
			responseUser.setLast_login(response.getLast_login());
			responseUser.setToken(response.getToken());
			responseUser.setIsactive(response.getIsactive());
			
			
			responseUser.setResponseCode(Integer.parseInt(HttpStatus.OK.toString()));
			responseUser.setResponseMessage("Proceso exitoso");
		
	
		} catch (Exception e) {
			System.out.println("Se produjo un error " + e);
		}	
		return responseUser;
	}

}
