import java.util.HashMap;
import java.util.Map;

/**
 * ============================================================
 * CLASS – RoomInventory
 * ============================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Description:
 * This class manages room availability using a centralized
 * HashMap. It acts as the single source of truth for
 * available room counts.
 *
 * @author Developer
 * @version 6.0
 */
public class RoomInventory {

    private HashMap<String, Integer> availability;

    /**
     * Initializes room availability.
     */
    public RoomInventory() {
        availability = new HashMap<>();
        availability.put("Single", 5);
        availability.put("Double", 3);
        availability.put("Suite", 2);
    }

    /**
     * Returns full availability map.
     *
     * @return availability map
     */
    public Map<String, Integer> getRoomAvailability() {
        return availability;
    }

    /**
     * Returns current availability for a room type.
     *
     * @param roomType room type
     * @return available count
     */
    public int getAvailability(String roomType) {
        return availability.getOrDefault(roomType, 0);
    }

    /**
     * Updates room availability directly.
     *
     * @param roomType room type
     * @param count updated count
     */
    public void updateAvailability(String roomType, int count) {
        availability.put(roomType, count);
    }

    /**
     * Decrements availability after successful allocation.
     *
     * @param roomType room type
     */
    public void decrementAvailability(String roomType) {
        int current = getAvailability(roomType);
        if (current > 0) {
            availability.put(roomType, current - 1);
        }
    }
}