/**
 * ============================================================
 * MAIN CLASS – UseCase10BookingCancellation
 * ============================================================
 *
 * Use Case 10: Booking Cancellation & Inventory Rollback
 *
 * Description:
 * This class demonstrates how confirmed
 * bookings can be cancelled safely.
 *
 * Inventory is restored and rollback
 * history is maintained.
 *
 * @version 10.0
 */
public class UseCase10BookingCancellation {

    /**
     * Application entry point.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {

        System.out.println("Booking Cancellation");

        RoomInventory inventory = new RoomInventory();
        CancellationService cancellationService = new CancellationService();

        // Register a confirmed booking
        cancellationService.registerBooking("Single-1", "Single");

        // Cancel booking and restore inventory
        cancellationService.cancelBooking("Single-1", inventory);

        // Show rollback history
        cancellationService.showRollbackHistory();

        // Display updated inventory
        System.out.println("\nUpdated Single Room Availability: "
                + inventory.getAvailability("Single"));
    }
}