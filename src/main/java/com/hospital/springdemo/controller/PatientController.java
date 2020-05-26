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

import com.hospital.springdemo.model.Patient;
import com.hospital.springdemo.service.PatientService;


@Controller
@RequestMapping("/hospital")
public class PatientController {
	@Autowired
	private PatientService patientService;
	
	@GetMapping("/home")
	public String mainPage() {
		
		return "main-page";
	}
	
	@GetMapping("/visit")
	public String visitPage() {
		
		return "visit-page";
	}
	
	
	// DOCTOR
	
		@GetMapping("/patlist")
		public String listPatients(Model theModel) {
			
			// get customers from the service
			List<Patient> thePatients = patientService.getPatient();
					
			// add the customers to the model
			theModel.addAttribute("patients", thePatients);
			
			return "list-patients";
		}
		
		@GetMapping("/patadd")
		public String showFormForAddDoc(Model theModel) {
			
			// create model attribute to bind form data
			Patient thePatient = new Patient();
			
			theModel.addAttribute("patient", thePatient);
			
			return "patient-form";
		}
		
		
		@PostMapping("/savePatient")
		public String saveDoctor(@ModelAttribute("patient") Patient thePatient) {
			
			// save the customer using our service
			patientService.savePatient(thePatient);	
			
			return "redirect:/hospital/patlist";
		}
		
		@GetMapping("/patupdate")
		public String showFormForUpdateDoc(@RequestParam("patientId") int theId, Model theModel) {
			
			// get the customer from our service
			Patient thePatient = patientService.getPatient(theId);	
			
			// set customer as a model attribute to pre-populate the form
			theModel.addAttribute("patient", thePatient);
			
			// send over to our form		
			return "patient-form";
		}
		
		@GetMapping("/patdelete")
		public String deletePatient(@RequestParam("patientId") int theId) {
			
			// delete the customer
			patientService.deletePatient(theId);
			
			return "redirect:/hospital/patlist";
		}
		
		
}
