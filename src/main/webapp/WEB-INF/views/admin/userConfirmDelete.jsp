<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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

        <section class="login-page">
            <h2>Czy jesteś pewien usunięcia użytkownika?</h2>
            <tbody>
            <table class="btn btn--without-border active">
                <tr>
                    <td>
                        <a href="<c:url value="/admin"/>" class="btn btn--without-active">NIE</a>
                    </td>
                    <td>
                        <a href="<c:url value="/userDelete/${param.id}"/>" class="btn btn--without-active">TAK</a>
                    </td>
                </tr>
                </tbody>
            </table>
        </section>


        <%@ include file="../user/footer.jsp" %>

</body>
</html>
