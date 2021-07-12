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
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/adminAddStocks"/>">Add stocks</a></h2>
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
                        <div class="title"><strong>Edit stock</strong></div>
                        <div class="block-body">
                            <form:form method="post" modelAttribute="adminStocksEdit">
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Id</label>
                                    <div class="col-sm-9">
                                        <c:out value="${id}"/></div>
                                    <label for="name" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Bid</label>
                                    <div class="col-sm-9">
                                        <form:input id="bid" type="text" name="bid" path="bid"
                                                    placeholder="bid" data-msg="Please enter name"
                                                    class="form-control"/>
                                        <form:errors path="bid"/></div>
                                    <label for="bid" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Storage link</label>
                                    <div class="col-sm-9">
                                        <form:input id="change" type="text" name="name" path="change"
                                                    placeholder="Change" data-msg="Please enter change"
                                                    class="form-control"/>
                                        <form:errors path="change"/>
                                    </div>
                                    <label for="change" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Storage link</label>
                                    <div class="col-sm-9">
                                        <form:input id="currency" type="text" name="currency" path="currency"
                                                    placeholder="Currency" data-msg="Please enter currency"
                                                    class="form-control"/>
                                        <form:errors path="currency"/>
                                    </div>
                                    <label for="change" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Storage link</label>
                                    <div class="col-sm-9">
                                        <form:input id="name" type="text" name="name" path="name"
                                                    placeholder="Name" data-msg="Please enter name"
                                                    class="form-control"/>
                                        <form:errors path="name"/>
                                    </div>
                                    <label for="change" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Storage link</label>
                                    <div class="col-sm-9">
                                        <form:input id="price" type="text" name="price" path="price"
                                                    placeholder="Price" data-msg="Please enter price"
                                                    class="form-control"/>
                                        <form:errors path="price"/>
                                    </div>
                                    <label for="change" class="label-material"></label>
                                </div>
                                <div class="form-group text-center">
                                    <a href="<c:url value="/adminStocks"/>"
                                       class="btn btn-secondary">Cancel</a>
                                    <input id="register" type="submit" value="Update" class="btn btn-primary">
                                </div>
                            </form:form><small>List of all stocks? </small><a href="<c:url value="/adminStocks"/>">Here</a>

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
