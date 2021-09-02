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
        <div class="page-header">
            <div class="list-inline-item">
                <h2 class="h4 d-none d-sm-inline">Admin dashboard</h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/addContact"/>">Send message</a></h2>
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
                        <div class="title"><strong>Edit message</strong></div>

                        <form:form method="post" modelAttribute="contactEdit">
                            <form:input type="hidden" path="id"/>
                            <div class="form-group row">
                                <label class="col-sm-3 form-control-label">Message</label>
                                <div class="col-sm-9">

                                    <form:input id="message" type="text" name="message" path="message"
                                                placeholder="Name" data-msg="Please enter name"
                                                class="form-control"/>
                                    <form:errors path="message"/></div>
                                <label for="message" class="label-material"></label>
                            </div>
                            <div class="form-group text-center">
                                <a href="<c:url value="/yourContact"/>"
                                   class="btn btn-secondary">Cancel</a>
                                <input id="register" type="submit" value="Update" class="btn btn-primary">
                            </div>
                        </form:form>
                        <small>List of all messages? </small><a href="<c:url value="/yourContact"/>">Here</a>

                    </div>
                </div>
            </div>
        </section>
    </div>
</div>



    <%@ include file="../footer.jsp" %>
</body>
</html>
