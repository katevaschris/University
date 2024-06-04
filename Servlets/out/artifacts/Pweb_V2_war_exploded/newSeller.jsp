<%--
  Created by IntelliJ IDEA.
  User: spirt
  Date: 6/13/2020
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New seller</title>
</head>
<body>

<%
    //CLEAR CACHE
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0); // Proxies.
    if(session.getAttribute("username")==null){

        response.sendRedirect("index.jsp");
    }


%>


<h1>Lodaphone</h1>
<form  action="properties.Admin" method="post">
    <p><input name="goToActions" type="submit" value="Back" /></p>

</form>

<form  action="properties.Admin" method="post">

    <table style="with: 50%;">
    <tr>
        <td>UserName</td>
        <td><input name="username" type="text" /></td>
    </tr>
    <tr>
        <td>Password</td>
        <td><input name="password" type="password" /></td>
    </tr>
    <tr>
        <td>Password</td>
        <td><input name="password2" type="password" /></td>
    </tr>
</table>

<p>Passwords must match!</span> </p>


    <p>${error}</p>

    <input type="submit" name="reg seller" value="Create seller" /></p><br/>
</form>
</body>
</html>
