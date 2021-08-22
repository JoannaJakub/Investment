<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en"><%@ include file="../head.jsp" %>
<body>
<%@ include file="header.jsp" %>
<div class="d-flex align-items-stretch">
    <%@ include file="sideMenu.jsp" %>



        <div class="page-content">
            <div class="page-header">
                <div class="list-inline-item">
                    <h2 class="h4 d-none d-sm-inline"></h2>
                </div>
                <div class="list-inline-item">
                    <h2 class="h4 no-margin-bottom"><a href="<c:url value="/addRole"/>"></a></h2>
                </div>
            </div>

            <section class="no-padding-top">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-lg-6">

                        </div>
                    </div>

                    <div class="page-content">

                    <div class="container-fluid">
                <div class="row">
                    <!-- Form Elements -->
                    <div class="col-lg-12">
                        <div class="block">
                            <div class="title"><strong>There is nothing to display!</strong></div>
                            </div>
                        </div>
                    </div>
                </div>
        </section>
    </div>
</div>




        <%@ include file="footer.jsp" %>

</body>
</html>