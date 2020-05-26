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
import com.hospital.springdemo.service.DoctorService;


@Controller
@RequestMapping("/hospital")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	
	// DOCTOR
	
		@GetMapping("/doclist")
		public String listDoctors(Model theModel) {
			
			// get customers from the service
			List<Doctor> theDoctors = doctorService.getDoctor();
					
			// add the customers to the model
			theModel.addAttribute("doctors", theDoctors);
			
			return "list-doctors";
		}
		
		@GetMapping("/docadd")
		public String showFormForAddDoc(Model theModel) {
			
			// create model attribute to bind form data
			Doctor theDoctor = new Doctor();
			
			theModel.addAttribute("doctor", theDoctor);
			
			return "doctor-form";
		}
		
		
		@PostMapping("/saveDoctor")
		public String saveDoctor(@ModelAttribute("doctor") Doctor theDoctor) {
			
			// save the customer using our service
			doctorService.saveDoctor(theDoctor);	
			
			return "redirect:/hospital/doclist";
		}
		
		@GetMapping("/docupdate")
		public String showFormForUpdateDoc(@RequestParam("doctorId") int theId, Model theModel) {
			
			Doctor theDoctor = doctorService.getDoctor(theId);	
			
			theModel.addAttribute("doctor", theDoctor);
			
			// send over to our form		
			return "doctor-form";
		}
		
		@GetMapping("/docdelete")
		public String deleteDoctor(@RequestParam("doctorId") int theId) {
			
			// delete the customer
			doctorService.deleteDoctor(theId);
			
			return "redirect:/hospital/doclist";
		}
		
		
}
