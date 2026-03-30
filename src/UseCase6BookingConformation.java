/**
 * ============================================================
 * MAIN CLASS – UseCase6BookingConfirmation
 * ============================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Goal:
 * Confirm booking requests by assigning rooms safely while
 * ensuring inventory consistency and preventing double-booking.
 *
 * Flow:
 * - dequeue booking request
 * - check availability
 * - generate unique room ID
 * - record room ID
 * - decrement inventory
 * - confirm reservation
 *
 * @author Developer
 * @version 6.0
 */
public class UseCase6BookingConformation {

    /**
     * Application entry point.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        System.out.println("Reservation Confirmation & Room Allocation\n");

        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        RoomInventory inventory = new RoomInventory();
        BookingService bookingService = new BookingService();

        bookingQueue.addRequest(new Reservation("Abhi", "Single"));
        bookingQueue.addRequest(new Reservation("Subha", "Double"));
        bookingQueue.addRequest(new Reservation("Vannathi", "Suite"));
        bookingQueue.addRequest(new Reservation("Kiran", "Single"));

        while (bookingQueue.hasPendingRequests()) {
            Reservation reservation = bookingQueue.getNextRequest();
            bookingService.confirmReservation(reservation, inventory);
        }

        bookingService.displayAllocatedRooms();

        System.out.println("\nUpdated Inventory:");
        System.out.println("Single -> " + inventory.getAvailability("Single"));
        System.out.println("Double -> " + inventory.getAvailability("Double"));
        System.out.println("Suite -> " + inventory.getAvailability("Suite"));
    }
}