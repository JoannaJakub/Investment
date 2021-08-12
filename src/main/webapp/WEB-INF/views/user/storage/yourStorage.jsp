<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<%@ include file="../../head.jsp" %>
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
                <h2 class="h4 no-margin-bottom"><a href="<c:url value="/addStorage"/>">Add storage</a></h2>
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
                        <div class="title"><strong>Your stocks storage</strong></div>
                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Link</th>
                                    <th>Stocks</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${yourStocksStorage}" var="yourStocksStorage">
                                    <tr>
                                        <td><c:out value="${yourStocksStorage.storage.name}"/></td>
                                        <td><c:out value="${yourStocksStorage.storage.link}"/></td>
                                        <td><a href="<c:url value="/allStocksFromStorage/${yourStocksStorage.storage.id}"/>">All stocks</a></td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
    </section>
        <section class="no-padding-top">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-6">

                    </div>
                </div>

                <div class="col-lg-20">
                    <div class="block">
                        <div class="title"><strong>Your crypto storage</strong></div>
                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <thead>
                                <tr>
                                    <th>Name</th>
                                    <th>Link</th>
                                    <th>Crypto</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${yourCryptoStorage}" var="yourCryptoStorage">
                                    <tr>
                                        <td><c:out value="${yourCryptoStorage.storage.name}"/></td>
                                        <td><c:out value="${yourCryptoStorage.storage.link}"/></td>
                                        <td><a href="<c:url value="/allCryptoFromStorage/${yourCryptoStorage.storage.id}"/>">All Crypto</a></td>
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