public class NewItem extends InventoryItem {
    private String condition;
    private String location;
    private String warrantyPeriod;

    // Constructor
    public NewItem(String itemName, int quantity, double price, String condition, String location, String warrantyPeriod) {
        super(itemName, quantity, price);  // Call parent constructor
        this.condition = condition;
        this.location = location;
        this.warrantyPeriod = warrantyPeriod;
    }

    // Getters
    public String getCondition() {
        return condition;
    }

    public String getLocation() {
        return location;
    }

    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    // Override getItemType to return specific type
    @Override
    public String getItemType() {
        return "New Item";
    }

    @Override
    public String toString() {
        return super.toString() + ", Condition: " + condition + ", Location: " + location + ", Warranty: " + warrantyPeriod;
    }
}
