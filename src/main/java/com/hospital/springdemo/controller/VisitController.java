package com.hospital.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hospital.springdemo.model.Doctor;
import com.hospital.springdemo.model.Patient;
import com.hospital.springdemo.model.Visit;
import com.hospital.springdemo.service.DoctorService;
import com.hospital.springdemo.service.PatientService;
import com.hospital.springdemo.service.VisitService;

@Controller
@RequestMapping("/hospital")
public class VisitController {

	@Autowired
	private DoctorService doctorService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private VisitService visitService;
	
	@GetMapping("/vislist")
	public String listVisits(Model theModel) {
		
		// get customers from the service
		List<Visit> theVisits = visitService.getVisit();
				
		// add the customers to the model
		theModel.addAttribute("visits", theVisits);
		
		return "list-visits";
	}
	
	
	@GetMapping("/visadd")
	public String mainPage(Model theModel) {
		
		// get customers from the service
					Visit theVisit = new Visit();
		
					theModel.addAttribute("visit", theVisit);
		
		
					List<Patient> thePatients = patientService.getPatient();
					theModel.addAttribute("patients", thePatients);

					List<Doctor> theDoctors = doctorService.getDoctor();
					theModel.addAttribute("doctors", theDoctors);
		return "visit-form";
	}
	
	
	
	@PostMapping("/saveVisit")
	public String saveVisit(@ModelAttribute("visit") Visit theVisit) {
		
		// save the customer using our service
		visitService.saveVisit(theVisit);	
		
		return "redirect:/hospital/vislist";
	}
	
	@GetMapping("/visupdate")
	public String showFormForUpdateDoc(@RequestParam("visitId") int theId, Model theModel) {
		
		List<Patient> thePatients = patientService.getPatient();
		theModel.addAttribute("patients", thePatients);

		List<Doctor> theDoctors = doctorService.getDoctor();
		theModel.addAttribute("doctors", theDoctors);
		
		
		Visit theVisit = visitService.getVisit(theId);	
		theModel.addAttribute("visit", theVisit);
		
		return "visit-form";
	}
	
	
	@GetMapping("/deleteVisit")
	public String deletePatient(@RequestParam("visitId") int theId) {
		
		// delete the customer
		visitService.deleteVisit(theId);
		
		return "redirect:/hospital/vislist";
	}
	
}
