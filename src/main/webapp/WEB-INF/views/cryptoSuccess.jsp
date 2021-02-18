<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<%@ include file="head.jsp" %>
<body>
<%@ include file="header.jsp" %>
<div class="d-flex align-items-stretch">
    <%@ include file="sideMenu.jsp" %>
    <div class="page-content">
        <!-- Page Header-->
        <div class="page-header no-margin-bottom">
            <div class="container-fluid">
            </div>
        </div>
        <!-- Breadcrumb-->
        <div class="container-fluid">
            <ul class="breadcrumb">

            </ul>
        </div>
        <section class="no-padding-top">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-20">
                            <div class="content">
                                <div class="text-left">
                                    <h1>You have add your crypto successfully!</h1>
                                    </br>
                                    <h4><a href="yourCrypto">Click here to see all your coins!</a></h4>
                                </br>
                                    <h5><a href="addCrypto">Click here to add more coins!</a></h5>
                                </div>
                            </div>
                         </div>
                </div>
            </div>
        </section>
        <footer class="footer">
            <div class="footer__block block no-margin-bottom">
                <div class="container-fluid text-center">
                    <!-- Please do not remove the backlink to us unless you support us at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
                    <p class="no-margin-bottom">2020 &copy; Your company. Design by <a href="https://bootstrapious.com/p/bootstrap-4-dark-admin">Bootstrapious</a>.</p>
                </div>
            </div>
        </footer>
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