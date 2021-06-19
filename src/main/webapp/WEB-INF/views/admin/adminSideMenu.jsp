<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav id="sidebar">
    <!-- Sidebar Header-->
    <div class="sidebar-header d-flex align-items-center">
        <div class="avatar"><img src="resources/distribution/img/avatar-6.jpg" alt="..."
                                 class="img-fluid rounded-circle"></div>
        <div class="title">

            <h1 class="h5">Your name</h1>
            <p></p>
        </div>
    </div>
    <!-- Sidebar Navidation Menus--><span class="heading">Main</span>
    <ul class="list-unstyled">
        <li class="active"><a href="<c:url value="/users"/>"> <i class="icon-home"></i>Users </a></li>
        <li><a href="<c:url value="/role"/>"><i class="icon-grid"></i>Role</a></li>
        <li><a href="<c:url value="/users"/>"> <i class="fa fa-bar-chart"></i>Storage</a></li>
        <li><a href="<c:url value="/users"/>"> <i class="icon-padnote"></i>All stocks </a></li>
        <li><a href="<c:url value="/users"/>"> <i class="icon-padnote"></i>All crypto </a></li>
    </ul>
</nav>