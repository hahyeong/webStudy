<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<c:set var="root" value="${pageContext.request.contextPath }/" />

<script>
    alert("로그인 해야합니다")
    location.href='${root}login'
</script>