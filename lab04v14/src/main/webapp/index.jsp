<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Application</title>
</head>
<body>
<center>
    <h2>
        <a href="new">Add New Owner</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list">List All Owners</a>

    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2><%out.println("List of Owners");%></h2></caption>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>BirthDate</th>
            <th>Address</th>
            <th>IQ</th>
        </tr>
        <c:forEach var="owner" items="${listOwners}">
            <tr>
                <td><c:out value="${owner.id}" /></td>
                <td><c:out value="${owner.name}" /></td>
                <td><calendar:formatDate  value="${owner.birthDate}" pattern="yyyy-MM-dd"/></td>
                <td><c:out value="${owner.address}" /></td>
                <td><c:out value="${owner.iq}" /></td>
                <td>
                    <a href="edit?id=<c:out value='${owner.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<c:out value='${owner.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>