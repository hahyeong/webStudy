<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<c:set var="root" value="${pageContext.request.contextPath}/"/>
<html>
<head>
</head>
<body>

<form action="delete_pro" method="post">
    <input type="hidden" name="subject_num" value="${subject_num}">
    <input type="hidden" name="student_num" value="${student_num}">
    <table>
        <thead>
        <tr>
            <th>과목번호</th>
            <th>과목명</th>
            <th>학점</th>
            <th>수강인원</th>
            <th>강의요일</th>
            <th>강의시간</th>
            <th>수강신청</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="li" items="${subject_apply}">
            <tr>
                <td>${li.subject_num}</td>
                <td>${li.subject_name}</td>
                <td>${li.subject_point}</td>
                <td>${li.subject_cur_stu}/${li.subject_max_stu}</td>
                <td>${li.subject_day}</td>
                <td>${li.subject_time}</td>
                <td><button type="submit">취소</button></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</form>

</body>
</html>