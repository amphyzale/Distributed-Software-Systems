<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <link type="text/css"
          href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
    <script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
    <script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
    <title>Add new user</title>
</head>
<body>
<script>
    $(function() {
        $('input[name=birthDate]').datepicker();
    });
</script>

<form method="POST" action='OwnerController' name="frmAddOwner">
    Owner ID : <input type="text" readonly="readonly" name="OwnerId"
                     value="<c:out value="${owner.id}" />" /> <br />
    Name : <input
        type="text" name="firstName"
        value="<c:out value="${user.firstName}" />" /> <br />
    Birth Date : <input
        type="text" name="birthDate"
        value="<fmt:formatDate pattern="yyyy-MM-dd" value="${owner.birthDate}" />" /> <br />
    Address : <input
        type="text" name="address"
        value="<c:out value="${owner.address}" />" /> <br />
    Iq : <input type="text" name="iq"
                   value="<c:out value="${owner.iq}" />" /> <br /> <input
        type="submit" value="Submit" />
</form>
</body>
</html>
