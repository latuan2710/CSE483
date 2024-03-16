package Monolithic.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnector {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/cse483_lab6";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    public static void createDatabase() {
        try (Connection connection = DatabaseConnector.getConnection()) {
            Statement statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS products (" +
                    "productId INT AUTO_INCREMENT PRIMARY KEY," +
                    "productName VARCHAR(255) NOT NULL," +
                    "productDescription TEXT," +
                    "productPrice DECIMAL(10,2) NOT NULL" + ")");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS orders (" +
                    "orderId INT AUTO_INCREMENT PRIMARY KEY," +
                    "orderNumber VARCHAR(50) NOT NULL UNIQUE" + ")");

            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS OrderLineItem ("
                            + "orderLineId INT AUTO_INCREMENT PRIMARY KEY,"
                            + "orderId INT," + "orderLineSkuCode INT,"
                            + "productPrice DECIMAL(10, 2) NOT NULL,"
                            + "quantity INT NOT NULL,"
                            + "FOREIGN KEY (orderId) REFERENCES orders(orderId) ON DELETE CASCADE,"
                            + "FOREIGN KEY (orderLineSkuCode) REFERENCES products(productId) ON DELETE CASCADE"
                            + ")");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Inventory ("
                    + "invId INT AUTO_INCREMENT PRIMARY KEY,"
                    + "productId INT,"
                    + "quantity INT NOT NULL,"
                    + "FOREIGN KEY (productId) REFERENCES products(productId) ON DELETE CASCADE"
                    + ")");

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
