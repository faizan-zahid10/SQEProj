<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Banking Details</title>
</head>
<body>

    <h2>Banking Details</h2>

    <form action="submitForm.jsp" method="post">
        <label for="accountNumber">Account Number:</label>
        <input type="text" id="accountNumber" name="accountNumber" required><br>

        <label for="amount">Amount:</label>
        <input type="text" id="amount" name="amount" required><br>

        <input type="submit" value="Submit">
    </form>

</body>
</html>

