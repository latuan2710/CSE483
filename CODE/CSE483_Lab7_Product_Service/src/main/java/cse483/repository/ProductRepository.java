package cse483.repository;

import cse483.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
    Product findByProductId(String productId);

    void deleteByProductId(String productId);
}
