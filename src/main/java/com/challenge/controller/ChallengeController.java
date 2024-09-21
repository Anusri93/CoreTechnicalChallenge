package com.challenge.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.bean.Request;
import com.challenge.service.SchedulerService;
import com.challenge.service.impl.SchedulerImpl;

@RestController
public class ChallengeController {
	
	@Autowired
	SchedulerService schedulerService;
	
	private static final Logger logger = LogManager.getLogger("commons-log");

	 @GetMapping("/api/verve/accept") 
	    public ResponseEntity<String> getResponseUsingGet(@RequestParam Integer reqId,@RequestParam Optional<String> str) throws InterruptedException, ExecutionException {
	     	logger.info("Request Id: "+reqId);
	     	schedulerService  = new SchedulerImpl();
	     	if(schedulerService != null) {
	     		schedulerService.updateUniqueRequestsCount(reqId);
	     		schedulerService.currentUniqueRequestsCount();

	     		return ResponseEntity.ok("Ok");
	     	}
	     	return ResponseEntity.ok("failed");
	    }  
	 
	 @PostMapping(value = "/api/verve/accept", consumes= "application/json") 
	    public ResponseEntity<String> getResponseUsingPost(@RequestParam Request req) throws InterruptedException, ExecutionException {
	     	logger.info("Request Id: "+req.getId());
	     	schedulerService  = new SchedulerImpl();
	     	if(schedulerService != null) {
	     		schedulerService.updateUniqueRequestsCount(req.getId());
	     		schedulerService.currentUniqueRequestsCount();
	     		return ResponseEntity.ok("Ok");
	     	}
	     	return ResponseEntity.ok("failed");
	    } 
	 
	 /**@RequestMapping(path = "/download", method = RequestMethod.GET)
	 public ResponseEntity<Resource> download(String param) throws IOException {

	     InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

	     return ResponseEntity.ok()
	             .headers(headers)
	             .contentLength(file.length())
	             .contentType(MediaType.APPLICATION_OCTET_STREAM)
	             .body(resource);
	 }**/
}
