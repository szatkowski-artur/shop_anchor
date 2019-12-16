<%@ taglib prefix="c" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="ss" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 11.12.2019
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<head>--%>

<link rel="stylesheet" href="/webjars/bulma/0.7.5/css/bulma.min.css">
<script defer src="webjars/font-awesome/5.10.1/js/fontawesome.min.js"></script>
<script src="https://kit.fontawesome.com/dccc7f3006.js" crossorigin="anonymous"></script>
<nav class="navbar is-fixed-top" role="navigation" aria-label="main navigation">
    <div class="container">
        <div class="navbar-menu">
            <div class="navbar-start">
                <a class="navbar-item" href="/">
                    Homepage
                </a>
                <%-- Tutaj pozostałe linki, które chcemy mieć widoczne --%>

                <div class="navbar-item has-dropdown is-hoverable">
                    <a class="navbar-link">
                        More
                    </a>

                    <div class="navbar-dropdown">
                        <a class="navbar-item">
                            Link do niczego
                        </a>
                        <%-- Tutaj kolejne linki w menu dodatkowym --%>
                    </div>
                </div>
            </div>

            <div class="navbar=end">
                <div class="navbar-item">
                    <div class="buttons">
                        <form method="get" action="/register">
                            <input type="submit" class="button is-primary" value="Register">
                            <c:csrfInput/>
                        </form>
                        <form method="get" action="/login">
                            <input type="submit" class="button is-success" value="Login" >
<%--                            <input type="submit" class="button is-success" value="Login">--%>
                            <c:csrfInput/>
                        </form>
                        <form method="get" action="/user">
                            <input type="submit" class="button is-primary" value="Your account">
                            <c:csrfInput/>
                        </form>
                        <form method="post" action="/logout">
                            <button class="button is-link" type="submit">Logout</button>
                            <c:csrfInput/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</nav>

<%--</head>--%>

