<%@ page import="ru.users.UserProduct" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="ru.users.User" %><%--
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
    <meta charset="utf-8">
    <title>Home page</title>
    <link href="/css/table.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
    String userName = (String) request.getAttribute("userName");
    List<UserProduct> productList = (List<UserProduct>) request.getAttribute("productList");
    Iterator<UserProduct> iterator = productList.iterator();
    int i = 0;
%>


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
        <%
            while (iterator.hasNext()) {
                i++;
                UserProduct userProduct = iterator.next();
                String productName = userProduct.getProductName();
                int price = userProduct.getPrice();

        %>
        <tr>
            <td><%=i%>
            </td>
            <td><%=productName%>
            </td>
            <td><%=price%>
            </td>

        </tr>

        <% }%>

        </tbody>
    </table>

    <form method="post" action="/home">
        <table>
            <thead>
            <th>Добавление товара</th>
            <th>Цена Товара</th>
            </thead>
            <tbody>
            <tr>
                <td><input type="text" name="id1" placeholder="Наименование товара"/></td>
                <td><input type="text" name="price1" placeholder="Цена товара"/></td>
            </tr>
            <tr>
                <td><input type="text" name="id2" placeholder="Наименование товара"/></td>
                <td><input type="text" name="price1" placeholder="Цена товара"/></td>
            </tr>
            <tr>
                <td><input type="text" name="id3" placeholder="Наименование товара"/></td>
                <td><input type="text" name="price3" placeholder="Цена товара"/></td>
            </tr>
            <tr>
                <td><input type="text" name="id4" placeholder="Наименование товара"/></td>
                <td><input type="text" name="price4" placeholder="Цена товара"/></td>
            </tr>
            <tr>
                <td><input type="text" name="id5" placeholder="Наименование товара"/></td>
                <td><input type="text" name="price5" placeholder="Цена товара"/></td>
            </tr>
            <td colspan="2">
                <button>Добавить</button>

            </td>

            </tbody>


        </table>


    </form>
</div>

</body>
</html>



