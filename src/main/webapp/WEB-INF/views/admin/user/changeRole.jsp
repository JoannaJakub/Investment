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
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/adminRegister"/>">Add user</a></h2>
            </div>
        </div>

        <div class="no-padding-top">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-6">

                </div>
            </div>

            <div class="col-lg-12">
                <div class="block">
                    <div class="title"><strong>Change role</strong></div>
                    <div class="block-body">
                        <form:form method="post" modelAttribute="changeRole">
                            <div class="form-group row">
                                <label class="col-sm-3 form-control-label">User id</label>
                                <div class="col-sm-9">
                                    <c:out value="${id}"/></div>
                                <form:hidden path="firstName"/>
                                <form:hidden path="lastName"/>
                                <form:hidden path="password"/>
                                <form:hidden path="username"/>

                                <label for="id" class="label-material"></label>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 form-control-label">Username</label>
                                <div class="col-sm-9">
                                    <c:out value="${changeRole.stream().iterator().next().username}"/>
                                    <label for="role" class="label-material"></label>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 form-control-label">Current role</label>
                                <div class="col-sm-9">
                                    <c:out value="${changeRole.stream().iterator().next().role}"/>
                                    <label for="role" class="label-material"></label>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 form-control-label">Choose role</label>
                                <div class="col-sm-9">
                                    <c:forEach items="${role}" var="role">
                                        <form:radiobutton path="role" value="${role.id}"
                                                          name="role"/>
                                        <span class="checkbox radio"></span>
                                        <span class="name"><c:out value="${role.name}"/></span>
                                    </c:forEach>
                                    <label for="role" class="label-material"></label>
                                </div>
                            </div>
                            <div class="form-group text-center">
                                <a href="<c:url value="/users"/>"
                                   class="btn btn-secondary">Cancel</a>
                                <input id="register" type="submit" value="Update" class="btn btn-primary">
                            </div>
                        </form:form><small>List of users? </small><a href="<c:url value="/users"/>">Here</a>

                    </div>
                </div>
            </div>
        </div>
        </div>
        <%@ include file="../../main/footer.jsp" %>

</body>
</html>
