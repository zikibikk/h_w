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
    <title>Добавление пользователя</title>
</head>
<body>

<div id="users">
    <table>
        <tr>
            <th>ID           </th>
            <th>Имя          </th>
            <th>Фамилия      </th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>
                    <c:out value="${user.id}"/>
                </td>
                <td>
                    <c:out value="${user.firstName}"/>
                </td>
                <td>
                    <c:out value="${user.lastName}"/>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

    <form action="/users" method="post" class="form">
        <p>Добавление пользователя</p>
        <p>
            <label for="lastName">Last name<input id="lastName" type="text" name="lastName"></label><br>
            <label for="firstName">First name<input id="firstName" type="text" name="firstName"></label><br>
        <p><button type="submit">Добавить пользователя.</button></p><br>
    </form>

</body>
</html>
