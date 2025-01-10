<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<c:set var="root" value="${pageContext.request.contextPath}/" />

<html>
<head>
    <title>
        네이버 클라우드 수강신청
    </title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery-3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
<div class="container" style="margin-top: 100px">
    <div class="row">
        <div class="col-sm-3"></div>
        <div class="col-sm-6">
            <div class="card shadow">
                <div class="card-body">
                    <c:if test="${fail == true}">
                        <div class="alert alert-danger">
                            <h2>Login Failed</h2>
                            <p>Check your ID and Password</p>
                        </div>
                    </c:if>
                    <h2>네이버 클라우드 수강신청</h2>
                    <form:form action="${root}login_proc" method="post" modelAttribute="loginProcBean">
                        <div class="form-group">
                            <form:label path="student_id">ID</form:label>
                            <form:input type="text" path="student_id" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <form:label path="student_pw">PASSWORD</form:label>
                            <form:password path="student_pw" class="form-control"/>
                        </div>
                        <div class="form-group">
                            <div class="text-right">
                                <form:button class="btn btn-primary">로그인</form:button>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>