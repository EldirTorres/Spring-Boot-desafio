package com.everis.desafio.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;


@Embeddable
@Table(name="USER_PHONES")
public class Contact {
	
	@Column(name="number")
	public String number;
	
	@Column(name="citycode")
	public String citycode;
	
	@Column(name="conuntrycode")
	public String conuntrycode;
	
	public Contact() {
		super();
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}

	public String getConuntrycode() {
		return conuntrycode;
	}

	public void setConuntrycode(String conuntrycode) {
		this.conuntrycode = conuntrycode;
	}

	
	
}
