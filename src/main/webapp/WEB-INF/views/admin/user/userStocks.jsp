<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@ include file="../../head.jsp" %>

<body>
<%@ include file="../adminHeader.jsp" %>
<div class="d-flex align-items-stretch">
    <%@ include file="../adminSideMenu.jsp" %>


    <div class="page-content">
        <div class="page-header">
            <div class="list-inline-item">
                <h2 class="h4 d-none d-sm-inline">Dashboard</h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/userCrypto/${id}"/>">Only crypto</a></h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/userInvest"/>">All invest</a></h2>
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
                                <c:forEach items="${userStocks}" var="userStocks">
                                    <tr>
                                        <td>${userStocks.id}</td>
                                        <td>${userStocks.stocks.name}</td>
                                        <td>${userStocks.stocks.price}</td>
                                        <td>${userStocks.howMuch}</td>
                                        <td>${userStocks.numOfCoins}</td>
                                        <td>${userStocks.whenBought}</td>
                                        <td>${userStocks.notes}</td>
                                        <td><a href="<c:url value="/usersOwnedStocksDetails/${userStocks.id}"/>">Details</a></td>
                                        <td><a href="<c:url value="/usersOwnedStocksEdit/${userStocks.id}"/>">Edit</a></td>
                                        <td><a href="<c:url value="/usersOwnedStocksConfirmDelete/?id=${userStocks.id}"/>">Delete</a></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>

    </section>


        <%@ include file="../../main/footer.jsp" %>

</body>
</html>