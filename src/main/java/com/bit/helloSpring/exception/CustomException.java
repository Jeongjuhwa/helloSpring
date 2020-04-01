package com.bit.helloSpring.exception;


// Java가 기본적으로 제공하는 예외, 특히 RuntimeException은 일반적인 의미의 예외이기 떄문에
// 실제 구체적인 예외 상황을 명시하지는 않는다
// 사용자가 상황에 맞는 Exception을 생성하고
// 그 내부에 예외상황에서의 각종 데이터, 상황 정보 등을 저장하는 것이 더 좋다
public class CustomException extends RuntimeException {
	// TODO: 상황 정보 혹은 당시의 데이터를 저장하는 필드+ getter/setter를 만들고
	// 예외 상황에서의 데이터를 저장하는 로직을 만드는 것이 좋다
	public CustomException() {
		super("CustomException 발생");
	}
	
	public CustomException(String message) {
		super(message);
	}
}
