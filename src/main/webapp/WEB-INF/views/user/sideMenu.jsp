<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<nav id="sidebar">
    <!-- Sidebar Header-->
    <div class="sidebar-header d-flex align-items-center">
        <div class="avatar"><img src="../resources/distribution/img/user-icon.png" alt="..."
                                 class="img-fluid rounded-circle"></div>
        <div class="title">

            <h1 class="h5"><c:out value="${pageContext.request.remoteUser}"/></h1>
            <p></p>
        </div>
    </div>
    <!-- Sidebar Navidation Menus--><span class="heading">Main</span>
    <ul class="list-unstyled">
        <li class="active"><a href="<c:url value="/dashboard"/>"> <i class="icon-home"></i>Home </a></li>
        <li><a href="<c:url value="/yourStocks"/>"> <i class="icon-grid"></i>Your stocks </a></li>
        <li><a href="<c:url value="/yourCrypto"/>"><i class="fa fa-bar-chart"></i>Your crypto </a></li>
        <li><a href="<c:url value="/yourStorage"/>"><i class="icon-padnote"></i>Your storage </a></li>
        <li><a href="<c:url value="/storage"/>"><i class="icon-padnote"></i>All storage </a></li>
        <li><a href="<c:url value="/allStocks"/>"><i class="icon-padnote"></i>All stocks </a></li>
        <li><a href="<c:url value="/allCrypto"/>"><i class="icon-padnote"></i>All crypto </a></li>
        <li><a href="<c:url value="/yourContact"/>"><i class="icon-padnote"></i>Your messages</a></li>
    </ul>
</nav>
</nav>