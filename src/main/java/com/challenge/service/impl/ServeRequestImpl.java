package com.challenge.service.impl;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.challenge.service.HandleRequest;

//@Service
public class ServeRequestImpl implements HandleRequest{
	
	private static final Logger logger = LogManager.getLogger(ServeRequestImpl.class);
	
	//@Autowired
/*	ExecutorService executorService = Executors.newCachedThreadPool();
	
	@Autowired
	Executor executor;
	
	
	@Override
	public String handleLoad(Integer reqId) {
		// TODO Auto-generated method stub
		final String response;
		executorService.execute(new Runnable() {
		    public void run() {
		        success(reqId);
		    }
		});		
		
		return "ok";//response;
	}*/
	
	
	@Override
	public String success(Integer reqId) {
		// TODO Auto-generated method stub
		logger.info(reqId);
		return "Ok";
	}


	@Override
	public String identifyUniqueRequests(Integer reqId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void registerRequest(Integer reqId) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public String failure(Integer reqId) {
		// TODO Auto-generated method stub
		return "Failed";
	}
	
	

	

}
