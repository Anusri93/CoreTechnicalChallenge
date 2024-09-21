package com.challenge.service.impl;

import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.challenge.service.SchedulerService;

@Component
public class SchedulerImpl implements SchedulerService {

	//private static final Logger logCommon = LogManager.getLogger("commons-log");
	//private static final Logger logAnalytics = LogManager.getLogger("analytics-log");
	static java.util.logging.Logger stdLogger = java.util.logging.Logger.getLogger(SchedulerImpl.class.getName());

	@Override
	@Scheduled(cron = "*/60 * * * * *")
	public void currentUniqueRequestsCount() {
		stdLogger.log(Level.INFO,"Current minute", currentMinute());
		
		for(Map.Entry<Integer,Integer> entry : mapSynchedReqCountPerMin.entrySet()) {
			Integer key = entry.getKey();
			Integer value = entry.getValue();
			stdLogger.info(key + " => " + value);
		}
		
	}

	@Override
	public void updateUniqueRequestsCount(Integer requestId) {
		// TODO Auto-generated method stub/
		stdLogger.info("Calling updateUniqueRequestsCount method");
		if(requestId != null && mapSynchedReqCountPerMin != null) {
			Integer value =  mapSynchedReqCountPerMin.get(requestId);
			synchronized (mapSynchedReqCountPerMin) {
				if(value != null) {
					value = value + 1;
					mapSynchedReqCountPerMin.put(requestId, value);
				}else {
					mapSynchedReqCountPerMin.put(requestId, 1);
				}  
			}
		}
	}
	
	@Override
	public Integer currentMinute() {
		// TODO Auto-generated method stub
		java.util.Calendar now = java.util.Calendar.getInstance();
	    int hour = now.get(java.util.Calendar.HOUR_OF_DAY);
	    int minute = now.get(java.util.Calendar.MINUTE);
	    int currentMinuteOfDay = ((hour * 60) + minute);
	    return currentMinuteOfDay;
	}

	@Override
	public TreeMap<Integer, Integer> countUniqueRequestsPerMinute() {
		// TODO Auto-generated method stub
		return null;
	}
}






