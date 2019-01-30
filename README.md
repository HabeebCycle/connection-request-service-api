# connection-request-service-api
# Tracking Connection History

Ability to retrieve connection history made from specific ip address for specific timespan
Ability to check if the same ip has been connected more than 10000 times within last 1000000 connections

All End points

BaseUrl: http://localhost:8080

1. 
/access/ip
Expose all the IP address that has connected to our service
Example:
http://localhost:8080/access/ip

2.
/access/ip/{ipAddress}
Expose all the access an IP address has accessed a service and the corresponding date. {ipAddress} should be replaced by one of the ip address.
Example:
http://localhost:8080/access/ip/194.87.56.88

3.
/access/ip/{ipAddress}/days/{days}
Expose all the access aconnection history made from specific ip address for specific timespan in days. {ipAddress} should be replaced by one in , while {days} is the number of days to check.
Example:
http://localhost:8080/access/ip/194.87.56.88/days/5

4.
/access/ip/count/{ipAddress}
Expose the number of times same ip has been connected more than 10000 times within last 1000000 connections.
Example:
http://localhost:8080/access/ip/count/194.87.56.88
