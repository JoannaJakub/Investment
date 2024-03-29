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
        </div>

        <section class="no-padding-top">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-6">

                    </div>
                </div>

                <div class="col-lg-20">
                    <div class="block">
                        <div class="title"><strong>New user</strong></div>
                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <tbody>

                                <form:form action="adminRegisterSuccess" modelAttribute="user" method="post">
                                    <div class="form-group-material">
                                        <form:input id="firstName" type="text" name="firstName" path="firstName"
                                                    placeholder="Name" data-msg="Please enter your name"
                                                    class="input-material"/>
                                        <form:errors path="firstName"/>
                                        <label for="firstName" class="label-material"></label>
                                    </div>
                                    <div class="form-group-material">
                                        <form:input id="register-surname" type="text" name="registerSurname"
                                                    path="lastName" placeholder="Surname"
                                                    data-msg="Please enter your surname" class="input-material"/>
                                        <form:errors path="lastName"/>
                                        <label for="register-surname" class="label-material"></label>
                                    </div>
                                    <div class="form-group-material">
                                        <form:input id="register-username" type="text" name="registerUsername"
                                                    path="username" placeholder="Email"
                                                    data-msg="Please enter a valid email address"
                                                    class="input-material"/>
                                        <form:errors path="username"/>
                                        <label for="register-username" class="label-material"> </label>
                                    </div>
                                    <div class="form-group-material">
                                        <c:forEach items="${role}" var="role">
                                            <form:radiobutton path="role" value="${role.id}"
                                                              name="role" />
                                            <span class="checkbox radio"></span>
                                            <span class="name"><c:out value="${role.name}" /></span>
                                        </c:forEach>
                                        <label for="register-password" class="label-material"> </label>
                                    </div>
                                    <div class="form-group-material">
                                        <form:input id="register-password" type="password" name="registerPassword"
                                                    path="password" placeholder="Password"
                                                    data-msg="Please enter your password" class="input-material"/>
                                        <form:errors path="password"/>
                                        <label for="register-password" class="label-material"> </label>
                                    </div>
                                    <div class="form-group-material">
                                        <form:input id="register-passwordConfirm" type="password" name="passwordConfirm"
                                                    path="passwordConfirm" placeholder="Confirm password"
                                                    data-msg="Please enter your password" class="input-material"/>
                                        <form:errors path="passwordConfirm"/>
                                        <label for="register-password" class="label-material"> </label>
                                    </div>

                                    <%--     <div class="form-group terms-conditions text-center">
                                             <input id="register-agree" name="registerAgree" type="checkbox" required value="1" data-msg="Your agreement is required" class="checkbox-template">
                                             <label for="register-agree">I agree with the terms and policy</label>
                                         </div>--%>
                                    <div class="form-group text-center">
                                        <input id="register" type="submit" value="Add" class="btn btn-primary">
                                    </div>
                                </form:form><small>List of users? </small><a href="<c:url value="/users"/>">Here</a>


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
