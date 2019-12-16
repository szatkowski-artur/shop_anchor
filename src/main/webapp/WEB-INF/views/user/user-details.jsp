<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 13.12.2019
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
</head>
<body>
<header>
    <jsp:include page="../fragments/dashboard-header.jsp"/>
</header>

<section class="section">
    <div class="tabs">
        <ul>
            <li><a href="<c:url value="/user/details"/>">Personal data</a></li>
            <li><a href="<c:url value="/user/details/edit"/>">Edit personal data</a></li>
            <li><a href="<c:url value="/user/edit-password"/>">Change password</a></li>
        </ul>
    </div>
    <c:choose>
        <c:when test="${readonly==true}">
            <jsp:include page="user-details-plain.jsp"/>
        </c:when>
        <c:otherwise>
            <jsp:include page="user-details-edit.jsp"/>
        </c:otherwise>
    </c:choose>
</section>

<footer>
    <jsp:include page="../fragments/homepage-footer.jsp"/>
</footer>
</body>
</html>
