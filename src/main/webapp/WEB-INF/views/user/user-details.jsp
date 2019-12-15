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
                <form:hidden path="id" value="${userData.id}"/>
                <div class="control">
                    <form:label path="username" cssClass="label" cssErrorClass="label is-danger">
                        Username
                        <form:input path="username" cssClass="input" cssErrorClass="input is-danger"
                                    readonly="true"
                        />
                        <form:errors path="username" cssClass="help is-danger"/>
                    </form:label>
                </div>
                <div class="control">
                    <form:label path="email" cssClass="label" cssErrorClass="label is-danger">
                        Email
                        <form:input path="email" cssClass="input" cssErrorClass="input is-danger" readonly="true"
                        />
                        <form:errors path="email" cssClass="help is-danger"/>
                    </form:label>
                </div>
                <div class="control">
                    <form:label path="detailsFirstName" cssClass="label" cssErrorClass="label is-danger">
                        First Name
                        <form:input path="detailsFirstName" cssClass="input" cssErrorClass="input is-danger"
                                    readonly="${readonly}"
                        />
                        <form:errors path="detailsFirstName" cssClass="help is-danger"/>
                    </form:label>
                </div>
                <div class="control">
                    <form:label path="detailsLastName" cssClass="label" cssErrorClass="label is-danger">
                        Last Name
                        <form:input path="detailsLastName" cssClass="input" cssErrorClass="input is-danger"
                                    readonly="${readonly}"
                        />
                        <form:errors path="detailsLastName" cssClass="help is-danger"/>
                    </form:label>
                </div>
                <div class="control">
                    <form:label path="detailsBirthday" cssClass="label" cssErrorClass="label is-danger">
                        Birthday
                        <form:input type="date" path="detailsBirthday" cssClass="input" cssErrorClass="input is-danger"
                                    readonly="${readonly}"
                        />
                        <form:errors path="detailsBirthday" cssClass="help is-danger"/>
                    </form:label>
                </div>
                <c:choose>
                    <c:when test="${readonly == true}">
                        <div class="control">
                            <form:label path="detailsGender" cssClass="label" cssErrorClass="label is-danger">
                                Gender
                                <form:input path="detailsGender" cssClass="input" cssErrorClass="input is-danger"
                                            readonly="${readonly}"
                                />
                                <form:errors path="detailsGender" cssClass="help is-danger"/>
                            </form:label>
                        </div>
                        <div class="control">
                            <form:label path="detailsCountry" cssClass="label" cssErrorClass="label is-danger">
                                Country
                                <form:input path="detailsCountry" cssClass="input" cssErrorClass="input is-danger"
                                            readonly="${readonly}"
                                />
                                <form:errors path="detailsCountry" cssClass="help is-danger"/>
                            </form:label>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="control">
                            <form:label path="detailsGender" cssClass="label" cssErrorClass="label is-danger">
                                Gender
                                <form:select path="detailsGender" items="${genders}" cssClass="select" cssErrorClass="select is-danger"
                                             readonly="${readonly}"/>
                                <form:errors path="detailsGender"/>
                            </form:label>
                        </div>
                        <div class="control">
                            <form:label path="detailsCountry" cssClass="label" cssErrorClass="label is-danger">
                                Country
                                <form:select path="detailsCountry" items="${countries}" cssClass="select" readonly="${readonly}"
                                             cssErrorClass="select is-danger"/>
                                <form:errors path="detailsCountry" cssClass="help is-danger"/>
                            </form:label>
                        </div>
                    </c:otherwise>
                </c:choose>
                <div class="control">
                    <form:label path="detailsCity" cssClass="label" cssErrorClass="label is-danger">
                        City
                        <form:input path="detailsCity" cssClass="input" cssErrorClass="input is-danger"
                                    readonly="${readonly}"/>
                        <form:errors path="detailsCity" cssClass="help is-danger"/>
                    </form:label>
                </div>
                <div class="control">
                    <form:label path="detailsPostalCode" cssClass="label" cssErrorClass="label is-danger">
                        Postal code
                        <form:input path="detailsPostalCode" type="number" size="5" cssClass="input" readonly="${readonly}"
                                    cssErrorClass="input is-danger"/>
                        <form:errors path="detailsPostalCode" cssClass="help is-danger"/>
                    </form:label>
                </div>
                <div class="control">
                    <form:label path="detailsStreetName" cssClass="label" cssErrorClass="label is-danger">
                        Street name
                        <form:input path="detailsStreetName" cssClass="input" cssErrorClass="input is-danger"
                                    readonly="${readonly}"
                        />
                        <form:errors path="detailsStreetName" cssClass="help is-danger"/>
                    </form:label>
                </div>
                <div class="control">
                    <form:label path="detailsStreetNumber" cssClass="label" cssErrorClass="label is-danger">
                        Street number
                        <form:input path="detailsStreetNumber" cssClass="input" cssErrorClass="input is-danger"
                                    readonly="${readonly}"
                        />
                        <form:errors path="detailsStreetNumber" cssClass="help is-danger"/>
                    </form:label>
                </div>
                <div class="control">
                    <form:label path="detailsFlatNumber" cssClass="label" cssErrorClass="label is-danger">
                        Flat number
                        <form:input path="detailsFlatNumber" cssClass="input" cssErrorClass="input is-danger"
                                    readonly="${readonly}"
                        />
                        <form:errors path="detailsFlatNumber" cssClass="help is-danger"/>
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
