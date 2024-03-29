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
                        <div class="title"><strong>Change password</strong></div>
                        <div class="block-body">
                            <form:form method="post" modelAttribute="userChangePassword">

                            <div class="form-group row">
                                <label class="col-sm-3 form-control-label">Password</label>
                                <div class="col-sm-9">
                                    <form:input id="password" type="password" name="Password"
                                                path="password" placeholder="Password"
                                                data-msg="Please enter your password" class="input-material"/>
                                    <form:errors path="password"/></div>
                                <label for="password" class="label-material"></label>

                                <label class="col-sm-3 form-control-label">Confirm password</label>
                                <div class="col-sm-9">
                                    <form:input id="passwordConfirm" type="password" name="passwordConfirm"
                                                path="passwordConfirm"
                                                data-msg="Please enter your password" class="input-material"/>
                                    <form:errors path="passwordConfirm"/>
                                    <label for="passwordConfirm" class="label-material"> </label>
                                </div>
                            </div>
                                <div class="form-group text-center">
                                    <a href="<c:url value="/myDetailsEdit"/>"
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
