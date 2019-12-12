<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 11.12.2019
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your account</title>
    <jsp:include page="dashboard-header.jsp"></jsp:include>
</head>
<body>
<section class="section">
    <h3 class="tag is-info is-large">
        Your most recent products
        <a href="">
            <span> </span><i class="fas fa-redo"></i>
        </a>
    </h3>

    <table class="table is-bordered is-hoverable  is-striped">
        <thead>
        <tr>
            <th>N<sup>o</sup></th>
            <th>Name</th>
            <th>Available</th>
            <th>Link</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <c:forEach items="${products}" var="product" varStatus="i">
            <tr>
                <td>${i.count}</td>
                <td>${product.name}</td>
                <td>
                        <span class="icon">
                            <c:choose>
                                <c:when test="${product.available}">
                                    <i class="fas fa-check"></i>
                                </c:when>
                                <c:otherwise>
                                    <i class="fas fa-minus"></i>
                                </c:otherwise>
                            </c:choose>
                        </span>
                </td>
                <td>
                    <a href="<c:url value="${product.url}"/> " target="_blank">
                        <span class="icon"><i class="fas fa-globe"></i></span>
                    </a>
                </td>
                <td>
                    <a href="<c:url value="/product/all?productId=${product.id}&username=${username}"/>">
                        <span class="icon"><i class="fas fa-edit"></i></span>
                    </a>
                </td>
                <td>
                    <a href="<c:url value="/product/delete?id=${product.id}" />">
                        <span class="icon"><i class="fas fa-times"></i></span>
                    </a>
                </td>
            </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>
