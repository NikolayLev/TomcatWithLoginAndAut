<%--
  Created by IntelliJ IDEA.
  User: NikolayLevchenko
  Date: 18.08.2019
  Time: 18:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home page</title>
    <link href="/css/table.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
    String userName = (String) request.getAttribute("userName");

%>
<div class="datagrid">

    <table>

        <thead>
        <tr>
            <th><%=userName%>
            </th>
            <th>Наименование товара</th>
            <th>Цена</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>data</td>
            <td>data</td>
            <td>data</td>

        </tr>
        <tr>
            <td>data</td>
            <td>data</td>
            <td>data</td>

        </tr>

        </tbody>
    </table>

    <form method="post" action="/home">
    <table>
        <thead>
        <th>Добавление товара</th>
        </thead>
        <tr>
            <td>
                <input type="text" name="id1" placeholder="Наименование товара"/>
                <input type="text" name="id2" placeholder="Наименование товара"/>
                <input type="text" name="id3" placeholder="Наименование товара"/>
                <input type="text" name="id4" placeholder="Наименование товара"/>
                <input type="text" name="id5" placeholder="Наименование товара"/>
                <button>Добавить</button>
            </td>
        </tr>
    </table>

    </form>
</div>

</body>
</html>
