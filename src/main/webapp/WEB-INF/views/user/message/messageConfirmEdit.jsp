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
                        <div class="title"><strong>Message has been updated!</strong></div>
                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <tbody>
                                <form:form items="${messageConfirmEdit}" var="messageConfirmEdit">
                                    <div>
                                        <tr>
                                            <td><c:out value="${id}"/></td>

                                            <td>Message</td>
                                            <td><c:out value="${messageConfirmEdit.message}"/></td>
                                        </tr>
                                        <tr>
                                            <td>Date</td>
                                            <td><c:out value="${messageConfirmEdit.updateDate}"/></td>
                                        </tr>
                                    </div>
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
                <small>List of all messages? </small><a href="<c:url value="/yourMessage"/>">Here</a>
            </div>
        </section>
        <%@ include file="../footer.jsp" %>
</body>
</html>
