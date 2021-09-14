<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
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
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/adminSendMessage"/>">Send message</a></h2>
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
                        <div class="title"><strong>Messages</strong></div>
                        <div class="title"><strong><c:out value="${error}"/></strong></div>
                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Message</th>
                                    <th>Date</th>
                                    <th>User</th>
                                    <th>Delete</th>
                                    <th>Edit</th>
                                    <th>Details</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${adminMessage}" var="adminMessage">
                                <tr>
                                        <td><c:out value="${adminMessage.id}"/></td>
                                        <td><c:out value="${adminMessage.message}"/></td>
                                        <td><c:out value="${adminMessage.updateDate}"/></td>
                                        <td><c:out value="${adminMessage.user.id}"/></td>
                                        <td><a href="<c:url value="/adminMessageConfirmDelete/?id=${adminMessage.id}"/>">Delete</a></td>
                                        <td><a href="<c:url value="/adminMessageEdit/${adminMessage.id}"/>">Edit</a></td>
                                        <td><a href="<c:url value="/adminMessageDetails/${adminMessage.id}"/>">Details</a></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
        </section>
        <%@ include file="../../main/footer.jsp" %>
</body>
</html>
