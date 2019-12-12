<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
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
    <div class="column is-one-third is-offset-one-third">
        <div class="column is-one-third is-offset-one-third">
            <form action="/product/user/refresh" method="post">
                <input type="submit" class="button is-info" value="Refresh">
<%--                <input type="image" src="/images/redoButton.png" alt="submit"/>--%>
                <%--                TODO set redo icon as button--%>
                <s:csrfInput/>
            </form>
        </div>
        <table class="table is-bordered is-hoverable  is-striped">
            <thead>
            <tr>
                <th>N<sup>o</sup></th>
                <th>Name</th>
                <th>Available</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <c:forEach items="${products}" var="product" varStatus="i">
                <tr>
                <c:choose>
                    <c:when test="${product.id.equals(productId)}">
                        <form:form method="post" action="/product/update" cssClass="form" modelAttribute="editProduct">
                            <td>
                                    ${i.count}
                            </td>
                            <td>
                                <form:label path="name" cssClass="label" cssErrorClass="label is-danger">
                                    Name
                                    <form:input path="name" id="name" cssClass="input" cssErrorClass="input is-danger"/>
                                    <form:errors path="name" element="p" cssClass="help is-danger"/>
                                </form:label>
                            </td>
                            <td>
                                <form:label path="size" cssClass="label">
                                    Size
                                    <form:input path="size" cssClass="input"/>
                                </form:label>
                            </td>
                            <td>
                                <form:label path="url" cssClass="label" cssErrorClass="label is-danger">
                                    <%--                                    TODO add cancel button--%>URL
                                    <form:input path="url" cssClass="input" cssErrorClass="input is-danger" type="url"/>
                                    <form:errors path="url" element="p" cssClass="help is-danger"/>
                                </form:label>
                            </td>
                            <td>
                                <form:label path="shopId" cssClass="label" cssErrorClass="label is-danger">
                                    Shop
                                    <form:select path="shopId" items="${shops}" cssClass="select" itemLabel="name"
                                                 itemValue="id" cssErrorClass="select is-danger"/>
                                    <form:errors path="shopId" element="p" cssClass="help is-danger"/>
                                </form:label>
                                <form:hidden path="available" value="${editProduct.available}"/>
                                <form:hidden path="id" value="${productId}"/>
                                <form:hidden path="created" value="${editProduct.created}"/>
                                <input type="submit" class="button is-success" value="Send">
                            </td>
                            <s:csrfInput/>
                        </form:form>
                        </tr>
                    </c:when>
                    <c:otherwise>
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
                            <a href="<c:url value="/product/all?productId=${product.id}&username=${username}"/>">
                                <span class="icon"><i class="fas fa-edit"></i></span>
                            </a>
                        </td>
                        <td>
                            <a href="<c:url value="/product/delete?id=${product.id}" />">
                                <span class="icon"><i class="fas fa-times"></i></span>
                            </a>
                        </td>
                    </c:otherwise>
                </c:choose>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>
</body>
</html>
