package com.hospital.springdemo.service;

import java.util.List;

import com.hospital.springdemo.model.Doctor;

public interface DoctorService {
	
	public List<Doctor> getDoctor();

	public void saveDoctor(Doctor theDoctor);

	public Doctor getDoctor(int theId);

	public void deleteDoctor(int theId);
		
	}


