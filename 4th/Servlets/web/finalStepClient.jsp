<%--
  Created by IntelliJ IDEA.
  User: spirt
  Date: 5/20/2020
  Time: 6:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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

    <h1>Lodaphone</h1>

    <br/>

    <strong>Add the last information to create the account.</strong>

    <form action="properties.Client" method="post">
        <table style="width: 292px;">
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
        <p><input name="create_acc" type="submit" value="Create account!" /></p>

    </form>
</body>

</html>
