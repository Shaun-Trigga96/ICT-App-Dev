
/**
 * Name: Chuma
 * Surname: Nxazonke
 * Student No: 219181187
 *

 * Part C: Elementary Data Structures Implementation
 *
 * This class demonstrates the implementation and usage of:
 * 1. Singly Linked List
 * 2. Array-based Stack
 * 3. Circular Array Queue
 *
 * Each data structure is implemented from scratch with proper documentation.
 */
public class PartC_DataStructures {


        public static void run() {
            System.out.println("=== Part C: Elementary Data Structures ===\n");

            // Demonstrate Singly Linked List
            demonstrateLinkedList();

            // Demonstrate Stack (reverse a string)
            demonstrateStack();

            // Demonstrate Queue (bank simulation)
            demonstrateQueue();
        }

        // =========================================================================
        // 1. SINGLY LINKED LIST IMPLEMENTATION
        // =========================================================================

        /**
         * Node class for Singly Linked List
         * Each node contains data and a reference to the next node
         */
        static class Node {
            int data;
            Node next;

            // Constructor
            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        /**
         * Singly Linked List class with basic operations:
         * - insert: Add a new node at the end
         * - delete: Remove a node with specific value
         * - search: Check if a value exists in the list
         * - display: Print all elements in the list
         */
        static class SinglyLinkedList {
            Node head;  // Reference to the first node in the list

            /**
             * Insert a new node with given data at the end of the list
             * Time Complexity: O(n) where n is the number of nodes
             *
             * @param data The value to be inserted
             */
            public void insert(int data) {
                Node newNode = new Node(data);

                // If list is empty, make new node the head
                if (head == null) {
                    head = newNode;
                } else {
                    // Traverse to the end of the list
                    Node current = head;
                    while (current.next != null) {
                        current = current.next;
                    }
                    // Add new node at the end
                    current.next = newNode;
                }
            }

            /**
             * Delete the first occurrence of a node with given data
             * Time Complexity: O(n) where n is the number of nodes
             *
             * @param data The value to be deleted
             */
            public void delete(int data) {
                // If list is empty, nothing to delete
                if (head == null) return;

                // If head node needs to be deleted
                if (head.data == data) {
                    head = head.next;
                    return;
                }

                // Traverse the list to find the node to delete
                Node current = head;
                while (current.next != null) {
                    if (current.next.data == data) {
                        // Bypass the node to be deleted
                        current.next = current.next.next;
                        return;
                    }
                    current = current.next;
                }
            }

            /**
             * Search for a node with given data in the list
             * Time Complexity: O(n) where n is the number of nodes
             *
             * @param data The value to search for
             * @return true if found, false otherwise
             */
            public boolean search(int data) {
                Node current = head;
                while (current != null) {
                    if (current.data == data) {
                        return true;
                    }
                    current = current.next;
                }
                return false;
            }

            /**
             * Display all elements in the linked list
             * Time Complexity: O(n) where n is the number of nodes
             */
            public void display() {
                Node current = head;
                while (current != null) {
                    System.out.print(current.data + " -> ");
                    current = current.next;
                }
                System.out.println("null");
            }
        }

        /**
         * Demonstrate the usage of Singly Linked List
         */
        public static void demonstrateLinkedList() {
            System.out.println("1. SINGLY LINKED LIST DEMONSTRATION");
            System.out.println("===================================");

            SinglyLinkedList list = new SinglyLinkedList();

            // Insert elements
            System.out.println("Inserting elements: 10, 20, 30, 40");
            list.insert(10);
            list.insert(20);
            list.insert(30);
            list.insert(40);

            // Display the list
            System.out.print("Linked List: ");
            list.display();

            // Search for elements
            System.out.println("Search for 20: " + list.search(20));
            System.out.println("Search for 50: " + list.search(50));

            // Delete elements
            System.out.println("Deleting 30");
            list.delete(30);
            System.out.print("Linked List after deletion: ");
            list.display();

            System.out.println("Deleting 10 (head)");
            list.delete(10);
            System.out.print("Linked List after deletion: ");
            list.display();

            System.out.println("Trying to delete non-existent element 99");
            list.delete(99);
            System.out.print("Linked List remains unchanged: ");
            list.display();

            System.out.println();
        }

        // =========================================================================
        // 2. ARRAY-BASED STACK IMPLEMENTATION
        // =========================================================================

        /**
         * Array-based Stack class with basic operations:
         * - push: Add an element to the top of the stack
         * - pop: Remove and return the top element
         * - peek: Return the top element without removing it
         * - isEmpty: Check if stack is empty
         * - isFull: Check if stack is full
         */
        static class ArrayStack {
            private int[] stackArray;  // Array to store stack elements
            private int top;           // Index of the top element
            private int capacity;      // Maximum capacity of the stack

            /**
             * Constructor to initialize the stack with given size
             *
             * @param size The maximum capacity of the stack
             */
            public ArrayStack(int size) {
                capacity = size;
                stackArray = new int[capacity];
                top = -1;  // Stack is initially empty
            }

            /**
             * Add an element to the top of the stack
             * Time Complexity: O(1)
             *
             * @param value The value to be pushed
             * @throws StackOverflowError if stack is full
             */
            public void push(int value) {
                if (isFull()) {
                    throw new StackOverflowError("Stack is full");
                }
                stackArray[++top] = value;
            }

            /**
             * Remove and return the top element from the stack
             * Time Complexity: O(1)
             *
             * @return The top element of the stack
             * @throws RuntimeException if stack is empty
             */
            public int pop() {
                if (isEmpty()) {
                    throw new RuntimeException("Stack is empty");
                }
                return stackArray[top--];
            }

