
# TERM 2 COMPREHENSIVE NOTES
## ADP470S – Applications Development Practice 4

### Table of Contents
1. Review of Recursion & The Call Stack
2. Queue Algorithms (Circular Array, Linked List, Priority Queue)
3. Binary Trees & Traversals
4. Introduction to AVL Trees (Height Balanced Binary Tree)
5. Sorting Algorithms & Algorithm Analysis

---

## 1. REVIEW OF RECURSION & THE CALL STACK

### 1.1 Recursion Recap
Recursion is a technique where a method calls itself to solve a smaller instance of the same problem. Every recursive function must have:
- **Base Case**: The stopping condition.
- **Recursive Case**: The function calling itself with a modified parameter.

### 1.2 The Call Stack
Each recursive call places a new stack frame (activation record) on the call stack containing:
- Local variables
- Return address
- Parameters

*Illustration description for Word: Draw a vertical stack. At the bottom, label "main()". Above it, add "factorial(3)", then "factorial(2)", then "factorial(1)" at the top. Arrows show pushing onto stack. Then reverse arrows show popping as base case is reached.*

**Example: Factorial (n!)**
```java
public int factorial(int n) {
    if (n == 0) return 1;          // Base case
    return n * factorial(n - 1);   // Recursive case
}
```
**Trace for factorial(3):**
1. factorial(3) calls factorial(2) → waits
2. factorial(2) calls factorial(1) → waits
3. factorial(1) calls factorial(0) → waits
4. factorial(0) returns 1
5. factorial(1) returns 1 × 1 = 1
6. factorial(2) returns 2 × 1 = 2
7. factorial(3) returns 3 × 2 = 6

> ⚠️ **Risk**: Too many recursive calls cause **Stack Overflow** (memory exhausted).

---

## 2. QUEUE ALGORITHMS

A queue is a **FIFO** (First In, First Out) data structure. Operations:
- `enqueue(item)` – add to rear
- `dequeue()` – remove from front
- `peek()` / `front()` – examine front without removing
- `isEmpty()` – check if empty
- `isFull()` – check if full (for fixed-size queues)

### 2.1 Queue using Circular Array

**Problem with simple array queue:** After several dequeues, front moves forward, leaving unused space at the front that cannot be reused.

**Circular Array Solution:** Use modulo arithmetic to wrap around.

*Illustration description for Word: Draw an array of size 5 (indices 0-4). Show front=2, rear=4 with arrows. Then after enqueue, rear wraps to 0. Use a circular diagram.*

**Key formulas:**
- Enqueue: `rear = (rear + 1) % capacity`
- Dequeue: `front = (front + 1) % capacity`
- Queue full condition: `(rear + 1) % capacity == front` (sacrifices one slot)
- Queue empty condition: `front == rear`

**Java implementation (circular array):**
```java
public class CircularQueue {
    private int[] arr;
    private int front, rear, capacity;

    public CircularQueue(int size) {
        capacity = size;
        arr = new int[capacity];
        front = 0;
        rear = 0;
    }

    public void enqueue(int item) {
        if ((rear + 1) % capacity == front) {
            System.out.println("Queue Full");
            return;
        }
        arr[rear] = item;
        rear = (rear + 1) % capacity;
    }

    public int dequeue() {
        if (front == rear) {
            System.out.println("Queue Empty");
            return -1;
        }
        int item = arr[front];
        front = (front + 1) % capacity;
        return item;
    }
}
```

### 2.2 Queue using Linked List

**Advantages over array queue:** Dynamic size, no overflow (unless memory exhausted).

*Illustration description for Word: Draw nodes connected by arrows. Each node has "data" and "next". Label "front" arrow pointing to first node, "rear" arrow pointing to last node. Show enqueue adding at rear, dequeue removing from front.*

**Operations:**
- `enqueue`: Add new node at rear, update rear pointer
- `dequeue`: Remove front node, update front pointer

### 2.3 Priority Queue

In a priority queue, elements are dequeued based on **priority**, not just arrival order. Higher priority elements come out first.

**Implementation approaches:**
| Approach | Enqueue Complexity | Dequeue Complexity |
|----------|-------------------|--------------------|
| Unsorted array/list | O(1) | O(n) |
| Sorted array/list | O(n) | O(1) |
| Binary Heap | O(log n) | O(log n) |

