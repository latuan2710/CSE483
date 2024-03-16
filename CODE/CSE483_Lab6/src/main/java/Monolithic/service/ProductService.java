package Monolithic.service;

import java.sql.*;

import Monolithic.model.Product;
import Monolithic.util.DatabaseConnector;

public class ProductService {
    private final NotificationService notificationService = new NotificationService();

    public Product createProduct(Product product) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "INSERT INTO products (productName, productDescription, productPrice) VALUES (?, ?, ?)"
                    , Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, product.getProductName());
            stmt.setString(2, product.getProductDescription());
            stmt.setDouble(3, product.getProductPrice());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();

            if (generatedKeys.next()) {
                Product savedProduct = new Product();

                savedProduct.setProductId(generatedKeys.getInt(1));
                savedProduct.setProductName(product.getProductName());
                savedProduct.setProductDescription(product.getProductDescription());
                savedProduct.setProductPrice(product.getProductPrice());

                notificationService.sendProductNotification(0, -1);
                return savedProduct;
            } else {
                notificationService.sendProductNotification(1, -1);
                return null;
            }
        } catch (SQLException e) {
            notificationService.sendProductNotification(2, -1);
            return null;
        }
    }

    public void deleteProduct(int productId) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String deleteQuery = "DELETE FROM products WHERE productId = ?";
            PreparedStatement stmt = conn.prepareStatement(deleteQuery);
            stmt.setInt(1, productId);
            if (stmt.executeUpdate() == 0) {
                notificationService.sendProductNotification(4, productId);
                return;
            }
            notificationService.sendProductNotification(3, productId);
        } catch (SQLException e) {
            notificationService.sendProductNotification(4, productId);
        }
    }

    public void viewProducts() {
        try (Connection connection = DatabaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Product product = new Monolithic.model.Product();
                    product.setProductId(resultSet.getInt("productId"));
                    product.setProductName(resultSet.getString("productName"));
                    product.setProductDescription(resultSet.getString("productDescription"));
                    product.setProductPrice(resultSet.getDouble("productPrice"));

                    System.out.println(product);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkProductExist(int productId) {
        boolean productExists = false;
        try (Connection conn = DatabaseConnector.getConnection()) {
            String selectProductQuery = "SELECT * FROM products WHERE productId = ?";
            try (PreparedStatement stmt = conn.prepareStatement(selectProductQuery)) {
                stmt.setInt(1, productId);
                ResultSet rs = stmt.executeQuery();
                productExists = rs.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (!productExists)
            notificationService.sendProductNotification(5, productId);

        return productExists;
    }
}
