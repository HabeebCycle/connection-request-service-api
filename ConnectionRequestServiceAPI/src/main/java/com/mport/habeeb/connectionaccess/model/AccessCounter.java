package com.mport.habeeb.connectionaccess.model;

public class AccessCounter {

	private String ipAddress;
	private long accessCount;
	private long maxAccess;
	
	public AccessCounter() {
		
	}

	public AccessCounter(String ipAddress, long accessCount, long maxAccess) {
		super();
		this.ipAddress = ipAddress;
		this.accessCount = accessCount;
		this.maxAccess = maxAccess;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public long getAccessCount() {
		return accessCount;
	}

	public void setAccessCount(long accessCount) {
		this.accessCount = accessCount;
	}

	public long getMaxAccess() {
		return maxAccess;
	}

	public void setMaxAccess(long maxAccess) {
		this.maxAccess = maxAccess;
	}

	@Override
	public String toString() {
		return "AccessCounter [ipAddress=" + ipAddress + ", accessCount=" + accessCount + ", maxAccess=" + maxAccess
				+ "]";
	}
	
	
}
