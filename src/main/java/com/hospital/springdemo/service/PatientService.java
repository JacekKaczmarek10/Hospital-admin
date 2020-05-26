package com.hospital.springdemo.service;

import java.util.List;

import com.hospital.springdemo.model.Patient;

public interface PatientService {

	public List<Patient> getPatient();

	public void savePatient(Patient thePatient);

	public Patient getPatient(int theId);

	public void deletePatient(int theId);
	
}
