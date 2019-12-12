<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 12.12.2019
  Time: 13:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Product</title>
</head>
<body>
<section class="hero is-fullheight is-light is-bold">
    <div class="hero-head">
        <jsp:include page="dashboard-header.jsp"/>
        <span>
            <br>
            <br>
            <br>
        </span>
        <div class="hero is-large is-warning is-bold">
            <div class="column">
                <div class="tags has-addons">
                    <span class="tag is-warning is-large">Are you sure you want to delete ${product.name}?</span>
                    <form method="post">
                        <input type="submit" value="Delete" class="tag is-danger is-large">
                        <s:csrfInput/>
                    </form>
                    <form action="/product/all" method="get">
                        <input type="submit" value="Cancel" class="tag is-success is-large" >
                        <s:csrfInput/>
                    </form>
<%--                    <span class="tag is-danger is-large is-bold">--%>
<%--                        <a class="has-text-white" href="/product/deleteProcess">Delete</a>--%>
<%--                    </span>--%>
                </div>
            </div>
        </div>
    </div>
</section>
</body>
</html>
