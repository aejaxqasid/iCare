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

import com.shaikh.model.Doctor;
import com.shaikh.service.IDoctorService;
import com.shaikh.service.ISpecializationService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {

	@Autowired
	private IDoctorService service;

	@Autowired
	private ISpecializationService specService;

	@GetMapping("/create")
	public String create(Model model) {
		Map<Long, String> specs = specService.fetchSpecsIdAndName();
		model.addAttribute("specs", specs);

		return "DoctorRegister";
	}

	@PostMapping("/create")
	public String create(@ModelAttribute Doctor doc, RedirectAttributes rd) {
		String msg = service.createDoc(doc);
		rd.addFlashAttribute("msg", msg);

		return "redirect:all";
	}
	
	//TODO: view one doctor profile

	@GetMapping("/all")
	public String viewAll(Model model) {
		List<Doctor> list = service.fetchAll();
		model.addAttribute("list", list);

		return "DoctorData";
	}

	@GetMapping("/update")
	public String update(@RequestParam Long id, Model model) {
		Doctor doctor = service.fetchDoc(id);
		model.addAttribute("doc", doctor);
		
		Map<Long, String> specs = specService.fetchSpecsIdAndName();
		model.addAttribute("specs", specs);
		
		return "DoctorUpdate";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute Doctor doctor, RedirectAttributes rd) {
		String msg = service.updateDoc(doctor);
		rd.addFlashAttribute("msg", msg);
		
		return "redirect:all";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam Long id, RedirectAttributes rd) {
		String msg = service.deleteDoc(id);
		rd.addFlashAttribute("msg", msg);
		
		return "redirect:all";		
	}

}
