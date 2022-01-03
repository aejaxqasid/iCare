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

import com.shaikh.model.Specialization;
import com.shaikh.service.ISpecializationService;

@Controller
@RequestMapping("/spec")
public class SpecializationController {

	@Autowired
	private ISpecializationService service;

	@GetMapping("/create")
	public String create() {
		return "SpecializationRegister";
	}

	@PostMapping("/create")
	public String create(@ModelAttribute Specialization spec, RedirectAttributes rd) {
		String msg = service.createSpec(spec);
		rd.addFlashAttribute("msg", msg);
		return "redirect:all";
	}

	@GetMapping("/all")
	public String viewAll(Model model) {
		List<Specialization> list = service.fetchAllSpecs();
		model.addAttribute("list", list);
		return "SpecializationData";
	}

	@GetMapping("/update")
	public String update(@RequestParam Long id, Model model) {
		Specialization spec = service.fetchSpec(id);
		model.addAttribute("spec", spec);
		return "SpecializationUpdate";
		
	}

	@PostMapping("/update")
	public String update(@ModelAttribute Specialization spec, RedirectAttributes rd) {
		String msg = service.updateSpec(spec);
		rd.addFlashAttribute("msg", msg);
		return "redirect:all";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam Long  id, RedirectAttributes rd) {
		String msg = service.deleteSpec(id);
		rd.addFlashAttribute("msg", msg);
		return "redirect:all";
	}

}
