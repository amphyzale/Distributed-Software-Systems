<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="calendar" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>
<html>
<head>
    <title>Lab05v2</title>

    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<a href="<c:url value="/index.jsp"/>">Back to main menu</a>

<br/>
<br/>

<h1>Owner List</h1>

<c:if test="${!empty listOwners}">
    <table class="tg">
        <tr>
            <th width="80">ID</th>
            <th width="120">Name</th>
            <th width="120">Birth Date</th>
            <th width="120">Address</th>
            <th width="120">IQ</th>
            <th width="60">Edit</th>
            <th width="60">Delete</th>
        </tr>
        <c:forEach items="${listOwners}" var="owner">
            <tr>
                <td>${owner.id}</td>
                <td><a href="<c:url value="/ownerdata/${owner.id}"/>">${owner.name}</a></td>
                <td><calendar:formatDate  value="${owner.birthDate}" pattern="yyyy-MM-dd"/></td>
                <td>${owner.address}</td>
                <td>${owner.iq}</td>
                <td><a href="<c:url value='/edit/${owner.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${owner.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h1>Add a Owner</h1>
<c:url var="addAction" value="/owners/add"/>

<form:form action="${addAction}" commandName="owner">
    <table>
        <c:if test="${!empty owner.name}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="name">
                    <spring:message text="Name"/>
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label type = "date" path="birthDate">
                    <spring:message text="Birth Date"/>
                </form:label>
            </td>
            <td>

                <form:input type = "date" pattern = "yyy-MM-dd" path="birthDate" />
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="address">
                    <spring:message text="Address"/>
                </form:label>
            </td>
            <td>
                <form:input path="address"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="iq">
                    <spring:message text="IQ"/>
                </form:label>
            </td>
            <td>
                <form:input type = "number" path="iq"/>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <c:if test="${!empty owner.name}">
                    <input type="submit"
                           value="<spring:message text="Edit Owner"/>"/>
                </c:if>
                <c:if test="${empty owner.name}">
                    <input type="submit"
                           value="<spring:message text="Add Owner"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
