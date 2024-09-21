package com.challenge.bean;

import java.beans.JavaBean;

@JavaBean
public class Request {
	
	Integer id;
	String endpoint;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	
	

}
