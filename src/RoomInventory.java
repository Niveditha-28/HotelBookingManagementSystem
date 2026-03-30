import java.util.HashMap;
import java.util.Map;

/**
 * ============================================================
 * CLASS – RoomInventory
 * ============================================================
 *
 * Description:
 * Manages room availability using a centralized HashMap.
 *
 * @version 11.0
 */
public class RoomInventory {

    private HashMap<String, Integer> availability;

    public RoomInventory() {
        availability = new HashMap<>();
        availability.put("Single", 3);
        availability.put("Double", 2);
        availability.put("Suite", 1);
    }

    public Map<String, Integer> getRoomAvailability() {
        return availability;
    }

    public int getAvailability(String roomType) {
        return availability.getOrDefault(roomType, 0);
    }

    public void updateAvailability(String roomType, int count) {
        availability.put(roomType, count);
    }

    public void decrementAvailability(String roomType) {
        int current = getAvailability(roomType);
        if (current > 0) {
            availability.put(roomType, current - 1);
        }
    }
}