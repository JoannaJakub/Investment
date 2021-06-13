<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@ include file="../head.jsp" %>

<body>

<header>
    <nav class="navbar navbar-expand-lg justify-content-around">
        <a href="" class="navbar-brand main-logo">
            <!-- Navbar Header-->
            <a href="/" class="navbar-brand">
                <div class="brand-text brand-big visible text-uppercase"><strong
                        class="text-primary">Inwestycje</strong><strong>w kupie</strong></div>
                <div class="brand-text brand-sm"><strong class="text-primary">D</strong><strong>A</strong></div>
            </a>
        </a>
        <ul class="nav nounderline text-uppercase">
            <li class="nav-item ml-4">
                <a class="nav-link color-header" href="login">Login</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link color-header" href="register">Register</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link color-header" href="#about">About</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link color-header" href="allStocksLandingPage">Stocks</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link" href="allCryptoLandingPage">Crypto</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link disabled" href="#contact">Contact</a>
            </li>
        </ul>
    </nav>
</header>
<nav class="navbar navbar-expand-lg justify-content-around">
    <nav class="page-content ">
        <div class="block">
            <div class="title"><strong>Cryptocurrencies</strong></div>
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Symbol</th>
                        <th>Num market pairs</th>
                        <th>CMC Rank</th>
                        <th>Circulating Supply</th>
                        <th>Total Supply</th>
                        <th>Volume 24h Max</th>
                        <th>Volume 24h Min</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cryptocurrencies}" var="cryptocurrencies">
                        <tr>
                            <td><c:out value="${cryptocurrencies.id}"/></td>
                            <td><c:out value="${cryptocurrencies.name}"/></td>
                            <td><c:out value="${cryptocurrencies.symbol}"/></td>
                            <td><c:out value="${cryptocurrencies.num_market_pairs}"/></td>
                            <td><c:out value="${cryptocurrencies.cmc_rank}"/></td>
                            <td><c:out value="${cryptocurrencies.circulating_supply}"/></td>
                            <td><c:out value="${cryptocurrencies.total_supply}"/></td>
                            <td><c:out value="${cryptocurrencies.volume24hMax}"/></td>
                            <td><c:out value="${cryptocurrencies.volume24hMin}"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </nav>
</nav>


<footer class="footer">
    <div class="footer__block block no-margin-bottom">
        <div class="container-fluid text-center">
            <!-- Please do not remove the backlink to us unless you support us at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
            <p class="no-margin-bottom"><a
                    href="https://bootstrapious.com/p/bootstrap-4-dark-admin"></a></p>
        </div>
    </div>
</footer>

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