<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.http.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Profile</title>
</head>
<body>

<%
    String current_user = (String) session.getAttribute("current_user");

    if (current_user != null && !current_user.isEmpty()) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommjava", "username", "password");
            String query = "SELECT * FROM CUSTOMER WHERE username = ?";

            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, current_user);
                ResultSet resultSet = statement.executeQuery();

                if (resultSet.next()) {
                    // Print user information
%>
<div>
    <p>User ID: <%= resultSet.getInt("id") %></p>
    <p>Username: <%= resultSet.getString("username") %></p>
    <p>Address: <%= resultSet.getString("address") %></p>
</div>
<%
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
} else {
%>
<div>
    <p>User not authenticated.</p>
</div>
<%
    }
%>

</body>
</html>
