
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
    <link href="/css/loginStyles.css" rel="stylesheet" type="text/css">

</head>
<body>
<div class="login-page">
    <div class="form">
                <form method="post" action="/SignUp">
                <input type="text" placeholder="User name" name="name"/>
                <input type="password" placeholder="password" name="password"/>
                <input type="password" placeholder="repeat password" name="password2"/>
                <button>Sign Up</button>
                <p class="message">Have Accaunt? <a href="/login">Please Login</a></p>
            </form>

    </div>
</div>
<div id="error" class="modalbackground">
    <div class="modalwindow">
        <h3>Ошибка!</h3>
        <p>Пользователь с таким ником уже есть</p>
        <a href=" ">Закрыть</a>
    </div>
</div>
</body>
</div>

</body>
</html>
