import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Campus locations graph, using an adjacency list.
 * Requirements 7-11: graph representation, add/remove locations and
 * connections, display connections, and BFS/DFS traversal.
 */
public class CampusGraph {

    private Map<String, List<String>> adjList = new LinkedHashMap<>();

    public boolean addLocation(String name) {
        if (adjList.containsKey(name)) return false;
        adjList.put(name, new ArrayList<>());
        return true;
    }

    public boolean removeLocation(String name) {
        if (!adjList.containsKey(name)) return false;
        adjList.remove(name);
        for (List<String> neighbours : adjList.values()) {
            neighbours.remove(name);
        }
        return true;
    }

    public boolean addConnection(String a, String b) {
        if (!adjList.containsKey(a) || !adjList.containsKey(b)) return false;
        if (adjList.get(a).contains(b)) return false; // already connected
        adjList.get(a).add(b);
        adjList.get(b).add(a);
        return true;
    }

    public boolean removeConnection(String a, String b) {
        if (!adjList.containsKey(a) || !adjList.containsKey(b)) return false;
        boolean removed = adjList.get(a).remove(b);
        adjList.get(b).remove(a);
        return removed;
    }

    public void displayConnections() {
        if (adjList.isEmpty()) {
            System.out.println("No campus locations added yet.");
            return;
        }
        for (String loc : adjList.keySet()) {
            System.out.println(loc + " -> " + adjList.get(loc));
        }
    }

    public void bfs(String start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Location not found: " + start);
            return;
        }
        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);
        System.out.print("BFS from " + start + ": ");
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            System.out.print(curr + " ");
            for (String neighbour : adjList.get(curr)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        System.out.println();
    }

    public void dfs(String start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Location not found: " + start);
            return;
        }
        Set<String> visited = new LinkedHashSet<>();
        System.out.print("DFS from " + start + ": ");
        dfsRec(start, visited);
        System.out.println();
    }

    private void dfsRec(String curr, Set<String> visited) {
        visited.add(curr);
        System.out.print(curr + " ");
        for (String neighbour : adjList.get(curr)) {
            if (!visited.contains(neighbour)) {
                dfsRec(neighbour, visited);
            }
        }
    }
}
