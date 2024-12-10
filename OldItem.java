public class OldItem extends InventoryItem {
    private String damageDescription;

    // Constructor
    public OldItem(String itemName, int quantity, double price, String damageDescription) {
        super(itemName, quantity, price);  // Call parent constructor
        this.damageDescription = damageDescription;
    }

    // Getter
    public String getDamageDescription() {
        return damageDescription;
    }

    // Override getItemType to return specific type
    @Override
    public String getItemType() {
        return "Old Item";
    }

    @Override
    public String toString() {
        return super.toString() + ", Damage Description: " + damageDescription;
    }
}
