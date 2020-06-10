<%--jstl tags--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--Spring tags--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--<script src="${pageContext.request.contextPath}../WEB-INF/assets/js/users.js"></script>--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <%--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">--%>
    <title>JSP Page</title>
</head>
<body>

<div class="container">
    <div class="col-6 my-2 container login_fix_">

        <f:form action="users" method="GET" modelAttribute="user">
            <div class="form-row">
            <div class="form-group col mb-2">
                <label for="name" class="sr-only">name </label>
                <f:input path="name"
                         class="form-control"
                         id="name"
                         placeholder="type name here"/>
                <form:errors path="name" cssClass="error"/>
            </div>


            <div class="form-group col mb-2">
                <label for="surname" class="sr-only">surname</label>
                <f:input path="surname"
                         class="form-control"
                         id="surname"
                         placeholder="type surname here"/>
                <form:errors path="surname" cssClass="error"/>
            </div>

            <div class="form-group mb-2">
                <f:button type="submit" class="btn btn-primary" value="Search">Search</f:button>
            </div>
            </div>
        </f:form>

    </div>


    <!--Table here -->
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col" class="text-center">name</th>
            <th scope="col" class="text-center">surname</th>
            <th scope="col" class="text-center">nationality</th>
            <th scope="col" class="text-center"></th>
            <th scope="col" class="text-center"></th>
            <th scope="col" class="text-center"></th>
        </tr>
        </thead>
        <tbody>
        <%--<%for (User list : lists) {%>--%>
        <c:forEach items="${users}" var="u">
            <tr>
                <td>${u.name}</td>
                <td>${u.surname}</td>
                <td>${u.nationality.name}</td>
                <td style="width:5px">

                    <input type="hidden" name="id" value="${u.id}"/>
                    <input type="hidden" name="action" value="delete"/>
                    <button class="btn btn-danger" type="submit" value="delete"
                            data-toggle="modal" data-target="#deleteModal"

                        onclick="idForDeleteModal(${u.id})">
                        Delete
                    </button>
                </td>
                <td style="width:5px">
                    <form action="userdetail" method="GET">
                        <input type="hidden" name="id" value="${u.id}"/>
                        <input type="hidden" name="action" value="update"/>
                        <button class="btn btn-secondary" type="submit" value="update">
                            info
                        </button>
                    </form>
                </td>
                </td>
                <td style="width:5px">
                    <form action="useredit" method="GET">
                        <input type="hidden" name="id" value="${u.id}"/>
                        <button class="btn btn-secondary" type="submit" value="update">
                            Edit
                        </button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>


<!--Delete Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" role="dialog" aria-labelledby="deleteModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="deleteModalLabel">Delete user</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Are you sure?
            </div>
            <div class="modal-footer">
                <form action="users" method="post">
                    <input type="hidden" name="ida" id="idForDeleteModal" value=""/>
                    <input type="hidden" name="action" value="delete"/>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-danger">Delete</button>
                </form>
            </div>

        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>

<script>
    function idForDeleteModal(id){
        var userId=id;
        document.getElementById("idForDeleteModal").value=userId;
    }
</script>
</body>
</html>
