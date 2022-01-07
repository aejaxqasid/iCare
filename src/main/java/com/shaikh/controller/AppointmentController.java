package com.shaikh.controller;

import java.util.List;

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
import com.shaikh.service.IDoctorService;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {
	
	@Autowired
	private IAppointmentService service;
	
	@Autowired 
	private IDoctorService docService;
	
	@GetMapping("/create")
	public String create(Model model) {
		List<Doctor> doctors = docService.fetchAll();
		model.addAttribute("doctors", doctors);
		
		return "AppointmentRegister";
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute Appointment apmt, RedirectAttributes rd) {
		String msg = service.createApmt(apmt);
		rd.addFlashAttribute("msg", msg);
		
		return "redirect:all";
	}
	
	@GetMapping("/all")
	public String viewAll(Model model) {
		List<Appointment> list = service.fetchAllApmts();
		model.addAttribute("list", list);
		
		return "AppointmentData";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam Long id, Model model) {
		Appointment appointment = service.fetchApmt(id);
		model.addAttribute("appointment", appointment);
		
		return "AppointmentUpdate";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Appointment app, RedirectAttributes rd) {
		String msg = service.updateApmt(app);
		rd.addFlashAttribute("msg", msg);
		
		return "redirect:all";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam Long id, RedirectAttributes rd) {
		String msg = service.deleteApmt(id);
		rd.addFlashAttribute("msg", msg);
		
		return "redirect:all"; 
	}
	
	
	//TODO : validate slot for a doctor by date (Ajax)

}
