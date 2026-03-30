import java.util.LinkedList;
import java.util.Queue;

/**
 * ============================================================
 * CLASS – BookingRequestQueue
 * ============================================================
 *
 * Use Case 6: Reservation Confirmation & Room Allocation
 *
 * Description:
 * This class manages booking requests in FIFO order.
 * Requests are processed in the order they are received.
 *
 * @author Developer
 * @version 6.0
 */
public class BookingRequestQueue {

    private Queue<Reservation> requestQueue;

    /**
     * Initializes the booking request queue.
     */
    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    /**
     * Adds a reservation request to the queue.
     *
     * @param reservation reservation request
     */
    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
    }

    /**
     * Removes and returns the next reservation request.
     *
     * @return next reservation
     */
    public Reservation getNextRequest() {
        return requestQueue.poll();
    }

    /**
     * Checks if there are pending requests.
     *
     * @return true if queue is not empty
     */
    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }
}