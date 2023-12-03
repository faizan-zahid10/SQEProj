<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.Date" %>
<%@ page import="your.package.name.AccountTransaction" %>

<%
    // Retrieve form parameters
    String accountNumber = request.getParameter("accountNumber");
    String amountStr = request.getParameter("amount");
    String operation = request.getParameter("operation");

    // Validate input
    boolean isValid = AccountTransaction.validateInput(accountNumber, amountStr, operation);

    // Handle the form submission
    if (isValid) {
        // Parse amount to double
        double amount = Double.parseDouble(amountStr);

        // Simulate various banking operations
        boolean transactionSuccess = AccountTransaction.performTransaction(accountNumber, amount, operation);

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
