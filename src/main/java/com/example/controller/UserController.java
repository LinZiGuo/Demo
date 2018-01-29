package com.example.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.WebSecurityConfig;
import com.example.domain.User;
import com.example.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String userList(Model model) {
		model.addAttribute("users", userService.findAll());
		System.out.println("到了UserController");
		return "UserList";
	}
	
	/**
	 * 跳转到用户登录界面
	 * @return
	 */
	@RequestMapping("/login")
	public String login() {
		System.out.println("到了/login");
		return "login";
	}
	
	@RequestMapping("/loginVerify")
	public String loginVerify(String username,String password,HttpSession session) {
		System.out.println("到了/loginVerify");
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		System.out.println("username="+username);
		boolean verify=userService.verifyLogin(user);
		if (verify) {
			session.setAttribute(WebSecurityConfig.SESSION_KEY, username);
			return "index";
		}else {
			return "redirect:/login?error=yes";
		}
	}
}
