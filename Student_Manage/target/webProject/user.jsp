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
    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
    <title>主页面</title>
</head>
<body>
<div class="container">

    <div class="row">
        <div class="col-12">
            <nav class="navbar navbar-dark bg-primary navbar-expand-lg navbar-light" style="background-color: #e3f2fd;">
                <a class="navbar-brand" href="#">主页导航</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavDropdown">
                    <ul class="navbar-nav">
                        <li class="nav-item active dropdown" id="Studentmanage">
                            <a class="nav-link dropdown-toggle" href="studentlist"  data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                学生管理
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink" id="Student-menu">
                                <a class="dropdown-item" href="studentlist">学生列表</a>
                                <a class="dropdown-item" href="#">增加学生</a>
                                <a class="dropdown-item" href="#">删除学生</a>
                                <a class="dropdown-item" href="#">修改学生</a>
                            </div>
                        </li>
                        <li class="nav-item active dropdown" id="teachermanage">
                            <a class="nav-link dropdown-toggle" href="teacherlist" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                老师管理
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink" id="teacher-menu">
                                <a class="dropdown-item" href="teacherlist">老师列表</a>
                                <a class="dropdown-item" href="#">增加老师</a>
                                <a class="dropdown-item" href="#">删除老师</a>
                                <a class="dropdown-item" href="#">修改老师</a>
                            </div>
                        </li>
                        <li class="nav-item active dropdown" id="classmanage">
                            <a class="nav-link dropdown-toggle" href="classeslist" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                班级管理
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink" id="class-menu">
                                <a class="dropdown-item" href="classeslist">班级列表</a>
                                <a class="dropdown-item" href="#">增加班级</a>
                                <a class="dropdown-item" href="#">删除班级</a>
                                <a class="dropdown-item" href="#">修改班级</a>
                            </div>
                        </li>
                        <li class="nav-item active dropdown" id="scoremanage">
                            <a class="nav-link dropdown-toggle" href="scorelist" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                成绩管理
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink" id="score-menu">
                                <a class="dropdown-item" href="scorelist">成绩列表</a>
                                <a class="dropdown-item" id="score-add" href="#">增加学生成绩</a>
                                <a class="dropdown-item" id="score-del" href="#">删除学生成绩</a>
                                <a class="dropdown-item" id="score-mod" href="#">修改学生成绩</a>
                            </div>
                        </li>
                    </ul>
                </div>
                <div class="col-2">
                    <form role="form" method="get" action="userlist">
                        <input type="hidden" name="action" value="loginout">
                        <button type="submit" class="btn btn-primary btn-block" style="color: white;font-size: 20px">注销</button>
                    </form>
                </div>
            </nav>

        </div>
    </div>
    <div class="row">



    <%--放面包屑导航栏的内容--%>
    </div>
    <div class="row" style="height: 650px;padding-right: 13.5px;padding-left: 13.5px">
            <img  width=100% height=100% src="assets/img/111.jpg" title="图书馆">
        <%--放正文内容--%>
    </div>
</div>




<script src="assets/js/jquery-1.12.0.min.js"></script>
<script src="assets/js/popper.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script>
    /*  写js代码，控制页面的内容显示*/
    $(document).ready(function(){    // 表示文档准备好了以后再去执行
        // 当页面所有内容显示完整以后，再执行这里的js代码
        var statue=localStorage.getItem("identity");
        if (statue=="student"){
            $("#teacher-menu").hide();

        }
        $("#Studentmanage").mouseenter(function () {
           // var identity=request.getParameter("identity");

            //$("#errinfo").hide();
           // $("errinfo").remove();
        });


    });
</script>
</body>
</html>

