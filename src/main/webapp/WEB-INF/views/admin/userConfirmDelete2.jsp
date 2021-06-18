<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<%@ include file="../head.jsp" %>
<body>
<%@ include file="../header.jsp" %>
<div class="d-flex align-items-stretch">
    <%@ include file="adminSideMenu.jsp" %>
        <div class="page-content">
            <div class="page-header">
                <div class="list-inline-item">
                    <h2 class="h4 d-none d-sm-inline">Dashboard</h2>
                </div>
                <div class="list-inline-item">
                    <h2 class="h5 no-margin-bottom"><a href="addStorage">Add storage</a></h2>
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
                                <h2>Czy jesteś pewien usunięcia użytkownika?</h2>
                                <tbody>
                                <tr>
                                    <td>
                                        <a href="<c:url value="/users"/>" class="btn btn--without-active">NIE</a>
                                    </td>
                                    <td>
                                        <a href="<c:url value="/userDelete/${param.id}"/>"
                                           class="btn btn--without-active">TAK</a>
                                    </td>
                                </tr>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>


        <%@ include file="../user/footer.jsp" %>

</body>
</html>
