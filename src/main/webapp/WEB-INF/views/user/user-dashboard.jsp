<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 11.12.2019
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your account</title>
    <jsp:include page="dashboard-header.jsp"></jsp:include>
</head>
<body>
<section class="section">
    <h3 class="tag is-info is-large">Your most recent products</h3>
    <table class="table is-hoverable">
        <thead>
        <tr>
            <th>Product name</th>
            <th>Available</th>
            <th>Refresh</th>
            <th>Delete</th>
        </tr>
        </thead>
    </table>
</section>
</body>
</html>
