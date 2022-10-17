<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>learn Resources</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>

<div style="text-align: center;margin:0 auto;width: 1000px; ">
    <h1>Spring boot</h1>
    <a href="/emp/toAdd">添加员工</a>
    <table width="100%" border="1" cellspacing="1" cellpadding="0">
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>密码</td>

        </tr>
        <c:forEach var="emp" items="${list}">
            <tr>
                <td th:text="${emp.empId}">编号</td>
                <td th:text="${emp.empName}">姓名</td>
                <td th:text="${emp.password}">密码</td>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>