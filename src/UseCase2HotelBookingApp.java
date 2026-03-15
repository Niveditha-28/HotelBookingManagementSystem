/**
 * ======================================================
 * MAIN CLASS – UseCase2HotelBookingApp
 * ======================================================
 *
 * Use Case 2: Basic Room Types and Static Availability
 *
 * Demonstrates:
 * - Abstract class
 * - Inheritance
 * - Encapsulation
 * - Polymorphism
 */
public class UseCase2HotelBookingApp {

    public static void main(String[] args) {

        System.out.println("Hotel Room Initialization\n");

        Room[] rooms = {
                new SingleRoom(),
                new DoubleRoom(),
                new SuiteRoom()
        };

        for (Room room : rooms) {

            System.out.println(room.getRoomType() + ":");
            System.out.println("Beds: " + room.getBeds());
            System.out.println("Size: " + room.getSize() + " sqft");
            System.out.println("Price per night: " + room.getPrice());
            System.out.println("Available: " + room.getAvailable());
            System.out.println();
        }
    }
}
