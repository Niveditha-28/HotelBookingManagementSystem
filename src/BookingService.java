import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * ============================================================
 * CLASS – BookingService
 * ============================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Description:
 * This class processes queued booking requests and performs
 * safe room allocation while preventing double-booking.
 *
 * Concepts used:
 * - Set for uniqueness
 * - HashMap for grouping allocated room IDs by room type
 * - Immediate inventory synchronization
 *
 * @author Developer
 * @version 6.0
 */
public class BookingService {

    private Map<String, Set<String>> allocatedRooms;
    private Set<String> allAllocatedRoomIds;
    private Map<String, Integer> roomCounters;

    /**
     * Initializes allocation tracking structures.
     */
    public BookingService() {
        allocatedRooms = new HashMap<>();
        allAllocatedRoomIds = new HashSet<>();
        roomCounters = new HashMap<>();

        allocatedRooms.put("Single", new HashSet<>());
        allocatedRooms.put("Double", new HashSet<>());
        allocatedRooms.put("Suite", new HashSet<>());

        roomCounters.put("Single", 0);
        roomCounters.put("Double", 0);
        roomCounters.put("Suite", 0);
    }

    /**
     * Confirms a reservation if availability exists.
     * Generates a unique room ID, stores it, updates inventory,
     * and prints confirmation.
     *
     * @param reservation reservation request
     * @param inventory inventory service
     */
    public void confirmReservation(Reservation reservation, RoomInventory inventory) {
        String roomType = reservation.getRoomType();

        if (inventory.getAvailability(roomType) <= 0) {
            System.out.println("Booking failed for Guest: " + reservation.getGuestName()
                    + ", Room Type: " + roomType
                    + " (No rooms available)");
            return;
        }

        String roomId = generateUniqueRoomId(roomType);

        allocatedRooms.get(roomType).add(roomId);
        allAllocatedRoomIds.add(roomId);

        inventory.decrementAvailability(roomType);

        System.out.println("Reservation confirmed for Guest: " + reservation.getGuestName()
                + ", Room Type: " + roomType
                + ", Room ID: " + roomId);
    }

    /**
     * Generates a unique room ID based on room type.
     *
     * @param roomType room type
     * @return unique room ID
     */
    private String generateUniqueRoomId(String roomType) {
        String prefix;

        if (roomType.equals("Single")) {
            prefix = "SG";
        } else if (roomType.equals("Double")) {
            prefix = "DB";
        } else {
            prefix = "ST";
        }

        while (true) {
            int next = roomCounters.get(roomType) + 1;
            roomCounters.put(roomType, next);

            String roomId = prefix + next;

            if (!allAllocatedRoomIds.contains(roomId)) {
                return roomId;
            }
        }
    }

    /**
     * Displays allocated room IDs grouped by room type.
     */
    public void displayAllocatedRooms() {
        System.out.println("\nAllocated Rooms:");
        for (Map.Entry<String, Set<String>> entry : allocatedRooms.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}