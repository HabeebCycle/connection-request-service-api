package com.mport.habeeb.connectionaccess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mport.habeeb.connectionaccess.model.Connection;

@Repository
public interface ConnectionRepository extends JpaRepository<Connection, Long> {
	public List<Connection> findByIpAddress(String ipAddress);
	public List<Connection> findByDateAccess(long dateAccess);
}