*Illustration description for Word: Draw a priority queue with 3 elements: (Task A, priority 3), (Task B, priority 1), (Task C, priority 2). Show that dequeue returns Task B (priority 1 - highest) first regardless of arrival order.*

**Use cases:** Operating system process scheduling, Dijkstra's algorithm, Huffman coding.

---

## 3. BINARY TREES & TRAVERSALS

### 3.1 Binary Tree Terminology
- **Root**: Topmost node (no parent)
- **Parent**: Node with children
- **Child**: Node directly under another
- **Leaf**: Node with no children
- **Subtree**: Any node and its descendants
- **Height**: Number of edges on longest path from root to leaf
- **Depth**: Number of edges from root to a specific node

*Illustration description for Word: Draw a root node (e.g., 10). Two children: left child (5), right child (15). Each child may have its own children. Label root, internal nodes, leaves, height, depth.*

**Properties:**
- Maximum nodes at level `L` = `2^L` (root level 0)
- Maximum nodes in tree of height `h` = `2^(h+1) - 1`
- Height of a node = length of longest downward path to a leaf

### 3.2 Tree Traversals (Binary Tree)

Traversal = visiting every node exactly once.

**Three main depth-first traversals:**

| Traversal | Order | Use Case |
|-----------|-------|----------|
| **Pre-order** | Root → Left → Right | Copying a tree, prefix expression |
| **In-order** | Left → Root → Right | Getting sorted order (in BST) |
| **Post-order** | Left → Right → Root | Deleting a tree, postfix expression |

*Illustration description for Word: Draw a simple binary tree with root 'A', left child 'B', right child 'C'. B has left child 'D', right child 'E'. Show arrows with numbered steps for each traversal type.*

**Example Tree:**
```
        A
       / \
      B   C
     / \
    D   E
```

**Results:**
- Pre-order: A, B, D, E, C
- In-order: D, B, E, A, C
- Post-order: D, E, B, C, A

**Level-order traversal (Breadth-First):** Visit level 0, then level 1, then level 2... → A, B, C, D, E

**Java implementation (recursive):**
```java
class Node {
    int data;
    Node left, right;
    Node(int data) { this.data = data; }
}

void preOrder(Node node) {
    if (node == null) return;
    System.out.print(node.data + " ");
    preOrder(node.left);
    preOrder(node.right);
}
```

---

## 4. INTRODUCTION TO AVL TREES (HEIGHT BALANCED BINARY TREE)

### 4.1 Problem with Regular BST
A regular Binary Search Tree can become **skewed** (degenerate) into a linked list if data is inserted in sorted order, making search O(n) instead of O(log n).

*Illustration description for Word: Draw a skewed BST: root 1 → right child 2 → right child 3 → right child 4. This looks like a straight line.*

### 4.2 AVL Tree Definition
An AVL tree is a **self-balancing** BST where for every node, the heights of left and right subtrees differ by at most 1 (balance factor -1, 0, or +1).

**Balance Factor = height(left subtree) – height(right subtree)**

| Balance Factor | Meaning |
|----------------|---------|
| 0 | Perfectly balanced |
| +1 | Left subtree taller by 1 |
| -1 | Right subtree taller by 1 |
| >1 or <-1 | **Imbalance** – rotation needed |

### 4.3 Rotations (Re-balancing)

When a node becomes unbalanced after insertion/deletion, perform one of four rotations:

| Imbalance Case | Rotation |
|----------------|----------|
| Left-Left (LL) | Right rotate |
| Right-Right (RR) | Left rotate |
| Left-Right (LR) | Left rotate on left child → Right rotate on node |
| Right-Left (RL) | Right rotate on right child → Left rotate on node |

*Illustration description for Word - For each rotation, draw before and after diagrams:*
- **Right Rotation (LL case):** Show node Z with left child Y, Y has left child X. After rotation: Y becomes root, X becomes Y's left, Z becomes Y's right.
- **Left Rotation (RR case):** Mirror image of right rotation.

**Right Rotation Step-by-step:**
```
Before:        After rotation:
    Z               Y
   / \             / \
  Y   T3          X   Z
 / \                 / \
X   T2              T2  T3
```

