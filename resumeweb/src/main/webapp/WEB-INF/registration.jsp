<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: xeyal
  Date: 08.06.2020
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>Registration</title>
</head>
<html>
<body>
<%@include file="../WEB-INF/header.jsp" %>

<div class="col-8 my-5 container login_fix_">
    ${message}
    <f:form action="registration" method="POST" modelAttribute="userRegistration" enctype="utf8">
    <div class="form-group mx-sm-3 mb-2">
        <label for="name" class="sr-only">name </label>
        <f:input path="name"
                 class="form-control"
                 id="name"
                 placeholder="type name here"/>
        <f:errors path="name" cssClass="error"/>
    </div>
    <div class="form-group mx-sm-3 mb-2">
        <label for="surname" class="sr-only">surname</label>
        <f:input path="surname"
                 class="form-control"
                 id="surname"
                 placeholder="type surname here"/>
        <f:errors path="surname" cssClass="error"/>
    </div>
    <div class="form-group mx-sm-3 mb-2">
        <label for="email" class="sr-only">email</label>
        <f:input path="email"
                 class="form-control"
                 id="email"
                 placeholder="type email here"/>
        <f:errors path="email" cssClass="error"/>
    </div>
    <div class="form-group mx-sm-3 mb-2">
        <label for="password" class="sr-only">password</label>
        <f:password path="password"
                    class="form-control"
                    id="password"
                    placeholder="type password here"/>
        <f:errors path="password" cssClass="error"/>
    </div>
        <div class="form-group mx-sm-3 mb-2">
            <label for="password" class="sr-only">password</label>
            <f:password path="matchingPassword"
                        class="form-control"
                        id="password"
                        placeholder="type password here"/>
            <f:errors path="password" cssClass="error"/>
        </div>


    <div class="form-group mx-sm-3 mb-2">
        <f:button type="submit" class="btn btn-primary">Register</f:button>
    </div>
</div>
</f:form>
</body>
</html>
