# University Student Record and Campus Route Management System

CIT300 Data Structures and Algorithms — Graded Practical Assignment 1

## Group Members

| Name | Student ID | Responsibility | Contribution |
|------|-----------|-----------------|---------------|
| [H.Aafrin Banu] | [23DA2-0659] | Linked list + student record management | |
| [AF.Hilma] | [23DA2-0981] | Stack + queue implementation | |
| [RF.Raseedha] | [23DA2-0959] | BST + hashing/search functionality | |
| [JF.Samrootha] | [23DA2-0813] | Graph + BFS/DFS traversal | |

## How to Compile and Run

From the project root:

```
javac -d bin src/*.java
java -cp bin Main
```

## Project Structure

- `Student.java` — student record model
- `StudentLinkedList.java` — linked list storing/managing student records (add, update, delete, display)
- `ActionStack.java` — stack tracking recent actions/history
- `ServiceQueue.java` — queue for student service requests (FIFO)
- `StudentHashTable.java` — custom hash table (separate chaining) for O(1)-average student ID search
- `StudentBST.java` — binary search tree of students, keyed by Student ID, for ordered search/display
- `CampusGraph.java` — campus locations as an adjacency list, with add/remove location & connection, display, and BFS/DFS traversal
- `Main.java` — menu-driven console interface tying everything together, with input validation

## How the Requirements Map to the Code

| Requirement | Where |
|---|---|
| Linked list for student records | `StudentLinkedList.java` |
| Stack for recent actions | `ActionStack.java` |
| Queue for service requests | `ServiceQueue.java` |
| BST for organizing/searching by ID | `StudentBST.java` |
| Hashing for student ID search | `StudentHashTable.java` |
| Graph (adjacency list) for campus locations | `CampusGraph.java` |
| BFS / DFS traversal | `CampusGraph.bfs()` / `CampusGraph.dfs()` |
| Menu-driven interface + validation | `Main.java` |

All 16 menu items from the assignment spec are implemented (add/update/delete/display students, service queue, action history, BST display, hash search, location/connection add-remove-display, BFS/DFS traversal, exit).

