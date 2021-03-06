<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Dark Bootstrap Admin by Bootstrapious.com</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="resources/distribution/vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="resources/distribution/vendor/font-awesome/css/font-awesome.min.css">
    <!-- Custom Font Icons CSS-->
    <link rel="stylesheet" href="resources/distribution/css/font.css">
    <!-- Google fonts - Muli-->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Muli:300,400,700">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="resources/distribution/css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="resources/distribution/css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="resources/distribution/img/favicon.ico">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
</head>
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
