<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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

                <div class="col-lg-12">
                    <div class="block">
                        <div class="title"><strong>Edit event</strong></div>
                        <div class="block-body">
                            <form:form method="post" modelAttribute="adminEventEdit">
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Event id</label>
                                    <div class="col-sm-9">
                                        <c:out value="${id}"/></div>
                                    <label for="name" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Title</label>
                                    <div class="col-sm-9">
                                        <form:input id="title" type="text" name="title" path="title"
                                                    placeholder="title" data-msg="Please enter your title"
                                                    class="form-control"/>
                                        <form:errors path="title"/></div>
                                    <label for="title" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Description</label>
                                    <div class="col-sm-9">
                                        <form:input id="description" type="text" name="description" path="description"
                                                    placeholder="Description" data-msg="Please enter description"
                                                    class="form-control"/>
                                        <form:errors path="description"/>
                                    </div>
                                    <label for="description" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Start</label>
                                    <div class="col-sm-9">
                                        <form:input id="start" type="text" name="start" path="start"
                                                    placeholder="Start" data-msg="Please enter start hour"
                                                    class="form-control"/>
                                        <form:errors path="start"/>
                                    </div>
                                    <label for="start" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Start</label>
                                    <div class="col-sm-9">
                                        <form:input id="end" type="text" name="start" path="end"
                                                    placeholder="End" data-msg="Please enter end hour"
                                                    class="form-control"/>
                                        <form:errors path="end"/>
                                    </div>
                                    <label for="end" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">User ID</label>
                                    <div class="col-sm-9">
                                        <form:input id="user" type="text" name="user" path="user"
                                                    placeholder="User id" data-msg="Please enter user id"
                                                    class="form-control"/>
                                        <form:errors path="user"/>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Username</label>
                                    <div class="col-sm-9">
                                        <c:out value="${adminEventEdit.get().user.username}"/></div>
                                    <label for="user" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Name</label>
                                    <div class="col-sm-9">
                                        <c:out value="${adminEventEdit.get().user.firstName}"/></div>
                                    <label for="user" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Surname</label>
                                    <div class="col-sm-9">
                                        <c:out value="${adminEventEdit.get().user.lastName}"/></div>
                                    <label for="user" class="label-material"></label>
                                </div>
                                <div class="form-group text-center">
                                    <a href="<c:url value="/adminCalendar"/>"
                                       class="btn btn-secondary">Cancel</a>
                                    <input id="register" type="submit" value="Update" class="btn btn-primary">
                                </div>
                            </form:form><small>List of all events? </small><a href="<c:url value="/adminCalendar"/>">Here</a>

                        </div>
                    </div>
                </div>
            </div>

        </section>

    </div>
</div>
<%@ include file="../../main/footer.jsp" %>
</body>
</html>
