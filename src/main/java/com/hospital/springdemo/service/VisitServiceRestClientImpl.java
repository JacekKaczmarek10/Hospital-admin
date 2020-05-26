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

import com.hospital.springdemo.model.Visit;

@Service
public class VisitServiceRestClientImpl implements VisitService {

	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public VisitServiceRestClientImpl(RestTemplate theRestTemplate, 
										@Value("${vis.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<Visit> getVisit() {
		
		logger.info("in getVisits(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<Visit>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
																  new ParameterizedTypeReference<List<Visit>>() {});

		// get the list of customers from response
		List<Visit> visits = responseEntity.getBody();

		logger.info("in getVisits(): visits" + visits);
		
		return visits;
	}

	@Override
	public Visit getVisit(int theId) {

		logger.info("in getVisit(): Calling REST API " + crmRestUrl);

		// make REST call
		Visit theVisit = 
				restTemplate.getForObject(crmRestUrl + "/" + theId, 
						Visit.class);

		logger.info("in saveVisit(): theVisit=" + theVisit);
		
		return theVisit;
	}

	@Override
	public void saveVisit(Visit theVisit) {

		logger.info("in savePatient(): Calling REST API " + crmRestUrl);
		
		int employeeId = theVisit.getId();

		// make REST call
		if (employeeId == 0) {
			// add employee
			restTemplate.postForEntity(crmRestUrl, theVisit, Visit.class);			
		
		} else {
			// update employee
			restTemplate.put(crmRestUrl, theVisit);
		}

		logger.info("in saveVisit(): success");	
	}

	@Override
	public void deleteVisit(int theId) {

		logger.info("in deleteVisit(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deleteVisit(): deleted visit theId=" + theId);
	}

}
