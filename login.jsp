<%-- 
    Document   : login
    Created on : May 20, 2025, 1:10:32 PM
    Author     : hoadoan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>Login information</h1>
        <form action="MainController" method="POST">
            User ID<input type="text" name="userID" required=""/></br>
            Password<input type="password" name="password" required=""/></br>
            <input type="submit" name="action" value="Login"/>
            <input type="hidden" name="abc" value="12345"/>
            <input type="reset"  value="Reset"/>
        </form>
        <% 
            String error= (String)request.getAttribute("ERROR_MESSAGE");
            if(error== null){
                error= "";
            }
        %>
        <%= error %>
    </body>
</html>
