import java.util.HashMap;
import java.util.Map;

/**
 * ============================================================
 * CLASS – RoomInventory
 * ============================================================
 *
 * Description:
 * This class manages room availability using a centralized
 * HashMap data structure.
 *
 * It provides:
 * - Registration of room types
 * - Availability lookup
 * - Controlled inventory updates
 * - Display of current inventory state
 *
 * This ensures a single source of truth for room availability.
 *
 * @author Developer
 * @version 3.0
 */
class RoomInventory {

    private HashMap<String, Integer> inventory;

    /**
     * Initializes the room inventory with default room counts.
     */
    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    /**
     * Returns current availability for a given room type.
     *
     * @param roomType type of room
     * @return available count
     */
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    /**
     * Updates room availability in a controlled way.
     *
     * @param roomType type of room
     * @param newCount updated count
     */
    public void updateAvailability(String roomType, int newCount) {
        inventory.put(roomType, newCount);
    }

    /**
     * Displays the entire inventory state.
     */
    public void displayInventory() {
        System.out.println("Current Room Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}