<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <c:if test="${owner != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${owner == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${owner != null}">
                            Edit Owner
                        </c:if>
                        <c:if test="${owner == null}">
                            Add New owner
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${owner != null}">
                    <input type="hidden" name="id" value="<c:out value='${owner.id}' />" />
                </c:if>
                <tr>
                    <th>Name: </th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${owner.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Birth Date: </th>
                    <td>
                        <input type="date" name="birthDate" size="45"
                               value="<c:out value='${owner.birthDate}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Address: </th>
                    <td>
                        <input type="text" name="address" size="45"
                               value="<c:out value='${owner.address}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>Iq: </th>
                    <td>
                        <input type="number" name="iq" size="5"
                               value="<c:out value='${owner.iq}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>

</body>
</html>
