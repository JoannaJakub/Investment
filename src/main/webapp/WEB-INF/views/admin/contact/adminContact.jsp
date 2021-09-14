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
                                <c:forEach items="${adminContact}" var="adminContact">
                                <tr>
                                        <td><c:out value="${adminContact.id}"/></td>
                                        <td><c:out value="${adminContact.message}"/></td>
                                        <td><c:out value="${adminContact.updateDate}"/></td>
                                        <td><c:out value="${adminContact.user.id}"/></td>
                                        <td><a href="<c:url value="/adminContactConfirmDelete/?id=${adminContact.id}"/>">Delete</a></td>
                                        <td><a href="<c:url value="/adminContactEdit/${adminContact.id}"/>">Edit</a></td>
                                        <td><a href="<c:url value="/adminContactDetails/${adminContact.id}"/>">Details</a></td>
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
