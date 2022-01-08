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

import com.shaikh.model.Patient;
import com.shaikh.service.IPatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {

	@Autowired
	private IPatientService service;

	@GetMapping("/create")
	public String create(Model model) {

		return "PatientRegister";
	}

	@PostMapping("/create")
	public String create(@ModelAttribute Patient patient, RedirectAttributes rd) {

		String msg = service.createPatient(patient);
		rd.addFlashAttribute("msg", msg);

		return "redirect:all";

	}

	// TODO: view one Patienttor profile

	@GetMapping("/all")
	public String viewAll(Model model) {
		List<Patient> list = service.fetchAll();
		model.addAttribute("list", list);

		return "PatientData";
	}

	@GetMapping("/update")
	public String update(@RequestParam Long id, Model model) {
		Patient patient = service.fetchPatient(id);
		model.addAttribute("patient", patient);

		return "PatientUpdate";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute Patient patient, RedirectAttributes rd) {
		String msg = service.updatePatient(patient);
		rd.addFlashAttribute("msg", msg);

		return "redirect:all";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Long id, RedirectAttributes rd) {
		String msg = service.deletePatient(id);
		rd.addFlashAttribute("msg", msg);

		return "redirect:all";
	}

}
