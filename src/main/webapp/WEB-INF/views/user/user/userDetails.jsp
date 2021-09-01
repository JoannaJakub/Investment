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
            <!-- Page Header-->
            <div class="page-header">
                <div class="list-inline-item">
                    <h2 class="h4 no-margin-bottom" ><a href="addCrypto"></a></h2>
                </div>
                <div class="list-inline-item">
                    <h2 class="h4 no-margin-bottom"><a href="addStocks">Add stocks</a></h2>
                </div>
                <div class="list-inline-item">
                    <h2 class="h4 no-margin-bottom"><a href="addStorage">Add storage</a></h2>
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
                    <div class="col-lg-6">

                    </div>
                </div>

                <div class="col-lg-20">
                    <div class="block">
                        <div class="title"><strong>My details</strong></div>
                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <tbody>

                                <form:form items="${myDetails}" var="myDetails">
                                    <div class="form-group-material">
                                        <label class="col-sm-3 form-control-label">User id</label>
                                        <c:out value="${myDetails.id}"/>
                                        <label class="label-material"></label>
                                    </div>
                                    <div class="form-group-material">
                                        <label class="col-sm-3 form-control-label">Username</label>

                                        <c:out value="${myDetails.username}"/>
                                        <label class="label-material"> </label>
                                    </div>
                                    <div class="form-group-material">
                                        <label class="col-sm-3 form-control-label">Name</label>

                                        <c:out value="${myDetails.firstName}"/>
                                        <label class="label-material"></label>
                                    </div>
                                    <div class="form-group-material">
                                        <label class="col-sm-3 form-control-label">Surname</label>

                                        <c:out value="${myDetails.lastName}"/>
                                        <label class="label-material"> </label>
                                    </div>
                                    <div class="form-group-material">
                                        <label class="col-sm-3 form-control-label">Password</label>
                                        <c:out value="${userDetails.password}"/>
                                        <label f class="label-material"> </label>
                                    </div>
                                    <div class="form-group-material">
                                        <label class="col-sm-3 form-control-label">Enabled</label>
                                        <c:out value="${myDetails.enabled}"/>
                                        <label f class="label-material"> </label>
                                    </div>
                                    <div class="form-group-material">
                                        <label class="col-sm-3 form-control-label">Role</label>
                                        <a href="<c:url value="/userRole/${myDetails.role.iterator().next().id}"/>"><c:out
                                                value="${myDetails.role.iterator().next().name}"/></a>
                                        <label f class="label-material"> </label>
                                    </div>
                                    <div class="form-group-material">
                                        <div class="col-sm ml-auto">
                                            <a href="<c:url value="/myDetailsEdit"/>"
                                               class="btn btn-primary">Edit details</a>
                                        </div>
                                    </div>
                                </form:form>


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
