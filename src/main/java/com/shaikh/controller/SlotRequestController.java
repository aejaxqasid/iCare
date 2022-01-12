package com.shaikh.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shaikh.model.Appointment;
import com.shaikh.model.Doctor;
import com.shaikh.service.IAppointmentService;
import com.shaikh.service.ISlotRequestService;

@Controller
@RequestMapping("/slot")
public class SlotRequestController {
	
	@Autowired
	private ISlotRequestService service;
	
	@Autowired
	private IAppointmentService apmtService;
		
	@GetMapping("/create")
	public String create(Model model) {
		List<Appointment> appointments = apmtService.fetchAllApmts();
		model.addAttribute("appointments", appointments);
		
		return "DoctorRegister";
	}

	@PostMapping("/create")
	public String create(@ModelAttribute Doctor doc, RedirectAttributes rd) {
		
		return "redirect:all";
	}
	
	//TODO: view one doctor profile

	@GetMapping("/all")
	public String viewAll(Model model) {
		

		return "DoctorData";
	}

	@GetMapping("/update")
	public String update(@RequestParam Long id, Model model) {
		
		return "DoctorUpdate";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Doctor doctor, RedirectAttributes rd) {
		
		return "redirect:all";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam Long id, RedirectAttributes rd) {
		
		return "redirect:all";		
	}

}
