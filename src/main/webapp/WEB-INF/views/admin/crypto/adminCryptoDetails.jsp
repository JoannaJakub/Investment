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
                <h2 class="h5 no-margin-bottom"><a href="<c:url value="/adminAddCrypto"/>">Add crypto</a></h2>
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
                        <div class="title"><strong>Crypto details</strong></div>
                        <div class="block-body">
                            <form:form items="${adminCryptoDetails}" var="adminCryptoDetails">
                                <div class="form-group-material">
                                    <label class="col-sm-3 form-control-label">Id</label>
                                    <c:out value="${adminCryptoDetails.id}"/>
                                    <label class="label-material"></label>
                                </div>
                                <div class="form-group-material">
                                    <label class="col-sm-3 form-control-label">Aux</label>
                                    <c:out value="${adminCryptoDetails.aux}"/>
                                    <label class="label-material"></label>
                                </div>
                                <div class="form-group-material">
                                    <label class="col-sm-3 form-control-label">Cmc rank</label>
                                    <c:out value="${adminCryptoDetails.cmc_rank}"/>
                                    <label class="label-material"></label>
                                </div>
                                <div class="form-group-material">
                                    <label class="col-sm-3 form-control-label">Limit</label>
                                    <c:out value="${adminCryptoDetails.limit}"/>
                                    <label class="label-material"></label>
                                </div>
                                <div class="form-group-material">
                                    <label class="col-sm-3 form-control-label">Name</label>
                                    <c:out value="${adminCryptoDetails.name}"/>
                                    <label class="label-material"></label>
                                </div>
                                <div class="form-group-material">
                                    <label class="col-sm-3 form-control-label">Max price</label>
                                    <c:out value="${adminCryptoDetails.priceMax}"/>
                                    <label class="label-material"></label>
                                </div>
                                <div class="form-group-material">
                                    <div class="col-sm ml-auto">
                                        <a href="<c:url value="/adminCryptoEdit/${adminCryptoDetails.id}"/>"  class="btn btn-primary">Edit crypto</a>
                                    </div>
                                </div>
                            </form:form><small>List of all crypto? </small><a
                                href="<c:url value="/adminCrypto"/>">Here</a>


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
