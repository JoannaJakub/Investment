<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<%@ include file="../head.jsp" %>
<body>
<%@ include file="../header.jsp" %>
<div class="d-flex align-items-stretch">
    <%@ include file="../sideMenu.jsp" %>
    <div class="page-content">
        <!-- Page Header-->
        <div class="page-header">
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom" ><a href="addCrypto">Add cryptocurrencies</a></h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="addStocks"></a></h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="addStorage">Add storage</a></h2>
            </div>
        </div>
        <!-- Breadcrumb-->
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li class="breadcrumb-item"><a href=>Fill in form</a></li>
            </ul>
        </div>
        <section class="no-padding-top">
            <div class="container-fluid">
                <div class="row">
                    <!-- Form Elements -->
                    <div class="col-lg-12">
                        <div class="block">
                            <div class="title"><strong>All form elements</strong></div>
                            <div class="block-body">
                                <form:form action="stocksSuccess" class="form-horizontal" method="post" modelAttribute="ownedstocks">
                                    <div class="form-group row">
                                        <label class="col-sm-3 form-control-label">Chooose stock</label>
                                        <div class="col-sm-9 ml-auto">
                                            <form:hidden path="user" items="${user}" class="form-control" itemLabel="user" itemValue="id" />
                                            <form:select path="stocks" items="${stocks}" class="form-control" itemLabel="name" itemValue="id" />
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-3 form-control-label">Chooose storage</label>
                                        <div class="col-sm-9 ml-auto">
                                            <form:select path="storage" items="${storage}" class="form-control" itemLabel="name" itemValue="id" />
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-3 form-control-label" for="howMuch">Your price per capita</label>
                                        <div class="col-sm-9">
                                            <form:input id="howMuch"  type="text" class="form-control" path="howMuch"  name="howMuch"/>
                                            <form:errors path="howMuch"/>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-3 form-control-label" for="numOfCoins">Number of stocks</label>
                                        <div class="col-sm-9">
                                            <form:input id="numOfCoins"  type="text" class="form-control" path="numOfCoins" name="numOfCoins"/>
                                            <form:errors path="numOfCoins"/>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-3 form-control-label" for="whenBought">Date of transactions</label>
                                        <div class="col-sm-9">
                                            <form:input id="whenBought"  type="text" class="form-control" path="whenBought" name="whenBought"/>
                                            <form:errors path="whenBought"/>
                                        </div>
                                    </div>
                                    <div class="line"></div>
                                    <div class="form-group row">
                                        <label class="col-sm-3 form-control-label">Notes</label>
                                        <div class="col-sm-9">
                                            <form:input id="notes"  type="text" class="form-control" path="notes"/><small class="help-block-none">You can add your comments here.</small>
                                        </div>
                                    </div>

                                    <div class="line"></div>
                                    <div class="form-group row">
                                        <div class="col-sm-9 ml-auto">
                                            <button type="submit" class="btn btn-secondary">Cancel</button>
                                            <button type="submit" class="btn btn-primary">Save changes</button>
                                        </div>
                                    </div>
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                </form:form>

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