<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/adminAddEvent"/>">Add event</a></h2>
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
                        <div class="title"><strong>Event has been changed!</strong></div>
                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <tbody>

                                <form:form items="${adminEventConfirmEdit}" var="adminEventConfirmEdit">
                                    <div>
                                        <tr>
                                            <td>ID</td>
                                            <td><c:out value="${id}"/></td>
                                        </tr>
                                        <tr>
                                            <td>Title</td>
                                            <td><c:out value="${adminEventConfirmEdit.title}"/></td>
                                        </tr>
                                        <tr>
                                            <td>Description</td>
                                            <td><c:out value="${adminEventConfirmEdit.description}"/></td>
                                        </tr>
                                        <tr>
                                            <td>Start</td>
                                            <td><c:out value="${adminEventConfirmEdit.start}"/></td>
                                        </tr>
                                        <tr>
                                            <td>End</td>
                                            <td><c:out value="${adminEventConfirmEdit.end}"/></td>
                                        </tr>
                                        <tr>
                                            <td>User ID</td>
                                            <td><c:out value="${adminEventConfirmEdit.user.id}"/></td>
                                        </tr>
                                        <tr>
                                            <td>Username</td>
                                            <td><a href="<c:url value="/userDetails/${adminEventConfirmEdit.user.id}"/>"><c:out
                                                value="${adminEventConfirmEdit.user.username}"/></a></td>
                                        </tr>
                                        <tr>
                                            <td>Name</td>
                                            <td><c:out value="${adminEventConfirmEdit.user.firstName}"/></td>
                                        </tr>
                                        <tr>
                                            <td>Surname</td>
                                            <td><c:out value="${adminEventConfirmEdit.user.lastName}"/></td>
                                        </tr>
                                    </div>

                                </form:form>


                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>
            <br>
            <br>
            <br>
            <div class="no-margin-bottom">
                <small>List of all messages? </small><a href="<c:url value="/adminContact"/>">Here</a>
            </div>
        </section>
    </div>
</div>

<%@ include file="../../main/footer.jsp" %>
</body>
</html>
