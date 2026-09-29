import java.util.Stack;

/**
 * Tracks recent actions (add/update/delete/etc.) using a stack.
 * Requirement 3: "Use a stack to maintain recent actions, deleted records, or an undo/history feature."
 */
public class ActionStack {

    private Stack<String> actions = new Stack<>();

    public void push(String action) {
        actions.push(action);
    }

    public void displayAll() {
        if (actions.isEmpty()) {
            System.out.println("No recent actions.");
            return;
        }
        System.out.println("Recent actions (most recent first):");
        for (int i = actions.size() - 1; i >= 0; i--) {
            System.out.println((actions.size() - i) + ". " + actions.get(i));
        }
    }
}
