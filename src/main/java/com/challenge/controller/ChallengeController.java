package com.challenge.controller;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.asm.Handle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.service.HandleRequest;
import com.challenge.service.SchedulerService;
import com.challenge.service.impl.SchedulerImpl;


@RestController
public class ChallengeController {
	
	//private static final Logger logger = LogManager.getLogger(ChallengeController.class);
	
//	@Autowired
//	HandleRequest handleRequest;
	
	@Autowired
	SchedulerService schedulerService;
	
	private static final Logger logger = LogManager.getLogger("commons-log");
	
		
    @GetMapping("/api/verve/accept") 
    public ResponseEntity<String> demo(@RequestParam Integer reqId,@RequestParam Optional<String> str) throws InterruptedException, ExecutionException {
 
  //  	executor = handleRequest.handleLoad(id);
    //    return ResponseEntity.ok(handleRequest.handleLoad(id));
     	logger.info("Request Id: "+reqId);
     	schedulerService  = new SchedulerImpl();
     	if(schedulerService != null) {
     		schedulerService.updateUniqueRequestsCount(reqId);
     		schedulerService.currentUniqueRequestsCount();
     		return ResponseEntity.ok("Ok");
     	}
     	return ResponseEntity.ok("failed");
    }  
 

}
