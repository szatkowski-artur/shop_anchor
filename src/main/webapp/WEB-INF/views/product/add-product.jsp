<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 11.12.2019
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add product</title>
    <jsp:include page="../fragments/dashboard-header.jsp"/>
</head>
<body>
<section class="section">
    <div class="column is-offset-one-third is-one-third">
        <form:form method="post" modelAttribute="product" cssClass="form">
            <form:label path="name" cssClass="label" cssErrorClass="label is-danger">
                Name
                <form:input path="name" id="name" cssClass="input" cssErrorClass="input is-danger"/>
                <form:errors path="name" element="p" cssClass="help is-danger"/>
            </form:label>
            <form:label path="size" cssClass="label">
                Size
                <form:input path="size" cssClass="input"/>
                <form:errors path="size" cssClass="help is-danger"/>
            </form:label>
            <form:label path="url" cssClass="label" cssErrorClass="label is-danger">
                URL
                <form:input path="url" cssClass="input" cssErrorClass="input is-danger"/>
                <form:errors path="url" element="p" cssClass="help is-danger"/>
            </form:label>
            <form:hidden path="available" value="${false}"/>
            <input type="submit" class="button is-success" value="Send">
            <s:csrfInput/>
        </form:form>
    </div>
</section>
<footer>
    <jsp:include page="../fragments/homepage-footer.jsp"/>
</footer>
</body>
</html>
