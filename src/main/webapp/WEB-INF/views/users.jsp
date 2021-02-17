<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="ISO-8859-1">
    <title>List Users</title>

</head>
<body>
<div class="container text-center">
    <div>
        <form action="logout" method="post">
            <p>
                Welcome <b></b>
            </p>
            <input type="submit" value="Sign Out" />
        </form>
    </div>
    <div>
        <h1>List of Users</h1>
    </div>

    <div>
        <table class="table table-striped table-bordered">
            <thead class="thead-dark">
            <tr>
                <th>User ID</th>
                <th>E-mail</th>
                <th>First Name</th>
                <th>Last Name</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listUsers}" var="listUsers">
            <tr>

                <td> <c:out value="${user.id}"/></td>
                <td> <c:out value="${user.email}"/></td>
                <td> <c:out value="${user.firstname}"/></td>
                <td> <c:out value="${user.lastname}"/></td>
            </tr>
            </tbody>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>