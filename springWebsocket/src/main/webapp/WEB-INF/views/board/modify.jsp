 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
 <%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <jsp:useBean id="today" class="java.util.Date" />

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin 2 - Register</title>

  <!-- Custom fonts for this template-->
  <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css" rel="stylesheet">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board.css">
	
</head>

<body class="bg-gradient-primary">
<jsp:include page="../includes/header.jsp"></jsp:include>
  <div class="container">

    <div class="card o-hidden border-0 shadow-lg my-5">
      <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
          <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
          <div class="col-lg-7">
            <div class="p-5">
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">Board Modify Page</h1>
              </div>
              <form class="user" method="post" action="${pageContext.request.contextPath}/board/modifypost" >
             	 <div class="form-group">
                  <input type="text" class="form-control form-control-user" name="bno" value="${board.bno }" readonly="readonly">
                </div>
                <div class="form-group row">
                  <div class="col-sm-12 mb-3 mb-sm-0">
                    <input type="text" class="form-control form-control-user" name="title" value="${board.title }" >
                  </div>
                </div>
                <div class="form-group ">
                  	<textarea rows="7"  name="content" class="form-control" >${board.content }</textarea>
                </div>
                <div class="form-group">
                  <input type="text" class="form-control form-control-user" name="writer" value="${board.writer }" readonly="readonly">
                </div>
               

                <%-- <input type="hidden" name="updateDate" value="${today}"> --%>
         		 <hr>
         		 
                 <button class="btn btn-primary btn-user" type="submit" >Modify</button >
                 <button class="btn btn-primary btn-user ">
                  <a href="${pageContext.request.contextPath}/board/listYuni" class="text-white">List</a> 
                </button >
                <hr>
               
              </form>
         
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>

  <!-- Bootstrap core JavaScript-->
  <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Core plugin JavaScript-->
  <script src="${pageContext.request.contextPath}/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

  <!-- Custom scripts for all pages-->
  <script src="${pageContext.request.contextPath}/resources/js/sb-admin-2.min.js"></script>

</body>

</html>
