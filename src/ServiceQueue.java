import java.util.LinkedList;
import java.util.Queue;

/**
 * Manages student service requests in order of arrival (FIFO).
 * Requirement 4: "Use a queue to manage student service requests in order of arrival."
 */
public class ServiceQueue {

    private Queue<String> requests = new LinkedList<>();

    public void enqueue(String studentId, String description) {
        requests.add(studentId + " - " + description);
    }

    public String processNext() {
        return requests.poll();
    }

    public boolean isEmpty() {
        return requests.isEmpty();
    }

    public void displayAll() {
        if (requests.isEmpty()) {
            System.out.println("No pending service requests.");
            return;
        }
        int i = 1;
        for (String r : requests) {
            System.out.println((i++) + ". " + r);
        }
    }
}
