<!DOCTYPE html>
<html>
<%@ include file="../head.jsp" %>
<body>
<header class="header">

    <nav class="navbar navbar-expand-lg justify-content-around">
        <a href="" class="navbar-brand main-logo">
            <!-- Navbar Header-->
            <a href="" class="navbar-brand">
            <div class="brand-text brand-big visible text-uppercase"><strong class="text-primary">Inwestycje</strong><strong>w kupie</strong></div>
            <div class="brand-text brand-sm"><strong class="text-primary">D</strong><strong>A</strong></div></a>
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
                <a class="nav-link color-header" href="#contact">Contact</a>
            </li>
        </ul>
    </nav>
</header>
<div>
    <nav class="navbar navbar-expand-lg justify-content-around">

    <nav class="page-content ">

        <section class="section-more padding-small ">
            <div class="container d-flex justify-content-between">
                <div class="mr-4">
                    <h1 class="pb-3">Lorem ipsum dolor sit amet</h1>
                    <h4 class="pt-1">consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore
                        magna aliqua.</h4>
                </div>
                <div class="ml-4 align-self-center">
                    <button class="btn btn-color rounded-0 mt-4 pl-4 pr-4">
                        <a href="landingPage.html">Lorem ipsum</a>
                    </button>
                </div>
            </div>
        </section>
        <section class="padding-medium story" id="about">
            <div class="container d-flex justify-content-center align-items-center">
                <div class="row">
                    <div class="col-4 mr-4">
                        <div class="div-img">
                        </div>
                    </div>

                    <div class="col-7 ml-4">
                        <h1 class="pb-1">It is about us.</h1>
                        <p>It is about us. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam at porttitor sem. Aliquam erat
                            volutpat. Donec placerat nisl magna, et faucibus arcu condimentum sed. Lorem ipsum dolor sit
                            amet, consectetur adipiscing elit. Aliquam at porttitor sem. Aliquam erat volutpat. Donec
                            placerat nisl magna, et faucibus arcu condimentum sed.
                        </p>
                    </div>
                </div>
            </div>
        </section>
        <section class="padding-medium story">
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
                            </tr>
                            </thead>
                            <tbody>

                            <c:forEach items="${cryptocurrencies}" var="cryptocurrencies">
                                <tr>
                                    <td><c:out value="${cryptocurrencies.id}"/></td>
                                    <td><c:out value="${cryptocurrencies.name}"/></td>
                                    <td><c:out value="${cryptocurrencies.num_market_pairs}"/></td>
                                    <td><c:out value="${cryptocurrencies.cmc_rank}"/></td>
                                    <td><c:out value="${cryptocurrencies.circulating_supply}"/></td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </section>
        <section class="last-info-section padding-small" id="contact">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <h3 class="mb-4">THIS IS CONTACT</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam at porttitor sem.  Aliquam erat volutpat. Donec placerat nisl magna.</p>
                    </div>

                    </div>
                </div>

        </section>
    </nav>
    </nav>
</div>

<footer class="footer">
    <div class="footer__block block no-margin-bottom">
        <div class="container-fluid text-center">
            <p class="no-margin-bottom">2021 &copy; Your company. Design by <a href="https://bootstrapious.com/p/bootstrap-4-dark-admin">BL blb</a>.</p>
        </div>
    </div>
</footer>
<!-- JavaScript files-->
<script src="vendor/jquery/jquery.min.js"></script>
<script src="vendor/popper.js/umd/popper.min.js"> </script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="vendor/jquery.cookie/jquery.cookie.js"> </script>
<script src="vendor/chart.js/Chart.min.js"></script>
<script src="vendor/jquery-validation/jquery.validate.min.js"></script>
<script src="js/charts-home.js"></script>
<script src="js/front.js"></script>
</body>
</html>