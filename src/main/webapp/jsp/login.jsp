<%--
  Created by IntelliJ IDEA.
  User: NikolayLevchenko
  Date: 17.08.2019
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Login Page</title>
    <link href="/css/loginStyles.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="login-page">
    <div class="form">
        <form method="post" action="/login">
            <input type="text" name="name" placeholder="username"/>
            <input type="password" name="password" placeholder="password"/>
            <button>login</button>
            <p class="message">Not registered? <a href="/SignUp">Create an account</a></p>
        </form>

    </div>
</div>

</body>
</html>
