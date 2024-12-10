public class InventoryItem {
    private String itemName;
    private int quantity;
    private double price;

    // Constructor
    public InventoryItem(String itemName, int quantity, double price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters
    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    // Setters (optional if needed)
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Abstract method to be overridden in subclasses
    public String getItemType() {
        return "Generic Item";
    }

    @Override
    public String toString() {
        return itemName + " - Quantity: " + quantity + ", Price: $" + price;
    }
}
