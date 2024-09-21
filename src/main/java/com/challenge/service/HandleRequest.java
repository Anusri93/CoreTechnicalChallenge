package com.challenge.service;

import java.util.concurrent.Executor;

public interface HandleRequest {
	
//	public String handleLoad(Integer reqId);
	
	public String success(Integer reqId);
	
	public String identifyUniqueRequests(Integer reqId);
	
	public void registerRequest(Integer reqId);
	
	public String failure(Integer reqId);
	

}
