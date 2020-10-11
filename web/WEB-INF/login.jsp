<%-- 
    Document   : login
    Created on : Oct 10, 2020, 6:29:17 PM
    Author     : 838771
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lab 4: Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="POST" action="home">
            <label>Username: 
                <input type="text" name="username" value="${currentUser}">
            </label><br>
            <label>Password: 
                <input type="text" name="pasword" value="${currentPass}">
            </label><br>
            <input type="submit" name="submit" value="Log in">
        </form>
            <br>
            <p>${loginMessage}</p>
    </body>
</html>
