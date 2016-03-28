
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de números:</h1>
        <hr/>
        <ul>
            <c:forEach items="${listRandom}" var="item">
                <li>${item}</li>
            </c:forEach>
        </ul>
    </body>
</html>
