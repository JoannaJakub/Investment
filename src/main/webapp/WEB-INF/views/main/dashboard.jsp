<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@ include file="../head.jsp" %>

<body>
<%@ include file="../header.jsp" %>
<div class="d-flex align-items-stretch">
    <%@ include file="../sideMenu.jsp" %>

    <div class="page-content">
        <div class="page-header">
            <div class="list-inline-item">
                <h1 class="h4 d-none d-sm-inline">Dashboard</h1>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="addCrypto">Add cryptocurrencies</a></h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="addStocks">Add stocks</a></h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="addStorage">Add storage</a></h2>
            </div>
        </div>
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li class="breadcrumb-item">Random stocks and crypto</li>
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
                                    <th>Price</th>
                                    <th>Change</th>
                                    <th>Currency</th>
                                    <th>Bid</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${stocks}" var="stocks">
                                    <tr>
                                        <td><c:out value="${stocks.id}"/></td>
                                        <td><c:out value="${stocks.name}"/></td>
                                        <td><c:out value="${stocks.price}"/></td>
                                        <td><c:out value="${stocks.change}"/></td>
                                        <td><c:out value="${stocks.currency}"/></td>
                                        <td><c:out value="${stocks.bid}"/></td>

                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

                <div class="col-lg-20">
                    <div class="block">
                        <div class="title"><strong>Crypto</strong></div>
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
            </div>
        </section>


        <%@ include file="footer.jsp" %>
</body>
</html>