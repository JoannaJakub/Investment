<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<%@ include file="../head.jsp" %>
<body>
<%@ include file="../header.jsp" %>
<div class="d-flex align-items-stretch">
    <%@ include file="adminSideMenu.jsp" %>

        <div class="page-content">
            <div class="page-header">
                <div class="list-inline-item">
                    <h2 class="h5 no-margin-bottom" ><a href="addCrypto">Add cryptocurrencies</a></h2>
                </div>
                <div class="list-inline-item">
                    <h2 class="h5 no-margin-bottom"><a href="addStocks">Add stocks</a></h2>
                </div>
                <div class="list-inline-item">
                    <h2 class="h5 no-margin-bottom"><a href="addStorage"></a></h2>
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
                                <div class="title"><strong>Add role</strong></div>
                                <div class="block-body">
                                    <form:form action="roleSuccess" class="form-horizontal" method="post" modelAttribute="role">
                                        <div class="form-group row">

                                        </div>
                                        <div class="form-group row">
                                            <label class="col-sm-3 form-control-label">Role name</label>
                                            <div class="col-sm-9">
                                                <form:hidden path="id"/>
                                                <form:input path="name" type="text" class="form-control"/>
                                                <form:errors path="name"/>
                                            </div>
                                        </div>

                                        <div class="line"></div>
                                        <div class="form-group row">
                                            <div class="col-sm-9 ml-auto">
                                                <button type="submit" class="btn btn-secondary">Cancel</button>
                                                <button type="submit" class="btn btn-primary">Add role</button>
                                            </div>
                                        </div>
                                    </form:form>

                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>



        <%@ include file="../user/footer.jsp" %>

</body>
</html>
