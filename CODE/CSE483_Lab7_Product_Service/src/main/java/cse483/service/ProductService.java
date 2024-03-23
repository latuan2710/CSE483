package cse483.service;

import cse483.dto.Inventory;
import cse483.dto.ProductRespond;
import cse483.entity.Product;
import cse483.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity<?> createProduct(Product product) {
        try {
            Inventory inventory = restTemplate.getForObject(
                    "http://localhost:8082/inventory/" + product.getInventoryNumber(), Inventory.class);
            if(inventory==null){
                return new ResponseEntity<>("Not Found Inventory", HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<>(productRepository.save(product), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> deleteProduct(String id) {
        try {
            productRepository.deleteByProductId(id);
            return new ResponseEntity<>("Delete product successfully!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> fetchProductById(String id) {
        Product product = productRepository.findByProductId(id);

        if (product != null) {
            Inventory inventory = restTemplate.getForObject(
                    "http://localhost:8082/inventory/" + product.getInventoryNumber(), Inventory.class);
            ProductRespond productResponse = ProductRespond.builder()
                    .productId(product.getProductId())
                    .productName(product.getProductName())
                    .productPrice(product.getProductPrice())
                    .productDescription(product.getProductDescription())
                    .inventory(inventory)
                    .build();
            return new ResponseEntity<>(productResponse, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No Product Found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> fetchProducts() {
        List<Product> products = productRepository.findAll();

        if (products.isEmpty()) {
            return new ResponseEntity<>("No Products", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(products, HttpStatus.OK);
        }
    }
}
