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
    <meta name="viewport" content="width=device-width; initial-scale=1.0, maximum-scale=1.0"/>

    <%-- Linki do szablonów css trafią tutaj --%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">

    <%-- Linki do skryptów js trafią tutaj --%>
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body>
<div class="tag are-large">
    <h3 class="tag is-success is-large">Congratulations Your're almost done!</br>
        To finish registration You have to click on confirmation link we've send to your
        email(${registrationDataDTO.email})</br>
        See You soon!</h3>
</div>
</body>
</html>
