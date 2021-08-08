<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<%@ include file="../adminHead.jsp" %>

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
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/addRole"/>">Add role</a></h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/role"/>">All users</a></h2>
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
                        <div class="title"><strong>User Role</strong></div>
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
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${userRole}" var="userRole">
                                    <tr>
                                        <td><c:out value="${userRole.id}"/></td>
                                        <td><c:out value="${userRole.firstName}"/></td>
                                        <td><c:out value="${userRole.lastName}"/></td>
                                        <td><c:out value="${userRole.username}"/></td>
                                        <td><c:out value="${userRole.enabled}"/></td>
                                        <td><c:out value="${userRole.role.iterator().next().name}"/></td>
                                        <td><a href="<c:url value="/userConfirmDelete/?id=${user.id}"/>">Delete</a></td>
                                        <td><a href="<c:url value="/userEdit/${user.id}"/>">Edit</a></td>
                                        <td><a href="<c:url value="/userDetails/${user.id}"/>">Details</a></td>
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
