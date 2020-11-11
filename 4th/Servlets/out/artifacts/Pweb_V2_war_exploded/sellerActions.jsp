<%--
  Created by IntelliJ IDEA.
  User: spirt
  Date: 5/20/2020
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lodaphone</title>
</head>

<body>

<form  action="properties.Seller" method="post">

    <h1>Lodaphone</h1>


    <p><input name="logout" type="submit" value="Logout" /></p>
    <%
        //CLEAR CACHE
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); // Proxies.
        if(session.getAttribute("username")==null){

            response.sendRedirect("index.jsp");
        }


    %>
    <p>Welcome ${username} ! </p>
    <p>property: ${property}</p>



    <br /> <h2>Choose an action:</h2>

    <p><br /> &#9632; <input name="newClient" type="submit" value="Insert a new client" /></p>

    <p><br /> &#9632; Enter afm code to create client's bill : <br />

        Afm code:&nbsp;<input name="afmCode2" type="text" /><br /><br />
        <input name="createBill" type="submit" value="Create client's bill" /></p>
    <p>${billError}</p>



    <p><br /> &#9632; <input name="showProg" type="submit" value="Show available programs " /></p>

    <p><br /> &#9632; <input name="showClients" type="submit" value="Show all clients" /></p>

    <p><br /> &#9632; Enter programs name and clients afm code: <br />


        Programs name:&nbsp;<input name="progName" type="text" /><br />
        Afm code:&nbsp;<input name="afmCode" type="text" /><br /><br />
        <input name="giveProg" type="submit" value="Give program to the client" /></p>
    <p> ${giveProg2}</p>

</form>
</body>
</html>
