<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<%@ include file="../../head.jsp" %>

<body>
<%@ include file="../adminHeader.jsp" %>
<div class="d-flex align-items-stretch">
    <%@ include file="../adminSideMenu.jsp" %>
    <div class="page-content">
        <div class="page-header">
            <div class="list-inline-item">
                <h2 class="h4 d-none d-sm-inline">Admin Dashboard</h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/userCrypto/${id}"/>">Only crypto</a></h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/userStocks/${id}"/>">Only stocks</a></h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/adminUsersInvest/export/excel/${id}"/>">Export
                    to Excel</a></h2>
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
                        <div class="title"><strong>All investments</strong></div>
                        <div class="title"><strong><c:out value="${error}"/></strong></div>
                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Price</th>
                                    <th>How much</th>
                                    <th>When bought</th>
                                    <th>Amount of crypto</th>
                                    <th>Notes</th>
                                    <th>Details</th>
                                    <th>Edit</th>
                                    <th>Delete</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${userInvestCrypto}" var="userInvestCrypto">
                                <tr>
                                    <td>${userInvestCrypto.id}</td>
                                    <td>${userInvestCrypto.cryptocurrencies.name}</td>
                                    <td>${userInvestCrypto.cryptocurrencies.priceMin}</td>
                                    <td>${userInvestCrypto.howMuch}</td>
                                    <td>${userInvestCrypto.numOfCoins}</td>
                                    <td>${userInvestCrypto.whenBought}</td>
                                    <td>${userInvestCrypto.notes}</td>
                                    <td><a href="<c:url value="/usersOwnedCryptoDetails/${userInvestCrypto.id}"/>">Details</a>
                                    </td>
                                    <td><a href="<c:url value="/usersOwnedCryptoEdit/${userInvestCrypto.id}"/>">Edit</a>
                                    </td>
                                    <td>
                                        <a href="<c:url value="/usersOwnedCryptoConfirmDelete/?id=${userInvestCrypto.id}"/>">Delete</a>
                                    </td>
                                </tr>
                                </c:forEach>
                                <c:forEach items="${userStocks}" var="userStocks">
                                    <tr>
                                        <td>${userStocks.id}</td>
                                        <td>${userStocks.stocks.name}</td>
                                        <td>${userStocks.stocks.price}</td>
                                        <td>${userStocks.howMuch}</td>
                                        <td>${userStocks.numOfCoins}</td>
                                        <td>${userStocks.whenBought}</td>
                                        <td>${userStocks.notes}</td>
                                        <td>
                                            <a href="<c:url value="/usersOwnedStocksDetails/${userStocks.id}"/>">Details</a>
                                        </td>
                                        <td><a href="<c:url value="/usersOwnedStocksEdit/${userStocks.id}"/>">Edit</a>
                                        </td>
                                        <td>
                                            <a href="<c:url value="/usersOwnedStocksConfirmDelete/?id=${userStocks.id}"/>">Delete</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>


        </section>


        <%@ include file="../../main/footer.jsp" %>

</body>
</html>