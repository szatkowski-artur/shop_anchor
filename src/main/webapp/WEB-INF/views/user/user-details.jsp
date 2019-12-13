<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 13.12.2019
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Details</title>
</head>
<body>
<header>
    <jsp:include page="../fragments/dashboard-header.jsp"/>
</header>

<section class="section">
    <div class="tabs">
        <ul>
            <li><a href="<c:url value="/user/details"/>">Personal data</a></li>
            <li><a href="<c:url value="/user/details/edit"/>">Edit personal data</a></li>
            <li><a href="<c:url value="/user/edit-password"/>">Edit password</a></li>
        </ul>
    </div>
    <div class="column is-one-third is-offset-one-third">
        <div class="box">
            <form:form method="post" modelAttribute="userData">
                <div class="control">
                    <form:label path="username" cssClass="label" cssErrorClass="label is-danger">
                        Username
                        <form:input path="username" cssClass="input" cssErrorClass="input is-danger"
                                    readonly="${readonly}"
                        />
                        <form:errors path="username" cssClass="help is-danger"/>
                    </form:label>
                </div>
                <div class="control">
                    <form:label path="email" cssClass="label" cssErrorClass="label is-danger">
                        Email
                        <form:input path="email" cssClass="input" cssErrorClass="input is-danger" readonly="${readonly}"
                        />
                        <form:errors path="email" cssClass="help is-danger"/>
                    </form:label>
                </div>
                <div class="control">
                    <form:label path="firstName" cssClass="label" cssErrorClass="label is-danger">
                        First Name
                        <form:input path="firstName" cssClass="input" cssErrorClass="input is-danger"
                                    readonly="${readonly}"
                        />
                        <form:errors path="firstName" cssClass="help is-danger"/>
                    </form:label>
                </div>
                <div class="control">
                    <form:label path="lastName" cssClass="label" cssErrorClass="label is-danger">
                        Last Name
                        <form:input path="lastName" cssClass="input" cssErrorClass="input is-danger"
                                    readonly="${readonly}"
                        />
                        <form:errors path="lastName" cssClass="help is-danger"/>
                    </form:label>
                </div>
                <div class="control">
                    <form:label path="birthday" cssClass="label" cssErrorClass="label is-danger">
                        Birthday
                        <form:input type="date" path="birthday" cssClass="input" cssErrorClass="input is-danger"
                                    readonly="${readonly}"
                        />
                        <form:errors path="birthday" cssClass="help is-danger"/>
                    </form:label>
                </div>
                <c:choose>
                    <c:when test="${readonly == true}">
                        <div class="control">
                            <form:label path="gender" cssClass="label" cssErrorClass="label is-danger">
                                Gender
                                <form:input path="gender" cssClass="input" cssErrorClass="input is-danger"
                                            readonly="${readonly}"
                                />
                                <form:errors path="gender" cssClass="help is-danger"/>
                            </form:label>
                        </div>
                        <div class="control">
                            <form:label path="country" cssClass="label" cssErrorClass="label is-danger">
                                Country
                                <form:input path="country" cssClass="input" cssErrorClass="input is-danger"
                                            readonly="${readonly}"
                                />
                                <form:errors path="country" cssClass="help is-danger"/>
                            </form:label>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="control">
                            <form:label path="gender" cssClass="label" cssErrorClass="label is-danger">
                                Gender
                                <form:select path="gender" items="${genders}" cssClass="select" cssErrorClass="select is-danger"
                                             readonly="${readonly}"/>
                                <form:errors path="gender"/>
                            </form:label>
                        </div>
                        <div class="control">
                            <form:label path="country" cssClass="label" cssErrorClass="label is-danger">
                                Country
                                <form:select path="country" items="${countries}" cssClass="select" readonly="${readonly}"
                                             cssErrorClass="select is-danger"/>
                                <form:errors path="country" cssClass="help is-danger"/>
                            </form:label>
                        </div>
                    </c:otherwise>
                </c:choose>
                <div class="control">
                    <form:label path="city" cssClass="label" cssErrorClass="label is-danger">
                        City
                        <form:input path="city" cssClass="input" cssErrorClass="input is-danger"
                                    readonly="${readonly}"/>
                        <form:errors path="city" cssClass="help is-danger"/>
                    </form:label>
                </div>
                <div class="control">
                    <form:label path="postalCode" cssClass="label" cssErrorClass="label is-danger">
                        Postal code
                        <form:input path="postalCode" type="number" size="5" cssClass="input" readonly="${readonly}"
                                    cssErrorClass="input is-danger"/>
                        <form:errors path="postalCode" cssClass="help is-danger"/>
                    </form:label>
                </div>
                <div class="control">
                    <form:label path="streetName" cssClass="label" cssErrorClass="label is-danger">
                        Street name
                        <form:input path="streetName" cssClass="input" cssErrorClass="input is-danger"
                                    readonly="${readonly}"
                        />
                        <form:errors path="streetName" cssClass="help is-danger"/>
                    </form:label>
                </div>
                <div class="control">
                    <form:label path="streetNumber" cssClass="label" cssErrorClass="label is-danger">
                        Street number
                        <form:input path="streetNumber" cssClass="input" cssErrorClass="input is-danger"
                                    readonly="${readonly}"
                        />
                        <form:errors path="streetNumber" cssClass="help is-danger"/>
                    </form:label>
                </div>
                <div class="control">
                    <form:label path="flatNumber" cssClass="label" cssErrorClass="label is-danger">
                        Flat number
                        <form:input path="flatNumber" cssClass="input" cssErrorClass="input is-danger"
                                    readonly="${readonly}"
                        />
                        <form:errors path="flatNumber" cssClass="help is-danger"/>
                    </form:label>
                </div>
                <div class="control">
                    <c:choose>
                        <c:when test="${readonly == false}">
                            <input type="submit" class="button is-success" value="Send">
                        </c:when>
                    </c:choose>
                </div>
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
