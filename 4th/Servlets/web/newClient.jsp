<%--
  Created by IntelliJ IDEA.
  User: spirt
  Date: 5/24/2020
  Time: 6:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lodaphone</title>
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


<br/><br/>


<strong>Lodaphone</strong>
<form  action="properties.Admin" method="post">
    <p><input name="goToActions" type="submit" value="Back" /></p>

</form>


<form action="properties.Seller" method="post">
    <table style="width: 292px;">
        <tr>
            <td>UserName</td>
            <td><input name="username" type="text" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input name="password2" type="password" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input name="password3" type="password" /></td>
        </tr>
        <tr style="height: 20px;">
            <td style="height: 20px; width: 103px;">First name</td>
            <td style="height: 20px; width: 173px;"><input name="fname" type="text" /></td>
        </tr>
        <tr style="height: 21px;">
            <td style="height: 21px; width: 103px;">Last name</td>
            <td style="height: 21px; width: 173px;"><input name="lname" type="text" /></td>
        </tr>
        <tr>
            <td style="width: 103px;">AFM code</td>
            <td style="width: 173px;"><input name="afm" type="text" /></td>
        </tr>
        <tr>
            <td style="width: 103px;">Phone number</td>
            <td style="width: 173px;"><input name="pnumber" type="text" /></td>
        </tr>
    </table>
    <p><input name="create_acc_via_seller" type="submit" value="Create account!" /></p>

    <p>${accError}</p>


</form>

</body>
</html>
