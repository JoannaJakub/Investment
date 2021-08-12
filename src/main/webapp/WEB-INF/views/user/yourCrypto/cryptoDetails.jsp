<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                        <div class="title"><strong>Crypto details</strong></div>
                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <tbody>

                                <form:form items="${cryptoDetails}" var="cryptoDetails">
                                    <div class="form-group-material">
                                        <label class="col-sm-3 form-control-label">Id</label>
                                        <c:out value="${cryptoDetails.id}"/>
                                        <label class="label-material"></label>
                                    </div>
                                    <div class="form-group-material">
                                        <label class="col-sm-3 form-control-label">Name</label>
                                        <c:out value="${cryptoDetails.cryptocurrencies.name}"/>
                                        <label class="label-material"> </label>
                                    </div>
                                    <div class="form-group-material">
                                        <label class="col-sm-3 form-control-label">How much</label>
                                        <c:out value="${cryptoDetails.howMuch}"/>
                                        <label class="label-material"></label>
                                    </div>
                                    <div class="form-group-material">
                                        <label class="col-sm-3 form-control-label">Amount of crypto</label>
                                        <c:out value="${cryptoDetails.numOfCoins}"/>
                                        <label class="label-material"> </label>
                                    </div>
                                    <div class="form-group-material">
                                        <label class="col-sm-3 form-control-label">Date</label>
                                        <c:out value="${cryptoDetails.whenBought}"/>
                                        <label class="label-material"> </label>
                                    </div>
                                    <div class="form-group-material">
                                        <label class="col-sm-3 form-control-label">Notes</label>
                                        <c:out value="${cryptoDetails.notes}"/>
                                        <label class="label-material"> </label>
                                    </div>
                                    <div class="form-group-material">
                                        <label class="col-sm-3 form-control-label">Max price</label>
                                        <c:out value="${cryptoDetails.cryptocurrencies.priceMax}"/>
                                        <label class="label-material"> </label>
                                    </div>
                                    <div class="form-group-material">
                                        <label class="col-sm-3 form-control-label">Min price</label>
                                        <c:out value="${cryptoDetails.cryptocurrencies.priceMin}"/>
                                        <label class="label-material"> </label>
                                    </div>
                                    <div class="form-group-material">
                                        <label class="col-sm-3 form-control-label">Aux</label>
                                        <c:out value="${cryptoDetails.cryptocurrencies.aux}"/>
                                        <label class="label-material"> </label>
                                    </div>
                                    <div class="form-group-material">
                                        <label class="col-sm-3 form-control-label">Storage</label>
                                        <c:out value="${cryptoDetails.storage.name}"/>
                                        <label class="label-material"> </label>
                                    </div>
                                    <div class="form-group-material">
                                        <div class="col-sm ml-auto">
                                            <a href="<c:url value="/cryptoEdit/${cryptoDetails.id}"/>"
                                               class="btn btn-primary">Edit crypto</a>
                                        </div>
                                    </div>
                                </form:form><small>List of all your crypto? </small><a
                                        href="<c:url value="/yourCrypto"/>">Here</a>
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
