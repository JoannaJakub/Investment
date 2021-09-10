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
                <h2 class="h4 no-margin-bottom"><a href="<c:url value="/addStorage"/>">Add storage</a></h2>
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
                        <div class="title"><strong>Storage details</strong></div>
                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <tbody>

                                <form:form items="${storageDetails}" var="storageDetails">
                                    <div class="form-group-material">
                                        <label class="col-sm-3 form-control-label">Id</label>
                                        <c:out value="${storageDetails.id}"/>
                                        <label class="label-material"></label>
                                    </div>
                                    <div class="form-group-material">
                                        <label class="col-sm-3 form-control-label">Name</label>
                                        <c:out value="${storageDetails.name}"/>
                                        <label class="label-material"> </label>
                                    </div>
                                    <div class="form-group-material">
                                        <label class="col-sm-3 form-control-label">Link</label>
                                        <c:out value="${storageDetails.link}"/>
                                        <label class="label-material"></label>
                                    </div>
                                </form:form><small>List of all your storage? </small><a
                                        href="<c:url value="/yourStorage"/>">Here</a>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>

<%@ include file="../footer.jsp" %>
    </div>
</div>
</body>
</html>
