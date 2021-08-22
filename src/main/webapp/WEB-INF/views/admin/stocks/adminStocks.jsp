<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en"><%@ include file="../../head.jsp" %>

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
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/adminAddStocks"/>">Add stocks</a></h2>
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
                                    <th>Bid</th>
                                    <th>Change</th>
                                    <th>Currency</th>
                                    <th>Name</th>
                                    <th>Price</th>
                                    <th>Delete</th>
                                    <th>Edit</th>
                                    <th>Details</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${adminStocks}" var="adminStocks">
                                    <tr>
                                        <td><c:out value="${adminStocks.id}"/></td>
                                        <td><c:out value="${adminStocks.bid}"/></td>
                                        <td><c:out value="${adminStocks.change}"/></td>
                                        <td><c:out value="${adminStocks.currency}"/></td>
                                        <td><c:out value="${adminStocks.name}"/></td>
                                        <td><c:out value="${adminStocks.price}"/></td>
                                        <td><a href="<c:url value="/adminStocksConfirmDelete/?id=${adminStocks.id}"/>">Delete</a></td>
                                        <td><a href="<c:url value="/adminStocksEdit/${adminStocks.id}"/>">Edit</a></td>
                                        <td><a href="<c:url value="/adminStocksDetails/${adminStocks.id}"/>">Details</a></td>
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
