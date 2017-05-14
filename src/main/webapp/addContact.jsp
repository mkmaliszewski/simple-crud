<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new contact</title>
    </head>
    <body>
        <h1>This is the page, where you can add a new contact. Please fill the
        following form:</h1>
        <form action="Controller" method="post" autocomplete="off">
            <table>
                <tbody>
                    <tr>
                        <td>Name: </td>
                        <td><input type="text" name="newName" autofocus required></td>
                    </tr>
                    <tr>
                        <td>Last name: </td>
                        <td><input type="text" name="newLastName" required></td>
                    </tr>
                    <tr>
                        <td>Mail: </td>
                        <td><input type="email" name="newMail" required></td>
                    </tr>
                    <tr>
                        <td>Number: </td>
                        <td><input type="number" name="newNumber" required></td>
                    </tr>
                    <tr>
                        <td>Born: </td>
                        <td><input type="date" name="newBornDate" required max="2010-01-01"></td>
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
