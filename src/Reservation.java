/**
 * ============================================================
 * CLASS – Reservation
 * ============================================================
 *
 * Description:
 * Represents a booking request or confirmed reservation.
 *
 * @author Developer
 * @version 8.0
 */
public class Reservation {

    private String guestName;
    private String roomType;

    /**
     * Creates a new reservation.
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
     * Returns room type.
     *
     * @return room type
     */
    public String getRoomType() {
        return roomType;
    }
}