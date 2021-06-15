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
            <div class="title"><strong>Stocks</strong></div>
            <div class="table-responsive">
                <table class="table table-striped table-sm">
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Bid</th>
                        <th>Change</th>
                        <th>Curency</th>
                        <th>Price</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${stocks}" var="stocks">
                        <tr>
                            <td><c:out value="${stocks.id}"/></td>
                            <td><c:out value="${stocks.name}"/></td>
                            <td><c:out value="${stocks.bid}"/></td>
                            <td><c:out value="${stocks.change}"/></td>
                            <td><c:out value="${stocks.currency}"/></td>
                            <td><c:out value="${stocks.price}"/></td>

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