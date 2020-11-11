<%--
  Created by IntelliJ IDEA.
  User: spirt
  Date: 5/18/2020
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Final step</title>
</head>
<body>
<h1>Lodaphone</h1>

<br/>

<p>Add the last informations to create the account</p>
<%
    //CLEAR CACHE
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0); // Proxies.

    if(session.getAttribute("username")==null){

        response.sendRedirect("index.jsp");
    }
%>
<form action="BasicClass.ConnectToAcc" method="post">
    <table style="width: 292px;">
        <tbody>
        <tr style="height: 20px;">
            <td style="height: 20px; width: 103px;">First name</td>
            <td style="height: 20px; width: 173px;"><input name="username1" type="text" /></td>
        </tr>
        <tr style="height: 21px;">
            <td style="height: 21px; width: 103px;">Last name</td>
            <td style="height: 21px; width: 173px;"><input name="password1" type="password" /></td>
        </tr>
        <tr>
            <td style="width: 103px;">AFM code</td>
            <td style="width: 173px;"><input name="username2" type="text" /></td>
        </tr>
        <tr>
            <td style="width: 103px;">Phone number</td>
            <td style="width: 173px;"><input name="password2" type="password" /></td>
        </tr>
        </tbody>
    </table>
    <p><input name="reg button" type="submit" value="Create account!" /></p>
</form>
</body>
</html>
