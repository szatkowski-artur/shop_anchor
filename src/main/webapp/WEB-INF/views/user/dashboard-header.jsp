<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

            <a class="navbar-item" href="<c:url value="/product/add?username=${username}" />">
                Add product
            </a>

            <a class="navbar-item" href="<c:url value="/product/all?username=${username}" />">
                All products
            </a>

            <div class="navbar-item has-dropdown is-hoverable">
                <a class="navbar-link">
                    More
                </a>

                <div class="navbar-dropdown">
                    <a class="navbar-item" href="/register/details">
                        Your account details
                    </a>
                    <a class="navbar-item">
                        Change password
                    </a>
                    <a class="navbar-item">
                        Contact
                    </a>
                    <hr class="navbar-divider">
                    <a class="navbar-item">
                        Report an issue
                    </a>
                </div>
            </div>
        </div>

        <div class="navbar-end">
            <div class="navbar-item">
                <div class="buttons">
                    <a class="button is-success">Welcome <strong>&nbsp;${username}</strong>!</a>
                    <a class="button is-primary" href="/logout">
                        <strong>Log out</strong>
                    </a>
                </div>
            </div>
        </div>
    </div>
</nav>

