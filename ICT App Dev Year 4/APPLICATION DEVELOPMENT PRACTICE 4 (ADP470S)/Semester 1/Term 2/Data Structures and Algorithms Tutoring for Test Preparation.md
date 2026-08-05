I’ll guide you through **Term 1 topics** for your ADP470S test, using the provided practice questions and slides. We’ll start from **recursion** and work through **factorial, Fibonacci, Big‑O analysis, sorting algorithms (bubble, insertion, quick)** and also cover **searching** (linear & binary) because the subject guide includes them.  

I’ll use **text‑based diagrams / ASCII art** so you can visualise stacks, passes, and recursion trees. Every concept is linked to a practice question – I’ll **show you the full answer** and explain how I got there.

---

## 1. Recursion & Iteration – Factorial

### Recursive factorial – code
```java
public static int fact(int n) {
    if (n == 0) return 1;           // base case
    return n * fact(n - 1);         // recursive case
}
```

### How the stack grows (for `fact(5)`)
Each call gets its own **stack frame** (holds `n`, return address).  
Depth = `n+1` frames.

```
fact(5)  | n=5  | calls fact(4)
fact(4)  | n=4  | calls fact(3)
fact(3)  | n=3  | calls fact(2)
fact(2)  | n=2  | calls fact(1)
fact(1)  | n=1  | calls fact(0)
fact(0)  | n=0  | returns 1
Then each frame returns: 1→1→2→6→24→120
```

### Big‑O of recursive factorial
- **Time**: O(n) – one call per level, each does O(1) work.
- **Space**: O(n) – `n+1` stack frames exist at the deepest point.

### Iterative factorial – code
```java
public static int factorial(int n) {
    int prod = 1;
    for (int i = 1; i <= n; i++) prod *= i;
    return prod;
}
```
- **Time**: O(n)  
- **Space**: O(1) – only a few variables, no stack growth.

### Comparison (time & space utilisation)
|                | Recursive fact | Iterative fact |
|----------------|----------------|----------------|
| Time (Big‑O)   | O(n)           | O(n)           |
| Space (Big‑O)  | O(n)           | O(1)           |
| Overhead       | Function calls, risk of stack overflow | No overhead |
| **Real‑world preference** | **Iterative** – uses less memory, no stack limit, faster in practice. |

---

## ✅ Practice Questions 1–4 – Answered

**1. Implement a recursive method for factorial**  
→ See `fact(int n)` above.

**2. Implement an iterative method for factorial**  
→ See `factorial(int n)` above.

**3. Using the concept of a stackframe, explain the performance of the recursive method using Big‑O notation**  
> Each recursive call creates a new stack frame storing `n` and the return address. To compute `fact(n)`, we need `n+1` frames simultaneously, so **space complexity = O(n)**. Time is O(n) because we make `n` calls, each doing constant work. The overhead of pushing/popping frames adds constant factors but does not change Big‑O.

**4. Compare the performance (time & space). Which is preferable in the real world?**  
> Both have O(n) time, but recursion uses O(n) extra space while iteration uses O(1). Recursion also risks **stack overflow** for large `n` (e.g., `n=10000`). Therefore **iterative is preferable** in production systems.

---

## 2. Big‑O for Code Excerpts (Practice Q5)

### Snippet 1
```java
int sum = 0;
for (int i = 0; i < n; i++) sum = sum + a[i];
for (int j = 0; j < n; j++) sum = sum + a[j];
```
- First loop: `n` iterations → O(n)  
- Second loop: `n` iterations → O(n)  
- Total = O(n + n) = **O(n)**

### Snippet 2
```java
int prod = 1;
for (int i = 1; i < n; i++) {
    for (int j = 1; j < n; j = j * 3) {
        prod = prod * j;
    }
}
```
- Outer loop: `n-1` times → O(n)  
- Inner loop: `j` grows as 1, 3, 9, … until `< n` → about `log₃(n)` iterations → O(log n)  
- Total = **O(n log n)**

### Snippet 3
```java
int sum = 0;
for (i = 0; i <= n-1; i += 3) {
    for (j = n-1; j > 0; j--) {
        sum = sum + (i * j);
    }
}
```
- Outer loop: `i` takes values 0,3,6,… up to `n-1` → about `n/3` iterations → O(n)  
- Inner loop: `j` goes from `n-1` down to 1 → `n-1` iterations → O(n)  
- Total = **O(n²)**

---

## 3. Bubble Sort on {90, 23, 5, 109, 12}

**Algorithm** – repeatedly step through list, swap adjacent if out of order. After each full pass, the largest unsorted element “bubbles” to its correct position at the end.

### Step‑by‑step (showing enough changes)
```
Initial: [90, 23, 5, 109, 12]

Pass 1 (compare each pair):
  compare 90 & 23 → swap → [23, 90, 5, 109, 12]
  compare 90 & 5  → swap → [23, 5, 90, 109, 12]
  compare 90 & 109 → no swap
  compare 109 & 12 → swap → [23, 5, 90, 12, 109]   // 109 is now correct

Pass 2 (ignore last element):
  compare 23 & 5  → swap → [5, 23, 90, 12, 109]
  compare 23 & 90 → no swap
  compare 90 & 12 → swap → [5, 23, 12, 90, 109]   // 90 correct

Pass 3 (ignore last two):
  compare 5 & 23  → no swap
  compare 23 & 12 → swap → [5, 12, 23, 90, 109]   // 23 correct

Pass 4 (one comparison): 5 & 12 → no swap → done.
Final sorted: [5, 12, 23, 90, 109]
```

