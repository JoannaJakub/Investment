<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<%@ include file="../../head.jsp" %>

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
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/adminAddEvent"/>">Add event</a></h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/calendar"/>">Export to Excel</a></h2>
            </div>
        </div>
        <script type="text/javascript" src="resources/distribution/js/jquery-1.3.2.min.js"></script>
        <script type="text/javascript" src="resources/distribution/js/common.js"></script>
        <script type="text/javascript" src="resources/distribution/js/calendar.js"></script>
        <div id="dp"></div>
        <script type="text/javascript">

            $(document).ready(function() {
                var dpc = $("#dpc").daypilotCalendar({
                    backendUrl : '${pageContext.request.contextPath}/dpc',
                    viewType : "Week"
                });
            });

        </script>
        <!-- DayPilot Pro library-->
        <script src="resources/distribution/js/daypilot-all.min.js"></script>

        <!-- basic calendar config -->

        <section class="no-padding-top">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-6">

                    </div>
                </div>

                <div class="col-lg-20">
                    <div class="block">
                        <div class="title"><strong>Calendar</strong></div>
                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Title</th>
                                    <th>Start</th>
                                    <th>End</th>
                                    <th>Description</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${event}" var="event">
                                    <tr>
                                        <td><c:out value="${event.id}"/></td>
                                        <td><c:out value="${event.title}"/></td>
                                        <td><c:out value="${event.start}"/></td>
                                        <td><c:out value="${event.end}"/></td>
                                        <td><c:out value="${event.description}"/></td>

                                        <td><a href="<c:url value="/adminEventConfirmDelete/?id=${event.id}"/>">Delete</a></td>
                                        <td><a href="<c:url value="/adminEventEdit/${event.id}"/>">Edit</a></td>
                                        <td><a href="<c:url value="/adminEventDetails/${event.id}"/>">Details</a></td>

                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <%@ include file="../../main/footer.jsp" %>

</body>
</html>
