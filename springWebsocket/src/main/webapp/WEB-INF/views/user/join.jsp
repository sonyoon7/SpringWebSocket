 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
 <!DOCTYPE html> 
 <html> 
  <head> 
  <meta charset="UTF-8"> 
  <title>Insert title here</title> 	
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/join.css">

  </head> 
  <body> 
    <jsp:include page="../includes/header.jsp" flush="false"></jsp:include>
    
    <form action="${path }/user/insertUser" method="post" style="border:1px solid #ccc">
  <div class="container">
    <h1>Sign Up</h1>
    <p>Please fill in this form to create an account.</p>
    <hr>

    <label for="userid"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="userid" required>
    
    <label for="name"><b>Name</b></label>
    <input type="text" placeholder="Enter User Name" name="name" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="passwd" required>

    <label for="psw-repeat"><b>Repeat Password</b></label>
    <input type="password" placeholder="Repeat Password" name="passwd-repeat" required>
    
    <label for="authority"><b>Authority</b>
    	<select name="authority">
    		<option value="ROLE_USER">일반 사용자</option>
    		<option value="ROLE_ADMIN">관리자</option>
    	</select>
    </label>
    
    <p>By creating an account you agree to our <a href="#" style="color:dodgerblue">Terms & Privacy</a>.</p>

    <div class="clearfix">
      <button type="button" class="cancelbtn">Cancel</button>
      <button type="submit" class="signupbtn">Sign Up</button>
    </div>
  </div>
</form>
    
  </body> 
 </html>