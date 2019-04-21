package com.renting.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.renting.pojo.Users;
import com.renting.service.IUsersService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	@Autowired
	private IUsersService usersService;
	
	
	
	@RequestMapping(value="/login")
	public String login( Users user,Model model,HttpServletRequest request) {
		System.out.println("进入Login==========");
		System.out.println("uuser, pwd:"+user.getUuser()+"\t"+ user.getPwd());
		Users ulist = usersService.selectUser(user);
		if(ulist !=null) {
			
			model.addAttribute("uid",ulist.getUid());
		    request.getSession().setAttribute("userinfo", ulist);
		return "redirect:/guanli/list";
	}else {
		model.addAttribute("uuser",user.getUuser());
		model.addAttribute("logonError", "登录失败，用户名或密码不正确！");
		return "login";
	}

		
	}
	//去注册页面
	@RequestMapping("/regs")
	public String regs() {
		return "regs";
	}
	
	@PostMapping("/regSubmit")
	public String regSubmit(Users users,Model model) {
		System.out.println("进入 regSubmit=========users="+users.toString());
		if(usersService.insertUsers(users)) {
			model.addAttribute("success", "注册成功，您可以直接登录了");
			return "login";
		}
		model.addAttribute("error", "注册失败，请重新注册");
		return "regs";
	}

}
