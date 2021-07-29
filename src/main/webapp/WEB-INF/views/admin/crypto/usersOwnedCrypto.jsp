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
                <h2 class="h4 d-none d-sm-inline">Admin Dashboard</h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/adminAddCrypto"/>">Add crypto</a></h2>
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
                                    <th>Crypto Id</th>
                                    <th>Name</th>
                                    <th>Cmc_rank</th>
                                    <th>Limit</th>
                                    <th>Max price</th>
                                    <th>Id</th>
                                    <th>Price</th>
                                    <th>How many</th>
                                    <th>Date</th>
                                    <th>Notes</th>
                                    <th>User Id</th>
                                    <th>Username</th>
                                    <th>Delete</th>
                                    <th>Edit</th>
                                    <th>Details</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${usersCrypto}" var="usersCrypto">
                                    <tr>
                                        <td><a href="<c:url value="/oneCryptoUser/${usersCrypto.cryptocurrencies.id}"/>"><c:out
                                                value="${usersCrypto.cryptocurrencies.id}"/></a></td>
                                        <td><c:out value="${usersCrypto.cryptocurrencies.name}"/></td>
                                        <td><c:out value="${usersCrypto.cryptocurrencies.cmc_rank}"/></td>
                                        <td><c:out value="${usersCrypto.cryptocurrencies.limit}"/></td>
                                        <td><c:out value="${usersCrypto.cryptocurrencies.priceMax}"/></td>
                                        <td><c:out value="${usersCrypto.id}"/></td>
                                        <td><c:out value="${usersCrypto.howMuch}"/></td>
                                        <td><c:out value="${usersCrypto.numOfCoins}"/></td>
                                        <td><c:out value="${usersCrypto.whenBought}"/></td>
                                        <td><c:out value="${usersCrypto.notes}"/></td>
                                        <td><c:out value="${usersCrypto.user.id}"/></td>
                                        <td><c:out value="${usersCrypto.user.username}"/></td>
                                        <td>
                                            <a href="<c:url value="/usersOwnedCryptoConfirmDelete/?id=${usersCrypto.id}"/>">Delete</a>
                                        </td>
                                        <td><a href="<c:url value="/usersOwnedCryptoEdit/${usersCrypto.id}"/>">Edit</a>
                                        </td>
                                        <td><a href="<c:url value="/usersOwnedCryptoDetails/${usersCrypto.id}"/>">Details</a>
                                        </td>
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
