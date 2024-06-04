<%--
  Created by IntelliJ IDEA.
  User: spirt
  Date: 5/20/2020
  Time: 7:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lodaphone</title>
</head>
<body>

<form action="properties.Client" method="post">



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



    <p>Welcome ${username} ! </p>
    <p>property: ${property}</p>

    <form  action="properties.Client" method="post">




        <p><input name="logout" type="submit" value="Logout" /></p>



        <br /> <h2>Choose an action:</h2>

        <p><br /> &#9632; <input name="showBill" type="submit" value="Show bill" /></p>

        <p><br /> &#9632; <input name="callHisory" type="submit" value="Show call history" /></p>

        <p><br /> &#9632; <input name="payBill" type="submit" value="Pay bill" /></p>
        <p>${paid}</p>



    </form>

</body>
</html>
