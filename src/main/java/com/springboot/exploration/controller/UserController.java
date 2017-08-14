package com.springboot.exploration.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.exploration.constant.Constants;
import com.springboot.exploration.model.User;
import com.springboot.exploration.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "/index";
	}

	@RequestMapping(value = "/userLogin", method = RequestMethod.GET)
	public String login(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "/login";
	}

	@RequestMapping("/signup")
	public String register(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "/register";
	}

	@RequestMapping(value = "/userRegistration", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute("user") User user, Model model, BindingResult result) {
		if (result.hasErrors()) {
			return "/login";
		}
		userService.addUser(user);
		return "/profile";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public String authenticate(@ModelAttribute("user") User user, HttpSession session) {

		if (userService.authenticate(user)) {
			session.setAttribute(Constants.LOGGED_USER, user.getUsername());
			return "/profile";
		}
		return "/userLogin";
	}

	@RequestMapping("/userInfo")
	public String userInfo() {
		return "/next";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {

		if ((String) session.getAttribute(Constants.LOGGED_USER) != null)
			session.invalidate();
		return "/userLogin";
	}

	@RequestMapping(value = "/allUsers")
	public String allUsers(Model model) {

		System.out.println("Inside all uses Methods");
		model.addAttribute("users", userService.getUsers());
		return "/users";
	}
}