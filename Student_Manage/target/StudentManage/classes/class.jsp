
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%--打开El表达式--%>
<%@ page isELIgnored="false"%>
<%--把jstl很多好用的标签都引入进来了--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>学生列表</title>

    <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css">
</head>
<body>



    <div class="container " style="margin-top: 30px;">
        <div class="row justify-content-sm-start">
            <div class="col-2">
            <form role="form" method="get" action="userlist">
                 <input type="hidden" name="action" value="loginout">
                 <button type="submit" class="btn btn-primary btn-block">注销</button>
            </form>
            </div>
            <div class="col-2">
                <div class="form-group" id="state" >
                    <label style="color: red; margin: auto">欢迎：${username}</label>
                </div>
            </div>
            <form role="form" method="get" action="classeslist" id="classes-add">
                <input type="hidden" name="action" value="addbefore">
                <button type="submit" class="btn btn-primary btn-block">添加班级</button>
            </form>
        </div>
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <label style="color: #f014e5;"> 我的位置：</label>
                    <li class="breadcrumb-item"><a href="userlist"> 用户首页</a></li>
                    <li class="breadcrumb-item active" aria-current="page"> 班级管理</li>
                </ol>
            </nav>
        <table class="table table-striped">
            <tr>
                <th>序号</th>
                <th>班级id</th>
                <th>班级名</th>
                <th>老师</th>
                <th>学生数</th>
                <th>描述</th>
                <th id="classes-operate">操作</th>
            </tr>
            <tr>
                <c:forEach var="clazz" items="${ classes }" varStatus="status">
            <tr>
                <td>${status.index + 1} </td>
                <td>${clazz.value.id}</td>
                <td>${clazz.value.c_name}</td>
                <td>${clazz.value.c_teacher}</td>
                <td>${clazz.value.c_s_number}</td>
                <td>${clazz.value.c_extra}</td>
                <td class="important">
                    <a href="classeslist?action=mod&uid=${clazz.value.id}">修改</a>
                    <a href="classeslist?action=del&uid=${clazz.value.id}">删除</a>
                </td>
            </tr>
            </c:forEach>
            </tr>
        </table>
    </div>

    <script src="../assets/js/jquery-1.12.0.min.js"></script>
    <%--<script src="assets/js/bootstrap.min.js"></script>--%>
<script>
    $(document).ready(function () {
        var statue=localStorage.getItem("identity");
        if (statue=="student") {
            $("td.important").hide();


            $("#classes-add").hide();
            $("#classes-operate").hide();
        }
    });
</script>
</body>
</html>
