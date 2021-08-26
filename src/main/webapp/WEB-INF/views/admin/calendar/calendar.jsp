<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en"><%@ include file="../../head.jsp" %>

<body>
<%@ include file="../adminHeader.jsp" %>
<div class="d-flex align-items-stretch">
    <%@ include file="../adminSideMenu.jsp" %>

    <div class="page-content">
        <div class="page-header">
            <div class="list-inline-item">
                <h2 class="h4 d-none d-sm-inline">Admin Dashboard</h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/adminRegister"/>">Add user</a></h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/usersAdminRole/2"/>">Admin role</a></h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="usersUserRole/1"/>">User role</a></h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/adminUsers/export/excel"/>">Export to Excel</a></h2>
            </div>
        </div>
        <div id="dp"></div>

        <!-- DayPilot Pro library-->
        <script src="resources/distribution/js/daypilot-all.min.js"></script>

        <!-- basic calendar config -->

        <section class="no-padding-top">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-6">

                    </div>
                </div>

                <script type="text/javascript" src="resources/distribution/js/jquery-1.3.2.min.js"></script>
                <script type="text/javascript" src="resources/distribution/js/daypilot/common.js"></script>
                <script type="text/javascript" src="$resources/distribution/js/daypilot/calendar.js"></script>
                <div id="dpc"></div>

                <script type="text/javascript">

                    $(document).ready(function() {
                        var dpc = $("#dpc").daypilotCalendar({
                            backendUrl : '${pageContext.request.contextPath}/dpc',
                            viewType : "Week"
                        });
                    });

                </script>
                    </div>

        </section>

        <%@ include file="../../main/footer.jsp" %>

</body>
</html>
