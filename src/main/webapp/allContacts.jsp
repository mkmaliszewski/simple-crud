<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contacts</title>
    </head>
    <body>
        <h1>Hello! This is a page containing contacts from a database.</h1>
        <p> Click here to add a new record to the database: </p>
        <a href="Controller?action=insert">Add new contact</a>
        <table>
            <thead>
                <tr>
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
                    <td><c:out value="${contact.name}" /></td>
                    <td><c:out value="${contact.lastName}" /></td>
                    <td><c:out value="${contact.mail}" /></td>
                    <td><c:out value="${contact.number}" /></td>
                    <td><c:out value="${contact.bornDate}" /></td>
                    <td><a href="Controller?action=edit&id=<c:out value="${contact.id}" />">Edit</a></td>
                    <td><a href="Controller?action=delete&id=<c:out value="${contact.id}" />">Delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </body>
</html>
