import java.util.HashMap;
import java.util.Map;

/**
 * ============================================================
 * CLASS – RoomAllocationService
 * ============================================================
 *
 * Use Case 11: Concurrent Booking Simulation
 *
 * Description:
 * This class allocates rooms and updates
 * inventory in a controlled way.
 *
 * Room IDs are generated per room type.
 *
 * @version 11.0
 */
public class RoomAllocationService {

    private Map<String, Integer> counters;

    public RoomAllocationService() {
        counters = new HashMap<>();
        counters.put("Single", 0);
        counters.put("Double", 0);
        counters.put("Suite", 0);
    }

    /**
     * Allocates a room if available.
     *
     * @param reservation booking request
     * @param inventory shared room inventory
     */
    public void allocateRoom(Reservation reservation, RoomInventory inventory) {

        String roomType = reservation.getRoomType();

        if (inventory.getAvailability(roomType) <= 0) {
            System.out.println("Booking failed for Guest: "
                    + reservation.getGuestName()
                    + ", Room Type: " + roomType
                    + " (No rooms available)");
            return;
        }

        String roomId = generateRoomId(roomType);
        inventory.decrementAvailability(roomType);

        System.out.println("Booking confirmed for Guest: "
                + reservation.getGuestName()
                + ", Room ID: " + roomId);
    }

    /**
     * Generates room ID using room type prefix.
     *
     * @param roomType room type
     * @return room ID
     */
    private String generateRoomId(String roomType) {
        int next = counters.get(roomType) + 1;
        counters.put(roomType, next);

        if (roomType.equals("Single")) {
            return "Single-" + next;
        } else if (roomType.equals("Double")) {
            return "Double-" + next;
        } else {
            return "Suite-" + next;
        }
    }
}