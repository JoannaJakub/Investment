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

            <div class="list-inline-item">
                <h2 class="h4 no-margin-bottom"><a href="<c:url value="/addStocks"/>">Add stock</a></h2>
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
                        <div class="title"><strong>Stocks from storage </strong></div>
                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Change</th>
                                    <th>Price</th>
                                    <th>How much</th>
                                    <th>Num of stocks</th>
                                    <th>When bought</th>
                                    <th>Notes</th>
                                    <th>Details</th>
                                    <th>Edit</th>
                                    <th>Delete</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${allStocksFromStorage}" var="allStocksFromStorage">
                                    <tr>
                                        <td>${allStocksFromStorage.id}</td>
                                        <td>${allStocksFromStorage.stocks.name}</td>
                                        <td>${allStocksFromStorage.stocks.change}</td>
                                        <td>${allStocksFromStorage.stocks.price}</td>
                                        <td>${allStocksFromStorage.howMuch}</td>
                                        <td>${allStocksFromStorage.numOfCoins}</td>
                                        <td>${allStocksFromStorage.whenBought}</td>
                                        <td>${allStocksFromStorage.notes}</td>
                                        <td><a href="<c:url value="/stocksDetails/${allStocksFromStorage.id}"/>">Details</a></td>
                                        <td><a href="<c:url value="/stocksEdit/${allStocksFromStorage.id}"/>">Edit</a></td>
                                        <td><a href="<c:url value="/stocksConfirmDelete/?id=${allStocksFromStorage.id}"/>">Delete</a></td>
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
    </div>
</div>
</body>
</html>