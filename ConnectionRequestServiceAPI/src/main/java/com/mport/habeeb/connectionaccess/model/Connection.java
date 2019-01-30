package com.mport.habeeb.connectionaccess.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Connection {
	
	@Id
	@GeneratedValue
	private long id;
	private String ipAddress;
	private long dateAccess;
	private String date;
	
	public Connection() {
		
	}

	public Connection(long id, String ipAddress, long dateAccess, String date) {
		super();
		this.id = id;
		this.ipAddress = ipAddress;
		this.dateAccess = dateAccess;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public long getDateAccess() {
		return dateAccess;
	}

	public void setDateAccess(long dateAccess) {
		this.dateAccess = dateAccess;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}

}
