<%-- 
    Document   : User
    Created on : 30-05-2025, 14:11:26
    Author     : ADMIN
--%>
<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        <h1>Hello User!</h1>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !"US".equals(loginUser.getRoleID())) {
                response.sendRedirect("login.jsp");
                return;
            }
        %>
        User ID: <%= loginUser.getUserID() %></br>
        Full Name: <%= loginUser.getFullName() %></br>
        Role ID: <%= loginUser.getRoleID() %></br>
        Password: <%= loginUser.getPassword() %>
    </body>
</html>
