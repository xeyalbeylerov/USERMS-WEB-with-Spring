<%--
  Created by IntelliJ IDEA.
  User: xeyal
  Date: 13.03.2020
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body class="login_background">

<form action="logout" method="POST">
    <%--action='<spring:url value="/login"/>'--%>
    <div class="col-4 container login_fix_">

            <h1 style="text-align: center">Logout:</h1>


        <button type="submit" class="btn btn-primary" >Logout</button>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </div>
</form>

</body>
</html>
