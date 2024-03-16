package Monolithic.service;

import java.sql.*;

import Monolithic.model.Inventory;
import Monolithic.util.DatabaseConnector;

public class InventoryService {
    private final NotificationService notificationService = new NotificationService();
    private final ProductService productService = new ProductService();

    public boolean isProductInStock(int productId) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String selectInventoryQuery = "SELECT quantity FROM inventory WHERE productId = ?";
            PreparedStatement stmt = conn.prepareStatement(selectInventoryQuery);

            stmt.setInt(1, productId);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int availableQuantity = rs.getInt("quantity");

                if (availableQuantity > 0) {
                    return true;
                } else {
                    notificationService.sendInventoryNotification(1, productId, -1);
                    return false;
                }
            } else {
                notificationService.sendInventoryNotification(2, productId, -1);
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkProductExistInInventory(int productId) {
        boolean productExists = false;
        try (Connection conn = DatabaseConnector.getConnection()) {
            String selectInventoryQuery = "SELECT * FROM inventory WHERE productId = ?";
            try (PreparedStatement stmt = conn.prepareStatement(selectInventoryQuery)) {
                stmt.setInt(1, productId);
                ResultSet rs = stmt.executeQuery();
                productExists = rs.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return productExists;
    }

    public void addProductIntoInventory(int productId, int quantity) {
        if (productService.checkProductExist(productId)) {
            if (this.checkProductExistInInventory(productId)) {
                this.updateProductQuanity(productId, quantity);
                return;
            }
        }

        try (Connection conn = DatabaseConnector.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO Inventory (productId, quantity) VALUES (?, ?)");
            stmt.setInt(1, productId);
            stmt.setInt(2, quantity);
            stmt.executeUpdate();

            notificationService.sendInventoryNotification(4, productId, quantity);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateProductQuanity(int productId, int quantity) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String updateInventoryQuery = "UPDATE Inventory SET quantity = quantity + ? WHERE productId = ?";
            PreparedStatement stmt = conn.prepareStatement(updateInventoryQuery);
            stmt.setInt(1, quantity);
            stmt.setInt(2, productId);
            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                notificationService.sendInventoryNotification(4, productId, quantity);
            }
        } catch (SQLException e) {
            System.err.println("Error updating product quantity: " + e.getMessage());
        }
    }

    public void viewInventories() {
        try (Connection connection = DatabaseConnector.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Inventory");

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Inventory inventory = new Inventory();
                    inventory.setInvId(resultSet.getInt(1));
                    inventory.setProductId(resultSet.getInt(2));
                    inventory.setQuantity(resultSet.getInt(3));

                    System.out.println(inventory);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
