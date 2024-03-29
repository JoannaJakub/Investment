<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en"><%@ include file="../../head.jsp" %>

<body>
<%@ include file="../adminHeader.jsp" %>
<div class="d-flex align-items-stretch">
    <%@ include file="../adminSideMenu.jsp" %>

    <div class="page-content">
        <div class="page-header">
            <div class="list-inline-item">
                <h2 class="h4 d-none d-sm-inline">Admin Dashboard</h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/adminRegister"/>">Add user</a></h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/usersAdminRole/2"/>">Admin role</a></h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="usersUserRole/1"/>">User role</a></h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/adminUsers/export/excel"/>">Export to Excel</a></h2>
            </div>
        </div>

        <section class="no-padding-top">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-6">

                    </div>
                </div>

                <div class="col-lg-20">
                    <div class="block">
                        <div class="title"><strong>Users</strong></div>
                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Surname</th>
                                    <th>Username</th>
                                    <th>Enabled</th>
                                    <th>Role</th>
                                    <th>Delete</th>
                                    <th>Edit</th>
                                    <th>Details</th>
                                    <th>Change role</th>
                                    <th>User's investment</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${user}" var="user">
                                    <tr>
                                        <td><c:out value="${user.id}"/></td>
                                        <td><c:out value="${user.firstName}"/></td>
                                        <td><c:out value="${user.lastName}"/></td>
                                        <td><c:out value="${user.username}"/></td>
                                        <td><c:out value="${user.enabled}"/></td>
                                        <td><a href="<c:url value="/userRole/${user.role.iterator().next().id}"/>"><c:out
                                                value="${user.role.iterator().next().name}"/></a></td>
                                        <td><a href="<c:url value="/userConfirmDelete/?id=${user.id}"/>">Delete</a></td>
                                        <td><a href="<c:url value="/userEdit/${user.id}"/>">Edit</a></td>
                                        <td><a href="<c:url value="/userDetails/${user.id}"/>">Details</a></td>
                                        <td><a href="<c:url value="/changeRole/${user.id}"/>">Change role</a></td>
                                        <td><a href="<c:url value="/userInvest/${user.id}"/>">User's investment</a></td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>


        <%@ include file="../../main/footer.jsp" %>

</body>
</html>
