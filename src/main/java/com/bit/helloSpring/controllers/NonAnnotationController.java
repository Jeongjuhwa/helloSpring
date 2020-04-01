package com.bit.helloSpring.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// Non Annotation 기반 Controller는
// ModelAndView handleRequest(req,res); 
public class NonAnnotationController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "<h3>Non Annotation Controller</h3>");
		mav.setViewName("WEB-INF/views/hello.jsp");
		return mav;
	}

}
