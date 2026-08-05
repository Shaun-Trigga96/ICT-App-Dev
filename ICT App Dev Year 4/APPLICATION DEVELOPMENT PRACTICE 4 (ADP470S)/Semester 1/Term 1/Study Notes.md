ADP470S Term 1 Subject Outcomes: Comprehensive Study Notes

1. SO1: Algorithm Analysis and Complexity Metrics

In computer science, we evaluate algorithms not by their subjective "elegance," but by measurable metrics that predict performance as input size grows. As a student, you must master the two primary metrics: Step Count and Extra Memory.

Primary Metrics

* Step Count: The total number of primitive operations (e.g., additions, assignments, comparisons) an algorithm executes.
* Extra Memory: The additional memory consumed by the algorithm beyond the space required for the input data. In recursive contexts, this is dominated by the allocation of stack frames.

Algorithm Comparison: Recursive vs. Iterative

The choice between recursion and iteration significantly impacts these metrics:

Metric	Recursive Approach	Iterative Approach
Step Count (Growth)	Grows with the depth of recursion; each call performs constant work.	Typically linear (O(n)) relative to the input n.
Extra Memory (Growth)	Linear (O(n)): Requires one stack frame for every recursive call.	Constant (O(1)): Reuses the same memory space regardless of n.

The Runtime Call Stack

Recursive algorithms utilize the Runtime Call Stack to manage "Extra Memory." Each time a function calls itself, a new block of memory (a stack frame) is "pushed" onto the stack. This creates a memory footprint that scales linearly with the recursion depth. Iterative solutions avoid this overhead by remaining within a single stack frame.


--------------------------------------------------------------------------------


2. SO2: Recursive vs. Iterative Computations

Core Definitions

* Recursion: A technique where a method calls itself with a reduced argument. It requires a Base Case (the stopping condition) and a Recursive Case (the logic that moves toward the base case).
* Iteration: A technique that uses loop structures (for, while) to repeat logic until a condition is met, without additional method calls.

Case Study 1: Factorial (n!)

Mathematical Definition: n! = n \times (n-1)!, where the base case is 0! = 1.

Java Implementation (Recursive)

public static int factorial(int n) {
    if (n == 0) { // Base case per source context
        return 1;
    }
    return n * factorial(n - 1); // Recursive case
}


Java Implementation (Iterative)

public static int factorial(int n) {
    int result = 1;
    for(int i = 1; i <= n; i++) {
        result *= i;
    }
    return result;
}


Call Expansion and Unwinding Trace for factorial(5)

To understand the call stack, we must view the expansion (pushing frames) and the subsequent unwinding (popping frames):

1. factorial(5) calls factorial(4)
2. factorial(4) calls factorial(3)
3. factorial(3) calls factorial(2)
4. factorial(2) calls factorial(1)
5. factorial(1) calls factorial(0)
6. Base Case Reached: factorial(0) returns 1.
7. Unwinding: factorial(1) returns 1 \times 1 = 1.
8. Unwinding: factorial(2) returns 2 \times 1 = 2.
9. Unwinding: factorial(3) returns 3 \times 2 = 6.
10. Unwinding: factorial(4) returns 4 \times 6 = 24.
11. Final Result: factorial(5) returns 5 \times 24 = \mathbf{120}.


--------------------------------------------------------------------------------


Case Study 2: Fibonacci Sequence

Mathematical Definition: F(n) = F(n-1) + F(n-2) for n \ge 2, with base cases F(0) = 1 and F(1) = 1.

Note: Following the specific source context, the sequence starts 1, 1, 2, 3, 5, 8 \dots. Therefore, F(5) = 8.

Java Implementation (Recursive)

public static int fibonacci(int n) {
    if (n <= 1)
        return 1; // Base case reflecting F(0)=1, F(1)=1
    return fibonacci(n - 1) + fibonacci(n - 2);
}


Recursive Call Tree & Inefficiency: The naïve recursive approach results in exponential time complexity, O(2^n). This is because the algorithm performs significant repeated work. For example, in calculating F(5), the call F(3) is computed twice, and F(2) is computed three times. The source notes this results in approximately 2^n total function calls.

Java Implementation (Iterative)

public static int fibonacci(int n) {
    if (n <= 1) return 1;
    int prev = 1, curr = 1;
    for(int i = 2; i <= n; i++) {
        int next = prev + curr;
        prev = curr;
        curr = next;
    }
    return curr;
}



--------------------------------------------------------------------------------


Complexity Comparison Table

The following table is essential for exam preparation:

Algorithm	Approach	Time Complexity	Space Complexity
Factorial	Recursive	O(n)	O(n)
Factorial	Iterative	O(n)	O(1)
Fibonacci	Recursive	O(2^n)	O(n)
Fibonacci	Iterative	O(n)	O(1)


--------------------------------------------------------------------------------


3. Stack Frame Mechanics

Recursion is managed internally by the system through stack frames. A frame is an allocated block of memory that exists while a method is active.

Components of a Stack Frame

Every stack frame stores three critical pieces of data:

1. Parameters: The values passed into the method.
2. Local Variables: Variables declared within the method body.
3. Return Address: The specific location in the code where control returns once the function finishes. This is what allows the program to "know where to go" after a frame is popped.

The Lifecycle: Push and Pop

* Push: When a method is called, a new frame is added to the top of the stack.
* Pop: When a method returns, the frame is removed, and the Return Address is used to resume the caller's execution.

Stack Overflow Error: This occurs when the stack runs out of memory. This usually happens in recursion due to an infinite loop (missing base case) or excessive recursion depth that exceeds the system's stack limit.


--------------------------------------------------------------------------------


4. SO3: Search Algorithms & BST Properties

Recursive logic is also used to define and navigate data structures like the Binary Search Tree (BST).

Binary Search Tree Properties

* Structure: Each node can have a maximum of two children.
* Ordering: The Left child must be less than the node value; the Right child must be greater than the node value.
* Uniqueness: Duplicate values are strictly prohibited.

Visual Hierarchy (Root = 5)

Given the rules above, a tree containing the values \{5, 3, 6, 1\} is structured as:

      5
     / \
    3   6
   /
  1


Logic Note: The value 1 is the left child of 3 because 1 < 3. Both are in the left subtree of 5 because 1 < 5 and 3 < 5.


--------------------------------------------------------------------------------


5. SO4 & SO5: Bubble Sort and 2D Arrays

Technical implementation details for Bubble Sort and the specific limitations of 2D Arrays were not included in the primary technical excerpts. Students are required to consult their secondary lecture slides and textbook materials for these Subject Outcomes as part of their self-study.


--------------------------------------------------------------------------------


6. SO6: Recursive Data Structures & Linked Lists

Linear structures like Linked Lists can be defined recursively. A list consists of a Head element (the first item) and a Sub-list (the tail), which is itself a list.

Example Sequence: The source provides the following sequence: 1 \to 2 \to 3 \to 4 \to 5 \to 7 \to 8 \to 9 \to 10. Note for students: Per the ground truth source, this specific sequence skips the number 6. Ensure your trace reflects this sequence exactly.


--------------------------------------------------------------------------------


7. Summary of Comparison Metrics

Readability vs. Performance

* Readability: Recursive solutions are favored when they closely mirror mathematical definitions, leading to concise and maintainable code.
* Performance: Iterative solutions are generally superior in production environments. They avoid "call-overhead" (the time taken to push/pop frames) and operate in constant space (O(1)).

Essential Checklist

Every recursive function you write for this course must include:

1. Base Case: A defined stopping condition.
2. Recursive Case: A reduction of the problem that moves closer to the base case.
