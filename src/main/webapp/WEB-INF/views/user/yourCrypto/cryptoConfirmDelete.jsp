<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<%@ include file="../../head.jsp" %>
<body>
<%@ include file="../header.jsp" %>
<div class="d-flex align-items-stretch">
    <%@ include file="../sideMenu.jsp" %>

    <div class="page-content">
        <div class="page-header">
            <div class="list-inline-item">
                <h2 class="h4 no-margin-bottom"><a href="<c:url value="/addCrypto"/>">Add crypto</a></h2>
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
                                <h1>Are you sure of removing crypto?</h1>
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
                    <a href="<c:url value="/yourCrypto"/>"
                       class="btn btn-secondary">NO</a>
                    <a href="<c:url value="/cryptoDelete/${param.id}"/>"
                       class="btn btn-primary">YES, delete crypto</a>
                </div>
            </div>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <div class="no-margin-bottom">
                <small>List of all crypto? </small><a href="<c:url value="/yourCrypto"/>">Here</a>
            </div>

        </section>
    </div>
</div>
<%@ include file="../footer.jsp" %>

</body>
</html>
