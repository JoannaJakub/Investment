<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@ include file="../head.jsp" %>

<body>
<%@ include file="header.jsp" %>
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

<%@ include file="footer.jsp" %>
</body>
</html>