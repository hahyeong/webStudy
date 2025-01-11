<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/>
<!DOCTYPE html>
<head>
    <title>SpringMVC</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery-3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>
<nav class="navbar bg-body-tertiary">
    <div class="container-fluid">
        <a href="${root}logout" class="btn btn-outline-success">로그아웃</a>
    </div>
</nav>

<div class="container">
    <div class="card-body">
        <h3 class="card-title text-center">강의목록</h3>
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th class="d-md-table-cell" width="10%">과목번호</th>
                <th class="d-md-table-cell" width="30%">과목명</th>
                <th class="d-md-table-cell" width="10%">학점</th>
                <th class="d-md-table-cell" width="10%">수강인원</th>
                <th class="d-md-table-cell" width="15%">강의요일</th>
                <th class="d-md-table-cell" width="15%">강의시간</th>
                <th class="d-md-table-cell" width="10%">수강신청</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="obj" items="${subjectBean}">
                <!-- 중복 체크를 위한 변수를 초기화 -->
                <c:set var="isDuplicate" value="false" />
                <c:forEach var="apply" items="${subject_apply}">
                    <!-- 중복된 항목이 있는지 체크 -->
                    <c:if test="${obj.subject_num == apply.subject_num}">
                        <c:set var="isDuplicate" value="true" />
                    </c:if>
                </c:forEach>
                <!-- 중복되지 않은 항목만 표시 -->
                <c:if test="${!isDuplicate}">

                    <tr>
                        <td class="d-md-table-cell">${obj.subject_num}</td>
                        <td class="d-md-table-cell">${obj.subject_name}</td>
                        <td class="d-md-table-cell">${obj.subject_point}</td>
                        <td class="d-md-table-cell">${obj.subject_cur_stu}/${obj.subject_max_stu}</td>
                        <td class="d-md-table-cell">${obj.subject_day}</td>
                        <td class="d-md-table-cell">${obj.subject_time}</td>
                        <td class="d-md-table-cell">
                            <c:choose>
                                <c:when test="${obj.subject_cur_stu < obj.subject_max_stu}">
                                    <a href="${root}apply_pro?subject_num=${obj.subject_num}" class="btn btn-primary">신청</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="${root}apply_pro?subject_num=${obj.subject_num}" class="btn btn-secondary disabled" aria-disabled="true" >신청</a>

                                </c:otherwise>
                            </c:choose>
                        </td>
                    </tr>

                </c:if>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

<div class="container">
    <div class="card-body">
        <h3 class="card-title text-center">내 강의목록</h3>
        <table class="table table-striped table-bordered">
            <thead>
            <tr>
                <th class="d-md-table-cell" width="10%">과목번호</th>
                <th class="d-md-table-cell" width="30%">과목명</th>
                <th class="d-md-table-cell" width="10%">학점</th>
                <th class="d-md-table-cell" width="10%">수강인원</th>
                <th class="d-md-table-cell" width="15%">강의요일</th>
                <th class="d-md-table-cell" width="15%">강의시간</th>
                <th class="d-md-table-cell" width="10%">수강신청</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="obj" items="${subject_apply}">
                <tr>
                    <td class="d-md-table-cell">${obj.subject_num}</td>
                    <td class="d-md-table-cell">${obj.subject_name}</td>
                    <td class="d-md-table-cell">${obj.subject_point}</td>
                    <td class="d-md-table-cell">${obj.subject_cur_stu}/${obj.subject_max_stu}</td>
                    <td class="d-md-table-cell">${obj.subject_day}</td>
                    <td class="d-md-table-cell">${obj.subject_time}</td>
                    <td class="d-md-table-cell">
                        <a href="#" class="btn btn-danger">취소</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
