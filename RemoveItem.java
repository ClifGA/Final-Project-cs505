import java.util.ArrayList;

public class RemoveItem {

    // Method to remove an item by name
    public static void removeItemByName(ArrayList<InventoryItem> inventory, String itemName) {
        boolean itemFound = false;
        for (InventoryItem item : inventory) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                inventory.remove(item);
                System.out.println(itemName + " has been removed from the inventory.");
                itemFound = true;
                break;
            }
        }
        if (!itemFound) {
            System.out.println("Item with name " + itemName + " not found.");
        }
    }
}
