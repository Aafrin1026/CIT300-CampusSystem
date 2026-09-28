/**
 * Singly linked list storing all student records.
 * Requirement 2: "Use a linked list to store and manage student records."
 */
public class StudentLinkedList {

    private class Node {
        Student data;
        Node next;
        Node(Student data) { this.data = data; }
    }

    private Node head;
    private int size;

    /** Returns false if a student with this ID already exists (duplicate check). */
    public boolean add(Student s) {
        if (search(s.getId()) != null) return false;
        Node newNode = new Node(s);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) curr = curr.next;
            curr.next = newNode;
        }
        size++;
        return true;
    }

    public Student search(String id) {
        Node curr = head;
        while (curr != null) {
            if (curr.data.getId().equals(id)) return curr.data;
            curr = curr.next;
        }
        return null;
    }

    public boolean update(String id, String name, String programme, double marks) {
        Student s = search(id);
        if (s == null) return false;
        s.setName(name);
        s.setProgramme(programme);
        s.setMarks(marks);
        return true;
    }

    public boolean delete(String id) {
        if (head == null) return false;
        if (head.data.getId().equals(id)) {
            head = head.next;
            size--;
            return true;
        }
        Node curr = head;
        while (curr.next != null) {
            if (curr.next.data.getId().equals(id)) {
                curr.next = curr.next.next;
                size--;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public void displayAll() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
    }

    public int size() { return size; }
}
