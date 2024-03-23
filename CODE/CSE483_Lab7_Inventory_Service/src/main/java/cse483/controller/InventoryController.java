package cse483.controller;

import cse483.entity.Inventory;
import cse483.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @GetMapping("/{inventoryNumber}")
    public Inventory getInventoryByInventoryNumber(@PathVariable int inventoryNumber) {
        return inventoryService.getInventoryByInventoryNumber(inventoryNumber);
    }

    @GetMapping
    public List<Inventory> getAllInventories() {
        return inventoryService.getAllInventories();
    }

    @PostMapping
    public Inventory addInventory(@RequestBody Inventory inventory) {
        return inventoryService.saveInventory(inventory);
    }

    @DeleteMapping("/{inventoryNumber}")
    public void deleteInventory(@PathVariable int inventoryNumber) {
        inventoryService.deleteInventory(inventoryNumber);
    }

    @PutMapping("/{inventoryNumber}")
    public Inventory updateInventory(@RequestBody Inventory inventory, @PathVariable int inventoryNumber) {
        inventory.setInventoryNumber(inventoryNumber);
        return inventoryService.saveInventory(inventory);
    }
}
