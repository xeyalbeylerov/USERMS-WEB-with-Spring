<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <title>JSP Page</title>
</head>
<body>
<%@include file="../WEB-INF/header.jsp" %>

<div class="col-8 my-5 container login_fix_">
    <f:form action="useredit" method="POST" modelAttribute="usered" enctype="utf8">
            <f:hidden  path="id"/>

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
            <label for="phone" class="sr-only">phone</label>
            <f:input  type="tel" path="phone"
                     class="form-control"
                     id="phone"
                     placeholder="type phone here"/>
            <f:errors path="phone" cssClass="error"/>
        </div>
        <div class="form-group mx-sm-3 mb-2">
            <label for="surname" class="sr-only">profileDesc</label>
            <f:textarea path="profileDesc"
                     class="form-control"
                     id="profileDesc"
                     placeholder="type profileDesc here"/>
            <f:errors path="profileDesc" cssClass="error"/>
        </div>

        <div class="form-group mx-sm-3 mb-2">
            <label for="birthDate" class="sr-only">birthDate</label>
            <f:input type="date" path="birthDate"
                        class="form-control"
                        id="birthDate"
                        placeholder="type birthDate here"/>
            <f:errors path="birthDate" cssClass="error"/>
        </div>

        <div class="form-group mx-sm-3 mb-2">
            <label for="address" class="sr-only">address</label>
            <f:input path="address"
                     class="form-control"
                     id="address"
                     placeholder="type address here"/>
            <f:errors path="address" cssClass="error"/>
        </div>

        <%--<div class="form-group mx-sm-3 mb-2">--%>
        <%--<label for="birthDate" class="sr-only">birthDate</label>--%>
        <%--<f:input type="date" path="birthDate"--%>
        <%--class="form-control"--%>
        <%--id="birthDate"--%>
        <%--placeholder="type birthDate here"/>--%>
        <%--<f:errors path="birthDate" cssClass="error"/>--%>
        <%--</div>--%>


        <div class="form-group mb-2">
            <f:button type="submit" class="btn btn-primary" value="update">Update</f:button>
        </div>


    </f:form>

</div>
</div>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
        integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>
