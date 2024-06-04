<%--
  Created by IntelliJ IDEA.
  User: spirt
  Date: 5/29/2020
  Time: 6:09 PM
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

<h1>Lodaphone</h1>

<p>Welcome ${username} ! </p>
<p>property: ${property}</p>

<form  action="properties.Admin" method="post">




    <p><input name="logout" type="submit" value="Logout" /></p>



    <br /> <h2>Choose an action:</h2>

    <p><br /> &#9632; <input name="newSeller" type="submit" value="Insert a new seller" /></p>


    <p><br /> &#9632; Enter client's or seller's username to delete a user : <br />

        Username:&nbsp;<input name="delAcc" type="text" /><br /><br />
        <input name="deleteUser" type="submit" value="Delete user" /></p>
    <p> ${deleteSuccess}</p>



    <p><br /> &#9632; <input name="newProg" type="submit" value="Insert a new program " /></p>


    <p><br /> &#9632; Enter program's name to delete a program : <br />

        Program name:&nbsp;<input name="delProgram" type="text" /><br /><br />
        <input name="delProg" type="submit" value="Delete program!" /></p>
    <p> ${deleteProgSuccess}</p>



    <p><br /> &#9632; <input name="changeProg" type="submit" value="Change a program" /></p>

    <p><br /> &#9632; Enter programs name and clients afm code: <br />


        Programs name:&nbsp;<input name="progName" type="text" /><br />
        Afm code:&nbsp;<input name="afmCode" type="text" /><br /><br />
        <input name="giveProg" type="submit" value="Give program to the client" /></p>
    <p> ${giveProg}</p>

</form>
</body>
</html>
