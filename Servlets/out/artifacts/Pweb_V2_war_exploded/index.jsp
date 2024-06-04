<%--
  Created by IntelliJ IDEA.
  User: spirt
  Date: 5/17/2020
  Time: 4:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Lodaphone</title>
</head>

<style>
  .content {
    max-width: 310px;
    margin: auto;
  }
</style>

<body>

<div class="content">

  <h1>Lodaphone</h1>
<form  action="BasicClass.ConnectToAcc" method="post">
  <strong> Login</strong>

  <table style="with: 50%;">
    <tr>
      <td>UserName</td>
      <td><input name="username1" type="text" /></td>
    </tr>
    <tr>
      <td>Password</td>
      <td><input name="password1" type="password" /></td>
    </tr>
  </table>


  <input type="submit"  name="Log in button" value="LogIn" />

  <p> ${LogError}</p>


  <p> ---------OR--------- <br /><br /></p>


<strong>Create an account</strong>

<table style="with: 50%;">
  <tr>
    <td>UserName</td>
    <td><input name="username2" type="text" /></td>
  </tr>
  <tr>
    <td>Password</td>
    <td><input name="password2" type="password" /></td>
  </tr>
  <tr>
    <td>Password</td>
    <td><input name="password3" type="password" /></td>
  </tr>
</table>

  <p>Passwords must match!</span> </p> <br/>

  <strong>Choose your property:</strong>
  <p>Client<input name="Q2" type="radio" value="client" />
  Seller<input name="Q2" type="radio" value="seller" />&nbsp;
  Admin<input name="Q2" type="radio" value="admin" /></p>

<input type="submit" name="reg button" value="Next step" /></p><br/>
  <p> ${RegError}</p>


</form>


</div>

</body>

</html>
