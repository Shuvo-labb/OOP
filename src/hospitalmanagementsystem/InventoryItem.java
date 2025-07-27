/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
// File: InventoryItem.java
package hospitalmanagementsystem;

/**
 * Represents an item in the hospital's inventory.
 * Demonstrates Encapsulation (CLO1, CLO3).
 */
public class InventoryItem {
    private String itemId;
    private String name;
    private int quantity;
    private String supplier;

    public InventoryItem(String itemId, String name, int quantity, String supplier) {
        this.itemId = itemId;
        this.name = name;
        this.quantity = quantity;
        this.supplier = supplier;
    }

    // Getters
    public String getItemId() { return itemId; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
    public String getSupplier() { return supplier; }

    // Setters (for updating stock levels)
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setName(String name) { this.name = name; }
    public void setSupplier(String supplier) { this.supplier = supplier; }

    @Override
    public String toString() {
        return "InventoryItem{" + "itemId=" + itemId + ", name=" + name + ", quantity=" + quantity + ", supplier=" + supplier + '}';
    }
}
