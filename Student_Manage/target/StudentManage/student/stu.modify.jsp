
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
    <title>修改学生信息</title>

    <link rel="stylesheet" type="text/css" href="../assets/css/bootstrap.min.css">
</head>
<body>

    <div class="container" style="margin-top: 30px">
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <label style="color: #f014e5;">我的位置：</label>
                    <li class="breadcrumb-item"><a href="userlist">用户首页</a></li>
                    <li class="breadcrumb-item"><a href="studentlist">学生管理</a></li>
                    <li class="breadcrumb-item active" aria-current="page">修改学生</li>
                </ol>
            </nav>
        <%--需要一个表单--%>
            <div class="row justify-content-center" >
                <div class="col-5">
                    <form role="form" method="post" action="studentlist">
                        <%--通过隐藏域来提交用户的id--%>
                        <input type="hidden" name="uid" value="${student.id}">
                            <input type="hidden" name="action" value="modifyStudent">

                            <div class="form-group">
                                <label>姓名</label>
                                <input type="text" name="name" class="form-control" value="${student.name}">
                            </div>
                            <div class="form-group">
                                <label>&nbsp;&nbsp;男</label><input type="radio" name="sex"  value="男" checked>
                                <label>&nbsp;&nbsp;女</label><input type="radio" name="sex"  value="女">
                            </div>
                            <div class="form-group">
                                <label>年龄</label>
                                <input type="text" name="age" class="form-control" value="${student.age}">
                            </div>
                            <div class="form-group">
                                <label>班级</label>
                                <input type="text" name="c_id" class="form-control" value="${student.c_id}">
                            </div>
                            <div class="form-group">
                                <label>描述</label>
                                <input type="text" name="s_extra" class="form-control" value="${student.s_extra}">
                            </div>
                        <button type="submit" class="btn btn-primary btn-block">确定修改</button>
                    </form>
                </div>
            </div>
    </div>

    <script src="../assets/js/jquery-1.12.0.min.js"></script>
    <script src="../assets/js/bootstrap.min.js"></script>
</body>
</html>
