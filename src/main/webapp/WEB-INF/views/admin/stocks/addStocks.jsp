<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<%@ include file="../../head.jsp" %>

<body>
<%@ include file="../../header.jsp" %>
<div class="d-flex align-items-stretch">
    <%@ include file="../adminSideMenu.jsp" %>

    <div class="page-content">
        <div class="page-header">
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/adminAddStorage"/>">Add cryptocurrencies</a>
                </h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/adminAddStocks"/>">Add stocks</a></h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/adminAddStorage"/>">Add stocks</a></h2>
            </div>
        </div>
        <!-- Breadcrumb-->
        <div class="container-fluid">
            <ul class="breadcrumb">
                <li class="breadcrumb-item"><a href=>Fill in form</a></li>
            </ul>
        </div>


        <section class="no-padding-top">
            <div class="container-fluid">
                <div class="row">
                    <!-- Form Elements -->
                    <div class="col-lg-12">
                        <div class="block">
                            <div class="title"><strong>Add stock</strong></div>
                            <div class="block-body">
                                <form:form action="adminStocksSuccess" class="form-horizontal" method="post"
                                           modelAttribute="adminAddStocks">
                                    <div class="form-group row">
                                        <label class="col-sm-3 form-control-label">Bid</label>
                                        <div class="col-sm-9">
                                            <form:hidden path="id"/>
                                            <form:input path="bid" type="text" class="form-control"/>
                                            <form:errors path="bid"/>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-3 form-control-label">Change</label>
                                        <div class="col-sm-9">
                                            <form:input path="change" type="text" class="form-control"/>
                                            <form:errors path="change"/>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-3 form-control-label">Currency</label>
                                        <div class="col-sm-9">
                                            <form:input path="currency" type="text" class="form-control"/>
                                            <form:errors path="currency"/>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-3 form-control-label">Name</label>
                                        <div class="col-sm-9">
                                            <form:input path="name" type="text" class="form-control"/>
                                            <form:errors path="name"/>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-3 form-control-label">Price</label>
                                        <div class="col-sm-9">
                                            <form:input path="price" type="text" class="form-control"/>
                                            <form:errors path="price"/>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-9 ml-auto">
                                            <a href="<c:url value="/adminStocks"/>"
                                               class="btn btn-secondary">Cancel</a>
                                            <button type="submit" class="btn btn-primary">Save changes</button>
                                        </div>
                                    </div>
                                </form:form>

                            </div>
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
