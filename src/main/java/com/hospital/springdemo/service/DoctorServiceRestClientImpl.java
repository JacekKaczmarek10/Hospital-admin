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

import com.hospital.springdemo.model.Doctor;

@Service
public class DoctorServiceRestClientImpl implements DoctorService {

	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public DoctorServiceRestClientImpl(RestTemplate theRestTemplate, 
										@Value("${dct.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  dct.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<Doctor> getDoctor() {
		
		logger.info("in getDoctors(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Doctor>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
																  new ParameterizedTypeReference<List<Doctor>>() {});

		// get the list of customers from response
		List<Doctor> doctors = responseEntity.getBody();

		logger.info("in getDoctors(): doctors" + doctors);
		
		return doctors;
	}

	@Override
	public Doctor getDoctor(int theId) {

		logger.info("in getDoctors(): Calling REST API " + crmRestUrl);

		// make REST call
		Doctor theDoctor = 
				restTemplate.getForObject(crmRestUrl + "/" + theId, 
										  Doctor.class);

		logger.info("in saveDoctor(): theDoctor=" + theDoctor);
		
		return theDoctor;
	}

	@Override
	public void saveDoctor(Doctor theDoctor) {

		logger.info("in saveDoctor(): Calling REST API " + crmRestUrl);
		
		int employeeId = theDoctor.getId();

		// make REST call
		if (employeeId == 0) {
			// add employee
			restTemplate.postForEntity(crmRestUrl, theDoctor, String.class);			
		
		} else {
			// update employee
			restTemplate.put(crmRestUrl, theDoctor);
		}

		logger.info("in saveDoctor(): success");	
	}

	@Override
	public void deleteDoctor(int theId) {

		logger.info("in deleteDoctor(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deletedoctor(): deleted doctor theId=" + theId);
	}

}
