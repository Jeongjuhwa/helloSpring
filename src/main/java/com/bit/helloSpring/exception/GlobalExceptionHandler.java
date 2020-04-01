package com.bit.helloSpring.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

// 어플리케이션 전체에서 발생하는 모든 이벤트를 감지
@ControllerAdvice

public class GlobalExceptionHandler {
@ExceptionHandler(Exception.class)
public ModelAndView handleGlobalException(
		HttpServletRequest req, Exception e) {
	// 전역 예외 처리 핸들러를 만들 수 있따
	// 1.로깅
	System.err.println("AdviceController:handleException");
	e.printStackTrace();
	// 2.오류 페이지로 전환
	ModelAndView mav = new ModelAndView();
	mav.addObject("name",e.getClass().getSimpleName());
	mav.addObject("message","GlobalHandler"+e.getMessage());
	mav.setViewName("error/exception");
	return mav;
}
}