### 4.4 When to Use AVL vs Regular BST
| Criterion | AVL Tree | Regular BST |
|-----------|----------|-------------|
| Search | O(log n) guaranteed | O(n) worst case |
| Insert/Delete | O(log n) with rotations | O(log n) average, O(n) worst |
| Implementation complexity | High | Low |
| Memory overhead | Stores height/balance | Minimal |

---

## 5. SORTING ALGORITHMS & ALGORITHM ANALYSIS

### 5.1 Time Complexity Cheat Sheet

| Algorithm | Best Case | Average Case | Worst Case | Space | Stable? |
|-----------|-----------|--------------|------------|-------|---------|
| **Bubble Sort** | O(n) | O(n²) | O(n²) | O(1) | Yes |
| **Selection Sort** | O(n²) | O(n²) | O(n²) | O(1) | No |
| **Insertion Sort** | O(n) | O(n²) | O(n²) | O(1) | Yes |
| **Merge Sort** | O(n log n) | O(n log n) | O(n log n) | O(n) | Yes |
| **Quick Sort** | O(n log n) | O(n log n) | O(n²) | O(log n) | No |
| **Heap Sort** | O(n log n) | O(n log n) | O(n log n) | O(1) | No |

### 5.2 Quick Explanation of Each

**Bubble Sort:** Repeatedly step through list, swap adjacent elements if out of order. Largest element "bubbles" to end.

**Selection Sort:** Find minimum, swap with first position; repeat for remaining unsorted portion.

**Insertion Sort:** Build sorted array one element at a time by inserting each new element into correct position (like sorting playing cards).

**Merge Sort:** Divide-and-conquer. Split array in half, sort each half recursively, then merge two sorted halves.
- *Illustration description for Word: Show a divide tree (top-down) and conquer (merge) bottom-up.*

**Quick Sort:** Choose pivot, partition array so elements < pivot come before, > pivot after; recursively sort subarrays.

**Heap Sort:** Build max-heap, repeatedly extract root (maximum), swap with last element, heapify.

### 5.3 Algorithm Analysis (Big O)

Big O notation describes **upper bound** of growth rate as input size → ∞.

| Notation | Name | Example |
|----------|------|---------|
| O(1) | Constant | Array access |
| O(log n) | Logarithmic | Binary search |
| O(n) | Linear | Linear search |
| O(n log n) | Linearithmic | Merge sort, Heap sort |
| O(n²) | Quadratic | Bubble, Selection, Insertion (worst) |
| O(2ⁿ) | Exponential | Recursive Fibonacci (naive) |

---

## TERM 2 ASSESSMENT PREPARATION CHECKLIST

Based on your exam topics image, ensure you can:

☐ Explain recursion with factorial/fibonacci examples  
☐ Trace the call stack for recursive calls  
☐ Implement and explain circular array queue (including full/empty conditions)  
☐ Compare array-based vs linked-list queue  
☐ Explain priority queue and real-world applications  
☐ Draw and traverse binary trees (pre, in, post, level-order)  
☐ Calculate balance factors and identify AVL imbalances  
☐ Perform LL, RR, LR, RL rotations on AVL trees  
☐ Compare sorting algorithms (time/space complexity, stability)  
☐ Apply Big O notation to any algorithm discussed  

---

## HOW TO CREATE THIS DOCUMENT IN WORD

1. **Copy all text above** (from "TERM 2 COMPREHENSIVE NOTES" to the checklist)
2. **Open Microsoft Word** and paste (Ctrl+V)
3. **Format headings:** Select headings like "1. REVIEW OF RECURSION" → Apply Heading 1 style
4. **Create diagrams:**
   - Go to Insert → Shapes → Use rectangles for nodes, lines for connections
   - Or Insert → SmartArt → Hierarchy for tree diagrams
   - For call stack: Insert → Shapes → Rectangle (stacked vertically)
5. **Add syntax highlighting to code:** Use a code formatter or paste as plain text with monospace font (Consolas/Courier New)
6. **Save as** `ADP470S_Term2_Notes_YourName.docx`

Would you like me to also create **practice exercises** or a **sample test paper** based on these Term 2 topics?