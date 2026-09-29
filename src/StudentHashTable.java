import java.util.LinkedList;

/**
 * Custom hash table (separate chaining) for O(1)-average student ID lookup.
 * Requirement 6: "Use hashing to support efficient student ID searching."
 *
 * Built from scratch (rather than java.util.HashMap) so the hashing concept
 * is explicitly demonstrated, since that's what the assignment asks for.
 */
public class StudentHashTable {

    private static final int TABLE_SIZE = 101; // prime size reduces clustering

    @SuppressWarnings("unchecked")
    private LinkedList<Student>[] table = new LinkedList[TABLE_SIZE];

    private int hash(String id) {
        int idx = id.hashCode() % TABLE_SIZE;
        return idx < 0 ? idx + TABLE_SIZE : idx;
    }

    public void put(Student s) {
        int idx = hash(s.getId());
        if (table[idx] == null) table[idx] = new LinkedList<>();
        table[idx].add(s);
    }

    public Student get(String id) {
        int idx = hash(id);
        if (table[idx] == null) return null;
        for (Student s : table[idx]) {
            if (s.getId().equals(id)) return s;
        }
        return null;
    }

    public boolean remove(String id) {
        int idx = hash(id);
        if (table[idx] == null) return false;
        return table[idx].removeIf(s -> s.getId().equals(id));
    }
}
