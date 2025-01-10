<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
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
        <a href="#" class="btn btn-outline-success">로그아웃</a>
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
                <tr>
                    <td class="d-md-table-cell">${obj.subject_num}</td>
                    <td class="d-md-table-cell">${obj.subject_name}</td>
                    <td class="d-md-table-cell">${obj.subject_point}</td>
                    <td class="d-md-table-cell">${obj.subject_cur_stu}/${obj.subject_max_stu}</td>
                    <td class="d-md-table-cell">${obj.subject_day}</td>
                    <td class="d-md-table-cell">${obj.subject_time}</td>
                    <td class="d-md-table-cell">
                        <a href="#" class="btn btn-secondary">신청</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <!--페이징-->
<%--        <div class="d-none d-md-block">--%>
<%--            <ul class="pagination justify-content-center">--%>
<%--                <c:choose>--%>
<%--                    <c:when test="${pBean.prePage <= 0}">--%>
<%--                        <li class="page-item disabled"><a href="#" class="page-link">이전</a></li>--%>
<%--                    </c:when>--%>
<%--                    <c:otherwise>--%>
<%--                        <li class="page-item">--%>
<%--                            <a href="${root}board/main?board_info_idx=${board_info_idx}&page=${pBean.prePage}" class="page-link">이전</a>--%>
<%--                        </li>--%>
<%--                    </c:otherwise>--%>
<%--                </c:choose>--%>

<%--                <c:forEach var='idx' begin="${pBean.min}" end='${pBean.max}'>--%>
<%--                    <c:choose>--%>
<%--                        <c:when test="${idx == pBean.currentPage}">--%>
<%--                            <li class="page-item active">--%>
<%--                                <a href="${root}board/main?board_info_idx=${board_info_idx}&page=${idx}" class="page-link">${idx}</a>--%>
<%--                            </li>--%>
<%--                        </c:when>--%>
<%--                        <c:otherwise>--%>
<%--                            <li class="page-item"><a--%>
<%--                                    href="${root}board/main?board_info_idx=${board_info_idx}&page=${idx}"--%>
<%--                                    class="page-link">${idx}</a></li>--%>
<%--                        </c:otherwise>--%>
<%--                    </c:choose>--%>
<%--                </c:forEach>--%>

<%--                <c:choose>--%>
<%--                    <c:when test="${pBean.max >= pBean.pageCnt}">--%>
<%--                        <li class="page-item disabled"><a href="#" class="page-link">다음</a></li>--%>
<%--                    </c:when>--%>
<%--                    <c:otherwise>--%>
<%--                        <li class="page-item">--%>
<%--                            <a href="${root}board/main?board_info_idx=${board_info_idx}&page=${pBean.nextPage}" class="page-link">다음</a>--%>
<%--                        </li>--%>
<%--                    </c:otherwise>--%>
<%--                </c:choose>--%>
<%--            </ul>--%>
<%--        </div>--%>

    </div>
</div>

<div class="container">
    <div class="card-body">
        <h3 class="card-title text-center">내 강의목록</h3>
        <table class="table table-hover">
            <thead>
            <tr>
                <th class="d-md-table-cell">과목번호</th>
                <th class="d-md-table-cell">과목명</th>
                <th class="d-md-table-cell">학점</th>
                <th class="d-md-table-cell">수강인원</th>
                <th class="d-md-table-cell">강의요일</th>
                <th class="d-md-table-cell">강의시간</th>
                <th class="d-md-table-cell">수강신청</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="obj" items="${allSubjectByUserIdBean}">
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