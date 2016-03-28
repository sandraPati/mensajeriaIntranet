<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! ${myVar}</h1>
        
        <b>List</b><br/>
        <ul>
            <c:forEach items="${listUser}" var="item">
            <li><c:out value="${item.id}" /> - <c:out value="${item.nombre}" /> <c:out value="${item.apellidos}" /> <c:out value="${item.password}" /> <c:out value="${item.rol.nombre}" /></li>
            </c:forEach>
        </ul>
        <b>Set</b><br/>
        <ul>
            <c:forEach items="${listExtractorUser}" var="item">
            <li>${item.nombre}</li>
            </c:forEach>
        </ul>
    </body>
</html>
