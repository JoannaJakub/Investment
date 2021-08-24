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

                <div class="col-lg-20">
                    <div class="block">
                        <div class="title"><strong>Storage</strong></div>
                        <div class="table-responsive">
                            <script>

                                const nav = new DayPilot.Navigator("nav");
                                nav.showMonths = 3;
                                nav.skipMonths = 3;
                                nav.selectMode = "week";
                                nav.onTimeRangeSelected = (args) => {
                                    dp.startDate = args.day;
                                    dp.update();
                                    dp.events.load("/api/events");
                                };
                                nav.init();


                                const dp = new DayPilot.Calendar("dp");
                                dp.viewType = "Week";
                                dp.onTimeRangeSelected = function (args) {
                                    DayPilot.Modal.prompt("Create a new event:", "Event").then(function (modal) {
                                        var dp = args.control;
                                        dp.clearSelection();
                                        if (!modal.result) {
                                            return;
                                        }
                                        var params = {
                                            start: args.start.toString(),
                                            end: args.end.toString(),
                                            text: modal.result
                                        };
                                        DayPilot.Http.ajax({
                                            url: '/api/events/create',
                                            data: params,
                                            success: function (ajax) {
                                                var data = ajax.data;
                                                dp.events.add(new DayPilot.Event(data));
                                                dp.message("Event created");
                                            }
                                        });
                                    });
                                };
                                dp.onEventMove = function (args) {
                                    var params = {
                                        id: args.e.id(),
                                        start: args.newStart.toString(),
                                        end: args.newEnd.toString()
                                    };
                                    DayPilot.Http.ajax({
                                        url: '/api/events/move',
                                        data: params,
                                        success: function (ajax) {
                                            dp.message("Event moved");
                                        }
                                    });
                                };
                                dp.onEventResize = function (args) {
                                    var params = {
                                        id: args.e.id(),
                                        start: args.newStart.toString(),
                                        end: args.newEnd.toString()
                                    };
                                    DayPilot.Http.ajax({
                                        url: '/api/events/move',
                                        data: params,
                                        success: function (ajax) {
                                            dp.message("Event resized");
                                        }
                                    });
                                };
                                dp.onBeforeEventRender = function(args) {
                                    args.data.barColor = args.data.color;
                                    args.data.areas = [
                                        { top: 2, right: 2, icon: "icon-triangle-down", visibility: "Visible", action: "ContextMenu", style: "font-size: 12px; background-color: #f9f9f9; border: 1px solid #ccc; padding: 2px 2px 0px 2px; cursor:pointer;"}
                                    ];
                                };
                                dp.contextMenu = new DayPilot.Menu({
                                    items: [
                                        {
                                            text: "Blue",
                                            icon: "icon icon-blue",
                                            color: "#1066a8",
                                            onClick: function(args) { updateColor(args.source, args.item.color); }
                                        },
                                        {
                                            text: "Green",
                                            icon: "icon icon-green",
                                            color: "#6aa84f",
                                            onClick: function(args) { updateColor(args.source, args.item.color); }
                                        },
                                        {
                                            text: "Yellow",
                                            icon: "icon icon-yellow",
                                            color: "#f1c232",
                                            onClick: function(args) { updateColor(args.source, args.item.color); }
                                        },
                                        {
                                            text: "Red",
                                            icon: "icon icon-red",
                                            color: "#cc0000",
                                            onClick: function(args) { updateColor(args.source, args.item.color); }
                                        },

                                    ]
                                });
                                dp.init();

                                dp.events.load("/api/events");


                                function updateColor(e, color) {
                                    var params = {
                                        id: e.id(),
                                        color: color
                                    };
                                    DayPilot.Http.ajax({
                                        url: '/api/events/setColor',
                                        data: params,
                                        success: function (ajax) {
                                            e.data.color = color;
                                            dp.events.update(e);
                                            dp.message("Color updated");
                                        }
                                    });
                                }

                            </script>



                        </div>
                    </div>
                </div>
            </div>
        </section>


        <%@ include file="../../main/footer.jsp" %>

</body>
</html>
