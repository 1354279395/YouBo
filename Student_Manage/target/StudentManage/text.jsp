
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

    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
</head>
<body>



    <div class="container" style="margin-top: 30px;">
        <table class="table table-striped">
            <tr>
                <th>序号</th>
                <th>学生id</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>班级</th>
                <th>描述</th>
                <th id="Student-operate">操作</th>
            </tr>

        </table>



    </div>
    <div class="row" style="margin: auto;width: auto">
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <li class="page-item" ><a class="page-link" id="privce" href="studentlist?action=show&pagenow=0">上一页</a></li>
                <li class="page-item"><a class="page-link" href="studentlist?action=show&pagenow=1">1</a></li>
                <li class="page-item"><a class="page-link" href="studentlist?action=show&pagenow=2">2</a></li>
                <li class="page-item"><a class="page-link" href="studentlist?action=show&pagenow=3">3</a></li>
                <li class="page-item"><a class="page-link" id="next" href="studentlist?action=show&pagenow=4">下一页</a></li>
            </ul>
        </nav>
    </div>





    <script src="assets/js/jquery-1.12.0.min.js"></script>
    <%--<script src="assets/js/bootstrap.min.js"></script>--%>
</body>
</html>
