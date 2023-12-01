<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Submit Form</title>
</head>
<body>

    <%-- Retrieve form parameters --%>
    <% String accountNumber = request.getParameter("accountNumber");
       String amountStr = request.getParameter("amount");
       String operation = request.getParameter("operation");

       // Validate input
       boolean isValid = validateInput(accountNumber, amountStr, operation);

       // Handle the form submission
       if (isValid) {
           // Parse amount to double
           double amount = Double.parseDouble(amountStr);

           // Simulate various banking operations (replace with your actual logic)
           boolean transactionSuccess = performTransaction(accountNumber, amount, operation);

           // Display result based on the success of the banking operation
           if (transactionSuccess) {
    %>
               <h2>Transaction Successful</h2>
               <p>Account Number: <%= accountNumber %></p>
               <p>Amount: <%= amount %></p>
               <p>Operation: <%= operation %></p>
               <p>Date: <%= new Date() %></p>
    <%
           } else {
    %>
               <h2>Error</h2>
               <p>Failed to process the transaction. Please try again later.</p>
    <%
           }
       } else {
    %>
           <h2>Error</h2>
           <p>Invalid input. Please check your account number, amount, and operation and try again.</p>
    <%
       }
    %>

<%
    // Validate input method
    private boolean validateInput(String accountNumber, String amount, String operation) {
        // Add your validation logic here
        // For simplicity, we'll check if accountNumber, amount, and operation are not empty
        return accountNumber != null && !accountNumber.isEmpty() &&
               amount != null && !amount.isEmpty() &&
               operation != null && !operation.isEmpty();
    }

    // Simulate various banking operations (replace with your actual logic)
    private boolean performTransaction(String accountNumber, double amount, String operation) {
        //   logic, replace with actual backend or external service calls
        if ("deposit".equals(operation)) {
            // Simulate deposit operation
            return deposit(accountNumber, amount);
        } else if ("withdraw".equals(operation)) {
            // Simulate withdraw operation
            return withdraw(accountNumber, amount);
        } else if ("checkBalance".equals(operation)) {
            // Simulate checking account balance
            return checkBalance(accountNumber);
        } else if ("transfer".equals(operation)) {
            // Simulate transfer operation
            return transfer(accountNumber, "123456", amount);
        } else {
            // Unsupported operation
            return false;
        }
    }

    //   logic for database interactions (replace with your actual database code)
    private boolean deposit(String accountNumber, double amount) {
        try {
            // Connect to your database (replace with your database details)
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdatabase", "username", "password");

            // Perform deposit operation (replace with your actual SQL)
            String depositSQL = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";
            try (PreparedStatement depositStatement = connection.prepareStatement(depositSQL)) {
                depositStatement.setDouble(1, amount);
                depositStatement.setString(2, accountNumber);
                int rowsAffected = depositStatement.executeUpdate();
                if (rowsAffected > 0) {
                    return true;
                } else {
                    System.out.println("Deposit failed: No rows affected");
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Deposit failed: " + e.getMessage());
            return false;
        }
    }

    //   logic for withdrawal
    private boolean withdraw(String accountNumber, double amount) {
        try {
            // Connect to your database (replace with your database details)
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdatabase", "username", "password");

            // Perform withdrawal operation (replace with your actual SQL)
            String withdrawSQL = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
            try (PreparedStatement withdrawStatement = connection.prepareStatement(withdrawSQL)) {
                withdrawStatement.setDouble(1, amount);
                withdrawStatement.setString(2, accountNumber);
                int rowsAffected = withdrawStatement.executeUpdate();
                if (rowsAffected > 0) {
                    return true;
                } else {
                    System.out.println("Withdrawal failed: No rows affected");
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Withdrawal failed: " + e.getMessage());
            return false;
        }
    }

    //   logic for checking balance
    private boolean checkBalance(String accountNumber) {
        try {
            // Connect to your database (replace with your database details)
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdatabase", "username", "password");

            // Retrieve account balance (replace with your actual SQL)
            String balanceSQL = "SELECT balance FROM accounts WHERE account_number = ?";
            try (PreparedStatement balanceStatement = connection.prepareStatement(balanceSQL)) {
                balanceStatement.setString(1, accountNumber);
                ResultSet resultSet = balanceStatement.executeQuery();
                if (resultSet.next()) {
                    double balance = resultSet.getDouble("balance");
                    if (balance >= 0) {
                        return true;
                    } else {
                        System.out.println("Invalid balance: " + balance);
                        return false;
                    }
                } else {
                    System.out.println("Account not found");
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Check balance failed: " + e.getMessage());
            return false;
        }
    }

    //   logic for transfer
    private boolean transfer(String senderAccount, String receiverAccount, double amount) {
        try {
            // Connect to your database (replace with your database details)
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdatabase", "username", "password");

            // Perform transfer operation (replace with your actual SQL)
            String withdrawSQL = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
            String depositSQL = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";
            
            try (PreparedStatement withdrawStatement = connection.prepareStatement(withdrawSQL);
                 PreparedStatement depositStatement = connection.prepareStatement(depositSQL)) {
                
                connection.setAutoCommit(false);

                // Withdraw from sender
                withdrawStatement.setDouble(1, amount);
                withdrawStatement.setString(2, senderAccount);
                int withdrawRowsAffected = withdrawStatement.executeUpdate();

                // Deposit to receiver
                depositStatement.setDouble(1, amount);
                depositStatement.setString(2, receiverAccount);
                int depositRowsAffected = depositStatement.executeUpdate();

                if (withdrawRowsAffected > 0 && depositRowsAffected > 0) {
                    connection.commit();
                    return true;
                } else {
                    connection.rollback();
                    System.out.println("Transfer failed: No rows affected");
                    return false;
                }
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Transfer failed: " + e.getMessage());
            return false;
        }
    }
%>

</body>
</html>

