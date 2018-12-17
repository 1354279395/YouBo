
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>登录页面</title>

    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
</head>

<body>
<div class="img" style="text-align:center;margin-top: 20px">
    <img src="assets/img/xatu.jpg" height="120px" width="120px">
</div>

<div class="container" style="margin-top: 30px;">
    <div class="row justify-content-center">
        <div class="col-5">
            <%--http://www.tulun.com/login jsp页面发起action或者请求资源，一定要携带context上下文路径--%>
            <form id="addForm" role="form" method="get" action="login">
                <div class="img-fluid" >
                </div>
                <div class="form-group" id="div-name">
                    <label>用户名</label>
                    <input id="Username" type="text" name="username" class="form-control" placeholder="输入用户名/手机/邮箱">
                </div>
                <div class="form-group" id="div-pwd">
                    <label>密码</label>
                    <input id="Userpwd" type="password" name="userpwd" class="form-control" placeholder="输入密码">
                </div>
                <div class="form-group" id="div-identity">
                    <label>学生</label><input type="radio" checked="checked" name="identity" value="student" />
                    <label>&nbsp;&nbsp;教师</label><input  type="radio" name="identity" value="teacher" />
                    <label>&nbsp;&nbsp;管理员</label><input type="radio" name="identity" value="admin" />
                </div>
                <input type="hidden" name="action" value="login">
                <button id="submitAdd" type="button" class="btn btn-primary btn-block">登录</button>
            </form>
        </div>
    </div>
</div>

<script src="assets/js/jquery-1.12.0.min.js"></script>
<%--<script src="${pageContext.request.contextPath}assets/js/bootstrap.min.js"></script>--%>
<script>
    /*  写js代码，控制页面的内容显示*/
    $(document).ready(function(){    // 表示文档准备好了以后再去执行
        // 当页面所有内容显示完整以后，再执行这里的js代码
        $("#Username").focus(function () {
            // 当用户名的输入框获取焦点的时候，这里就会响应执行
            //alert("用户名的输入框获取焦点");
            /*  var errorinfo = $("#errinfo").text();
              if(errorinfo != ""){
                  //$("#errinfo").text("");
                 //  $("#errinfo").hide();
              }*/
            $("#Username").css("border-color", "");
            //$("#errinfo").hide();
            $("#errinfo").remove();
        });

        $("#Userpwd").focus(function () {
            // 当用户名的输入框获取焦点的时候，这里就会响应执行
            //alert("用户名的输入框获取焦点");
            /*var errorinfo = $("#errinfo").text();
            if(errorinfo != ""){
              //  $("#errinfo").text("");
             //  $("#errinfo").hide();
            }*/
            $("#Userpwd").css("border-color", "");
            //$("#errinfo").hide();
            $("#errinfo").remove();
        });
        $(":button").click(function(){
            // 1. 获取用户名和密码    text：拿普通元素的文本内容  val：表单的输入框的数据
            var name = $("#Username").val();
            var pwd = $("#Userpwd").val();
            var identity= $('input:radio:checked').val();
            localStorage.setItem("identity",identity);
            if(name.trim() == ""){
                // 给用户名的输入框改变它的样式 border-color
                $("#Username").css("border-color", "red");
                return;
            }

            if(pwd.trim() == ""){
                // 给密码的输入框改变它的样式 border-color
                $("#Userpwd").css("border-color", "red");
                return;
            }

            // 2.发送ajax异步请求resquest，在服务器验证用户名和密码的正确性
            $.ajax({
                url : "login",
                type : "post",
                data : {
                    username : name,
                    userpwd : pwd,
                    identity:identity,
                    action : "ajaxlogin"
                },
                dataType:"json",
                success : function(data) {
                    if(data.code == 100){
                        var errdiv = "<div class=\"form-group\" id=\"errinfo\">\n" +
                            "    <label style=\"color: red;\">用户名或者密码错误</label>\n" +
                            "         </div>";
                        // 把显示错误信息的div元素，动态添加到密码输入框的后面
                        $("#div-identity").after(errdiv);
                    }else {
                        // 登录成功了 200  新的页面的url
                        var url =  data.url;
                        $(location).attr("href", url);
                    }
                }
            });
        });


        // 任务三，就是把users.jsp这个页面 把注销按钮设置只占2列， 给它的后面显示当前登录用户是：xxx
        // 同一行的后面继续显示，当前在线人数是：xxx人
    });
</script>
</body>
</html>



