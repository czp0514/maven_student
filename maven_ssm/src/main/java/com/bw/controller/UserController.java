package com.bw.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bw.pojo.User;
import com.bw.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("login.action")
	public String login(User user,HttpSession session) {
		User u = userService.login(user);
		if(u!=null) {
			session.setAttribute("u", u);
			return "redirect:GetStudentList.action";
		}else {
			return "redirect:login.jsp";
		}
		
	}
}
