<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello! This is a page containing contacts data from a database.</h1>
        <table>
            <thead>
                <tr>
                    <td>Contact ID</td>
                    <td>Name</td>
                    <td>Last Name</td>
                    <td>Mail</td>
                    <td>Number</td>
                    <td>Born</td>
                </tr>
            </thead>
            <tbody>
            <c:forEach items="${contacts}" var="contact">
                <tr>
                    <td><c:out value="${contact.id}" /></td>
                    <td><c:out value="${contact.name}" /></td>
                    <td><c:out value="${contact.lastName}" /></td>
                    <td><c:out value="${contact.mail}" /></td>
                    <td><c:out value="${contact.number}" /></td>
                    <td><c:out value="${contact.bornDate}" /></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </body>
</html>
