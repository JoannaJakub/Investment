<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en"><%@ include file="../../head.jsp" %>
<body>
<%@ include file="../adminHeader.jsp" %>
<div class="d-flex align-items-stretch">
    <%@ include file="../adminSideMenu.jsp" %>

    <div class="page-content">
        <div class="page-header">
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/adminAddCrypto"/>">Add cryptocurrencies</a></h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/adminAddStocks"/>">Add stocks</a></h2>
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
                            <div class="title"><strong>Add storage</strong></div>
                            <div class="block-body">
                                <form:form action="adminStorageSuccess" class="form-horizontal" method="post"
                                           modelAttribute="adminAddStorage">
                                    <div class="form-group row">
                                        <label class="col-sm-3 form-control-label">Storage name</label>
                                        <div class="col-sm-9">
                                            <form:hidden path="id"/>
                                            <form:input path="name" type="text" class="form-control"/>
                                            <form:errors path="name"/>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-3 form-control-label">Storage link</label>
                                        <div class="col-sm-9">
                                            <form:input path="link" type="text" class="form-control"/>
                                            <form:errors path="link"/>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <div class="col-sm-9 ml-auto">
                                            <a href="<c:url value="/adminStorage"/>"
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
<%@ include file="../../main/footer.jsp" %>
</body>
</html>
