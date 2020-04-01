<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
input{
	display : block;
	margin-top : 10px;
	
}
</style>
<body>
<!-- contextPath는 환경에 따라 변경할 수 있기 때문에 
고정된 문자열이 아닌 동적으로 변경된 url을 잡아줘야 한다 -->
<form action = "<c:url value="/user/join"/>" method="POST">
	<input type="text" name="name" placeholder="이름" />
	<input type="password" name="password" placeholder="암호 입력" />
	<input type="email" name="email" placeholder="이메일 입력" />
	<input type="text" name="address" placeholder="주소 입력" />
	
	<input type ="submit" value="가입" />
	
</form>

</body>
</html>