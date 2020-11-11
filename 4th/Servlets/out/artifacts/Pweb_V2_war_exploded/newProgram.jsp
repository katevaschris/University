<%--
  Created by IntelliJ IDEA.
  User: spirt
  Date: 6/17/2020
  Time: 7:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Program</title>
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


<form action="properties.Admin" method="post">
    <table style="width: 292px;">
        <tr>
            <td>Program name: </td>
            <td><input name="progname2" type="text" /></td>
        </tr>
        <tr style="height: 20px;">
            <td style="height: 20px; width: 103px;">Talk time in our network</td>
            <td style="height: 20px; width: 173px;"><input name="inTalk" type="text" /></td>
        </tr>
        <tr style="height: 21px;">
            <td style="height: 21px; width: 103px;">Talk time out of our network</td>
            <td style="height: 21px; width: 173px;"><input name="outTalk" type="text" /></td>
        </tr>
        <tr>
            <td style="width: 103px;">Cost per month</td>
            <td style="width: 173px;"><input name="costPerMonth" type="text" /></td>
        </tr>
    </table>

    <p>${error}</p>

    <p><input name="createProgram" type="submit" value="Save program!" /></p>

</form>


</body>
</html>
