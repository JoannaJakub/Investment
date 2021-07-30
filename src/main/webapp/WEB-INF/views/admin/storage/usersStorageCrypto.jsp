<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@ include file="../../head.jsp" %>

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
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/usersStorage"/>">All storage</a></h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/storageOfUsersStocks/${id}"/>">Only stocks
                    storage</a></h2>
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
                        <div class="title"><strong>User's storage for crypto</strong></div>
                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <thead>
                                <tr>
                                    <th>User Id</th>
                                    <th>Name</th>
                                    <th>Surname</th>
                                    <th>Username</th>
                                    <th>Storage Id</th>
                                    <th>Name</th>
                                    <th>Link</th>
                                    <th>Delete</th>
                                    <th>Edit</th>
                                    <th>Details</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${usersStorageCrypto}" var="usersStorageCrypto">
                                    <tr>
                                        <td><c:out value="${usersStorageCrypto.user.id}"/></td>
                                        <td><c:out value="${usersStorageCrypto.user.firstName}"/></td>
                                        <td><c:out value="${usersStorageCrypto.user.lastName}"/></td>
                                        <td><c:out value="${usersStorageCrypto.user.username}"/></td>
                                        <td><c:out value="${usersStorageCrypto.storage.id}"/></td>
                                        <td><c:out value="${usersStorageCrypto.storage.name}"/></td>
                                        <td><c:out value="${usersStorageCrypto.storage.link}"/></td>
                                        <td>
                                            <a href="<c:url value="/storageConfirmDelete/?id=${usersStorageCrypto.id}"/>">Delete</a>
                                        </td>
                                        <td><a href="<c:url value="/storageEdit/${usersStorageCrypto.id}"/>">Edit</a>
                                        </td>
                                        <td>
                                            <a href="<c:url value="/storageDetails/${usersStorageCrypto.id}"/>">Details</a>
                                        </td>
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
