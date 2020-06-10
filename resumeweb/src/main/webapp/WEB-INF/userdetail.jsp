
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c-rt" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
<table class="table table-striped container" >
    <thead>
    <tr>
        <th scope="col" class="text-center" width="30%">#</th>
        <th scope="col" class="text-center" width="70%" >Details</th>

    </tr>
    </thead>
    <tbody>
    <tr scope="row"><td>Id</td>     <td>${userdet.id}</td></tr>
    <tr scope="row"><td>name</td>     <td>${userdet.name}</td></tr>
    <tr scope="row"><td>surname</td>     <td>${userdet.surname}</td></tr>
    <tr scope="row"><td>email</td>     <td>${userdet.email}</td></tr>
    <tr scope="row"><td>address</td>     <td>${userdet.address}</td></tr>
    <tr scope="row"><td>phone</td>     <td>${userdet.phone}</td></tr>
    <tr scope="row"><td>profileDesc</td>     <td>${userdet.profileDesc}</td></tr>

    <c:forEach items="${userdet.skills}" var="s">
    <tr scope="row"><td>skills</td>
            <td>${s.skill.name}
            ${s.power}</td>
    </c:forEach>
    </tr>



    </tbody>
</table>
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
