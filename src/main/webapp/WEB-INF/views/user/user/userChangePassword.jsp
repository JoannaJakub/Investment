<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<%@ include file="../../head.jsp" %>
<body>
<%@ include file="../header.jsp" %>
<div class="d-flex align-items-stretch">
    <%@ include file="../sideMenu.jsp" %>
    <div class="page-content">
        <!-- Page Header-->
        <div class="page-header">
            <div class="list-inline-item">
                <h2 class="h4 no-margin-bottom"><a href="addCrypto"></a></h2>
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
                        <div class="title"><strong>Change password</strong></div>
                        <div class="block-body">
                            <div id="errormsg" style="display:none"></div>
                            <div>
                                <input id="oldpass" name="oldpassword" type="password" />
                                <input id="pass" name="password" type="password" />
                                <input id="passConfirm" type="password" />
                                <span id="error" style="display:none">Password mismatch</span>

                                <button type="submit" onclick="savePass()">Change Password</button>
                            </div>

                            <script src="jquery.min.js"></script>
                            <script type="text/javascript">

                                var serverContext = [[@{/}]];
                                    function savePass(){
                                        var pass = $("#pass").val();
                                        var valid = pass == $("#passConfirm").val();
                                        if(!valid) {
                                            $("#error").show();
                                            return;
                                        }
                                        $.post(serverContext + "user/updatePassword",
                                            {password: pass, oldpassword: $("#oldpass").val()} ,function(data){
                                                window.location.href = serverContext +"/home.html?message="+data.message;
                                            })
                                            .fail(function(data) {
                                                $("#errormsg").show().html(data.responseJSON.message);
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
