package com.everis.desafio.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int id;
	
	@Column(name="name")
	public String name;
	
	@Column(name="email")
	public String email;
	
	@Column(name="password")
	public String password;
	
	@Column(name="created")
	public Date created;
	
	@Column(name="modified")
	public Date modified;
	
	@Column(name="last_login")
	public Date last_login;
	
	@Column(name="token")
	public String token;
	
	@Column(name="isactive")
	public char isactive;
	
	@ElementCollection
	public java.util.List<Contact> phones = new ArrayList<Contact>();

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Date getLast_login() {
		return last_login;
	}

	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public char getIsactive() {
		return isactive;
	}

	public void setIsactive(char isactive) {
		this.isactive = isactive;
	}

	public java.util.List<Contact> getPhones() {
		return phones;
	}

	public void setPhones(java.util.List<Contact> phones) {
		this.phones = phones;
	}

	
}
