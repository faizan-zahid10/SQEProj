import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountTransaction {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/yourdatabase";
    private static final String DB_USER = "username";
    private static final String DB_PASSWORD = "password";

    public static boolean validateInput(String accountNumber, String amount, String operation) {
        return accountNumber != null && !accountNumber.isEmpty() &&
                amount != null && !amount.isEmpty() &&
                operation != null && !operation.isEmpty();
    }

    public static boolean performTransaction(String accountNumber, double amount, String operation) {
        if ("deposit".equals(operation)) {
            return deposit(accountNumber, amount);
        } else if ("withdraw".equals(operation)) {
            return withdraw(accountNumber, amount);
        } else if ("checkBalance".equals(operation)) {
            return checkBalance(accountNumber);
        } else if ("transfer".equals(operation)) {
            return transfer(accountNumber, "123456", amount);
        } else {
            return false;
        }
    }

    private static boolean deposit(String accountNumber, double amount) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String depositSQL = "UPDATE accounts SET balance = balance + ? WHERE account_number = ?";
            try (PreparedStatement depositStatement = connection.prepareStatement(depositSQL)) {
                depositStatement.setDouble(1, amount);
                depositStatement.setString(2, accountNumber);
                int rowsAffected = depositStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean withdraw(String accountNumber, double amount) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String withdrawSQL = "UPDATE accounts SET balance = balance - ? WHERE account_number = ?";
            try (PreparedStatement withdrawStatement = connection.prepareStatement(withdrawSQL)) {
                withdrawStatement.setDouble(1, amount);
                withdrawStatement.setString(2, accountNumber);
                int rowsAffected = withdrawStatement.executeUpdate();
                return rowsAffected > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean checkBalance(String accountNumber) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String balanceSQL = "SELECT balance FROM accounts WHERE account_number = ?";
            try (PreparedStatement balanceStatement = connection.prepareStatement(balanceSQL)) {
                balanceStatement.setString(1, accountNumber);
                ResultSet resultSet = balanceStatement.executeQuery();
                if (resultSet.next()) {
                    double balance = resultSet.getDouble("balance");
                    return balance >= 0;
                } else {
                    return false;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean transfer(String senderAccount, String receiverAccount, double amount) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
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
                    return false;
                }
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
