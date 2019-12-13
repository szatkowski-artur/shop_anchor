<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 11.12.2019
  Time: 14:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<meta name="viewport" content="width=device-width; initial-scale=1.0, maximum-scale=1.0"/>
<link rel="stylesheet" href="/webjars/bulma/0.7.5/css/bulma.min.css">
<script defer src="webjars/font-awesome/5.10.1/js/fontawesome.min.js"></script>
<script src="https://kit.fontawesome.com/dccc7f3006.js" crossorigin="anonymous"></script>
<nav class="navbar" role="navigation" aria-label="main navigation">
    <div class="navbar-brand">
        <a class="navbar-item" href="/">
            <img src="https://bulma.io/images/bulma-logo.png" width="112" height="28">
            <%--            TODO change logo--%>
        </a>
    </div>
    <div class="navbar-menu">
        <div class="navbar-start">
            <a class="navbar-item" href="/user">
                Home
            </a>

            <a class="navbar-item" href="<c:url value="/product/add" />">
                Add product
            </a>

            <a class="navbar-item" href="<c:url value="/product/all" />">
                All products
            </a>

            <div class="navbar-item has-dropdown is-hoverable">
                <a class="navbar-link">
                    More
                </a>

                <div class="navbar-dropdown has-icons-left">
                    <a class="navbar-item" href="<c:url value="/user/details"/> ">
                        <span class="icon"><i class="fas fa-users-cog"></i></span>
                        <span> Account settings </span>
                    </a>
                    <a class="navbar-item" href="<c:url value=""/> ">
                        <span class="icon"><i class="far fa-envelope"></i></span>
                        <span>Contact us</span>
                    </a>
                    <hr class="navbar-divider">
                    <a class="navbar-item">
                        <span class="icon"><i class="fas fa-bug"></i></span>
                        <span>Report an issue</span>
                    </a>
                </div>
            </div>
        </div>

        <div class="navbar-end">
            <div class="navbar-item">
                <div class="buttons">
                    <%--                    TODO add proper username--%>
                    <form action="/logout" method="post">
                        <input type="button" value="Welcome <sec:authentication property="name"/>! " class="button is-success">
                        <input type="submit" value="Logout" class="button is-primary">
                        <s:csrfInput/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</nav>

