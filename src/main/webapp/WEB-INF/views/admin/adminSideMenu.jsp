<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav id="sidebar">
    <!-- Sidebar Header-->
    <div class="sidebar-header d-flex align-items-center">
        <div class="avatar"><img src="../resources/distribution/img/admin-icon2.png" alt="..."
                                 class="img-fluid rounded-circle"></div>
        <div class="title">
            <h1 class="h5"><c:out value="${pageContext.request.remoteUser}"/></h1>
            <p></p>
        </div>
    </div>
    <!-- Sidebar Navidation Menus--><span class="heading">Main</span>
    <ul class="list-unstyled">
        <li><a href="<c:url value="/users"/>"> <i class="icon-home"></i>Users </a></li>
        <li><a href="<c:url value="/role"/>"><i class="icon-grid"></i>Role</a></li>
        <li><a href="<c:url value="/adminStorage"/>"> <i class="fa fa-bar-chart"></i>Storage</a></li>
        <li><a href="<c:url value="/usersStorage"/>"> <i class="fa fa-bar-chart"></i>User's storage</a></li>
        <li><a href="<c:url value="/usersOwnedStocks"/>"> <i class="fa fa-bar-chart"></i>User's stocks</a></li>
        <li><a href="<c:url value="/usersOwnedCrypto"/>"> <i class="fa fa-bar-chart"></i>User's crypto</a></li>
        <li><a href="<c:url value="/adminStocks"/>"> <i class="icon-padnote"></i>All stocks </a></li>
        <li><a href="<c:url value="/adminCrypto"/>"> <i class="icon-padnote"></i>All crypto </a></li>
        <li><a href="<c:url value="/adminContact"/>"> <i class="icon-padnote"></i>Messages </a></li>
    </ul>
</nav>