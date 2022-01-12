package com.shaikh.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shaikh.model.UserInfo;
import com.shaikh.service.IUserInfoService;

@Controller
@RequestMapping("/user")
public class UserInfoController {

	@Autowired
	private IUserInfoService service;

	@GetMapping("/login")
	public String login() {
		return "UserLogin";
	}

	@GetMapping("/create")
	public String create() {
		return "UserRegister";
	}

	@PostMapping("/create")
	public String create(@ModelAttribute UserInfo userInfo, Model model) {
		String message = service.createUserInfo(userInfo);
		model.addAttribute("message", message);

		return "UserRegister";
	}

	@GetMapping("/setup")
	public String setup(HttpSession session, Principal principal) {

		String username = principal.getName();
		UserInfo user = service.findByUsername(username).get();
		session.setAttribute("user", user);

		return "redirect:create";
	}

}
