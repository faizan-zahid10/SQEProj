<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home Page</title>
</head>
<body>

    <h2>Welcome to the Home Page!</h2>

    <!-- Button to navigate to the profile page -->
    <button onclick="navigateToProfile()">Profile</button>

    //<script>
        // JavaScript function to navigate to the profile page
      //  function navigateToProfile() {
            // Redirect to the profile page URL
        //    window.location.href = '/profile.jsp';
       // }
    // </script>

    <%-- Fetch user information from the database (replace with your actual database logic) --%>
    <%
        try {
            // Connect to your database (replace with your database details)
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdatabase", "username", "password");

            // Query to fetch user information (replace with your actual SQL)
            String query = "SELECT * FROM user WHERE username = 'current_user'";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                ResultSet resultSet = statement.executeQuery();
                
                if (resultSet.next()) {
                    // Display user information (replace with your actual HTML structure)
    %>
                    <div>
                        <h3>User Information:</h3>
                        <p>Username: <%= resultSet.getString("username") %></p>
                        <p>Email: <%= resultSet.getString("email") %></p>
                        <p>Address: <%= resultSet.getString("address") %></p>
                        <!-- Add more fields as needed -->
                    </div>
    <%
                } else {
                    // User not found
    %>
                    <div>
                        <p>User not found.</p>
                    </div>
    <%
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    %>

</body>
</html>
