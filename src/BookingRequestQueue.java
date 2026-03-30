import java.util.LinkedList;
import java.util.Queue;

/**
 * ============================================================
 * CLASS – BookingRequestQueue
 * ============================================================
 *
 * Description:
 * Stores booking requests in FIFO order.
 *
 * @version 11.0
 */
public class BookingRequestQueue {

    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    public void addRequest(Reservation reservation) {
        requestQueue.offer(reservation);
    }

    public Reservation getNextRequest() {
        return requestQueue.poll();
    }

    public boolean hasPendingRequests() {
        return !requestQueue.isEmpty();
    }
}