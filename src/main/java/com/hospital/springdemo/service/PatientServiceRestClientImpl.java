package com.hospital.springdemo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hospital.springdemo.model.Patient;

@Service
public class PatientServiceRestClientImpl implements PatientService {

	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public PatientServiceRestClientImpl(RestTemplate theRestTemplate, 
										@Value("${crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<Patient> getPatient() {
		
		logger.info("in getPatients(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Patient>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
																  new ParameterizedTypeReference<List<Patient>>() {});

		// get the list of customers from response
		List<Patient> patients = responseEntity.getBody();

		logger.info("in getPatients(): patients" + patients);
		
		return patients;
	}

	@Override
	public Patient getPatient(int theId) {

		logger.info("in getPatient(): Calling REST API " + crmRestUrl);

		// make REST call
		Patient thePatient = 
				restTemplate.getForObject(crmRestUrl + "/" + theId, 
										  Patient.class);

		logger.info("in savePatient(): thePatient=" + thePatient);
		
		return thePatient;
	}

	@Override
	public void savePatient(Patient thePatient) {

		logger.info("in savePatient(): Calling REST API " + crmRestUrl);
		
		int employeeId = thePatient.getId();

		// make REST call
		if (employeeId == 0) {
			// add employee
			restTemplate.postForEntity(crmRestUrl, thePatient, String.class);			
		
		} else {
			// update employee
			restTemplate.put(crmRestUrl, thePatient);
		}

		logger.info("in savePatient(): success");	
	}

	@Override
	public void deletePatient(int theId) {

		logger.info("in deleteCustomer(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deletePatient(): deleted patient theId=" + theId);
	}

}
