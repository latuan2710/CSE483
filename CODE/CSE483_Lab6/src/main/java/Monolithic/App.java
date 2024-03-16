package Monolithic;

import Monolithic.model.Product;
import Monolithic.service.InventoryService;
import Monolithic.service.OrderService;
import Monolithic.service.ProductService;
import Monolithic.util.DatabaseConnector;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        DatabaseConnector.createDatabase();

        ProductService productService = new ProductService();
        InventoryService inventoryService = new InventoryService();
        OrderService orderService = new OrderService();

        Product product1 = new Product("produc1tName", "productDescription", 10);
        Product product2 = new Product("produc2tName", "productDescription", 10);
        Product product3 = new Product("produc3tName", "productDescription", 10);

        product1 = productService.createProduct(product1);
        product2 = productService.createProduct(product2);
        product3 = productService.createProduct(product3);
        productService.viewProducts();

        inventoryService.addProductIntoInventory(product1.getProductId(), 10);
        inventoryService.addProductIntoInventory(product2.getProductId(), 10);
        inventoryService.addProductIntoInventory(product3.getProductId(), 10);
        inventoryService.viewInventories();

        inventoryService.addProductIntoInventory(product1.getProductId(), 9);
        inventoryService.addProductIntoInventory(product1.getProductId(), 8);
        inventoryService.viewInventories();

        productService.deleteProduct(product1.getProductId());

        productService.viewProducts();
        inventoryService.viewInventories();

        orderService.placeOrder(new ArrayList<>(List.of(product1, product2, product3)));

        inventoryService.viewInventories();

        orderService.placeOrder(new ArrayList<>(List.of(product2, product3)));

        inventoryService.viewInventories();
    }
}
