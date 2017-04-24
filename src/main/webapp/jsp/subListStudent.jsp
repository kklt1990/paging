<%--
  User: root
  Date: 17-4-23
  Time: 下午5:13
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <%
        String myContext = request.getContextPath();
    %>
    <title>学生信息</title>
    <link type="text/css" rel="stylesheet"
          href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="<%=myContext%>/js/subListStudent.js"></script>
</head>
<body >
<%--在页面开始加载的时候执行初始化函数--%>
<div class="container">
    <div>
        <form action="<%=myContext %>/student/onePage"   id="stuForm"  method="post">
            姓名
            <input type="text" name="stuName" id="stu_name" style="width:120px" value="${stuName }">
            &nbsp;
            性别
            <select name="sex" id="sex" style="width:80px">
                <option value="0">全部</option>
                <option value="1">男</option>
                <option value="2">女</option>
            </select>
            &nbsp;&nbsp;
            <input type="submit" value="查询">
        </form>
    </div>
    <div class="panel panel-info">
        <div class="panel-heading">
            <h2 class="panel-title" style="text-align: center">学生信息</h2>
        </div>
        <table class="table">
            <tr>
                <th>id</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>家庭住址</th>
            </tr>
            <c:forEach items="${page.currentPageRecord}" var="student">
                <tr>
                    <td>${student.id}</td>
                    <td>${student.name}</td>
                    <td>
                        <c:if test="${student.sex eq 1}">男</c:if>
                        <c:if test="${student.sex eq 2}">女</c:if>
                    </td>
                    <td>${student.age}</td>
                    <td>${student.address}</td>
                </tr>
            </c:forEach>
        </table>
        <div style="text-align: center">
            <ul class="pagination">
                <li><a href="#">第${empty page.currentPageNumber ? 0:page.currentPageNumber}页</a></li>
                <li><a href="#" onclick="javascript: subListStudent.firstPage('<%=myContext%>');return false;">首页</a></li>
                <li><a href="#" onclick="javascript: subListStudent.prePage(${empty page.currentPageNumber? 1:page.currentPageNumber},'<%=myContext%>');">&laquo;</a></li>
                <li><a href="#" onclick="javascript: subListStudent.nextPage(${empty page.currentPageNumber? 1:page.currentPageNumber},'<%=myContext%>')">&raquo;</a></li>
                <li><a href="#" onclick="javascript: subListStudent.endPage(${empty page.totalPageSize? 1:page.totalPageSize },'<%=myContext%>');return false;">尾页</a></li>
                <li><a href="#" >共${empty page.totalPageSize ? 0:page.totalPageSize}页</a></li>
            </ul>
        </div>
    </div>
</div>
<script>
    var sex = ${sex};
    subListStudent.initPage(sex);
</script>
</body>
</html>
