package com.asiainfo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.asiainfo.constant.Constants;

public class AccessInterceptor implements HandlerInterceptor {

	 @Override
	    public void postHandle(HttpServletRequest request, 
	        HttpServletResponse response, Object handler, 
	        ModelAndView modelAndView) throws Exception { 
	    } 
	      
	    @Override
	    public void afterCompletion(HttpServletRequest request, 
	        HttpServletResponse response, Object handler, Exception ex) 
	        throws Exception { 
	    } 
	      
	    @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
	        Object handler) throws Exception { 
	    	HttpSession session=request.getSession(true); 
//	    	String path = request.getRequestURI();////原页面
//	    	System.out.println(path);
	        //session中获取用户名信息 
	        Object obj = session.getAttribute(Constants.LOGIN_USER); 
	        if (obj==null||"".equals(obj.toString())) { 
	          response.sendRedirect(request.getSession().getServletContext().getContextPath()+"/toLoginPage");
	             return false;
	          }
	          return true;
	    }

}
