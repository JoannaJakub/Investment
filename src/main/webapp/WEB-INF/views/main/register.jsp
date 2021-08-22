<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en"><html xmlns:th="http://www.thymeleaf.org">
<%@ include file="../head.jsp" %>
<body>
<div class="login-page">
    <div class="container d-flex align-items-center">
        <div class="form-holder has-shadow">
            <div class="row">
                <!-- Logo & Information Panel-->
                <div class="col-lg-6">
                    <div class="info d-flex align-items-center">
                        <div class="content">
                            <div class="logo">
                                <h1>Dashboard</h1>
                            </div>
                            <p>Register to get started!</p>
                        </div>
                    </div>
                </div>
                <!-- Form Panel    -->
                <div class="col-lg-6 bg-white">
                    <div class="form d-flex align-items-center">
                        <div class="content">
                            <a href="/" class="navbar-brand">
                                <div class="brand-text brand-big visible text-uppercase">
                                    <strong class="text-primary">Inwestycje</strong><strong>w kupie</strong>
                                </div>
                                </br></br>
                            </a>
                            <form:form action="register_success" modelAttribute="user" method="post" >
                                <div class="form-group-material">
                                    <form:input id="firstName" type="text" name="firstName" path="firstName" placeholder="Name"   data-msg="Please enter your name" class="input-material"/>
                                    <form:errors path="firstName"/>
                                    <label for="firstName" class="label-material"></label>
                                </div>
                                <div class="form-group-material">
                                    <form:input id="register-surname" type="text" name="registerSurname" path="lastName" placeholder="Surname" data-msg="Please enter your surname" class="input-material"/>
                                    <form:errors path="lastName"/>
                                    <label for="register-surname" class="label-material"></label>
                                </div>
                                <div class="form-group-material">
                                    <form:input id="register-username" type="text" name="registerUsername" path="username"  placeholder="Email"  data-msg="Please enter a valid email address" class="input-material"/>
                                    <form:errors path="username"/>
                                    <label for="register-username" class="label-material">      </label>
                                </div>
                                <div class="form-group-material">
                                    <form:input id="register-password" type="password" name="registerPassword" path="password"  placeholder="Password"  data-msg="Please enter your password" class="input-material"/>
                                    <form:errors path="password"/>
                                    <label for="register-password" class="label-material">        </label>
                                </div>
                           <%--     <div class="form-group terms-conditions text-center">
                                    <input id="register-agree" name="registerAgree" type="checkbox" required value="1" data-msg="Your agreement is required" class="checkbox-template">
                                    <label for="register-agree">I agree with the terms and policy</label>
                                </div>--%>
                                <div class="form-group text-center">
                                    <input id="register" type="submit" value="Register" class="btn btn-primary">
                                </div>
                            </form:form><small>Already have an account? </small><a href="login" class="signup">Login</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="copyrights text-center">
        <p>Design by <a href="https://bootstrapious.com" class="external">Bootstrapious</a></p>
        <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
    </div>
</div>
<!-- JavaScript files-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/popper.js/umd/popper.min.js"> </script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="vendor/jquery.cookie/jquery.cookie.js"> </script>
<script src="vendor/chart.js/Chart.min.js"></script>
<script src="vendor/jquery-validation/jquery.validate.min.js"></script>
<script src="js/front.js"></script>
</body>
</html>