            /**
             * Return the top element without removing it
             * Time Complexity: O(1)
             *
             * @return The top element of the stack
             * @throws RuntimeException if stack is empty
             */
            public int peek() {
                if (isEmpty()) {
                    throw new RuntimeException("Stack is empty");
                }
                return stackArray[top];
            }

            public boolean isEmpty() {
                return top == -1;
            }

            /**
             * Check if the stack is full
             * Time Complexity: O(1)
             *
             * @return true if stack is full, false otherwise
             */
            public boolean isFull() {
                return top == capacity - 1;
            }
            /**
             * Get the current size of the stack
             * Time Complexity: O(1)
            **/
            public int size() {
                return top + 1;
            }
        }

        /**
         * Demonstrate the usage of Stack by reversing a string
         */
        public static void demonstrateStack() {
            System.out.println("2. STACK DEMONSTRATION - REVERSING A STRING");
            System.out.println("===========================================");

            String originalString = "Hello World!";
            System.out.println("Original string: " + originalString);

            // Create a stack with capacity equal to string length
            ArrayStack stack = new ArrayStack(originalString.length());

            // Push each character onto the stack
            for (char c : originalString.toCharArray()) {
                stack.push(c);
            }

            // Pop characters from the stack to build the reversed string
            StringBuilder reversedString = new StringBuilder();
            while (!stack.isEmpty()) {
                reversedString.append((char) stack.pop());
            }

            System.out.println("Reversed string: " + reversedString.toString());
            System.out.println();
        }

        // =========================================================================
        // 3. CIRCULAR ARRAY QUEUE IMPLEMENTATION
        // =========================================================================

        /**
         * Circular Array Queue class with basic operations:
         * - enqueue: Add an element to the rear of the queue
         * - dequeue: Remove and return an element from the front
         * - peek: Return the front element without removing it
         * - isEmpty: Check if queue is empty
         * - isFull: Check if queue is full
         */
        static class CircularQueue {
            private int[] queueArray;  // Array to store queue elements
            private int front;         // Index of the front element
            private int rear;          // Index of the rear element
            private int size;          // Current number of elements
            private int capacity;      // Maximum capacity of the queue

            /**
             * Constructor to initialize the queue with given size
             *
             * @param k The maximum capacity of the queue
             */
            public CircularQueue(int k) {
                capacity = k;
                queueArray = new int[capacity];
                front = 0;
                rear = -1;
                size = 0;
            }

            /**
             * Add an element to the rear of the queue
             * Time Complexity: O(1)
             *
             * @param value The value to be added
             * @return true if successful, false if queue is full
             */
            public boolean enqueue(int value) {
                if (isFull()) {
                    System.out.println("Queue is full. Cannot enqueue " + value);
                    return false;
                }

                // Calculate new rear position using circular arrangement
                rear = (rear + 1) % capacity;
                queueArray[rear] = value;
                size++;
                return true;
            }

            /**
             * Remove and return an element from the front of the queue
             * Time Complexity: O(1)
             *
             * @return The front element of the queue
             * @throws RuntimeException if queue is empty
             */
            public int dequeue() {
                if (isEmpty()) {
                    throw new RuntimeException("Queue is empty");
                }

                int value = queueArray[front];
                front = (front + 1) % capacity;
                size--;
                return value;
            }

            /**
             * Return the front element of the queue without removing it
           **/
            public int peek() {
                if (isEmpty()) {
                    throw new RuntimeException("Queue is empty");
                }
                return queueArray[front];
            }

            public boolean isEmpty() {
                return size == 0;
            }

            /**
             * @return true if queue is full, false otherwise
             */
            public boolean isFull() {
                return size == capacity;
            }

            /**

             * @return Number of elements in the queue
             */
            public int size() {
                return size;
            }

            /**
             * Display the current state of the queue
             * Time Complexity: O(n) where n is the number of elements
             */
            public void display() {
                if (isEmpty()) {
                    System.out.println("Queue is empty");
                    return;
                }

                System.out.print("Queue: ");
                int count = 0;
                int index = front;

                while (count < size) {
                    System.out.print(queueArray[index] + " ");
                    index = (index + 1) % capacity;
                    count++;
                }
                System.out.println();
            }
        }

        /**
         * Demonstrate the usage of Queue with a bank simulation
         */
        public static void demonstrateQueue() {
            System.out.println("3. QUEUE DEMONSTRATION - BANK SIMULATION");
            System.out.println("========================================");

            // Create a queue with capacity for 5 customers
            CircularQueue bankQueue = new CircularQueue(5);

            // Customers arrive at the bank
            System.out.println("Customers arriving at the bank:");
            bankQueue.enqueue(101); // Customer 101
            bankQueue.enqueue(102); // Customer 102
            bankQueue.enqueue(103); // Customer 103
            bankQueue.display();

            // Bank teller serves customers
            System.out.println("\nBank teller serving customers:");
            System.out.println("Serving customer: " + bankQueue.dequeue());
            System.out.println("Serving customer: " + bankQueue.dequeue());
            bankQueue.display();

            // More customers arrive
            System.out.println("\nMore customers arriving:");
            bankQueue.enqueue(104); // Customer 104
            bankQueue.enqueue(105); // Customer 105
            bankQueue.enqueue(106); // Customer 106
            bankQueue.display();

            // Try to add more customers than queue capacity
            System.out.println("\nTrying to add more customers:");
            bankQueue.enqueue(107); // This should fail (queue is full)

            // Serve remaining customers
            System.out.println("\nServing remaining customers:");
            while (!bankQueue.isEmpty()) {
                System.out.println("Serving customer: " + bankQueue.dequeue());
            }

            // Try to serve from empty queue
            System.out.println("\nTrying to serve from empty queue:");
            try {
                bankQueue.dequeue();
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

