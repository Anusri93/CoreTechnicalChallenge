package com.challenge.service;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public interface SchedulerService {
	
	///Current minute
	public Integer currentMinute();
	//Collection that holds the unique request count accumulated every GET method
	public static final TreeMap<Integer, Integer> uniqueReqCount = new TreeMap<Integer, Integer>();
	
	//Collection that holds the unique request count accumulated every GET method
	public static final TreeMap<Integer, Integer> uniqueReqCountPerMin = new TreeMap<Integer, Integer>();
		
	//Scheduler method
	public void currentUniqueRequestsCount();
	//Scheduler method
	public void updateUniqueRequestsCount(Integer requestId);
	//Method to hold the total requests per minute
	public void countUniqueRequestsPerMinute(Integer requestId);
	//Sync map for total requests 
	Map<Integer, Integer> mapSynchedReqCount = Collections.synchronizedMap(uniqueReqCount);
	
	//Sync map for total requests per minute
	Map<Integer, Integer> mapSynchedReqCountPerMin = Collections.synchronizedMap(uniqueReqCountPerMin);
	
	//read file
	public void readFile() throws IOException;
	
	//write file
	public void writeFile();

}
