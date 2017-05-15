<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new contact</title>
    </head>
    <body>
        <h1>Adding new contact / editing existing. Please fill the
        following form:</h1>
        <form action="Controller" method="post" autocomplete="off">
            <table>
                <tbody>
                    <input type="text" name="id" 
                           value="<c:out value="${contact.id}" />"
                           hidden>
                    <tr>
                        <td>Name: </td>
                        <td>
                            <input type="text" name="newName" 
                                   value="<c:out value="${contact.name}" />" 
                                   autofocus required maxlength="15">
                        </td>
                    </tr>
                    <tr>
                        <td>Last name: </td>
                        <td>
                            <input type="text" name="newLastName"
                                   value="<c:out value="${contact.lastName}" />" 
                                   required maxlength="35">
                        </td>
                    </tr>
                    <tr>
                        <td>Mail: </td>
                        <td>
                            <input type="email" name="newMail" 
                                   value="<c:out value="${contact.mail}" />" 
                                   required maxlength="45">
                        </td>
                    </tr>
                    <tr>
                        <td>Number: </td>
                        <td>
                            <input type="number" name="newNumber" 
                                   value="<c:out value="${contact.number}" />"
                                   required max="999999999">
                        </td>
                    </tr>
                    <tr>
                        <td>Born: </td>
                        <td>
                            <input type="date" name="newBornDate" 
                                   value="<c:out value="${contact.bornDate}" />" 
                                   required max="2010-01-01">
                        </td>
                    </tr>
                    <tr>
                        <td><input type="reset" value="Reset"></td>
                        <td><input type="submit" value="Submit"></td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
