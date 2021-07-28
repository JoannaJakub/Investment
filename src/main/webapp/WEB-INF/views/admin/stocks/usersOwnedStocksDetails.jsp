<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<%@ include file="../adminHead.jsp" %>
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
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/adminAddStocks"/>">Add stocks</a></h2>
            </div>
        </div>

        <section class="no-padding-top">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-6">

                    </div>
                </div>

                <div class="col-lg-12">
                    <div class="block">
                        <div class="title"><strong>Edit user's stock</strong></div>
                        <div class="block-body">
                            <form:form items="${adminUsersStocksDetails}" var="adminUsersStocksDetails">
                                <div class="form-group-material">
                                    <label class="col-sm-3 form-control-label">Name of user</label>
                                    <c:out value="${adminUsersStocksDetails.user.username}"/>
                                    <label class="label-material"></label>
                                </div>
                                <div class="form-group-material">
                                    <label class="col-sm-3 form-control-label">Id</label>
                                    <c:out value="${adminUsersStocksDetails.id}"/>
                                    <label class="label-material"></label>
                                </div>
                                <div class="form-group-material">
                                    <label class="col-sm-3 form-control-label">Price</label>
                                    <c:out value="${adminUsersStocksDetails.howMuch}"/>
                                    <label class="label-material"></label>
                                </div>
                                <div class="form-group-material">
                                    <label class="col-sm-3 form-control-label">Amount of stocks</label>
                                    <c:out value="${adminUsersStocksDetails.numOfCoins}"/>
                                    <label class="label-material"></label>
                                </div>
                                <div class="form-group-material">
                                    <label class="col-sm-3 form-control-label">Date</label>
                                    <c:out value="${adminUsersStocksDetails.whenBought}"/>
                                    <label class="label-material"></label>
                                </div>
                                <div class="form-group-material">
                                    <label class="col-sm-3 form-control-label">Notes</label>
                                    <c:out value="${adminUsersStocksDetails.notes}"/>
                                    <label class="label-material"></label>
                                </div>
                                <div class="form-group-material">
                                    <label class="col-sm-3 form-control-label">Storage</label>
                                    <c:out value="${adminUsersStocksDetails.storage.name}"/>
                                    <label class="label-material"></label>
                                </div>
                                <div class="form-group-material">
                                    <div class="col-sm ml-auto">
                                        <a href="<c:url value="/usersOwnedStocksEdit/${adminUsersStocksDetails.id}"/>"  class="btn btn-primary">Edit users's stock</a>
                                    </div>
                                </div>
                            </form:form><small>List of all stocks of users? </small><a
                                href="<c:url value="/usersOwnedStocks"/>">Here</a>


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
