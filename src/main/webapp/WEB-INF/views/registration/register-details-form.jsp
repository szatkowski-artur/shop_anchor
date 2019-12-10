<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 10.12.2019
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register details</title>
    <meta name="viewport" content="width=device-width; initial-scale=1.0, maximum-scale=1.0"/>

    <%-- Linki do szablonów css trafią tutaj --%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.8.0/css/bulma.min.css">

    <%-- Linki do skryptów js trafią tutaj --%>
    <script defer src="https://use.fontawesome.com/releases/v5.3.1/js/all.js"></script>
</head>
<body>
<div class="field is-small">
    <form:form method="post" modelAttribute="userDetailsDTO">
        <div class="control">
            <form:label path="firstName" cssClass="label" cssErrorClass="label is-danger">
                First Name
                <form:input path="firstName" cssClass="input" cssErrorClass="input is-danger" placeholder="First name"/>
                <form:errors path="firstName" cssClass="help is-danger"/>
            </form:label>
        </div>
        <div class="control">
            <form:label path="lastName" cssClass="label" cssErrorClass="label is-danger">
                Last Name
                <form:input path="lastName" cssClass="input" cssErrorClass="input is-danger" placeholder="Last name"/>
                <form:errors path="lastName" cssClass="help is-danger"/>
            </form:label>
        </div>
        <div class="control">
            <form:label path="birthday" cssClass="label" cssErrorClass="label is-danger">
                Birthday
                <form:input type="date" path="birthday" cssClass="input" cssErrorClass="input is-danger" placeholder="yyyy/mm/dd"/>
                <form:errors path="birthday" cssClass="help is-danger"/>
            </form:label>
        </div>
        <div class="control">
            <form:label path="gender" cssClass="label" cssErrorClass="label is-danger">
                Gender
                <form:select path="gender" items="${genders}" cssClass="select" cssErrorClass="select is-danger"/>
                <form:errors path="gender" cssClass="help is-danger"/>
            </form:label>
        </div>
        <div class="control">
            <form:label path="country" cssClass="label" cssErrorClass="label is-danger">
                Country
                <form:select path="country" items="${countries}" cssClass="select" cssErrorClass="select is-danger"/>
                <form:errors path="country" cssClass="help is-danger"/>
            </form:label>
        </div>
        <div class="control">
            <form:label path="city" cssClass="label" cssErrorClass="label is-danger">
                City
                <form:input path="city" cssClass="input" cssErrorClass="input is-danger" placeholder="City"/>
                <form:errors path="city" cssClass="help is-danger"/>
            </form:label>
        </div>
        <div class="control">
            <form:label path="postalCode" cssClass="label" cssErrorClass="label is-danger">
                Postal code
                <form:input path="postalCode" type="number" size="5" cssClass="input" cssErrorClass="input is-danger" placeholder="e.g. 50500"/>
                <form:errors path="postalCode" cssClass="help is-danger"/>
            </form:label>
        </div>
        <div class="control">
            <form:label path="streetName" cssClass="label" cssErrorClass="label is-danger">
                Street name
                <form:input path="streetName" cssClass="input" cssErrorClass="input is-danger" placeholder="Street name"/>
                <form:errors path="streetName" cssClass="help is-danger"/>
            </form:label>
        </div>
        <div class="control">
            <form:label path="streetNumber" cssClass="label" cssErrorClass="label is-danger">
                Street number
                <form:input path="streetNumber" cssClass="input" cssErrorClass="input is-danger" placeholder="Street number"/>
                <form:errors path="streetNumber" cssClass="help is-danger"/>
            </form:label>
        </div>
        <div class="control">
            <form:label path="flatNumber" cssClass="label" cssErrorClass="label is-danger">
                Flat number
                <form:input path="flatNumber" cssClass="input" cssErrorClass="input is-danger" placeholder="Flat Number"/>
                <form:errors path="flatNumber" cssClass="help is-danger"/>
            </form:label>
        </div>
        <div class="control">
            <input type="submit" class="button" value="Send">
        </div>
        <form:hidden path="owner" value="${owner}"/>
    </form:form>
</div>
</body>
</html>
