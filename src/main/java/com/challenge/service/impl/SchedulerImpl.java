package com.challenge.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Level;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.io.ClassPathResource;
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
		stdLogger.log(Level.INFO,"Start --- Current minute --> ");
		for(Map.Entry<Integer,Integer> entry : mapSynchedReqCount.entrySet()) {
			Integer key = entry.getKey();
			Integer value = entry.getValue();
			stdLogger.info(key + " => " + value);
		}
		stdLogger.log(Level.INFO,"End ---Current minute --> ");
		stdLogger.log(Level.INFO,"Start --- Total requeuts count --> ");
		for(Map.Entry<Integer,Integer> entry : mapSynchedReqCountPerMin.entrySet()) {
			Integer key = entry.getKey();
			Integer value = entry.getValue();
			stdLogger.info(key + " => " + value);
		}
		mapSynchedReqCountPerMin.clear();
		stdLogger.log(Level.INFO,"Total requests per minute collection cleared!!");
		stdLogger.log(Level.INFO,"End --- Total requeuts count --> ");
		
	}

	@Override
	public void updateUniqueRequestsCount(Integer requestId) {
		// TODO Auto-generated method stub/
		stdLogger.info("Calling updateUniqueRequestsCount method");
		if(requestId != null && mapSynchedReqCount != null) {
			Integer value =  mapSynchedReqCount.get(requestId);
			synchronized (mapSynchedReqCount) {
				if(value != null) {
					value = value + 1;
					mapSynchedReqCount.put(requestId, value);
				}else {
					mapSynchedReqCount.put(requestId, 1);
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
	public void countUniqueRequestsPerMinute(Integer requestId) {
		// TODO Auto-generated method stub
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
	public void readFile() throws IOException {
		// TODO Auto-generated method stub
		File file = new ClassPathResource("requests.txt").getFile();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            System.out.println(file.getAbsolutePath());
            System.out.println(file.getPath());
            System.out.println("Total file size to read (in bytes) : "  + fis.available());
            int content;
            while ((content = fis.read()) != -1) {
                // convert to char and display it
                System.out.print((char) content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
            } catch (IOException ex) {
                ex.printStackTrace();
                ex.getMessage();
            }
        }
	
	}
	
	@Override
	public void writeFile() {
		// TODO Auto-generated method stub
		try {
            String content = "This is the content to write into file";
            File file = new ClassPathResource("requests.txt").getFile();
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();
        } catch (IOException e) {
            e.getMessage();
        }
	
	}
}






