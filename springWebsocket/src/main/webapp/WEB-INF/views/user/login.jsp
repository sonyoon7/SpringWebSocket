 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <!DOCTYPE html> 
 <html> 
  <head> 
  <meta charset="UTF-8"> 
  <title>Insert title here</title> 	
  	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
  	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css">
	<link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css" rel="stylesheet">
  </head> 
  <body> 
  <c:set var="path" value="${pageContext.request.contextPath}"></c:set>
  <jsp:include page="../includes/header.jsp" flush="false"></jsp:include>
  
  <!-- 
  		security-context.xml 과 url 맞춰주어야 함 
  		
		<sec:form-login login-page="/user/login"
			login-processing-url="/user/login_check"
			authentication-success-handler-ref="userLoginSuccessHandler"
			authentication-failure-handler-ref="userLoginFailureHandler"
			username-parameter="userid"
			password-parameter="passwd"/>
			
		<sec:remember-me key="userKey" token-validity-seconds="86400"/>	
   -->
	<form action="${path }/user/login_check" method="post">
	<span>${errMsg }</span>
	  <div class="imgcontainer">
	    <img src="${pageContext.request.contextPath}/resources/img/astronaut.png" alt="Avatar" class="avatar">
	  </div>
	
	  <div class="container">
	    <label for="uname"><b>Username</b></label>
	    <input type="text" placeholder="Enter Username" name="userid" required>
	
	    <label for="psw"><b>Password</b></label>
	    <input type="password" placeholder="Enter Password" name="passwd" required>
	
	    <button type="submit">Login</button>
	    <label>
	      <input type="checkbox" checked="checked" name="_spring_security_remember_me"> Remember me
	    </label>
	  </div>
	
	  <div class="container" style="background-color:#f1f1f1">
	    <button type="button" class="cancelbtn">Cancel</button>
	    <span class="psw">Forgot <a href="#">password?</a></span>
	  </div>
	</form>
  </body> 
 </html>