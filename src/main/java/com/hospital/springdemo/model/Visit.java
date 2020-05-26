package com.hospital.springdemo.model;

public class Visit {

	private int id;
	
	private int patId;
	
	private int docId;
	
	
	public Visit() {
		
		
	}
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getPatId() {
		return patId;
	}

	public void setPatId(int patId) {
		this.patId = patId;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}
	
	
	
}
