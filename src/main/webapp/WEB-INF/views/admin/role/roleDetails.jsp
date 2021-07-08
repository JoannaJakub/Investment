<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<%@ include file="../adminHead.jsp" %>
<body>
<%@ include file="../../header.jsp" %>
<div class="d-flex align-items-stretch">
    <%@ include file="../adminSideMenu.jsp" %>
    <div class="page-content">
        <div class="page-header">
            <div class="list-inline-item">
                <h2 class="h4 d-none d-sm-inline">Dashboard</h2>
            </div>
            <div class="list-inline-item">
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/addRole"/>">Add role</a></h2>
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
                        <div class="title"><strong>Role details</strong></div>
                        <div class="table-responsive">
                            <table class="table table-striped table-sm">
                                <tbody>

                                <form:form items="${adminStocksDetails}" var="adminStocksDetails">
                                    <div class="form-group-material">
                                        <label class="col-sm-3 form-control-label">Id</label>
                                        <c:out value="${adminStocksDetails.id}"/>
                                        <label class="label-material"></label>
                                    </div>
                                    <div class="form-group-material">
                                        <label class="col-sm-3 form-control-label">Bid</label>
                                        <c:out value="${adminStocksDetails.bid}"/>
                                        <label class="label-material"></label>
                                    </div>
                                    <div class="form-group-material">
                                        <div class="col-sm ml-auto">
                                            <a href="<c:url value="/roleEdit/${roleDetails.id}"/>"  class="btn btn-primary">Edit role</a>
                                        </div>
                                    </div>
                                </form:form><small>List of stocks? </small><a
                                        href="<c:url value="/adminStocks"/>">Here</a>


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
