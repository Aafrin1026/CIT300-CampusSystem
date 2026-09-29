import java.util.Scanner;

/**
 * University Student Record and Campus Route Management System.
 * CIT300 Graded Practical Assignment 1 (Week 10).
 *
 * Menu-driven console interface tying together:
 *   - Linked list (student records)
 *   - Stack (recent actions / history)
 *   - Queue (service requests)
 *   - Hash table (fast ID search)
 *   - BST (ordered search by ID)
 *   - Graph (campus locations + BFS/DFS)
 */
public class Main {

    private static StudentLinkedList studentList = new StudentLinkedList();
    private static ActionStack actionStack = new ActionStack();
    private static ServiceQueue serviceQueue = new ServiceQueue();
    private static StudentHashTable hashTable = new StudentHashTable();
    private static StudentBST bst = new StudentBST();
    private static CampusGraph graph = new CampusGraph();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            choice = readInt("Enter your choice: ");
            switch (choice) {
                case 1: addStudent(); break;
                case 2: updateStudent(); break;
                case 3: deleteStudent(); break;
                case 4: studentList.displayAll(); break;
                case 5: addServiceRequest(); break;
                case 6: processServiceRequest(); break;
                case 7: actionStack.displayAll(); break;
                case 8: bst.displayInOrder(); break;
                case 9: searchStudentHashing(); break;
                case 10: addLocation(); break;
                case 11: removeLocation(); break;
                case 12: addConnection(); break;
                case 13: removeConnection(); break;
                case 14: graph.displayConnections(); break;
                case 15: traverseGraph(); break;
                case 16: System.out.println("Exiting... Goodbye!"); break;
                default: System.out.println("Invalid choice. Please select 1-16."); break;
            }
            System.out.println();
        } while (choice != 16);
        sc.close();
    }

    private static void printMenu() {
        System.out.println("===== University Student Record & Campus Route Management System =====");
        System.out.println("1.  Add Student Record");
        System.out.println("2.  Update Student Record");
        System.out.println("3.  Delete Student Record");
        System.out.println("4.  Display All Records (Linked List)");
        System.out.println("5.  Add Service Request to Queue");
        System.out.println("6.  Process Next Service Request");
        System.out.println("7.  Display Recent Actions (Stack)");
        System.out.println("8.  Display Students (BST, in-order by ID)");
        System.out.println("9.  Search Student (Hashing)");
        System.out.println("10. Add Campus Location");
        System.out.println("11. Remove Campus Location");
        System.out.println("12. Add Campus Connection/Road");
        System.out.println("13. Remove Campus Connection/Road");
        System.out.println("14. Display Campus Connections");
        System.out.println("15. Traverse Campus Locations (BFS/DFS)");
        System.out.println("16. Exit");
    }

    // ---------- Student operations ----------

    private static void addStudent() {
        String id = readNonEmpty("Enter Student ID: ");
        if (hashTable.get(id) != null) {
            System.out.println("Error: A student with ID " + id + " already exists.");
            return;
        }
        String name = readNonEmpty("Enter Name: ");
        String programme = readNonEmpty("Enter Programme: ");
        double marks = readMarks("Enter Marks (0-100): ");

        Student s = new Student(id, name, programme, marks);
        studentList.add(s);
        hashTable.put(s);
        bst.insert(s);
        actionStack.push("Added student " + id + " (" + name + ")");
        System.out.println("Student added successfully.");
    }

    private static void updateStudent() {
        String id = readNonEmpty("Enter Student ID to update: ");
        Student existing = hashTable.get(id);
        if (existing == null) {
            System.out.println("Error: No student found with ID " + id);
            return;
        }
        String name = readNonEmpty("Enter new Name: ");
        String programme = readNonEmpty("Enter new Programme: ");
        double marks = readMarks("Enter new Marks (0-100): ");

        // Same Student object is shared by the list, hash table and BST,
        // so updating its fields in place keeps every structure in sync.
        studentList.update(id, name, programme, marks);
        actionStack.push("Updated student " + id);
        System.out.println("Student updated successfully.");
    }

    private static void deleteStudent() {
        String id = readNonEmpty("Enter Student ID to delete: ");
        if (hashTable.get(id) == null) {
            System.out.println("Error: No student found with ID " + id);
            return;
        }
        studentList.delete(id);
        hashTable.remove(id);
        bst.delete(id);
        actionStack.push("Deleted student " + id);
        System.out.println("Student deleted successfully.");
    }

    private static void searchStudentHashing() {
        String id = readNonEmpty("Enter Student ID to search: ");
        Student s = hashTable.get(id);
        if (s == null) System.out.println("No student found with ID " + id);
        else System.out.println("Found: " + s);
    }

    // ---------- Queue operations ----------

    private static void addServiceRequest() {
        String id = readNonEmpty("Enter Student ID for the request: ");
        String desc = readNonEmpty("Enter request description: ");
        serviceQueue.enqueue(id, desc);
        actionStack.push("Service request added for " + id);
        System.out.println("Service request added.");
    }

    private static void processServiceRequest() {
        if (serviceQueue.isEmpty()) {
            System.out.println("No service requests to process.");
            return;
        }
        String req = serviceQueue.processNext();
        actionStack.push("Processed service request: " + req);
        System.out.println("Processed: " + req);
    }

    // ---------- Graph operations ----------

    private static void addLocation() {
        String name = readNonEmpty("Enter new campus location name: ");
        if (graph.addLocation(name)) {
            actionStack.push("Added campus location " + name);
            System.out.println("Location added.");
        } else {
            System.out.println("Error: Location already exists.");
        }
    }

    private static void removeLocation() {
        String name = readNonEmpty("Enter campus location to remove: ");
        if (graph.removeLocation(name)) {
            actionStack.push("Removed campus location " + name);
            System.out.println("Location removed.");
        } else {
            System.out.println("Error: Location not found.");
        }
    }

    private static void addConnection() {
        String a = readNonEmpty("Enter first location: ");
        String b = readNonEmpty("Enter second location: ");
        if (graph.addConnection(a, b)) {
            actionStack.push("Connected " + a + " <-> " + b);
            System.out.println("Connection added.");
        } else {
            System.out.println("Error: could not add connection " +
                    "(check both locations exist and aren't already connected).");
        }
    }

    private static void removeConnection() {
        String a = readNonEmpty("Enter first location: ");
        String b = readNonEmpty("Enter second location: ");
        if (graph.removeConnection(a, b)) {
            actionStack.push("Disconnected " + a + " <-> " + b);
            System.out.println("Connection removed.");
        } else {
            System.out.println("Error: Connection not found.");
        }
    }

    private static void traverseGraph() {
        String start = readNonEmpty("Enter starting location: ");
        System.out.println("Choose traversal: 1) BFS  2) DFS");
        int c = readInt("Enter choice: ");
        if (c == 1) graph.bfs(start);
        else if (c == 2) graph.dfs(start);
        else System.out.println("Invalid traversal choice.");
    }

    // ---------- Input helpers (validation) ----------

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    private static double readMarks(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                double val = Double.parseDouble(line);
                if (val < 0 || val > 100) {
                    System.out.println("Marks must be between 0 and 100.");
                    continue;
                }
                return val;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
            }
        }
    }

    private static String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            if (!line.isEmpty()) return line;
            System.out.println("This field cannot be empty. Please try again.");
        }
    }
}
