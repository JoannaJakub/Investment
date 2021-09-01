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
        <section class="no-padding-top">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-6">

                    </div>
                </div>

                <div class="col-lg-20">
                    <div class="block">
                        <div class="title"><strong>Storage</strong></div>
                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <tbody>

                                <form:form items="${myDetailsConfirmEdit}" var="myDetailsConfirmEdit">

                                    <tr>
                                        <td>ID</td>
                                        <td><c:out value="${id}"/></td>
                                    </tr>
                                    <tr>
                                        <td>Name</td>
                                        <td><c:out value="${myDetailsConfirmEdit.firstName}"/></td>
                                    </tr>
                                    <tr>
                                        <td>Surname</td>
                                        <td><c:out value="${myDetailsConfirmEdit.lastName}"/></td>
                                    </tr>

                                    <tr>
                                        <td>Password</td>
                                        <td><c:out value="${myDetailsConfirmEdit.password}"/></td>
                                    </tr>
                                    <div class="form-group text-center">
                                        <input id="register" type="submit" value="Add" class="btn btn-primary">
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
            </div>
        </section>
    </div>
</div>
<%@ include file="../../main/footer.jsp" %>

</body>
</html>
