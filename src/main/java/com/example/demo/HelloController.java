package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.UserService;

@RestController
@RequestMapping("/demo")
public class HelloController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/hello")
	public String hello() {
		System.out.println("到了demo/HelloController");
		return "hello, this is a spring boot demo.It's port is 8088";
	}
	
	@RequestMapping("/user")
	public String userList(Model model) {
		model.addAttribute("users", userService.findAll());
		System.out.println("到了demo/UserController");
		return "UserList";
	}
}
