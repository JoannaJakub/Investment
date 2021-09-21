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
        <!-- Page Header-->
        <div class="page-header">
            <div class="list-inline-item">
                <h2 class="h4 no-margin-bottom"><a href="addCrypto"></a></h2>
            </div>

        </div>

        <section class="no-padding-top">
            <div class="container-fluid">
                <div class="col-lg-20">
                    <div class="block">
                        <div class="title"><strong>Updated details</strong></div>
                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <tbody>

                                <form:form items="${myDetailsConfirmEdit}" var="myDetailsConfirmEdit">

                                    <tr>
                                        <td>Name</td>
                                        <td><c:out value="${myDetailsConfirmEdit}"/></td>
                                    </tr>
                                    <tr>
                                        <td>Surname</td>
                                        <td><c:out value="${myDetailsConfirmEdit.lastName}"/></td>
                                    </tr>
                                    <tr>
                                        <td>Username</td>
                                        <td><c:out value="${myDetailsConfirmEdit.username}"/></td>
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
            </div>
            <div class="no-margin-bottom">
                <small>Your details? </small><a href="<c:url value="/myDetails"/>">Here</a>
            </div>
        </section>


<%@ include file="../../main/footer.jsp" %>

</body>
</html>
