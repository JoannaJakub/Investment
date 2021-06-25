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
                <h2 class="h4 d-none d-sm-inline">Dashboard</h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/addStorage"/>">Add storage</a></h2>
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
                        <div class="title"><strong>Storage</strong></div>
                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <tbody>
                                <div></div>
                                <form:form method="post" modelAttribute="storageEdit">
                                    <div class="form-group-material">ID:
                                        <c:out value="${id}"/>
                                        <label for="name" class="label-material"></label>
                                    </div>
                                    <div class="form-group-material">
                                        <form:input id="name" type="text" name="name" path="name"
                                                    placeholder="Name" data-msg="Please enter name"
                                                    class="input-material"/>
                                        <form:errors path="name"/>
                                        <label for="name" class="label-material"></label>
                                    </div>
                                    <div class="form-group-material">
                                        <form:input id="link" type="text" name="name" path="link"
                                                    placeholder="Link" data-msg="Please enter link"
                                                    class="input-material"/>
                                        <form:errors path="link"/>
                                        <label for="link" class="label-material"></label>
                                    </div>
                                    <div class="form-group text-center">
                                        <input id="register" type="submit" value="Update" class="btn btn-primary">
                                    </div>
                                </form:form><small>List of all storage? </small><a href="<c:url value="/storage"/>">Here</a>
                                </tbody>
                            </table>
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
