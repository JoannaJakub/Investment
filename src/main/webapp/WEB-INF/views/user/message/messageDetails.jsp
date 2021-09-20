<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en"><%@ include file="../../head.jsp" %>
<body>
<%@ include file="../header.jsp" %>
<div class="d-flex align-items-stretch">
    <%@ include file="../sideMenu.jsp" %>
    <div class="page-content">
        <div class="page-header">

            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/addMessage"/>">Send message</a></h2>
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
                        <div class="title"><strong>Message details</strong></div>
                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <tbody>

                                <form:form items="${messageDetails}" var="messageDetails">
                                    <div class="form-group-material">
                                        <label class="col-sm-3 form-control-label">Message id</label>
                                        <c:out value="${messageDetails.id}"/>
                                        <label class="label-material"></label>
                                    </div>
                                    <div class="form-group-material">
                                        <label class="col-sm-3 form-control-label">Message</label>
                                        <c:out value="${messageDetails.messanger}"/>
                                        <label class="label-material"></label>
                                    </div>
                                    <div class="form-group-material">
                                        <label class="col-sm-3 form-control-label">Date</label>
                                        <c:out value="${messageDetails.updateDate}"/>
                                        <label class="label-material"> </label>
                                    </div>
                                    <div class="form-group-material">
                                        <div class="col-sm ml-auto">
                                            <a href="<c:url value="/messageEdit/${messageDetails.id}"/>"
                                               class="btn btn-primary">Edit message</a>
                                        </div>
                                    </div>
                                </form:form>
                                <small>List of your messages? </small><a
                                        href="<c:url value="/yourMessage"/>">Here</a>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>

<%@ include file="../footer.jsp" %>
</body>
</html>
