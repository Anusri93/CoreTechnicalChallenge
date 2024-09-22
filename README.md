# CoreTechnicalChallenge
This project is building a Java application with REST service
# Description
 Building a Java application with REST service which can process at least 10K requests per second. 
 The service has one GET endpoint - /api/verve/accept which can accept an integer id as a mandatory query parameter and an optional string HTTP endpoint query parameter. It 
 returns String “ok” if there were no errors processing the request and “failed” in case of any errors. 
 Every minute, the application writes the count of unique requests in this application received in that minute to a log file and uniqueness of request is based on the id parameter. 
# End points
 **GET Request** 
  Input:  http://localhost:8083/api/verve/accept?reqId=4&str=”hello”
  Output: It processes the request and returns the response message as “ok” if there were no errors otherwise it returns “failed” message. Also,it counts the total       
  uniqueRequestIds and total uniqueRequestIdsPerMinute and writes the output into log file. It handles the 10k requests per second using loadbalancer.
**POST Request**
 Input: http://localhost:8083/api/verve/accept
 {“id”:1,” endpoint”:”hello”}
 Output: It processes the request and returns the response message as “ok” if there were no errors otherwise it returns “failed” message. Also,it counts the total 
 uniqueRequestIds and total uniqueRequestIdsPerMinute and writes the output into log file. It handles the 10k requests per second using loadbalancer

# How to run
1)	Right click the project
2)	Select the RunAs
3)	Click SpringBootApplication
# Dependency
1) log4j2
2) spring-cloud
# Version History
•	0.3 -	CodeImprovements 
•	0.2 - LoadBalancer changes 
•	0.1 - Initial Release
# License
•	This project is licensed under the [Anusha Ramanan]
