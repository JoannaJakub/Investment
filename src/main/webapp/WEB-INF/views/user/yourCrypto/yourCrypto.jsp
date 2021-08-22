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
                <h2 class="h4 d-none d-sm-inline">Dashboard</h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h4 no-margin-bottom"><a href="<c:url value="/addCrypto"/>">Add crypto</a></h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h4 no-margin-bottom"><a href="<c:url value="/usersCrypto/export/excel"/>">Export to excel</a></h2>
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
                                    <th>PriceMin</th>
                                    <th>PriceMax</th>
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

                                <c:forEach items="${ownedcryptocurrencies}" var="ownedcryptocurrencies">
                                    <tr>
                                        <td>${ownedcryptocurrencies.id}</td>
                                        <td>${ownedcryptocurrencies.cryptocurrencies.name}</td>
                                        <td>${ownedcryptocurrencies.cryptocurrencies.priceMin}</td>
                                        <td>${ownedcryptocurrencies.cryptocurrencies.priceMax}</td>
                                        <td>${ownedcryptocurrencies.howMuch}</td>
                                        <td>${ownedcryptocurrencies.numOfCoins}</td>
                                        <td>${ownedcryptocurrencies.whenBought}</td>
                                        <td>${ownedcryptocurrencies.notes}</td>
                                        <td><a href="<c:url value="/cryptoDetails/${ownedcryptocurrencies.id}"/>">Details</a></td>
                                        <td><a href="<c:url value="/cryptoEdit/${ownedcryptocurrencies.id}"/>">Edit</a></td>
                                        <td><a href="<c:url value="/cryptoConfirmDelete/?id=${ownedcryptocurrencies.id}"/>">Delete</a></td>
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