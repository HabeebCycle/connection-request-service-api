package com.mport.habeeb.connectionaccess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mport.habeeb.connectionaccess.exception.IpAddressNotFoundException;
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
	
	@GetMapping("/access/ip")
	public List<Connection> getAllHistory(){
		List<Connection> result = accessService.getAllConnection();
		if(result==null)
			throw new IpAddressNotFoundException("IP NOT FOUND");
		return result;
	}
	
	@GetMapping("/access/ip/{ipAddress}")
	public List<Connection> getIpAddressHistory(@PathVariable String ipAddress){
		List<Connection> result = accessService.getIpConnection(ipAddress);
		if(result==null)
			throw new IpAddressNotFoundException("IP NOT FOUND");
		return result;
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
