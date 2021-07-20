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
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/adminAddStocks"/>">Add stocks</a></h2>
            </div>
        </div>
        <!-- Breadcrumb-->
        <div class="container-fluid">

        </div>

        <section class="no-padding-top">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-20">
                        <div class="content">
                            <div class="text">
                                <h1>Are you sure of removing stocks?</h1>
                                </br>
                                </br>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="line"></div>
            <div class="form-group row">
                <div class="col-sm-9 ml-auto">
                    <a href="<c:url value="/usersStocks"/>"
                       class="btn btn-secondary">NO</a>
                    <a href="<c:url value="/adminUsersStocksDelete/${param.id}"/>"
                       class="btn btn-primary">YES, delete user's stocks</a>
                </div>
            </div>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <div class="no-margin-bottom">
                <small>List of storage? </small><a href="<c:url value="/usersStocks"/>">Here</a>
            </div>

        </section>
    </div>
</div>
<%@ include file="../../main/footer.jsp" %>

</body>
</html>
