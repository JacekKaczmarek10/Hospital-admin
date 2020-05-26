package com.hospital.springdemo.model;

import java.util.ArrayList;
import java.util.List;



public class Doctor {

	private int id;
	
	private String firstName;
	
	private String lastName;
	
	private String specialty;
	
	private String email;
	
	private List<Patient> patients;
	
	public Doctor() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

	public String getSpecialty() {
		return specialty;
	}

	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", specialty=" + specialty
				+ ", email=" + email + "]";
	}

	
	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}
	
	public void addPatient(Patient thePatient) {
		
		if(patients == null) {
			patients = new ArrayList<>();
		}
		
		patients.add(thePatient);
	}
	

	
	
}
