# University Student Record and Campus Route Management System

CIT300 Data Structures and Algorithms — Graded Practical Assignment 

## Group Members

| Name | Student ID | Responsibility | Contribution |
|------|-----------|-----------------|---------------|
| [H.Aafrin Banu] (Group Leader) | [23DA2-0659] | Linked list + student record management | | Implemented Student.java and StudentLinkedList.java (add, update, delete, search, display with duplicate-ID checks). Built Main.java menu and input validation, integrated all data structures, set up the GitHub repository, reviewed and merged pull requests, wrote the README. |
| [AF.Hilma] | [23DA2-0981] | Stack + queue implementation | | Implemented ActionStack.java (recent actions history, LIFO) and ServiceQueue.java (service requests, FIFO). Tested enqueue/dequeue and history display. Committed on branch feature/stack-queue and opened a pull request. |
| [RF.Raseedha] | [23DA2-0959] | BST + hashing/search functionality | | Implemented StudentBST.java (insert, search, delete, in-order display by Student ID) and StudentHashTable.java (custom hash table with separate chaining for ID search). Committed on branch feature/bst-hashing and opened a pull request. |
| [JF.Samrootha] | [23DA2-0813] | Graph + BFS/DFS traversal | | Implemented CampusGraph.java (adjacency list, add/remove locations and connections, display network, BFS and DFS traversal). Committed on branch feature/graph and opened a pull request. |

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

