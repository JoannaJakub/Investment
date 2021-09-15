<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@ include file="../adminHead.jsp" %>
<body>
<%@ include file="../adminHeader.jsp" %>
<div class="d-flex align-items-stretch">
    <%@ include file="../adminSideMenu.jsp" %>
    <div class="page-content">
        <div class="page-header">

        </div>
        <!-- Breadcrumb-->
        <div class="container-fluid">
            <ul class="breadcrumb">
            </ul>
        </div>


        <section class="no-padding-top">
            <div class="container-fluid">
                <div class="row">
                    <!-- Form Elements -->
                    <div class="col-lg-12">
                        <div class="block">
                            <div class="title"><strong>Send a message</strong></div>
                            <div class="block-body">
                                <form:form action="adminSendMessageSuccess" class="form-horizontal" method="post"
                                           modelAttribute="message">
                                    <div class="form-group row">
                                        <label class="col-sm-3 form-control-label">User</label>
                                        <div class="col-sm-9">
                                            <form:select path="user" items="${user}" type="long" class="form-control"/>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-sm-3 form-control-label">Message</label>
                                        <div class="col-sm-9">
                                            <form:input path="id"/>
                                            <form:input path="message" type="text" class="form-control"/>
                                            <form:errors path="message"/>
                                        </div>
                                    </div>
                                    <div class="line"></div>
                                    <div class="form-group row">
                                        <div class="col-sm-9 ml-auto">
                                            <a href="<c:url value="/adminMessage"/>" class="btn btn-secondary">Cancel</a>
                                            <button type="submit" class="btn btn-primary">Send message</button>
                                        </div>
                                    </div>
                                </form:form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <%@ include file="../../main/footer.jsp" %>
</body>
</html>