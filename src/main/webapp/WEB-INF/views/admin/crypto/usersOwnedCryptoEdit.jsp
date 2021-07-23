<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<%@ include file="../adminHead.jsp" %>
<body>
<%@ include file="../adminHeader.jsp" %>
<div class="d-flex align-items-stretch">
    <%@ include file="../adminSideMenu.jsp" %>
    <div class="page-content">
        <div class="page-header">
            <div class="list-inline-item">
                <h2 class="h4 d-none d-sm-inline">Admin dashboard</h2>
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

                <div class="col-lg-12">
                    <div class="block">
                        <div class="title"><strong>Edit crypto</strong></div>
                        <div class="block-body">
                            <form:form method="post" modelAttribute="adminUsersCryptoEdit">
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Id</label>
                                    <div class="col-sm-9">
                                        <c:out value="${id}"/></div>
                                    <form:hidden path="user" value="${user.id}"/>
                                    <form:hidden path="storage" value="${storage.id}"/>
                                    <form:hidden path="cryptocurrencies" value="${stocks.id}"/>
                                    <label for="id" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Price</label>
                                    <div class="col-sm-9">
                                        <form:input id="howMuch" type="text" name="howMuch" path="howMuch"
                                                    placeholder="howMuch" data-msg="Please enter name"
                                                    class="form-control"/>
                                        <form:errors path="howMuch"/></div>
                                    <label for="howMuch" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Amount of stocks</label>
                                    <div class="col-sm-9">
                                        <form:input id="numOfCoins" type="text" name="numOfCoins" path="numOfCoins"
                                                    placeholder="numOfCoins" data-msg="Please enter numOfCoins"
                                                    class="form-control"/>
                                        <form:errors path="numOfCoins"/>
                                    </div>
                                    <label for="numOfCoins" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Date</label>
                                    <div class="col-sm-9">
                                        <form:input id="whenBought" type="text" name="whenBought" path="whenBought"
                                                    placeholder="whenBought" data-msg="Please enter currency"
                                                    class="form-control"/>
                                        <form:errors path="whenBought"/>
                                    </div>
                                    <label for="whenBought" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Notes</label>
                                    <div class="col-sm-9">
                                        <form:input id="notes" type="text" name="notes" path="notes"
                                                    placeholder="Name" data-msg="Please enter name"
                                                    class="form-control"/>
                                        <form:errors path="notes"/>
                                    </div>
                                    <label for="notes" class="label-material"></label>
                                </div>
                                <div class="form-group text-center">
                                    <a href="<c:url value="/usersOwnedCrypto"/>"
                                       class="btn btn-secondary">Cancel</a>
                                    <input id="register" type="submit" value="Update" class="btn btn-primary">
                                </div>
                            </form:form><small>List of all crypto of users? </small><a href="<c:url value="/usersOwnedCrypto"/>">Here</a>

                        </div>
                    </div>
                </div>
            </div>

        </section>

    </div>
</div>
<%@ include file="../../main/footer.jsp" %>
</body>
</html>
