<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@ include file="../../head.jsp" %>
<body>
<%@ include file="../../header.jsp" %>
<div class="d-flex align-items-stretch">
    <%@ include file="../sideMenu.jsp" %>

    <div class="page-content">
        <div class="page-header">
            <div class="list-inline-item">
                <h2 class="h4 d-none d-sm-inline">Dashboard</h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h4 no-margin-bottom"><a href="addStocks">Add stocks</a></h2>
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
                        <div class="title"><strong>Stocks</strong></div>
                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Change</th>
                                    <th>Price</th>
                                    <th>How much</th>
                                    <th>When bought</th>
                                    <th>Num of stocks</th>
                                    <th>Notes</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${ownedstocks}" var="ownedstocks">
                                    <tr>
                                        <td>${ownedstocks.id}</td>
                                        <td>${ownedstocks.stocks.name}</td>
                                        <td>${ownedstocks.stocks.change}</td>
                                        <td>${ownedstocks.stocks.price}</td>
                                        <td>${ownedstocks.howMuch}</td>
                                        <td>${ownedstocks.numOfCoins}</td>
                                        <td>${ownedstocks.whenBought}</td>
                                        <td>${ownedstocks.notes}</td>
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