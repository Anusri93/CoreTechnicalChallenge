package com.challenge.service;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public interface SchedulerService {
	
	///Current minute
	public Integer currentMinute();
	//Collection that holds the unique request count accumulated every GET method
	public static final TreeMap<Integer, Integer> uniqueReqCountPerMin = new TreeMap<Integer, Integer>();
	//Scheduler method
	public void currentUniqueRequestsCount();
	//Scheduler method
	public void updateUniqueRequestsCount(Integer requestId);
	//Scheduler method
	public TreeMap<Integer, Integer> countUniqueRequestsPerMinute();
	//Scheduler method
	Map<Integer, Integer> mapSynchedReqCountPerMin = Collections.synchronizedMap(uniqueReqCountPerMin);

}
