package Monolithic.service;

import Monolithic.model.Product;
import Monolithic.util.DatabaseConnector;

import java.sql.*;
import java.util.List;
import java.util.Random;

public class OrderService {
    private final InventoryService inventoryService = new InventoryService();
    private final NotificationService notificationService = new NotificationService();
    private final ProductService productService = new ProductService();

    public void placeOrder(List<Product> products) {
        for (Product product : products) {
            boolean isProductInStock = inventoryService.isProductInStock(product.getProductId());
            boolean isProductExist = productService.checkProductExist(product.getProductId());
            if (!isProductInStock || !isProductExist) {
                notificationService.sendOrderNotification(0);
                return;
            }
        }

        int orderId = this.createOrder();
        if (orderId == -1) {
            notificationService.sendOrderNotification(0);
            return;
        }

        for (Product product : products) {
            this.createOrderLineItem(orderId, product.getProductId(), product.getProductPrice());
            inventoryService.updateProductQuanity(product.getProductId(), -1);
        }
        notificationService.sendOrderNotification(1);
    }

    private int createOrder() {
        int orderId = -1;

        try (Connection conn = DatabaseConnector.getConnection()) {
            String insertOrderQuery = "INSERT INTO orders (orderNumber) VALUES (?)";
            PreparedStatement stmt = conn.prepareStatement(insertOrderQuery, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, this.getOrderNumber());

            if (stmt.executeUpdate() != 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    orderId = generatedKeys.getInt(1);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return orderId;
    }

    private void createOrderLineItem(int orderId, int productId, double productPrice) {
        try (Connection conn = DatabaseConnector.getConnection()) {
            String insertOrderLineItemQuery = "INSERT INTO orderlineitem (orderId, orderLineSkuCode, quantity, productPrice) VALUES (?, ?, 1, ?)";
            PreparedStatement stmt = conn.prepareStatement(insertOrderLineItemQuery);

            stmt.setInt(1, orderId);
            stmt.setInt(2, productId);
            stmt.setDouble(3, productPrice);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private String getOrderNumber() {
        int length = 8;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        Random random = new Random();
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            sb.append(characters.charAt(randomIndex));
        }

        return sb.toString();
    }
}
