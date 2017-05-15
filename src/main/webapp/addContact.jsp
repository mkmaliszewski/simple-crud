<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new contact</title>
        <link rel="stylesheet" type="text/css" href="mystyles.css">
    </head>
    <body>
        <h1>Adding new contact / editing existing. Please fill the
        following form:</h1>
        <form action="Controller" method="post" autocomplete="off">
            <input type="text" name="id" value="<c:out value="${contact.id}" />" 
                   hidden>
            
            <label for="inputname">First Name:</label><br/>
            <input type="text" name="newName" id="inputname" 
                   value="<c:out value="${contact.name}" />" 
                   autofocus required maxlength="15"><br/>
            
            <label for="inputlastname">Last name:</label><br/>
            <input type="text" name="newLastName" id="inputlastname" 
                   value="<c:out value="${contact.lastName}" />" 
                   required maxlength="35"><br/>
            
            <label for="inputmail">Mail:</label><br/>
            <input type="email" name="newMail" id="inputmail" 
                   value="<c:out value="${contact.mail}" />" 
                   required maxlength="45"><br/>
            
            <label for="inputnumber">Number:</label><br/>
            <input type="number" name="newNumber" id="inputnumber" 
                   value="<c:out value="${contact.number}" />" 
                   required max="999999999"><br/>
            
            <label for="inputdate">Born date:</label><br/>
            <input type="date" name="newBornDate" id="inputdate" 
                   value="<c:out value="${contact.bornDate}" />" 
                   required max="2010-01-01"><br/>
            
            <input type="reset" value="Reset">
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
