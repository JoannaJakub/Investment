<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en"><%@ include file="../../head.jsp" %>
<body>
<%@ include file="../header.jsp" %>
<div class="d-flex align-items-stretch">
    <%@ include file="../sideMenu.jsp" %>

    <div class="page-content">
        <div class="page-header">
            <div class="container-fluid">
                <h2 class="h4 no-margin-bottom">Dashboard</h2>
            </div>
        </div>

        <section class="no-padding-top">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-6">

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
                                    <th>Symbol</th>
                                    <th>Num market pairs</th>
                                    <th>CMC Rank</th>
                                    <th>Circulating Supply</th>
                                    <th>Total Supply</th>
                                    <th>Volume 24h Max</th>
                                    <th>Volume 24h Min</th>
                                    <th>Details</th>
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
                                        <td><a href="<c:url value="/allCryptoDetails/${cryptocurrencies.id}"/>">Details</a></td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>


        <%@ include file="../footer.jsp" %>

</body>
</html>