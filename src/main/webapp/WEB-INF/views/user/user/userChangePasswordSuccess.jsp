<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
                <div class="row">
                    <div class="col-lg-20">
                        <div class="content">
                            <div class="text-left">
                                <h1>You have changed your password successfully!</h1>
                                </br>
                                <h4><a href="<c:url value="/myDetails"/>">Click here to your details!</a></h4>
                                </br>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <%@ include file="../../main/footer.jsp" %>

</body>
</html>
