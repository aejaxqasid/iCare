package com.shaikh.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.shaikh.constants.SlotStatus;
import com.shaikh.constants.UserRole;
import com.shaikh.exception.PatientNotFoundException;
import com.shaikh.model.Appointment;
import com.shaikh.model.Doctor;
import com.shaikh.model.Patient;
import com.shaikh.model.SlotRequest;
import com.shaikh.model.UserInfo;
import com.shaikh.service.IAppointmentService;
import com.shaikh.service.IPatientService;
import com.shaikh.service.ISlotRequestService;
import com.shaikh.service.IUserInfoService;

@Controller
@RequestMapping("/slot")
public class SlotRequestController {

	@Autowired
	private ISlotRequestService service;

	@Autowired
	private IAppointmentService apmtService;

	@Autowired
	IUserInfoService userService;

	@Autowired
	IPatientService patientService;

	@GetMapping("/book")
	public String book(@RequestParam Long appid, HttpSession session, Model model) {
		UserInfo user = (UserInfo) session.getAttribute("user");
		String role = user.getRole();

		Appointment appointment = apmtService.fetchApmt(appid);
		model.addAttribute("appointment", appointment);

		if (role.equalsIgnoreCase(UserRole.PATIENT.name())) {
			String email = user.getUsername();
			Patient patient = patientService.fetchPatientByEmail(email);
			model.addAttribute("patient", patient);

			return "SlotRegisterPatient";
		}

		else
			return "SlotRegisterAdmin";
	}

	@GetMapping("/book-patient")
	public String create(@RequestParam Long appid, Model model, Principal principal) {

		String username = principal.getName();
		Patient patient = patientService.fetchPatientByEmail(username);

		Appointment appointment = apmtService.fetchApmt(appid);

		String message = "";
		try {
			SlotRequest sr = new SlotRequest();
			sr.setPatient(patient);
			sr.setAppointment(appointment);
			sr.setStatus(SlotStatus.PENDING.name());

			message = service.createSlotRequest(sr);
			message = message + " with stasus = " + sr.getStatus() + " ; plsease wait for some time for ADMIN approval";
		} catch (DataIntegrityViolationException e) {
			message = "An Appointment with the same doctor is already there!";
		}

		model.addAttribute("message", message);
		return "SlotMessage";

	}

	@GetMapping("/book-admin")
	public String create(@RequestParam Long appid, @RequestParam String patientId, Model model) {

		Patient patient = patientService.fetchPatientByEmail(patientId);

		Appointment appointment = apmtService.fetchApmt(appid);

		String message = "";
		try {
			SlotRequest sr = new SlotRequest();
			sr.setPatient(patient);
			sr.setAppointment(appointment);
			sr.setStatus(SlotStatus.ACCEPTED.name());

			apmtService.setSlotCountMinus(appid);

			message = service.createSlotRequest(sr);
			message = message + " with stasus = " + sr.getStatus() + " ; plsease wait for some time for ADMIN approval";
		} catch (DataIntegrityViolationException e) {
			message = "An Appointment with the same doctor is already there!";
		} catch (PatientNotFoundException e) {
			message = e.getMessage();
		}

		model.addAttribute("message", message);
		return "SlotMessage";
	}

	@PostMapping("/create")
	public String create(@ModelAttribute Doctor doc, RedirectAttributes rd) {

		return "redirect:all";
	}

	// TODO: view one doctor profile

	@GetMapping("/all")
	public String viewAll(Model model) {
		List<Appointment> appointments = apmtService.fetchAllApmts();
		model.addAttribute("appointments", appointments);

		return "SlotRegister";
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
	
	@GetMapping("/view-all")
	public String viewAll(HttpSession session, Model model) {
		UserInfo user = (UserInfo) session.getAttribute("user");
		String role = user.getRole();
		// if user is patient then return all patients slots
		List<SlotRequest> slots = null;
		if(role.equalsIgnoreCase(UserRole.PATIENT.name())) {
			String email = user.getUsername();
			slots = service.fetchAllPatientSlot(email);
			model.addAttribute("slots", slots);
			
			return "SlotData";
		}
		
		if(role.equalsIgnoreCase(UserRole.ADMIN.name())) {
			slots = service.fetchAll();
			model.addAttribute("slots", slots);
			
			return "SlotData";
		}
		
		// if user is admin return all slots
		
		return null;
	}
	
	@GetMapping("/cancel")
	public String cancel(@RequestParam Long slotid) {
		service.updateSlotStatus(SlotStatus.CANCELLED.name(), slotid);
		
		return "redirect:view-all";
	}
	
	@GetMapping("/reclaim")
	public String reclaim(@RequestParam Long slotid) {
		service.updateSlotStatus(SlotStatus.PENDING.name(), slotid);
		
		return "redirect:view-all";
	}
	
	@GetMapping("/accept")
	public String accept(@RequestParam Long slotid) {
		service.updateSlotStatus(SlotStatus.ACCEPTED.name(), slotid);
		
		return "redirect:view-all";
	}
	
	@GetMapping("/reject")
	public String reject(@RequestParam Long slotid) {
		service.updateSlotStatus(SlotStatus.REJECTED.name(), slotid);
		
		return "redirect:view-all";
	}
}
