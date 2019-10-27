package com.everis.desafio.model.response;
import java.io.Serializable;

/**
 * Created by Eldir Torres on 15/02/2019.
 */
public class BaseResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer responseCode;
    private String responseMessage;
   
    
    
	public Integer getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(Integer responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
}
