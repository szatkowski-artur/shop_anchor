<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
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
   <jsp:include page="../fragments/homepage-header.jsp"/>
</head>
<body>
<section class="section">
    <div class="container">
        <div class="column is-offset-one-third is-one-third">
            <form:form method="post" modelAttribute="registrationDataDTO">
                <form:label path="username" cssClass="label">Username
                    <form:input path="username" cssClass="input" placeholder="Username" type="text"/>
                    <form:errors path="username" element="p" cssClass="help is-danger"/></form:label>

                <form:label path="email" cssClass="label">Email
                    <form:input path="email" cssClass="input" placeholder="Email" type="email"/>
                    <form:errors path="email" element="p" cssClass="help is-danger"/></form:label>

                <form:label path="password" cssClass="label">Password
                    <form:password path="password" cssClass="input" placeholder="Password"/>
                    <form:errors path="password" element="p" cssClass="help is-danger"/></form:label>

                <form:label path="password" cssClass="label">Verify Password
                    <form:password path="rePassword" cssClass="input" placeholder="verify password"/>
                    <form:errors path="" element="p" cssClass="help is-danger"/></form:label>

                <form:label path="termsAndConditions" cssClass="checkbox">
                    <form:checkbox path="termsAndConditions"/>I agree to <a
                        href="<c:url  value="/termsAndConditions" />">terms and conditions</a>
                    <form:errors path="termsAndConditions" element="p" cssClass="help is-danger"/>
                </form:label>
                <input type="submit" value="Send" class="button is-small">
                <s:csrfInput/>
            </form:form>

        </div>
    </div>
</section>
<footer>
    <jsp:include page="../fragments/homepage-footer.jsp"/>
</footer>

</body>
</html>
