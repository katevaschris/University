<%--
Created by IntelliJ IDEA.
User: spirt
Date: 5/24/2020
Time: 5:30 PM
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Verification</title>
</head>


<style>
    .content {
        max-width: 310px;
        margin: auto;
    }
</style>


<body>
<form  action="properties.Seller" method="post">

<div class="content">

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
    <strong>Insert Sellers verification key:</strong>
    <td><input name="password" type="password" /></td>
    <input type="submit" name="Login1" value="Login" /></p><br/>
    <p>${errorVeri}</p>


</div>

</form>
</body>
</html>