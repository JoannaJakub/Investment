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
<%@ include file="../../header.jsp" %>
<div class="d-flex align-items-stretch">
    <%@ include file="../adminSideMenu.jsp" %>
    <div class="page-content">
        <div class="page-header">
            <div class="list-inline-item">
                <h2 class="h4 d-none d-sm-inline">Admin dashboard</h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/adminAddContact"/>">Send message</a></h2>
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
                        <div class="title"><strong>Edit storage</strong></div>
                        <div class="block-body">
                            <form:form method="post" modelAttribute="adminContactEdit">
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Contact id</label>
                                    <div class="col-sm-9">
                                        <c:out value="${id}"/></div>
                                    <label for="name" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Contact message</label>
                                    <div class="col-sm-9">
                                        <form:input id="message" type="text" name="message" path="message"
                                                    placeholder="message" data-msg="Please enter your message"
                                                    class="form-control"/>
                                        <form:errors path="message"/></div>
                                    <label for="message" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">Contact date</label>
                                    <div class="col-sm-9">
                                        <form:input id="updateDate" type="text" name="updateDate" path="updateDate"
                                                    placeholder="Date" data-msg="Please enter date"
                                                    class="form-control"/>
                                        <form:errors path="updateDate"/>
                                    </div>
                                    <label for="updateDate" class="label-material"></label>
                                </div>
                                <div class="form-group row">
                                    <label class="col-sm-3 form-control-label">User id</label>
                                    <div class="col-sm-9">
                                        <form:input id="user" type="text" name="user" path="user"
                                                    placeholder="User id" data-msg="Please enter user id"
                                                    class="form-control"/>
                                        <form:errors path="user"/>
                                    </div>
                                    <label for="updateDate" class="label-material"></label>
                                </div>
                                <div class="form-group text-center">
                                    <a href="<c:url value="/adminContact"/>"
                                       class="btn btn-secondary">Cancel</a>
                                    <input id="register" type="submit" value="Update" class="btn btn-primary">
                                </div>
                            </form:form><small>List of all storage? </small><a href="<c:url value="/adminContact"/>">Here</a>

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
