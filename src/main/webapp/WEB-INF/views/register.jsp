<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<html xmlns:th="http://www.thymeleaf.org">
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
                            <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</p>
                        </div>
                    </div>
                </div>
                <!-- Form Panel    -->
                <div class="col-lg-6 bg-white">
                    <div class="form d-flex align-items-center">
                        <div class="content">
                            <form:form action="register_success" modelAttribute="user" class="text-left form-validate" method="post" >
                                <div class="form-group-material">
                                    <form:input id="firstName" type="text" name="firstName" path="firstName" placeholder="Name"   data-msg="Please enter your name" class="input-material"/>
                                    <form:hidden path="id" value="${user.id}"/><br>
                                    <label for="firstName" class="label-material"></label>
                                </div>
                                <div class="form-group-material">
                                    <form:input id="register-surname" type="text" name="registerSurname" path="lastName" placeholder="Surname" data-msg="Please enter your surname" class="input-material"/>
                                    <label for="register-surname" class="label-material"></label>
                                </div>
                                <div class="form-group-material">
                                    <form:input id="register-email" type="email" name="registerEmail" path="email"  placeholder="Email Address"  data-msg="Please enter a valid email address" class="input-material"/>
                                    <label for="register-email" class="label-material">      </label>
                                </div>
                                <div class="form-group-material">
                                    <form:input id="register-password" type="password" name="registerPassword" path="password"  placeholder="Password"  data-msg="Please enter your password" class="input-material"/>
                                    <label for="register-password" class="label-material">        </label>
                                </div>
                                <div class="form-group terms-conditions text-center">
                                    <input id="register-agree" name="registerAgree" type="checkbox" required value="1" data-msg="Your agreement is required" class="checkbox-template">
                                    <label for="register-agree">I agree with the terms and policy</label>
                                </div>
                                <div class="form-group text-center">
                                    <input id="register" type="submit" value="Register" class="btn btn-primary">
                                </div>
                            </form:form><small>Already have an account? </small><a href="admin/login" class="signup">Login</a>
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