<%--
  Created by IntelliJ IDEA.
  User: trivi
  Date: 9/8/2020
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
save values
<form action="/loadTime" method="post">
    <input name="id">
    <input type="time" name="timeSett">
    <input type="time" name="timeSett2">
    <input type="date" name="dateSett">
    <button type="submit"></button>

</form>


<table>
    <tbody>
    <c:forEach items="${loadTimeTable}" var="a">
        <tr>
            <td>${a.noticeId}</td>
        </tr>
    </c:forEach>
    </tbody>

</table>
find values
<form action="/loadTable" method="get">
    <input name="id">
    <input type="time" name="timeSett">
    <input type="time" name="timeSett2">
    <input type="date" name="dateSett">
    <button type="submit"></button>

</form>
</body>
</html>
