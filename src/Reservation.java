/**
 * ============================================================
 * CLASS – Reservation
 * ============================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Description:
 * This class represents a booking request made by a guest.
 * It stores the guest name and requested room type.
 *
 * @author Developer
 * @version 6.0
 */
public class Reservation {

    private String guestName;
    private String roomType;

    /**
     * Creates a new reservation request.
     *
     * @param guestName name of the guest
     * @param roomType requested room type
     */
    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    /**
     * Returns guest name.
     *
     * @return guest name
     */
    public String getGuestName() {
        return guestName;
    }

    /**
     * Returns requested room type.
     *
     * @return room type
     */
    public String getRoomType() {
        return roomType;
    }
}