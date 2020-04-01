package com.bit.helloSpring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bit.helloSpring.exception.CustomException;

@Controller
public class HelloController {
	// @RequestParam을 기본 형태로 썼을 때는 필수 파라미터가 된다.
	// 부가 옵션들을 부여할 수 있음 ( value, require, defaultvalue)
	@RequestMapping("/hello")
	public ModelAndView hello(@RequestParam (value="name", required=false, defaultValue="?")String name) {
		ModelAndView mav = new ModelAndView();
		// 데이터 객체를 view 전달
		mav.addObject("message","Hello, "+name);
		//mav.setViewName("/WEB-INF/views/hello.jsp");
		mav.setViewName("hello");
		return mav;
	}
	// 기본적으로 return type이 String이면 ViewName이다
	// 리턴된 문자의 ViewName을 가진 View 객체로 포워딩
	@RequestMapping("/hello2")
	public String hello2(
			@RequestParam(value="name", required=false, defaultValue="?")String name, ModelMap map) {
		map.addAttribute("message","hello,"+name);
		// return "/WEB-INF/views/hello.jsp";
		return "hello";
	}
	@ResponseBody	// view를 거치지 않고 응답으로 객체를 바로 돌려줄 때 사용
	@RequestMapping("/hello3")
	public String hello3() {
		return "<P>ResponseBody Annotation</p>";
	}
	@RequestMapping("/except")
	@ResponseBody
	public String except() {
		//강제 exception 발생
		try {
			int result = 4/0;
		}catch(Exception e) {
			// 대부분의 예외는 복구가 쉽지 않음
			// RuntimeException으로 전환하여 throw
			//throw new RuntimeException("welecomController에서 예외 발생");
			// RuntimeException 보다
			// 특별한 의미를 가지는 사용자 정의 예외를 만들어 throw 하는 것이 바람직
			throw new CustomException("WelcomeController에서 예외 발생");
		}
		return "Exception Test";
	}
	
	// Exception Handler V1: 컨트롤러 내부의 익셉션을 처리하는 방법
	/*
	@ExceptionHandler(RuntimeException.class)
	public String handleControllerException(RuntimeException e, Model model) {
		// 익셉션 발생시, 에러정보를 model에 담아서
		// error/exception view로 전달
		model.addAttribute("name", e.getClass().getSimpleName());
		model.addAttribute("message",e.getMessage());
		return "error/exception";
		
	}
		*/
	
	// Exception Handler v2: 보다 구체적인 의미의 Exception 처리
	// -> 권장
	/*
	@ExceptionHandler(CustomException.class)
	public String handleControllerExceptionV2(CustomException e, Model model) {
		model.addAttribute("name", e.getClass().getSimpleName());
		model.addAttribute("message",e.getMessage());
		return "error/exception";
	}
	*/
	
}
