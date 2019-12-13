<%--
  Created by IntelliJ IDEA.
  User: artur
  Date: 10.12.2019
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Login</title>
    <jsp:include page="../fragments/homepage-header.jsp"/>
</head>
<body>
<section class="section">
    <div class="container">
        <div class="columns">
            <div class="column"></div>
            <div class="column">
                <form method="post" action="/login">
                    <div class="field">
                        <label class="label" for="username"><s:message code="global.username"/></label>
                        <div class="control has-icons-left">
                            <input type="text" id="username" name="username" required
                                   class="input"/>
                            <span class="icon is-small is-left">
                                <i class="fas fa-user"></i>
                            </span>
                            <p class="help"><s:message code="pages.login.form.help.username"/></p>
                        </div>
                    </div>
                    <div class="field">
                        <label class="label" for="password"><s:message code="global.password"/></label>
                        <div class="control has-icons-left">
                            <input type="password" id="password" name="password" required
                                   class="input"/>
                            <span class="icon is-small is-left">
                                <i class="fas fa-lock"></i>
                            </span>
                            <p class="help"><s:message code="pages.login.form.help.password"/></p>
                        </div>
                    </div>
                    <div class="field">
                        <div class="control">
                            <button class="button is-success is-link" type="submit"><s:message code="pages.login.form.submit"/></button>
                        </div>
                    </div>
                    <sec:csrfInput/>
                </form>
            </div>
            <div class="column"></div>
        </div>
    </div>
</section>
</body>
</html>
