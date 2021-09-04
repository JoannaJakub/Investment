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
        <!-- Page Header-->
        <div class="page-header">
            <div class="list-inline-item">
                <h2 class="h4 no-margin-bottom"><a href="addCrypto"></a></h2>
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
                        <div class="title"><strong>Edit user</strong></div>
                        <div class="block-body">
                            <form:form method="post" modelAttribute="myDetailsEdit">
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Name</label>
                                    <div class="col-sm-9">
                                        <form:input type="hidden" path="id"/>
                                        <form:input type="hidden" path="role"/>
                                        <form:input type="hidden" path="password"/>
                                        <form:input id="firstName" type="text" name="firstName" path="firstName"
                                                    placeholder="Name" data-msg="Please enter your name"
                                                    class="input-material"/>
                                        <form:errors path="firstName"/></div>
                                    <label for="firstName" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Surname</label>
                                    <div class="col-sm-9">
                                        <form:input id="register-surname" type="text" name="registerSurname"
                                                    path="lastName" placeholder="Surname"
                                                    data-msg="Please enter your surname" class="input-material"/>
                                        <form:errors path="lastName"/></div>
                                    <label for="firstName" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Username</label>
                                    <div class="col-sm-9">
                                        <form:input id="register-username" type="text" name="registerUsername"
                                                    path="username" placeholder="Email"
                                                    data-msg="Please enter a valid email address"
                                                    class="input-material"/>
                                        <form:errors path="username"/></div>
                                    <label for="firstName" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Password</label>
                                    <div class="col-sm-9">
                                        <a href="<c:url value="/userChangePassword"/>"
                                           class="btn btn-primary">Change Password</a>
                                    <label for="firstName" class="label-material"></label>
                                </div>
                                <div class="form-group text-center">
                                    <a href="<c:url value="/myDetails"/>"
                                       class="btn btn-secondary">Cancel</a>
                                    <input id="register" type="submit" value="Update" class="btn btn-primary">
                                </div>
                            </form:form>

                        </div>
                    </div>
                </div>
            </div>

        </section>


        <%@ include file="../../main/footer.jsp" %>

</body>
</html>