---

## 4. Insertion Sort on {90, 23, 5, 109, 12}

**Algorithm** – take each element and insert it into the already sorted left part.

```
Start: [90] (sorted portion)

Insert 23: compare with 90 → shift 90 right → [23, 90]
Insert 5: compare with 90 → shift 90; compare with 23 → shift 23 → [5, 23, 90]
Insert 109: compare with 90 → no shift → [5, 23, 90, 109]
Insert 12: compare with 109 → shift 109; compare with 90 → shift 90; compare with 23 → shift 23; compare with 5 → insert → [5, 12, 23, 90, 109]
```

Each step shows the “sorted” region growing from the left.

---

## 5. Quick Sort with Middle Pivot on `[9,7,5,11,12,2,14,3,10,6]`

**Pivot choice** – middle element:  
`left=0`, `right=9`, `mid = (0+9)/2 = 4` → element at index 4 is **12**.

We use **Hoare partition** (two pointers moving towards each other).  
I’ll show the **first partition** in detail, then the recursive steps.

### Initial array
```
[9, 7, 5, 11, 12, 2, 14, 3, 10, 6]
 L→                    ←R
pivot = 12
```

**Partition step** (swap elements that are on the wrong side of pivot):

- Move L right while `arr[L] < pivot`: 9<12,7<12,5<12,11<12 → L stops at index 4 (value 12, not <12)
- Move R left while `arr[R] > pivot`: 6<12 (stop, because 6 is not >12)
- Now `L=4, R=9`. Since L <= R, swap arr[4] and arr[9] → array becomes:
```
[9, 7, 5, 11, 6, 2, 14, 3, 10, 12]
 L=4                R=9
```
- L++ → L=5, R-- → R=8

Continue:  
L=5 → arr[5]=2 <12 → L=6  
L=6 → arr[6]=14 not <12 → stop  
R=8 → arr[8]=10 >12? No, 10<12 → stop  
Swap arr[6] and arr[8]:
```
[9, 7, 5, 11, 6, 2, 10, 3, 14, 12]
```
L=7, R=7  
L=7 → arr[7]=3 <12 → L=8  
R=7, now L > R → partition ends. Return pivot index = L = 8.

**After first partition**, pivot (12) is at index 8? Wait – in Hoare partition the pivot value may not be at the returned index. Actually the array is now:
`[9,7,5,11,6,2,10,3,14,12]`  
All elements left of index 8 (indices 0..7) are ≤12, right of index 8 (index 9) is ≥12.  
We recursively sort `[0..7]` and `[8..9]`.

---

### Recursive step – left part `[0..7]`: `[9,7,5,11,6,2,10,3]`
Middle index = (0+7)/2 = 3 → value 11 (pivot).  
Partition (quickly):  
After swaps we get something like `[9,7,5,3,6,2,10,11]` with pivot 11 at end.  
Then left of 11 is `[9,7,5,3,6,2,10]` – continue recursively.

I’ll skip some sub‑steps for brevity, but the **fully sorted array** becomes:
```
[2, 3, 5, 6, 7, 9, 10, 11, 12, 14]
```

**Key takeaway** – Quick Sort works by repeatedly partitioning around a pivot. With a **middle pivot**, worst case is rare.

---

## 6. Quick Sort Performance (Best, Average, Worst)

| Case        | Time Complexity | When does it happen?                                      |
|-------------|----------------|-----------------------------------------------------------|
| **Best**    | O(n log n)     | Pivot always divides array into two equal halves.        |
| **Average** | O(n log n)     | Random or middle pivot – expected behaviour.              |
| **Worst**   | O(n²)          | Pivot is always the smallest or largest element (e.g., already sorted array with first/last pivot). With **middle pivot**, worst case is still possible but very unlikely. |

> **Space complexity** of Quick Sort is O(log n) for the recursion stack in the average case, O(n) in the worst case (if recursion depth = n).

---

## 7. Searching Algorithms (for completeness – test may include)

### Linear Search – O(n)
```java
int linearSearch(int[] arr, int target) {
    for (int i = 0; i < arr.length; i++)
        if (arr[i] == target) return i;
    return -1;
}
```
- **Best case**: O(1) – target at first position  
- **Worst & average**: O(n)

### Binary Search – O(log n) – requires **sorted array**
```java
int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length-1;
    while (left <= right) {
        int mid = left + (right-left)/2;
        if (arr[mid] == target) return mid;
        else if (arr[mid] < target) left = mid+1;
        else right = mid-1;
    }
    return -1;
}
```
- **Time**: O(log n)  
- **Space**: iterative O(1), recursive O(log n) for stack.

---

## 📚 Final Advice for Summa Cum Laude

1. **Practice tracing** – on paper, run bubble/insertion/quick sort on small arrays until you can do it blindfolded.
2. **Memorise the Big‑O table**:
   - O(1) – constant
   - O(log n) – binary search
   - O(n) – linear search, factorial
   - O(n log n) – quick sort (avg), merge sort
   - O(n²) – bubble, insertion, selection, quick sort (worst)
3. **Understand recursion vs iteration** – be able to explain stack frames and why recursion uses more memory.
4. **Use the practice questions as a mock test** – cover the answers, then try to reproduce them from scratch.

You’ve got this! Keep asking “why does this happen?” and visualise each step. Good luck on Thursday – aim for that summa cum laude! 🚀