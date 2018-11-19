<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Show All Users</title>
</head>
<body>
<table border=1>
    <thead>
    <tr>
        <th>Owner Id</th>
        <th>Name</th>
        <th>Birth Date</th>
        <th>Address</th>
        <th>Iq</th>
        <th colspan=2>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listOfOwners}" var="owner">
        <tr>
            <td><c:out value="${owner.id}" /></td>
            <td><c:out value="${owner.name}" /></td>
            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${owner.birthDate}" /></td>
            <td><c:out value="${owner.addres}" /></td>
            <td><c:out value="${owner.iq}" /></td>
            <td><a href="OwnerController?action=edit&ownerId=<c:out value="${owner.iq}"/>">Update</a></td>
            <td><a href="OwnerController?action=delete&ownerId=<c:out value="${owner.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p><a href="OwnerController?action=insert">Add Owner</a></p>
</body>
</html>
