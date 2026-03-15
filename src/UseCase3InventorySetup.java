/**
 * ============================================================
 * MAIN CLASS – UseCase3InventorySetup
 * ============================================================
 *
 * Use Case 3: Centralized Room Inventory Management
 *
 * Description:
 * This class demonstrates how room availability can be
 * managed using a centralized inventory structure.
 *
 * At this stage, the application:
 * - Initializes the inventory component
 * - Stores room availability in a HashMap
 * - Retrieves availability using room type keys
 * - Updates availability through controlled methods
 * - Displays the current inventory state
 *
 * This removes scattered state and introduces a
 * single source of truth for room availability.
 *
 * @author Developer
 * @version 3.0
 */
public class UseCase3InventorySetup {

    /**
     * Application entry point for UC3.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        System.out.println("Centralized Room Inventory Management\n");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Display initial inventory
        inventory.displayInventory();

        System.out.println();

        // Retrieve current availability
        System.out.println("Available Single Rooms: "
                + inventory.getAvailability("Single Room"));

        // Update availability
        inventory.updateAvailability("Single Room", 4);

        System.out.println("\nAfter Updating Single Room Availability:\n");
        inventory.displayInventory();
    }
}