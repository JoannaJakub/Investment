<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<%@ include file="../../head.jsp" %>
<body>
<%@ include file="../header.jsp" %>
<div class="d-flex align-items-stretch">
    <%@ include file="../sideMenu.jsp" %>
    <div class="page-content">
        <div class="page-header">

            <div class="list-inline-item">
                <h2 class="h4 no-margin-bottom"><a href="<c:url value="/addCrypto"/>">Add crypto</a></h2>
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
                        <div class="title"><strong>Crypto has been changed!</strong></div>
                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <tbody>

                                <form:form items="${cryptoConfirmEdit}" var="cryptoConfirmEdit">

                                    <div>
                                        <tr>
                                            <td>ID</td>
                                            <td><c:out value="${id}"/></td>
                                        </tr>
                                        <tr>
                                            <td>Name</td>
                                            <td><c:out value="${cryptoConfirmEdit.cryptocurrencies.name}"/></td>
                                        </tr>
                                        <tr>
                                            <td>Storage</td>
                                            <td><c:out value="${cryptoConfirmEdit.storage.name}"/></td>
                                        </tr>
                                        <tr>
                                            <td>Price</td>
                                            <td><c:out value="${cryptoConfirmEdit.howMuch}"/></td>
                                        </tr>
                                        <tr>
                                            <td>Amount of crypto</td>
                                            <td><c:out value="${cryptoConfirmEdit.numOfCoins}"/></td>
                                        </tr>
                                        <tr>
                                            <td>Date</td>
                                            <td><c:out value="${cryptoConfirmEdit.whenBought}"/></td>
                                        </tr>
                                        <tr>
                                            <td>Notes</td>
                                            <td><c:out value="${cryptoConfirmEdit.notes}"/></td>
                                        </tr>
                                    </div>

                                </form:form>


                                </tbody>
                            </table>

                        </div>
                    </div>
                </div>
            </div>
            <br>
            <br>
            <br>
            <div class="no-margin-bottom">
                <small>List of all crypto?</small><a href="<c:url value="/yourCrypto"/>">Here</a>
            </div>
        </section>
    </div>
</div>

<%@ include file="../../main/footer.jsp" %>
</body>
</html>
