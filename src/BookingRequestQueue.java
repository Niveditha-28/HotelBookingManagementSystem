import java.util.LinkedList;
import java.util.Queue;

/**
 * ============================================================
 * CLASS – BookingRequestQueue
 * ============================================================
 *
 * Description:
 * Manages booking requests using FIFO ordering.
 *
 * @version 9.0
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