<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 10.12.2019
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <jsp:include page="../fragments/homepage-header.jsp"/>
</head>
<body>
<section class="hero is-success is-bold is-medium">
    <div class="container has-text-white">
        <h1><strong>
            Congratulations Your're almost done!</br>
            To finish registration You have to click on confirmation link we've send to your
            email(${registrationDataDTO.email})</br>
            See You soon!
        </strong></h1>
    </div>
</section>
<footer>
    <jsp:include page="../fragments/homepage-footer.jsp"/>
</footer>
</body>
</html>
