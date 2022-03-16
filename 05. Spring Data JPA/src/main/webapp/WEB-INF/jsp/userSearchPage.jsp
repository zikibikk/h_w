<%--
  Created by IntelliJ IDEA.
  User: Samat
  Date: 22.09.2021
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Поиск</title>
</head>
<body>

    <form action="/search" method="get" class="form">
        <p>Фамилия пользователя</p>
        <p>
            <label for="lastName">Last name<input id="lastName" type="text" name="lastName"></label><br>
        <p><button type="submit">Поиск.</button></p><br>
    </form>

    <p>
        ${usersCount}
    </p>

</body>
</html>
