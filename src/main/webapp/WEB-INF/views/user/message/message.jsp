<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en"><%@ include file="../../head.jsp" %>
<body>
<%@ include file="../header.jsp" %>
<div class="d-flex align-items-stretch">
    <%@ include file="../sideMenu.jsp" %>

    <div class="page-content">
        <div class="page-header">
            <div class="list-inline-item">
                <h2 class="h4 no-margin-bottom"><a href="<c:url value="/addMessage"/>">Send message</a></h2>
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
                        <div class="title"><strong>Your messages</strong></div>
                        <div class="title"><strong><c:out value="${error}"/></strong></div>
                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Message</th>
                                    <th>Date</th>
                                    <th>Delete</th>
                                    <th>Edit</th>
                                    <th>Details</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${message}" var="message">
                                <tr>
                                        <td><c:out value="${message.id}"/></td>
                                        <td><c:out value="${message.message}"/></td>
                                        <td><c:out value="${message.updateDate.toString()}"/></td>
                                        <td><a href="<c:url value="/messageConfirmDelete/?id=${message.id}"/>">Delete</a></td>
                                        <td><a href="<c:url value="/messageEdit/${message.id}"/>">Edit</a></td>
                                        <td><a href="<c:url value="/messageDetails/${message.id}"/>">Details</a></td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </div>
        </section>


        <%@ include file="../footer.jsp" %>
    </div>
</div>
</body>
</html>