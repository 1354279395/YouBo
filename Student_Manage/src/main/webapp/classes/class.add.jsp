
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
    <title>添加学生信息</title>
    <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css">
</head>
<body>

    <div class="container" style="margin-top: 30px">
        <%--需要一个表单--%>
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        <label style="color: #f014e5;">我的位置：</label>
                        <li class="breadcrumb-item"><a href="userlist">用户首页</a></li>
                        <li class="breadcrumb-item"><a href="classeslist">班级管理</a></li>
                        <li class="breadcrumb-item active" aria-current="page">添加班级</li>
                    </ol>
                </nav>
            <div class="row justify-content-center" >
                <div class="col-5">
                    <form role="form" method="post" action="classeslist">
                        <%--通过隐藏域来提交用户的id--%>
                            <input type="hidden" name="action" value="addafter">
                            <div class="form-group">
                                <label>班级id</label>
                                <input type="text" name="uid" class="form-control" value="${clazz.id}">
                            </div>
                            <div class="form-group">
                                <label>班级名</label>
                                <input type="text" name="c_name" class="form-control" value="${clazz.c_name}">
                            </div>
                            <div class="form-group">
                                <label>老师</label>
                                <input type="text" name="c_teacher" class="form-control" value="${clazz.c_teacher}">
                            </div>
                            <div class="form-group">
                                <label>学生数</label>
                                <input type="text" name="c_s_number" class="form-control" value="${clazz.c_s_number}">
                            </div>
                            <div class="form-group">
                                <label>描述</label>
                                <input type="text" name="c_extra" class="form-control" value="${clazz.c_extra}">
                            </div>
                        <button type="submit" class="btn btn-primary btn-block">确定添加</button>
                    </form>
                </div>
            </div>
    </div>

    <script src="../assets/js/jquery-1.12.0.min.js"></script>
    <script src="../assets/js/bootstrap.min.js"></script>
</body>
</html>
