<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 11.12.2019
  Time: 18:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Your Products</title>
    <jsp:include page="dashboard-header.jsp"/>
</head>
<body>
<section class="section">
    <div class="column is-three-fifths is-offset-one-third">
        <table class="table is-bordered is-hoverable  is-striped">
            <thead>
            <tr>
                <th>N<sup>o</sup> </th>
                <th>Name</th>
                <th>Available</th>
                <th>Refresh</th>
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
                                    <i class="fas fa-times"></i>
                                </c:otherwise>
                            </c:choose>
                        </span>
                    </td>
                    <td>
                        <a href="<c:url value=""/>">
                                <%--                            TODO dodać link do odświeżania--%>
                            <span class="icon"><i class="fas fa-redo"></i></span>
                        </a>
                    </td>
                    <td>
                        <a href="<c:url value="/product/delete?id=${product.id}" />">
                            <span class="icon"><i class="fas fa-minus"></i></span>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>
</body>
</html>