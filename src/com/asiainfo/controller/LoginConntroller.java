package com.asiainfo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.asiainfo.constant.Constants;
import com.asiainfo.domain.User;
import com.asiainfo.service.UserService;

@Controller
public class LoginConntroller {
	@Resource
	private UserService userService;
	@RequestMapping("/toLoginPage")
	public String toLogin(){
		return "login";
	}
	@RequestMapping("/getLogin")
	public ModelAndView getLogin(User user,HttpServletRequest request){
		ModelAndView view=new ModelAndView();
		user = userService.toLogin(user);
		if(user!=null){
			//存入session
			request.getSession().setAttribute(Constants.LOGIN_USER, user.getUserName());
			view.setViewName("redirect:/main");
		}else{
			view.setViewName("login");
		}
		return view;
	}
	
	@RequestMapping("/outLogin")
	public ModelAndView outLogin(User user,HttpServletRequest request){
		ModelAndView view=new ModelAndView();
		request.getSession().setAttribute(Constants.LOGIN_USER, "");
		view.setViewName("redirect:/toLoginPage");
		return view;
	}
	
	@RequestMapping("/editPassword")
	@ResponseBody
	public String editPassword(User user,HttpServletRequest request){
		user.setUserName(request.getSession().getAttribute(Constants.LOGIN_USER).toString());
		userService.updatePassword(user);
		return "1";
	}
	@RequestMapping("/toEditPassPage")
	public String toEditPassPage(){
		return "editpassword";
	}
	
}
