
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
                <div class="form-group" id="state" style="display:table-cell;vertical-align: bottom">
                    <label style="color: red; ">欢迎：${username}</label>
                </div>
            </div>
            <form role="form" method="get" action="studentlist" id="Student-add">
                <input type="hidden" name="action" value="addbefore">
                <button type="submit" class="btn btn-primary btn-block">添加学生</button>
            </form>
        </div>
            <nav aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <label style="color: #f014e5;"> 我的位置：</label>
                    <li class="breadcrumb-item"><a href="userlist"> 用户首页</a></li>
                    <li class="breadcrumb-item active" aria-current="page"> 学生管理</li>
                </ol>
            </nav>
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
            <tr>
                <c:forEach var="student" items="${ students }" varStatus="status">
            <tr>
                <td>${status.index + 1+(page-1)*3} </td>
                <td>${student.value.id}</td>
                <td>${student.value.name}</td>
                <td>${student.value.sex}</td>
                <td>${student.value.age}</td>
                <td>${student.value.c_id}</td>
                <td>${student.value.s_extra}</td>
                <td class="important">
                    <a href="studentlist?action=mod&uid=${student.value.id}">修改</a>
                    <a href="studentlist?action=del&uid=${student.value.id}">删除</a>
                </td>
            </tr>
            </c:forEach>
            </tr>
        </table>
    </div>
    <div class="row justify-content-around" style="margin: auto;width: auto">
        <nav aria-label="Page navigation example" >
            <ul class="pagination">
                <li class="page-item" ><a class="page-link" id="privce" href="studentlist?action=show&pagenow=${page-1}">上一页</a></li>
                <c:forEach var="i" begin="1" end="${totalpageStudent}">
                    <li class="page-item"><a class="page-link" href="studentlist?action=show&pagenow=${i}">${i}</a></li>
                </c:forEach>
                <li class="page-item"><a class="page-link" id="next" href="studentlist?action=show&pagenow=${page+1}">下一页</a></li>
            </ul>
        </nav>
    </div>




    <script src="../assets/js/jquery-1.12.0.min.js"></script>
    <%--<script src="assets/js/bootstrap.min.js"></script>--%>
<script>
    $(document).ready(function () {

         /* $("#privce").click(function () {
               var currentpage1=${page};
               if (currentpage1==1){
                   ${page-1}=1;
                   alert("已经是第一页了");
                   //$("#privce").attr("href","studentlist?action=showpage&pagenow=1");
               }
           });
        $("#next").click(function () {
            var currentpage2=${page};
            alert(currentpage2);
            if (currentpage2==${totalpageStudent}){
                alert(${totalpageStudent});
                ${page+1}=currentpage2;
                alert("最后一页了")
            }
        });
*/

        var statue=localStorage.getItem("identity");
        if (statue!="admin") {
            $("td.important").hide(); //隐藏所有 class=improtant的 td元素

            $("#Student-add").hide();
            $("#Student-operate").hide();
        }


    });
</script>
</body>
</html>
