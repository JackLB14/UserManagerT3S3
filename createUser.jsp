<%-- 
    Document   : createUser
    Created on : 17-06-2025, 18:21:47
    Author     : ADMIN
--%>
<%@page import="sample.user.UserError" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create User Page</title>
    </head>
    <body>
        Input user information
        <%
            UserError userError= (UserError) request.getAttribute("USER_ERROR");
            if(userError == null){
                userError = new UserError();
            }
            String keyword = (String) request.getAttribute("keyword");
            if (keyword == null) {
                keyword = "";
        }
        %>
       <form action="Maincontroller" method="POST">
            User ID: <input type ="text" name="userID" required="<%= keyword %>"><%= userError.getUserIDError() %>
            </br>Full Name: <input type ="text" name="fullName" required=""><%= userError.getFullNameError() %>
            </br>Role ID: <select name="roleID">
                <option value="AD">Manager</option>
                <option value="US">User</option>
                <option value="OR">Other</option>
            </select><%= userError.getRoleIDError() %>
            </br>Password: <input type="password" name="password" required=""/>
            </br>Confirm: <input type="password" name="confirm" required=""/><%= userError.getPasswordError() %>
            </br><input type="submit" name="action" value="Create"/>
            <input type="reset" value="Reset"/>
        </form>
    </body>
</html>
