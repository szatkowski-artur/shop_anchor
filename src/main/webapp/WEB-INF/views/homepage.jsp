<%@ taglib prefix="c" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 09.12.2019
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Shop Anchor</title>
    <%-- Elementy dotyczące treści strony --%>


    <%-- Elementy dotyczące wyświetlania --%>
    <meta name="viewport" content="width=device-width; initial-scale=1.0, maximum-scale=1.0"/>

    <%-- Linki do szablonów css trafią tutaj --%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">

    <%-- Linki do skryptów js trafią tutaj --%>
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body class="has-navbar-fixed-top">
<header>
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
                            <a class="button is-primary" href="/register">
                                <strong>Register</strong>
                            </a>
                            <a class="button is-success" href="/login">
                                <strong>Login</strong>
                            </a>
                            <a class="button is-primary" href="/user">
                                <strong>Your Account</strong>
                            </a>
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
</header>
<section class="hero is-bold is-medium">
    <div class="container">
        <div class="hero-body">
            <h1 class="title">
                Shop Anchor
            </h1>
            <h2 class="subtitle">
                Welcome to  <strong>Shop Anchor!</strong>.
                <br/>Here I will write my description
<%--                TODO add description--%>
            </h2>

        </div>
    </div>
</section>
<footer class="footer">
    <div class="container">
        <div class="content has-text-centered">
            <p><strong>Shop Anchor</strong> by Artur Szatkowski &copy; Prawa licencyjne na
                zasadzie praw ogólnych</p>
        </div>
    </div>
</footer>
</body>
</html>
