package com.hospital.springdemo.service;

import java.util.List;

import com.hospital.springdemo.model.Visit;


public interface VisitService {

	
	public List<Visit> getVisit();
	
	public void saveVisit(Visit theVisit);

	public Visit getVisit(int theId);

	public void deleteVisit(int theId);
}
