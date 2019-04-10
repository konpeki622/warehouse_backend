<%--
  Created by IntelliJ IDEA.
  User: yameng
  Date: 2019/3/11
  Time: 18:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>success</title>
</head>
<body>

<div>
    <strong> welcome,${sessionScope.user.username}! </strong>
</div>
this is success page!

<form action="outLogin">
    <table>
        <tr>
            <td><input type="submit" value="退出登录"></td>
        </tr>
    </table>
</form>

</body>
</html>
