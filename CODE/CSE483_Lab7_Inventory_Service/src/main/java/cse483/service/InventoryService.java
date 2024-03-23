package cse483.service;

import cse483.entity.Inventory;
import cse483.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public Inventory getInventoryByInventoryNumber(int inventoryNumber) {
        return inventoryRepository.findByInventoryNumber(inventoryNumber);
    }

    public void deleteInventory(int inventoryNumber) {
        inventoryRepository.deleteByInventoryNumber(inventoryNumber);
    }

    public Inventory saveInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    public List<Inventory> getAllInventories() {
        return inventoryRepository.findAll();
    }
}
