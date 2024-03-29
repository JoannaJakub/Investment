<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <div class="title"><strong>Storage</strong></div>
                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Link</th>
                                    <th>Details</th>
                                </tr>
                                </thead>
                                <tbody>

                                <c:forEach items="${storage}" var="storage">
                                    <tr>
                                        <td><c:out value="${storage.id}"/></td>
                                        <td><c:out value="${storage.name}"/></td>
                                        <td><c:out value="${storage.link}"/></td>
                                        <td><a href="<c:url value="/storageDetails/${storage.id}"/>">Details</a></td>
                                    </tr>
                                </c:forEach>

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