/**
 * Abstract Room class representing common attributes of hotel rooms
 */
abstract class Room {

    private int beds;
    private int size;
    private double price;
    private int available;

    public Room(int beds, int size, double price, int available) {
        this.beds = beds;
        this.size = size;
        this.price = price;
        this.available = available;
    }

    public int getBeds() {
        return beds;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailable() {
        return available;
    }

    public abstract String getRoomType();
}