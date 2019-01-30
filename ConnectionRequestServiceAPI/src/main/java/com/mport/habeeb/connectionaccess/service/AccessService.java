package com.mport.habeeb.connectionaccess.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mport.habeeb.connectionaccess.model.AccessCounter;
import com.mport.habeeb.connectionaccess.model.Connection;
import com.mport.habeeb.connectionaccess.repository.ConnectionRepository;

@Service
public class AccessService {
	
	@Autowired
	private ConnectionRepository connectionRepository;

	/*
	 * Other business services
	 * 
	 * 
	 */
	
	public long getIpAccessVisit(String ipAddress) {
		return connectionRepository.countByIpAddress(ipAddress);
	}
	
	public List<Connection> getLast1000000Access(){
		return connectionRepository.findTop1000000ByOrderByIdDesc();
	}
	
	public AccessCounter getNumberOfAccess(String ipAddress) {
		/*List<Connection> history = getLast1000000Access().stream().
				filter(c -> c.getIpAddress().equals(ipAddress)).
				collect(Collectors.toCollection(() -> new ArrayList<>()));*/		
		//return new AccessCounter(ipAddress, history.size(), 1000000L);
		return new AccessCounter(ipAddress, getIpAccessVisit(ipAddress), 1000000L);
	}
	
	private long milliSecondsAgo(String days) {
		int day = Integer.parseInt(days);
		long milli = day * 24 * 60 * 60 * 1000;
		return new Date().getTime() - milli;
	}
	
	public List<Connection> getAllConnection(){
		return connectionRepository.findAll();
	}
	
	public List<Connection> getIpConnection(String ipAddress){
		return connectionRepository.findByIpAddress(ipAddress);
	}
	
	public List<Connection> getIpConnection(long accessDate){
		return connectionRepository.findByDateAccess(accessDate);
	}
	
	public List<Connection> getIpTimespanHistory(String ipAddress, String days){
		
		List<Connection> history = getIpConnection(ipAddress).stream().
				filter(c -> c.getDateAccess() >= milliSecondsAgo(days)).
				collect(Collectors.toCollection(() -> new ArrayList<>()));
		
		return history;
	}
}
