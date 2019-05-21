 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>SB Admin 2 - Tables</title>

  <!-- Custom fonts for this template -->
  <link href="${pageContext.request.contextPath}/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/sb-admin-2.min.css" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board.css">
  <!-- Custom styles for this page -->
  <link href="${pageContext.request.contextPath}/resources/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>

<body id="page-top">
		<jsp:include page="../includes/header.jsp" flush="false"></jsp:include>
		<%-- <jsp:include page="../includes/header.jsp"></jsp:include> --%>
        <!-- End of Topbar -->

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->

          <!-- DataTales Example -->
          <div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">List</h6>
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>#번호</th>
                      <th>제목</th>
                      <th>작성자</th>
                      <th>작성일</th>
                    </tr>
                  </thead>

                  <tbody>
                  <c:forEach items="${list}" var="i">
                    <tr>
                      <td>${i.bno }</td>
                      <!-- target="_blank" 를 a 태그 속성에 추가 하면 새 창이 뜬다 -->
                      <td><a href="${pageContext.request.contextPath}/board/get?bno=${i.bno }" >${i.title }</a></td>
                      <td>${i.writer }</td>
                      <td><fmt:formatDate value="${i.regdate }" pattern="yyyy-MM-dd"/></td>
                    <%--   <td><fmt:formatDate value="${i.updatedate }" pattern="yyyy-MM-dd"/></td> --%>
                    </tr>
                   </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>

        </div>
        <!-- /.container-fluid -->

     <jsp:include page="../includes/footer.jsp"></jsp:include>
<script>

		
		/* 뒤로가기 막기  */
history.pushState(null, null, location.href);
    window.onpopstate = function () {
        history.go(1);
};
</script>
</body>

</html>
