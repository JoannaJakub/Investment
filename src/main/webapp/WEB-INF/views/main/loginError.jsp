<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<html lang="en"><%@ include file="../head.jsp" %>
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
                            <div>
                                <p>Log in to see your investment</p></br>

                            </div>

                        </div>
                    </div>
                </div>
                <!-- Form Panel    -->
                <div class="col-lg-6">
                    <div class="form d-flex align-items-center">

                        <div class="content">
                            <a href="/" class="navbar-brand">
                                <div class="brand-text brand-big visible text-uppercase">
                                    <strong class="text-primary">Inwestycje</strong><strong>w kupie</strong>
                                </div>
                            </br></br>
                            </a>
                            <div class="form-group-material">
                                Password or email incorect!
                            </div>
                            <form:form method="post" class="form-validate mb-4" authentication-failure-url="/login?error=true">
                                <div class="form-group">
                                    <input id="login-username" type="text" name="username" placeholder="Email" required data-msg="Please enter your email" class="input-material">
                                    <form:errors path="username"/>

                                    <label for="login-username" class="label-material"></label>
                                </div>
                                <div class="form-group">
                                    <input id="login-password" type="password" name="password" placeholder="Password" required data-msg="Please enter your password" class="input-material">
                                    <form:errors path="password"/>
                                    <label for="login-password" class="label-material"></label>
                                </div>
                                </br>
                            <div class="form-group terms-conditions text-center">
                                <button type="submit" class="btn btn-primary">Login</button>
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                </br> </br>
                            </div>
                            </form:form><a href="#" class="forgot-pass">Forgot Password?</a><br>
                            <small>Do not have an account? </small><a href="register" class="signup">Signup</a><br>


                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="copyrights text-center">
        <p>Design by <a href="https://bootstrapious.com/p/bootstrap-4-dark-admin" class="external">Bootstrapious</a></p>
        <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
    </div>
</div>
<!-- JavaScript files-->
<script src="resources/distribution/vendor/jquery/jquery.min.js"></script>
<script src="resources/distribution/vendor/popper.js/umd/popper.min.js"> </script>
<script src="resources/distribution/vendor/bootstrap/js/bootstrap.js"></script>
<script src="resources/distribution/vendor/jquery.cookie/jquery.cookie.js"> </script>
<script src="resources/distribution/vendor/chart.js/Chart.min.js"></script>

</body>
</html>
