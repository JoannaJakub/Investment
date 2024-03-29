<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
        <h2 class="h4 d-none d-sm-inline">Admin Dashboard</h2>
    </div>
</div>

<section class="no-padding-top">
<div class="container-fluid">
<div class="row">
    <div class="col-lg-6">

    </div>
</div>

<div class="col-lg-20">
<div class="block">
<form:form items="${changeRoleConfirm}" var="changeRoleConfirm">
    <div class="title"><strong>Role was changed for user <c:out value="${changeRoleConfirm.username}"/></strong></div>
    <div class="table-responsive">
    <table class="table table-striped table-sm">
    <tbody>
        <tr>
            <td>Role ID</td>
            <td><c:out value="${changeRoleConfirm.role.iterator().next().id}"/></td>
        </tr>
        <tr>
            <td>Role</td>
            <td><c:out value="${changeRoleConfirm.role.iterator().next().name}"/></td>
        </tr>

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
    <small>List of all users? </small><a href="<c:url value="/users"/>">Here</a>
    </div>
    </section>
    </div>
    </div>
    <%@ include file="../../main/footer.jsp" %>

    </body>
    </html>
