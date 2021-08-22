<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/userCrypto/${id}"/>">Only crypto</a></h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/userStocks/${id}"/>">Only stocks</a></h2>
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
                        <div class="title"><strong>Edit user</strong></div>
                        <div class="block-body">
                            <form:form method="post" modelAttribute="userInvestEdit">
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Role id</label>
                                    <div class="col-sm-9">
                                        <c:out value="${id}"/></div>
                                    <label for="name" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Name</label>
                                    <div class="col-sm-9">
                                        <form:input id="firstName" type="text" name="firstName" path="firstName"
                                                    placeholder="Name" data-msg="Please enter your name"
                                                    class="input-material"/>
                                        <form:errors path="firstName"/></div>
                                    <label for="firstName" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Surname</label>
                                    <div class="col-sm-9">
                                        <form:input id="register-surname" type="text" name="registerSurname"
                                                    path="lastName" placeholder="Surname"
                                                    data-msg="Please enter your surname" class="input-material"/>
                                        <form:errors path="lastName"/></div>
                                    <label for="firstName" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Username</label>
                                    <div class="col-sm-9">
                                        <form:input id="register-username" type="text" name="registerUsername"
                                                    path="username" placeholder="Email"
                                                    data-msg="Please enter a valid email address"
                                                    class="input-material"/>
                                        <form:errors path="username"/></div>
                                    <label for="firstName" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Password</label>
                                    <div class="col-sm-9">
                                        <form:input id="register-password" type="password" name="registerPassword"
                                                    path="password" placeholder="Password"
                                                    data-msg="Please enter your password" class="input-material"/>
                                        <form:errors path="password"/></div>
                                    <label for="firstName" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Role</label>
                                    <div class="col-sm-9">
                                        <form:input id="register-password" type="text" name="registerPassword"
                                                    path="roles" placeholder="Role id"
                                                    data-msg="Please enter your password" class="input-material"/>
                                        <form:errors path="roles"/></div>
                                    <label for="firstName" class="label-material"></label>
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

        </section>


        <%@ include file="../../main/footer.jsp" %>

</body>
</html>