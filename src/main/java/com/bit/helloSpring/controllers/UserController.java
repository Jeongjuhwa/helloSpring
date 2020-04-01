package com.bit.helloSpring.controllers;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.helloSpring.vo.RequestVo;

@Controller
@RequestMapping("/user")
public class UserController {
	@RequestMapping(value={"/","/join"},	// 여러 URL 패턴을 함께 처리하는 Handler
			method=RequestMethod.GET)   // 요청 메서드
	public String joinform() {
		//return "/WEB-INF/views/joinform.jsp";
		return "joinform";
	}
	// 전달 받아야 할 파라미터가 많을 경우는 @ModelAttribute로 전달
	@RequestMapping(value="/join",
			method=RequestMethod.POST)
	public String joinAction(@ModelAttribute RequestVo vo) {
		
		// 내부 가입 로직 구현
		System.out.println("요청된 파라미터: "+ vo);
		return "redirect:/user/joinsuccess";
	}
	@RequestMapping("/joinsuccess")
	@ResponseBody
	public String joinSuccess() {
		return "<h1>JOIN SUCCESS</h1>";
	}
	// pathVariable
	// 파라미터를 쿼리 문자열이 아니라 url 요청 경로의 일부로 받는 방법
	// -> Fancy URL
	@RequestMapping("/profile/{userid}")
	@ResponseBody
	public String profile(@PathVariable("userid") String userid) {
		return "<h1>"+userid+"`s profile</h1>";
	}
}
