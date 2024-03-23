package cse483.repository;

import cse483.entity.Inventory;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    Inventory findByInventoryNumber(int inventoryNumber);

    @Transactional
    void deleteByInventoryNumber(int inventoryNumber);
}
