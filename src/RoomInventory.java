import java.util.HashMap;
import java.util.Map;

/**
 * ============================================================
 * CLASS – RoomInventory
 * ============================================================
 *
 * Description:
 * Manages centralized room availability using HashMap.
 *
 * @author Developer
 * @version 4.0
 */
class RoomInventory {

    private HashMap<String, Integer> availability;

    public RoomInventory() {
        availability = new HashMap<>();
        availability.put("Single", 5);
        availability.put("Double", 3);
        availability.put("Suite", 2);
    }

    /**
     * Returns the full room availability map.
     *
     * @return room availability map
     */
    public Map<String, Integer> getRoomAvailability() {
        return availability;
    }

    /**
     * Returns availability for a room type.
     *
     * @param roomType room type
     * @return available count
     */
    public int getAvailability(String roomType) {
        return availability.getOrDefault(roomType, 0);
    }

    /**
     * Updates availability in a controlled way.
     *
     * @param roomType room type
     * @param count new count
     */
    public void updateAvailability(String roomType, int count) {
        availability.put(roomType, count);
    }
}