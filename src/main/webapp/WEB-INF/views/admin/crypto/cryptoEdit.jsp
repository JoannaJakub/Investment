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
<%@ include file="../../header.jsp" %>
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
                            <form:form method="post" modelAttribute="adminCryptoEdit">
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Id</label>
                                    <div class="col-sm-9">
                                        <c:out value="${id}"/></div>
                                    <label for="name" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Bid</label>
                                    <div class="col-sm-9">
                                        <form:input id="aux" type="text" name="aux" path="aux"
                                                    placeholder="aux" data-msg="Please enter aux"
                                                    class="form-control"/>
                                        <form:errors path="aux"/></div>
                                    <label for="aux" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Cmc rank</label>
                                    <div class="col-sm-9">
                                        <form:input id="cmc_rank" type="text" name="cmc_rank" path="cmc_rank"
                                                    placeholder="cmc_rank" data-msg="Please enter cmc_rank"
                                                    class="form-control"/>
                                        <form:errors path="cmc_rank"/>
                                    </div>
                                    <label for="cmc_rank" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Limit</label>
                                    <div class="col-sm-9">
                                        <form:input id="limit" type="text" name="limit" path="limit"
                                                    placeholder="limit" data-msg="Please enter limit"
                                                    class="form-control"/>
                                        <form:errors path="limit"/>
                                    </div>
                                    <label for="limit" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Storage link</label>
                                    <div class="col-sm-9">
                                        <form:input id="name" type="text" name="name" path="name"
                                                    placeholder="Name" data-msg="Please enter name"
                                                    class="form-control"/>
                                        <form:errors path="name"/>
                                    </div>
                                    <label for="name" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Storage link</label>
                                    <div class="col-sm-9">
                                        <form:input id="priceMax" type="text" name="priceMax" path="priceMax"
                                                    placeholder="priceMax" data-msg="Please enter max price"
                                                    class="form-control"/>
                                        <form:errors path="priceMax"/>
                                    </div>
                                    <label for="priceMax" class="label-material"></label>
                                </div>
                                <div class="form-group text-center">
                                    <a href="<c:url value="/adminCrypto"/>"
                                       class="btn btn-secondary">Cancel</a>
                                    <input id="register" type="submit" value="Update" class="btn btn-primary">
                                </div>
                            </form:form><small>List of all crypto? </small><a href="<c:url value="/adminCrypto"/>">Here</a>

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
