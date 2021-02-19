<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@ include file="head.jsp" %>
<body>
<%@ include file="header.jsp" %>
<div class="d-flex align-items-stretch">
    <%@ include file="sideMenu.jsp" %>

    <div class="page-content">
        <div class="page-header">
            <div class="list-inline-item">
                <h2 class="h4 d-none d-sm-inline">Dashboard</h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h4 no-margin-bottom"><a href="addCrypto">Add crypto</a></h2>
            </div>
        </div>
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li class="breadcrumb-item"><a href="addStocks">Add your stocks</a></li>
            </ul>
        </div>
        <section class="no-padding-top">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-6">

                    </div>
                </div>


                <div class="col-lg-20">
                    <div class="block">
                        <div class="title"><strong>Stocks</strong></div>
                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Num_market_pairs</th>
                                    <th>CMC Rank</th>
                                    <th>Circulating Supply</th>
                                    <th>How much</th>
                                    <th>When bought</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${ownedcryptocurrencies}" var="ownedcryptocurrencies">
                                    <tr>
                                        <td><c:out value="${ownedcryptocurrencies.id}"/></td>
                                        <td><c:out value="${ownedcryptocurrencies.name}"/></td>
                                        <td><c:out value="${ownedcryptocurrencies.num_market_pairs}"/></td>
                                        <td><c:out value="${ownedcryptocurrencies.cmc_rank}"/></td>
                                        <td><c:out value="${ownedcryptocurrencies.circulating_supply}"/></td>
                                        <td><c:out value="${ownedcryptocurrencies.howMuch}"/></td>
                                        <td><c:out value="${ownedcryptocurrencies.whenBought}"/></td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
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
                <p class="no-margin-bottom">2020 &copy; Your company. Design by <a
                        href="https://bootstrapious.com/p/bootstrap-4-dark-admin">Bootstrapious</a>.</p>
            </div>
        </div>
    </footer>
</div>
</div>
<!-- JavaScript files-->
<script src="resources/distribution/vendor/jquery/jquery.min.js"></script>
<script src="resources/distribution/vendor/popper.js/umd/popper.min.js"></script>
<script src="resources/distribution/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="resources/distribution/vendor/jquery.cookie/jquery.cookie.js"></script>
<script src="resources/distribution/vendor/chart.js/Chart.min.js"></script>
<script src="resources/distribution/vendor/jquery-validation/jquery.validate.min.js"></script>
<script src="resources/distribution/js/charts-home.js"></script>
<script src="resources/distribution/js/front.js"></script>
</body>
</html>