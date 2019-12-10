<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 09.12.2019
  Time: 23:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <meta name="viewport" content="width=device-width; initial-scale=1.0, maximum-scale=1.0"/>

    <%-- Linki do szablonów css trafią tutaj --%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">

    <%-- Linki do skryptów js trafią tutaj --%>
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body>
<div class="field is-small">
    <form:form method="post" modelAttribute="registrationDataDTO">
        <form:label path="username" cssClass="label">Username
            <form:input path="username" cssClass="input" placeholder="Username" type="text"/>
            <form:errors path="username"/></form:label>

        <form:label path="email" cssClass="label">Email
            <form:input path="email" cssClass="input" placeholder="Email" type="email"/>
            <form:errors path="email"/></form:label>

        <form:label path="password" cssClass="label">Password
            <form:password path="password" cssClass="input" placeholder="Password"/>
            <form:errors path="password"/></form:label>

        <form:label path="password" cssClass="label">Verify Password
            <form:password path="rePassword" cssClass="input" placeholder="verify password"/>
            <form:errors path="rePassword"/></form:label>
        <form:label path="termsAndConditions" cssClass="checkbox">
            <form:checkbox path="termsAndConditions"/>I agree to <a
                href="<c:out  value="/termsAndConditions" />">terms and conditions</a></form:label>
        <input type="submit" value="Send" class="button">
    </form:form>
</div>
</body>
</html>
