package com.mport.habeeb.connectionaccess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mport.habeeb.connectionaccess.model.AccessCounter;
import com.mport.habeeb.connectionaccess.model.Connection;
import com.mport.habeeb.connectionaccess.service.AccessService;

@RestController
public class AccessController {
	
	@Autowired
	private AccessService accessService;
	
	/*
	 * Other controllers here that end-user can access and 
	 * Any API access is stored in the Connection model
	 * 
	 */
	
	
	@GetMapping("/access/ip/count/{ipAddress}/")
	public AccessCounter getIpAccess(@PathVariable String ipAddress) {
		return accessService.getNumberOfAccess(ipAddress);
	}
	
	@GetMapping("/access/")
	public List<Connection> getAllHistory(){
		return accessService.getAllConnection();
	}
	
	@GetMapping("/access/ip/{ipAddress}")
	public List<Connection> getIpAddressHistory(@PathVariable String ipAddress){
		return accessService.getIpConnection(ipAddress);
	}
	
	@GetMapping("/access/days/{accessDate}")
	public List<Connection> getIpAddressHistory(@PathVariable long accessDate){
		return accessService.getIpConnection(accessDate);
	}
	
	@GetMapping("/access/ip/{ipAddress}/days/{days}")
	public List<Connection> getIpAddressDaysAgo(@PathVariable String ipAddress, @PathVariable String days){
		return accessService.getIpTimespanHistory(ipAddress, days);
	}
}
