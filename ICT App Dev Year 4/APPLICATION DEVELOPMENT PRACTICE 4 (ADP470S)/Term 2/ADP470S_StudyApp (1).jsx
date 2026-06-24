import { useState } from "react";

const S = {
  bg:"#0d0d1a",sidebar:"#111126",sidebarActive:"#1e1e38",card:"#14142a",cardBorder:"#252545",
  cardInner:"#1a1a32",accent:"#00c9a7",accentDim:"#00c9a720",text:"#e4e4f0",muted:"#8888aa",
  faint:"#44445a",tag:["#00c9a7","#0984e3","#a29bfe","#e17055","#fd79a8","#fdcb6e"],
};

const qColor = n => S.tag[(n-1)%S.tag.length];

const PAPERS = [
  {id:"apr25",label:"Test 1 — April 2025",sub:"75m · 2 hours"},
  {id:"jun23",label:"Test 1 — June 2023",sub:"80m · 2 hours"},
  {id:"mar24",label:"Test 1 — March 2024",sub:"50m · 1.5 hours"},
  {id:"mid21",label:"Midyear Exam 2021",sub:"100m · 3 hours"},
  {id:"test21",label:"Test 1 — May 2021",sub:"80m · 2.5 hours"},
  {id:"asgn23",label:"Assignment 1 — 2023",sub:"100m · Take-home"},
  {id:"nov20",label:"Nov Test — 2020",sub:"100m · 2.5 hours"},
];

const TOPICS_NAV = [
  {id:"bigo",label:"Big-O Notation",icon:"📊"},
  {id:"recursion",label:"Recursion & Iteration",icon:"🔁"},
  {id:"sorting",label:"Sorting Algorithms",icon:"🔢"},
  {id:"stackqueue",label:"Stacks & Queues",icon:"📦"},
  {id:"trees",label:"Trees (BST & AVL)",icon:"🌳"},
  {id:"graphs",label:"Graph Algorithms",icon:"🕸️"},
  {id:"hashing",label:"Hash Tables",icon:"#️⃣"},
];

const NOTES = {
  bigo:{title:"Big-O Notation",color:"#00c9a7",
    sections:[
      {h:"What is Big-O?",body:`Big-O notation describes the WORST-CASE (upper bound) growth rate of an algorithm's time or space usage as input size n → ∞. Constants and lower-order terms are dropped because they become irrelevant at scale.\n\nKey insight: We care how the algorithm scales, not the exact count.`},
      {h:"The 5 Rules",body:`1. DROP CONSTANTS: O(2n) → O(n), O(100) → O(1)\n2. DROP LOWER TERMS: O(n² + n) → O(n²), O(n³ + n²) → O(n³)\n3. SEQUENTIAL LOOPS ADD: two O(n) loops → O(n)+O(n) = O(2n) → O(n)\n4. NESTED LOOPS MULTIPLY: O(n) inside O(n) → O(n²)\n5. GEOMETRIC INNER LOOP: if j *= k each step → O(log_k n), so nested with O(n) outer → O(n log n)`},
      {h:"Recognising Patterns in Code",body:`Pattern → Big-O:\n\n"for i in range(n)"                     → O(n)\n"for i in range(n): for j in range(n)"  → O(n²)\n"for i in range(n): j=1; j*=3 while j<n" → O(n log n)\n"for i in range(0,n,3): for j..."       → O(n²)  [i+=3 is still O(n)]\n"binary halving (j//=2)"                → O(log n)`},
      {h:"Dominant Terms Quick Guide",body:`T(n) = 5000n + 0.001n³ + 0.025n²  → O(n³)\nT(n) = 500n + 0.5n^1.7              → O(n^1.7)\nT(n) = 0.3n²logn + 600log(n²)      → O(n²log n)  [log n² = 2log n]\nT(n) = 8n log₃n + 2n log₂n         → O(n log n)\nT(n) = 100n + 0.01n²                → O(n²)`},
      {h:"5 Algorithm Characteristics",body:`1. INPUT      — zero or more well-defined inputs\n2. OUTPUT     — at least one output produced\n3. DEFINITENESS — every step is clear and unambiguous\n4. FINITENESS  — terminates after a finite number of steps\n5. EFFECTIVENESS — every step is basic and executable`},
    ]},
  recursion:{title:"Recursion & Iteration",color:"#0984e3",
    sections:[
      {h:"The Key Difference",body:`RECURSION: A function calls itself. Each call adds a FRAME to the call stack.\nITERATION: Uses a loop. No extra frames.\n\nFor factorial and fibonacci, both achieve the same result but:\n• Recursive: elegant, mirrors maths, but O(n) space (stack frames)\n• Iterative: less intuitive, but O(1) space (no stack risk)`},
      {h:"Factorial — Recursive Trace (n=4)",body:`fact(4)\n  └─ 4 × fact(3)\n         └─ 3 × fact(2)\n                └─ 2 × fact(1)\n                       └─ 1   ← BASE CASE\n\nUnwinding:\nfact(2) = 2 × 1 = 2\nfact(3) = 3 × 2 = 6\nfact(4) = 4 × 6 = 24\n\nTime: O(n) | Space: O(n) — 4 frames stacked simultaneously`},
      {h:"Factorial — Iterative Trace (n=4)",body:`result = 1\ni=2: result = 1 × 2 = 2\ni=3: result = 2 × 3 = 6\ni=4: result = 6 × 4 = 24\nreturn 24\n\nTime: O(n) | Space: O(1) — only 'result' variable exists`},
      {h:"Fibonacci — Why Recursion is Terrible",body:`fib(5) calls fib(4) AND fib(3)\nfib(4) calls fib(3) AND fib(2)  ← fib(3) called TWICE!\nfib(3) calls fib(2) AND fib(1)  ← fib(2) called MULTIPLE times!\n\nTime: O(2ⁿ) — exponential, catastrophic for large n\nSpace: O(n) — max recursion depth\n\nIterative Fibonacci:\nKeep only 2 previous values → O(n) time, O(1) space`},
      {h:"When to Use Each",body:`RECURSIVE when:\n• Problem naturally divides into subproblems (trees, graphs)\n• Code clarity matters and n is small\n• Base case is simple\n\nITERATIVE when:\n• Large n (stack overflow risk)\n• Memory is constrained\n• Performance is critical (no function call overhead)`},
    ]},
  sorting:{title:"Sorting Algorithms",color:"#a29bfe",
    sections:[
      {h:"The Big Picture",body:`COMPARISON TABLE:\n\nAlgorithm     Best        Average      Worst       Space  Stable?\nBubble        O(n)        O(n²)        O(n²)       O(1)   Yes\nSelection     O(n²)       O(n²)        O(n²)       O(1)   No\nInsertion     O(n)        O(n²)        O(n²)       O(1)   Yes\nQuick Sort    O(n log n)  O(n log n)   O(n²)*      O(logn) No\nHeap Sort     O(n log n)  O(n log n)   O(n log n)  O(1)   No\n\n*Worst case: sorted array with last-element pivot`},
      {h:"Bubble Sort — How it Works",body:`Compare adjacent pairs, swap if wrong order.\nLargest element "bubbles" to end each pass.\n\nExample {5,3,8,1}:\nPass 1: [3,5,8,1]→[3,5,1,8] ✓ 8 placed\nPass 2: [3,1,5,8] ✓ 5 placed  \nPass 3: [1,3,5,8] ✓ Done\n\nOptimisation: Add a 'swapped' flag.\nIf pass completes with 0 swaps → already sorted → stop early → O(n) best case.`},
      {h:"Quick Sort — How it Works",body:`Divide-and-conquer with a PIVOT element.\n\n1. Choose pivot (commonly: last element)\n2. PARTITION: move elements < pivot left, > pivot right\n3. Pivot is now in its FINAL correct position\n4. Recursively sort left and right sub-arrays\n\nWhy worst case O(n²)?\nSorted array + last-element pivot:\n[1,2,3,4,5] → pivot=5, left=[1,2,3,4], right=[]\nEach step only reduces by 1 → n levels × n work = O(n²)\n\nFix: Use random pivot or median-of-3 pivot.`},
      {h:"Heap Sort — How it Works",body:`TWO PHASE PROCESS:\n\nPHASE 1: Build MAX-HEAP\n• Parent ≥ both children (always!)\n• Root is always the maximum\n• Heapify from last non-leaf upward\n• Time: O(n)\n\nPHASE 2: Extract max repeatedly\n• Swap root (max) with last element\n• Reduce heap size by 1\n• Heapify down from root\n• Repeat n times → O(n log n)\n\nKEY ADVANTAGE: GUARANTEED O(n log n) — no worst case degradation!\nBetter than Quick Sort in guaranteed performance.`},
      {h:"Which Sort for the Exam?",body:`WHAT EXAMINERS TEST:\n• Trace through an array step-by-step (show your working!)\n• State the Big-O for best/average/worst case\n• Explain the strategy in words\n• Compare two algorithms\n\nTIP: For Quick Sort traces, always state your pivot.\nTIP: For Heap Sort, show the tree representation, not just the array.`},
    ]},
  stackqueue:{title:"Stacks & Queues",color:"#e17055",
    sections:[
      {h:"LIFO vs FIFO",body:`STACK — LIFO (Last In, First Out)\n• Like a stack of plates: add/remove from TOP only\n• push() adds to top, pop() removes from top\n• peek() views top without removing\n• Used in: function calls, undo/redo, DFS, expression evaluation\n\nQUEUE — FIFO (First In, First Out)\n• Like a bank queue: join at back, served from front\n• enqueue() adds to rear, dequeue() removes from front\n• Used in: BFS, task scheduling, printer queue, CPU scheduling`},
      {h:"Stack Implementation Key Points",body:`Array-based Stack:\n• Use an integer 'top' starting at -1\n• push: arr[++top] = value\n• pop:  return arr[top--]\n• isEmpty: top == -1\n• peek: return arr[top]\n\nLinked-based Stack:\n• Maintain pointer to 'top' node\n• push: create new node, point its next to current top, update top\n• pop:  save top, advance top = top.next, return saved\n• All operations: O(1)`},
      {h:"Circular Queue — The Key Trick",body:`PROBLEM with linear queue:\nAfter many dequeues, front pointer moves right.\nEven with space at the start, we can't use it → wasteful!\n\nSOLUTION: Circular queue using MODULO:\n  rear  = (rear  + 1) % capacity  ← wrap rear pointer\n  front = (front + 1) % capacity  ← wrap front pointer\n\nThis makes the array act like a circle!\nisFull:  size == capacity\nisEmpty: size == 0\n(Track size as a separate variable — cleaner than comparing front and rear)\n\nAll operations: O(1)`},
      {h:"Common Exam Mistakes",body:`❌ Forgetting the % capacity in circular queue\n❌ Not handling isEmpty/isFull before push/pop\n❌ Stack: starting top at 0 (should be -1 for empty)\n❌ Queue: confusing which end is front vs rear\n\n✅ Always throw an exception or handle full/empty case\n✅ State clearly: "This is LIFO/FIFO"\n✅ Show the linked structure with arrows in diagrams`},
    ]},
  trees:{title:"Trees (BST & AVL)",color:"#00c9a7",
    sections:[
      {h:"BST Property",body:`Binary Search Tree RULE (must hold for EVERY node):\n  ALL values in left subtree  < node value\n  ALL values in right subtree > node value\n\nThis means:\n• Insert: compare, go left or right, repeat until null\n• Find: same comparison logic → O(log n) balanced\n• Inorder traversal: always produces SORTED sequence\n\nTime: O(log n) balanced tree, O(n) degenerate (skewed) tree`},
      {h:"The Three Traversals",body:`Think of it as WHERE you process the root:\n\nIN-order:   Left → ROOT → Right   (IN the middle)\n  → Produces SORTED sequence — most useful!\n\nPRE-order:  ROOT → Left → Right   (ROOT first)\n  → Used to COPY/SERIALIZE a tree\n\nPOST-order: Left → Right → ROOT   (ROOT last)\n  → Used to DELETE a tree (children before parent)\n\nMemory aid: Pre=Root first, In=Root middle, Post=Root last`},
      {h:"BST Delete — 3 Cases",body:`Case 1: Node is a LEAF (no children)\n  → Simply remove it\n\nCase 2: Node has ONE child\n  → Replace node with its child\n\nCase 3: Node has TWO children\n  → Find INORDER SUCCESSOR (smallest value in right subtree)\n  → Replace deleted node's value with successor's value\n  → Delete the successor (which has at most 1 child)\n\nTime: O(log n) balanced`},
      {h:"AVL Tree — Self-Balancing",body:`PROBLEM: Inserting sorted data into BST creates a linear chain.\n{10,11,12,13} → right-skewed → search becomes O(n) not O(log n)!\n\nAVL SOLUTION:\nAfter every insert/delete, check BALANCE FACTOR:\n  BF = height(left subtree) − height(right subtree)\n  MUST be -1, 0, or +1 at every node\n\nIf |BF| > 1 → perform a ROTATION:\n  LL case → Right rotate\n  RR case → Left rotate\n  LR case → Left rotate child, then Right rotate\n  RL case → Right rotate child, then Left rotate\n\nGuarantee: height always ≤ 1.44 log₂n → all ops O(log n)`},
      {h:"Reconstructing a Tree from Traversals",body:`Given Preorder + Inorder → can uniquely reconstruct tree\n\nAlgorithm:\n1. First element of Preorder = ROOT\n2. Find root in Inorder array\n3. Elements LEFT of root in Inorder → left subtree\n4. Elements RIGHT of root in Inorder → right subtree\n5. Recurse on both halves\n\nExample:\nPreorder: [10, 5, 3, 7, 15]\nInorder:  [3, 5, 7, 10, 15]\nRoot = 10, left={3,5,7}, right={15} → BST confirmed`},
    ]},
  graphs:{title:"Graph Algorithms",color:"#fd79a8",
    sections:[
      {h:"BFS vs DFS — The Core Difference",body:`BFS — Breadth-First Search\n  Data structure: QUEUE (FIFO)\n  Strategy: Visit all neighbours before going deeper\n  → Level by level exploration\n  → Finds SHORTEST PATH in unweighted graphs\n  → Good for: nearest neighbour, social network distance\n\nDFS — Depth-First Search\n  Data structure: STACK (LIFO) or recursion\n  Strategy: Go deep on one path, backtrack when stuck\n  → Good for: maze solving, cycle detection, topological sort\n  → May not find shortest path\n\nBoth: Time O(V+E), Space O(V)`},
      {h:"BFS Algorithm Steps",body:`1. Create visited set, create empty queue\n2. Enqueue start node, mark as visited\n3. While queue is not empty:\n   a. Dequeue node → current\n   b. Process current (print/record it)\n   c. For each unvisited neighbour of current:\n      - Mark as visited\n      - Enqueue it\n4. Repeat until queue empty\n\nKey: Because we use a queue, nodes at same distance\nfrom source are always processed together (level order).`},
      {h:"DFS Algorithm Steps",body:`1. Create visited set, create empty stack\n2. Push start node onto stack\n3. While stack is not empty:\n   a. Pop node → current\n   b. If current not visited:\n      - Mark as visited\n      - Process current\n      - Push all unvisited neighbours\n4. Repeat until stack empty\n\nAlternatively: implement recursively\ndfs(node): mark visited → process → recurse on all unvisited neighbours`},
      {h:"Dijkstra's Shortest Path",body:`PROBLEM: Find shortest path from source to all vertices\nREQUIREMENT: Non-negative edge weights only!\n\nALGORITHM:\n1. dist[source]=0, dist[all others]=∞\n2. Unvisited = all vertices\n3. While unvisited not empty:\n   a. Pick u = vertex with minimum distance in unvisited\n   b. For each neighbour v of u:\n      → if dist[u] + weight(u,v) < dist[v]:\n         dist[v] = dist[u] + weight(u,v)  ← RELAX edge\n   c. Remove u from unvisited\n\nTime: O(V²) basic, O((V+E) log V) with priority queue`},
      {h:"Prim's vs Kruskal's MST",body:`MST = Minimum Spanning Tree: all V vertices connected,\nno cycles, minimum total edge weight, always V-1 edges.\n\nPRIM'S:\n• Grow MST from a starting vertex\n• Always add the cheapest edge connecting visited ↔ unvisited\n• Good for DENSE graphs\n• Time: O(E log V)\n\nKRUSKAL'S:\n• Sort ALL edges by weight\n• Add cheapest edge that doesn't create a cycle\n• Uses Union-Find data structure\n• Good for SPARSE graphs\n• Time: O(E log E)\n\nBoth produce the same MST result.`},
      {h:"Graph Representations",body:`ADJACENCY MATRIX [V×V array]:\n• matrix[i][j] = 1 if edge i→j exists\n• Space: O(V²)\n• Check edge: O(1)\n• List neighbours: O(V)\n• Best for: DENSE graphs\n\nADJACENCY LIST [array of linked lists]:\n• list[i] = all neighbours of vertex i\n• Space: O(V+E)\n• Check edge: O(degree)\n• List neighbours: O(degree)\n• Best for: SPARSE graphs (most real-world graphs!)`},
    ]},
  hashing:{title:"Hash Tables",color:"#fdcb6e",
    sections:[
      {h:"Hash Table Basics",body:`A hash table stores key-value pairs using a HASH FUNCTION\nto map keys to array indices.\n\nHASH FUNCTION: h(key) = key mod tableSize\n\nGoal: O(1) average time for insert, search, delete\n\nLOAD FACTOR α = n / tableSize (ratio of filled slots)\nKeep α < 0.7 for good performance`},
      {h:"Collisions & Linear Probing",body:`COLLISION: Two keys map to the same index.\n(Inevitable — by pigeonhole principle)\n\nLINEAR PROBING (Open Addressing):\nOn collision at slot h, try:\n  (h+1) % n, (h+2) % n, (h+3) % n...\nuntil an empty slot is found.\n\nPROBLEM: PRIMARY CLUSTERING\nLong runs of filled slots form, slowing future insertions.\nExample: If slots 3,4,5,6 are full, any key hashing to 3-6\nnow needs to probe all the way to slot 7.`},
      {h:"Exam Example (h(x) = x mod 7)",body:`Keys: 50, 700, 76, 85, 92, 73, 101\n\nh(50)=1  → [1] free ✓\nh(700)=0 → [0] free ✓\nh(76)=6  → [6] free ✓\nh(85)=1  → [1] taken → try [2] ✓\nh(92)=1  → [1][2] taken → try [3] ✓\nh(73)=3  → [3] taken → try [4] ✓\nh(101)=3 → [3][4] taken → try [5] ✓\n\nFinal: [0]=700 [1]=50 [2]=85 [3]=92 [4]=73 [5]=101 [6]=76`},
    ]},
};

const SCOPE_DATA = [
  {topic:"Big-O Code Analysis",marks:"9–15",papers:"ALL papers",priority:5,tip:"3 code snippets common. Know: two loops=O(n), nested=O(n²), j*=k inner=O(n log n)"},
  {topic:"Factorial (Recursive & Iterative)",marks:"10–20",papers:"ALL papers",priority:5,tip:"Must know trace, code in Java/Python, and O(n) time vs O(n)/O(1) space comparison"},
  {topic:"Quick Sort (trace + Big-O)",marks:"12–20",papers:"5 of 7 papers",priority:5,tip:"Show pivot choice, partition step, recurse. Know worst case is O(n²) with sorted+last pivot"},
  {topic:"Heap Sort (trace + Big-O)",marks:"12–20",papers:"5 of 7 papers",priority:5,tip:"Show build-max-heap phase AND extraction phase. KEY: always O(n log n) guaranteed"},
  {topic:"Bubble Sort (trace + Big-O)",marks:"8–12",papers:"Most papers",priority:4,tip:"Show each pass clearly. O(n) best (optimised), O(n²) worst"},
  {topic:"Stack (array or linked)",marks:"10–20",papers:"Multiple",priority:4,tip:"Must implement push, pop, isEmpty, peek. Know LIFO. Show code + complexity"},
  {topic:"Circular Queue",marks:"10–20",papers:"Multiple",priority:4,tip:"KEY: (rear+1)%capacity and (front+1)%capacity for wrapping. Know enqueue/dequeue/isEmpty/isFull"},
  {topic:"BST (insert, traversals)",marks:"15–20",papers:"Multiple",priority:4,tip:"Inorder=sorted! Know insert logic, all 3 traversals by definition and example"},
  {topic:"AVL Tree (balance + rotations)",marks:"6–10",papers:"Midyear 2021",priority:3,tip:"Know balance factor formula, 4 rotation types (LL/RR/LR/RL), why AVL guarantees O(log n)"},
  {topic:"Graph BFS & DFS",marks:"10–20",papers:"Older papers",priority:3,tip:"BFS=Queue, DFS=Stack. Know step-by-step algorithm for each"},
  {topic:"Dijkstra / Prim / Kruskal",marks:"10–20",papers:"Older papers",priority:3,tip:"Dijkstra=shortest path (no negative weights). Prim/Kruskal=MST"},
  {topic:"Hash Tables (linear probing)",marks:"10",papers:"Nov 2020",priority:3,tip:"Apply h(x)=x mod n, show probing step by step, know clustering problem"},
  {topic:"Algorithm characteristics",marks:"5",papers:"2024 / Asgn 2023",priority:4,tip:"5 characteristics: Input, Output, Definiteness, Finiteness, Effectiveness"},
  {topic:"Fibonacci (rec vs iter)",marks:"10",papers:"Asgn 2023",priority:3,tip:"Recursive Fibonacci is O(2ⁿ) — terrible! Iterative is O(n). Know why."},
];

const MEMORY_AIDS = [
  {title:"Algorithm Characteristics",sub:"IODEF",color:"#00c9a7",
   content:"I — Input: zero or more\nO — Output: at least one\nD — Definiteness: every step unambiguous\nE — Effectiveness: every step executable\nF — Finiteness: terminates in finite steps\n\nMnemonic: \"I Often Dream of Excellent Food\""},
  {title:"Big-O Quick Rules",sub:"4 Golden Rules",color:"#0984e3",
   content:"1. DROP constants: O(3n) → O(n)\n2. DROP lower terms: O(n²+n) → O(n²)\n3. SEQUENTIAL adds: O(n)+O(n) → O(n)\n4. NESTED multiplies: O(n)×O(n) → O(n²)\n\nBonus: j*=k in inner loop → O(log n) inner"},
  {title:"Sorting Cheat",sub:"Best Performance",color:"#a29bfe",
   content:"\"Quick Heap Always Wins Best\"\n→ Quick Sort: O(n log n) best & avg [but O(n²) worst]\n→ Heap Sort: O(n log n) ALL cases [guaranteed!]\n→ Bubble/Selection/Insertion: O(n²) worst & avg\n→ Insertion/Bubble BEST case: O(n) [nearly sorted]\n\nExam tip: Heap Sort = safest choice performance-wise"},
  {title:"LIFO vs FIFO",sub:"Stack vs Queue",color:"#e17055",
   content:"STACK = LIFO = \"Plates\"\n  Last plate added = first plate taken\n  push() → pop() → always from TOP\n\nQUEUE = FIFO = \"Bank Queue\"\n  First person in line = first served\n  enqueue() rear → dequeue() front\n\nMnemonic: \"Stack of plates, Queue at bank\""},
  {title:"Tree Traversals",sub:"L=Left R=Right N=Node",color:"#00c9a7",
   content:"PRE-order:  N L R  (Node FIRST)\nIN-order:   L N R  (Node IN middle) ← gives SORTED!\nPOST-order: L R N  (Node LAST)\n\nMemory: Pre=before, In=between, Post=after\n\n\"Inorder gives sorted output\" — this is the most\nimportant traversal fact for the exam!"},
  {title:"Circular Queue Magic",sub:"The Modulo Trick",color:"#fd79a8",
   content:"WHY circular? Linear queue wastes front slots.\nSOLUTION: Wrap pointers with %\n\nenqueue: rear  = (rear  + 1) % capacity\ndequeue: front = (front + 1) % capacity\nisFull:  size == capacity\nisEmpty: size == 0\n\nVisualize: imagine the array as a clock face.\nPointers go round and round!"},
  {title:"AVL Balance Factor",sub:"Self-balancing BST",color:"#fdcb6e",
   content:"BF = height(LEFT) − height(RIGHT)\nMust be: −1, 0, or +1 at EVERY node\n\nIf BF = +2 (left heavy):\n  Left child BF ≥ 0 → LL case → RIGHT rotate\n  Left child BF < 0 → LR case → Left then Right rotate\n\nIf BF = −2 (right heavy):\n  Right child BF ≤ 0 → RR case → LEFT rotate\n  Right child BF > 0 → RL case → Right then Left rotate"},
  {title:"Quick Sort vs Heap Sort",sub:"When to use which",color:"#a29bfe",
   content:"QUICK SORT:\n✅ Fast in practice (good cache performance)\n✅ In-place O(log n) space\n❌ O(n²) worst case (sorted input + bad pivot)\n\nHEAP SORT:\n✅ GUARANTEED O(n log n) always\n✅ In-place O(1) space\n❌ Slower in practice (poor cache performance)\n\nExam answer: \"For guaranteed performance, use Heap Sort\"\n              \"In practice, Quick Sort is typically faster\""},
  {title:"Dijkstra Remember",sub:"Shortest Path Algorithm",color:"#fd79a8",
   content:"PURPOSE: Shortest path, WEIGHTED graph\nLIMIT: No NEGATIVE weights!\n\nKey steps:\n1. dist[source]=0, all others=∞\n2. Pick unvisited vertex with min distance\n3. RELAX all edges: if dist[u]+w < dist[v] → update\n4. Mark u visited, repeat\n\n\"RELAX\" = update if found shorter path\nMnemonic: \"Dijkstra RELAXES on the way to the shortest path\""},
  {title:"Hash Table Probing",sub:"Linear Probing Rule",color:"#fdcb6e",
   content:"HASH: h(key) = key mod tableSize\nCOLLISION: slot taken → try next slot\n\nFormula: try slot (h + i) mod n for i=1,2,3...\n\nEXAM TRICK — check h(x) mod 7:\n• 50 mod 7 = 1 (50 = 7×7 + 1)\n• 700 mod 7 = 0 (700 = 7×100)\n• 85 mod 7 = 1 → collision!\n\nALWAYS show your working: h(key) = ? → which slot → collision? → probe"},
];

function FormulaTable({data}){
  if(!data) return null;
  return(
    <div style={{margin:"0.75rem 0",borderRadius:6,overflow:"hidden",border:`1px solid ${S.faint}`}}>
      <table style={{width:"100%",borderCollapse:"collapse",fontSize:12}}>
        <thead><tr style={{background:S.faint}}>
          {data.head.map((h,i)=><th key={i} style={{padding:"7px 10px",color:S.text,fontWeight:500,textAlign:"left",whiteSpace:"nowrap"}}>{h}</th>)}
        </tr></thead>
        <tbody>{data.rows.map((row,i)=>(
          <tr key={i} style={{borderTop:`1px solid ${S.faint}`,background:i%2===0?"transparent":"#0a0a18"}}>
            {row.map((cell,j)=><td key={j} style={{padding:"7px 10px",color:j===0?S.accent:S.muted,fontFamily:j===0?"monospace":"inherit",fontSize:12,verticalAlign:"top"}}>{cell}</td>)}
          </tr>
        ))}</tbody>
      </table>
    </div>
  );
}

// ─── DIAGRAM COMPONENTS ────────────────────────────────────────────────────

function BigODiagram(){
  const items=[
    {label:"O(1)",desc:"Constant",n10:1,n100:1,n1000:1,col:"#00c9a7"},
    {label:"O(log n)",desc:"Logarithmic",n10:3,n100:7,n1000:10,col:"#0984e3"},
    {label:"O(n)",desc:"Linear",n10:10,n100:100,n1000:1000,col:"#a29bfe"},
    {label:"O(n log n)",desc:"Linearithmic",n10:33,n100:664,n1000:9966,col:"#fdcb6e"},
    {label:"O(n²)",desc:"Quadratic",n10:100,n100:10000,n1000:1000000,col:"#e17055"},
    {label:"O(2ⁿ)",desc:"Exponential",n10:1024,n100:"HUGE",n1000:"∞",col:"#fd79a8"},
  ];
  const [n,setN]=useState(100);
  const vals=items.map(it=>typeof it[`n${n}`]==="number"?it[`n${n}`]:null);
  const max=Math.max(...vals.filter(v=>v!==null&&v<1e7));
  return(
    <div style={{padding:"1rem",background:S.cardInner,borderRadius:8,border:`1px solid ${S.cardBorder}`}}>
      <div style={{display:"flex",alignItems:"center",gap:12,marginBottom:"1rem",flexWrap:"wrap"}}>
        <span style={{fontSize:13,color:S.muted}}>Input size n =</span>
        {[10,100,1000].map(v=>(
          <button key={v} onClick={()=>setN(v)} style={{padding:"4px 14px",borderRadius:20,border:`1px solid ${n===v?S.accent:S.faint}`,background:n===v?S.accentDim:"transparent",color:n===v?S.accent:S.muted,cursor:"pointer",fontSize:13}}>n={v}</button>
        ))}
      </div>
      {items.map((it,i)=>{
        const val=it[`n${n}`];
        const isNum=typeof val==="number";
        const pct=isNum&&val<1e7?Math.min(100,(val/max)*100):100;
        return(
          <div key={i} style={{display:"flex",alignItems:"center",gap:10,marginBottom:10}}>
            <span style={{width:90,fontFamily:"monospace",fontSize:13,color:it.col,flexShrink:0}}>{it.label}</span>
            <span style={{width:110,fontSize:12,color:S.muted,flexShrink:0}}>{it.desc}</span>
            <div style={{flex:1,background:S.faint,borderRadius:3,height:18,overflow:"hidden"}}>
              <div style={{width:`${pct}%`,height:"100%",background:it.col,opacity:0.85,borderRadius:3,display:"flex",alignItems:"center",justifyContent:"flex-end",paddingRight:4}}>
              </div>
            </div>
            <span style={{width:70,fontSize:12,color:typeof val==="string"?it.col:S.muted,textAlign:"right",fontFamily:"monospace",flexShrink:0}}>{typeof val==="number"?val.toLocaleString():val}</span>
          </div>
        );
      })}
      <p style={{fontSize:11,color:S.faint,margin:"0.75rem 0 0"}}>Operations count for each complexity at n={n}. Note how O(n²) and O(2ⁿ) explode.</p>
    </div>
  );
}

function BubbleSortDiagram(){
  const initial=[64,34,25,12,22,11,90];
  const [arr,setArr]=useState([...initial]);
  const [step,setStep]=useState(0);
  const [i,setI]=useState(0);
  const [j,setJ]=useState(0);
  const [done,setDone]=useState(false);
  const [history,setHistory]=useState([[...initial]]);
  const [comparing,setComparing]=useState([0,1]);

  const next=()=>{
    if(done) return;
    const a=[...arr];
    let ni=i,nj=j,ndone=false;
    if(a[nj]>a[nj+1]){[a[nj],a[nj+1]]=[a[nj+1],a[nj]];}
    nj++;
    if(nj>=a.length-1-ni){nj=0;ni++;}
    if(ni>=a.length-1){ndone=true;}
    setArr(a);setI(ni);setJ(nj);setDone(ndone);
    setComparing([nj,nj+1]);
    setStep(s=>s+1);
    setHistory(h=>[...h,a]);
  };
  const reset=()=>{setArr([...initial]);setI(0);setJ(0);setDone(false);setStep(0);setHistory([[...initial]]);setComparing([0,1]);};
  const max=Math.max(...arr);
  return(
    <div style={{padding:"1rem",background:S.cardInner,borderRadius:8,border:`1px solid ${S.cardBorder}`}}>
      <div style={{display:"flex",alignItems:"flex-end",gap:6,height:100,marginBottom:"0.75rem",justifyContent:"center"}}>
        {arr.map((v,idx)=>(
          <div key={idx} style={{display:"flex",flexDirection:"column",alignItems:"center",gap:4}}>
            <span style={{fontSize:11,color:comparing.includes(idx)?"#fff":S.muted}}>{v}</span>
            <div style={{width:32,height:Math.max(8,Math.round((v/max)*70)),background:comparing.includes(idx)?S.accent:S.faint,borderRadius:"3px 3px 0 0",transition:"height 0.2s"}}></div>
          </div>
        ))}
      </div>
      {done
        ? <div style={{textAlign:"center",color:S.accent,fontSize:13,marginBottom:"0.75rem"}}>✓ Sorted! [{arr.join(", ")}]</div>
        : <div style={{textAlign:"center",color:S.muted,fontSize:12,marginBottom:"0.75rem"}}>Pass {i+1}, comparing positions {j} and {j+1} (values {arr[j]} and {arr[j+1]})</div>
      }
      <div style={{display:"flex",gap:8,justifyContent:"center"}}>
        <button onClick={next} disabled={done} style={{padding:"6px 16px",borderRadius:6,border:"none",background:done?S.faint:S.accent,color:done?S.muted:"#000",cursor:done?"not-allowed":"pointer",fontWeight:600,fontSize:13}}>Next Step →</button>
        <button onClick={reset} style={{padding:"6px 16px",borderRadius:6,border:`1px solid ${S.faint}`,background:"transparent",color:S.muted,cursor:"pointer",fontSize:13}}>Reset</button>
      </div>
      <p style={{fontSize:11,color:S.faint,textAlign:"center",margin:"0.5rem 0 0"}}>Highlighted bars are being compared. Step {step}</p>
    </div>
  );
}

function StackQueueDiagram(){
  const [stackItems,setStackItems]=useState([3,7,1]);
  const [queueItems,setQueueItems]=useState([5,2,8]);
  const [stackInput,setStackInput]=useState("");
  const [queueInput,setQueueInput]=useState("");
  const [sMsg,setSMsg]=useState("");
  const [qMsg,setQMsg]=useState("");

  const push=()=>{
    const v=parseInt(stackInput);
    if(!isNaN(v)){setStackItems(a=>[...a,v]);setSMsg(`Pushed ${v}`);setStackInput("");}
  };
  const pop=()=>{
    if(stackItems.length===0){setSMsg("Stack empty!");return;}
    const v=stackItems[stackItems.length-1];
    setStackItems(a=>a.slice(0,-1));setSMsg(`Popped ${v} (LIFO)`);
  };
  const enqueue=()=>{
    const v=parseInt(queueInput);
    if(!isNaN(v)){setQueueItems(a=>[...a,v]);setQMsg(`Enqueued ${v}`);setQueueInput("");}
  };
  const dequeue=()=>{
    if(queueItems.length===0){setQMsg("Queue empty!");return;}
    const v=queueItems[0];
    setQueueItems(a=>a.slice(1));setQMsg(`Dequeued ${v} (FIFO)`);
  };

  return(
    <div style={{display:"grid",gridTemplateColumns:"1fr 1fr",gap:12}}>
      <div style={{padding:"1rem",background:S.cardInner,borderRadius:8,border:`1px solid ${S.cardBorder}`}}>
        <div style={{fontSize:13,fontWeight:600,color:"#e17055",marginBottom:"0.75rem"}}>STACK — LIFO</div>
        <div style={{display:"flex",flexDirection:"column-reverse",gap:4,minHeight:80,marginBottom:"0.75rem",alignItems:"center"}}>
          {stackItems.map((v,i)=>(
            <div key={i} style={{width:"100%",padding:"5px 8px",background:i===stackItems.length-1?"#e1705540":"#2a2a40",borderRadius:4,textAlign:"center",fontSize:13,color:i===stackItems.length-1?"#e17055":S.muted,border:`1px solid ${i===stackItems.length-1?"#e17055":S.faint}`,position:"relative"}}>
              {v}{i===stackItems.length-1&&<span style={{position:"absolute",right:8,fontSize:10,color:"#e17055"}}>← TOP</span>}
            </div>
          ))}
          {stackItems.length===0&&<div style={{color:S.faint,fontSize:12}}>Empty stack</div>}
        </div>
        <div style={{display:"flex",gap:4,marginBottom:6}}>
          <input value={stackInput} onChange={e=>setStackInput(e.target.value)} placeholder="value" style={{flex:1,padding:"4px 8px",borderRadius:4,border:`1px solid ${S.faint}`,background:"#0a0a18",color:S.text,fontSize:13}} />
          <button onClick={push} style={{padding:"4px 10px",borderRadius:4,border:"none",background:"#e17055",color:"#fff",cursor:"pointer",fontSize:12}}>Push</button>
          <button onClick={pop} style={{padding:"4px 10px",borderRadius:4,border:`1px solid ${S.faint}`,background:"transparent",color:S.muted,cursor:"pointer",fontSize:12}}>Pop</button>
        </div>
        {sMsg&&<div style={{fontSize:11,color:"#e17055"}}>{sMsg}</div>}
      </div>
      <div style={{padding:"1rem",background:S.cardInner,borderRadius:8,border:`1px solid ${S.cardBorder}`}}>
        <div style={{fontSize:13,fontWeight:600,color:S.accent,marginBottom:"0.75rem"}}>QUEUE — FIFO</div>
        <div style={{display:"flex",flexDirection:"row",gap:4,minHeight:80,marginBottom:"0.75rem",alignItems:"center",flexWrap:"wrap"}}>
          {queueItems.map((v,i)=>(
            <div key={i} style={{padding:"5px 8px",background:i===0?"#00c9a740":"#2a2a40",borderRadius:4,textAlign:"center",fontSize:13,color:i===0?S.accent:S.muted,border:`1px solid ${i===0?S.accent:S.faint}`,position:"relative"}}>
              {v}
              {i===0&&<div style={{fontSize:9,color:S.accent,textAlign:"center"}}>FRONT</div>}
              {i===queueItems.length-1&&i!==0&&<div style={{fontSize:9,color:S.muted,textAlign:"center"}}>REAR</div>}
            </div>
          ))}
          {queueItems.length===0&&<div style={{color:S.faint,fontSize:12}}>Empty queue</div>}
        </div>
        <div style={{display:"flex",gap:4,marginBottom:6}}>
          <input value={queueInput} onChange={e=>setQueueInput(e.target.value)} placeholder="value" style={{flex:1,padding:"4px 8px",borderRadius:4,border:`1px solid ${S.faint}`,background:"#0a0a18",color:S.text,fontSize:13}} />
          <button onClick={enqueue} style={{padding:"4px 10px",borderRadius:4,border:"none",background:S.accent,color:"#000",cursor:"pointer",fontSize:12}}>Enqueue</button>
          <button onClick={dequeue} style={{padding:"4px 10px",borderRadius:4,border:`1px solid ${S.faint}`,background:"transparent",color:S.muted,cursor:"pointer",fontSize:12}}>Dequeue</button>
        </div>
        {qMsg&&<div style={{fontSize:11,color:S.accent}}>{qMsg}</div>}
      </div>
    </div>
  );
}

function BSTDiagram(){
  const [values,setValues]=useState([10,5,15,3,7,12,18]);
  const [input,setInput]=useState("");
  const buildTree=vs=>{
    const nodes={};
    vs.forEach(v=>{nodes[v]={val:v,left:null,right:null};});
    let root=null;
    const insert=(r,v)=>{
      if(!r) return v;
      if(v<r){nodes[r].left=insert(nodes[r].left,v);}
      else if(v>r){nodes[r].right=insert(nodes[r].right,v);}
      return r;
    };
    vs.forEach(v=>{root=insert(root,v);});
    return{nodes,root};
  };
  const tree=buildTree(values);
  const getPositions=(root,nodes,x,y,spread)=>{
    if(!root) return [];
    const pos=[{val:root,x,y}];
    if(nodes[root].left) pos.push(...getPositions(nodes[root].left,nodes,x-spread,y+60,spread/2));
    if(nodes[root].right) pos.push(...getPositions(nodes[root].right,nodes,x+spread,y+60,spread/2));
    return pos;
  };
  const getEdges=(root,nodes,x,y,spread)=>{
    if(!root) return [];
    const edges=[];
    if(nodes[root].left){edges.push({x1:x,y1:y,x2:x-spread,y2:y+60});edges.push(...getEdges(nodes[root].left,nodes,x-spread,y+60,spread/2));}
    if(nodes[root].right){edges.push({x1:x,y1:y,x2:x+spread,y2:y+60});edges.push(...getEdges(nodes[root].right,nodes,x+spread,y+60,spread/2));}
    return edges;
  };
  const positions=tree.root?getPositions(tree.root,tree.nodes,200,30,90):[];
  const edges=tree.root?getEdges(tree.root,tree.nodes,200,30,90):[];
  const inorder=(r,nodes)=>{if(!r)return[];return[...inorder(nodes[r].left,nodes),r,...inorder(nodes[r].right,nodes)];};
  const sorted=tree.root?inorder(tree.root,tree.nodes):[];
  const addNode=()=>{
    const v=parseInt(input);
    if(!isNaN(v)&&!values.includes(v)){setValues(a=>[...a,v]);setInput("");}
  };
  return(
    <div style={{padding:"1rem",background:S.cardInner,borderRadius:8,border:`1px solid ${S.cardBorder}`}}>
      <svg width="400" height="180" style={{display:"block",margin:"0 auto"}}>
        {edges.map((e,i)=><line key={i} x1={e.x1} y1={e.y1} x2={e.x2} y2={e.y2} stroke={S.faint} strokeWidth={1.5}/>)}
        {positions.map((p,i)=>(
          <g key={i}>
            <circle cx={p.x} cy={p.y} r={16} fill={S.sidebarActive} stroke={S.accent} strokeWidth={1.5}/>
            <text x={p.x} y={p.y+5} textAnchor="middle" fill={S.accent} fontSize={12} fontFamily="monospace">{p.val}</text>
          </g>
        ))}
      </svg>
      <div style={{textAlign:"center",fontSize:12,color:S.muted,marginBottom:"0.75rem"}}>
        Inorder (sorted): <span style={{color:S.accent,fontFamily:"monospace"}}>[{sorted.join(", ")}]</span>
      </div>
      <div style={{display:"flex",gap:6,justifyContent:"center"}}>
        <input value={input} onChange={e=>setInput(e.target.value)} placeholder="Add value" style={{width:100,padding:"4px 8px",borderRadius:4,border:`1px solid ${S.faint}`,background:"#0a0a18",color:S.text,fontSize:13}}/>
        <button onClick={addNode} style={{padding:"4px 12px",borderRadius:4,border:"none",background:S.accent,color:"#000",cursor:"pointer",fontSize:13}}>Insert</button>
        <button onClick={()=>setValues([10,5,15,3,7,12,18])} style={{padding:"4px 12px",borderRadius:4,border:`1px solid ${S.faint}`,background:"transparent",color:S.muted,cursor:"pointer",fontSize:13}}>Reset</button>
      </div>
    </div>
  );
}

function HashTableDiagram(){
  const [keys,setKeys]=useState([50,700,76,85,92,73,101]);
  const [input,setInput]=useState("");
  const [size]=useState(7);
  const buildTable=ks=>{
    const table=Array(size).fill(null);
    ks.forEach(k=>{
      let h=k%size;
      while(table[h]!==null){h=(h+1)%size;}
      table[h]=k;
    });
    return table;
  };
  const table=buildTable(keys);
  const addKey=()=>{
    const v=parseInt(input);
    if(!isNaN(v)){setKeys(k=>[...k,v]);setInput("");}
  };
  return(
    <div style={{padding:"1rem",background:S.cardInner,borderRadius:8,border:`1px solid ${S.cardBorder}`}}>
      <div style={{display:"grid",gridTemplateColumns:"repeat(7,1fr)",gap:4,marginBottom:"0.75rem"}}>
        {table.map((v,i)=>(
          <div key={i} style={{border:`1px solid ${v!==null?S.accent:S.faint}`,borderRadius:6,padding:"8px 4px",textAlign:"center",background:v!==null?S.accentDim:"transparent"}}>
            <div style={{fontSize:10,color:S.faint}}>[{i}]</div>
            <div style={{fontSize:14,fontFamily:"monospace",color:v!==null?S.accent:S.faint,fontWeight:v!==null?600:400}}>{v!==null?v:"—"}</div>
          </div>
        ))}
      </div>
      <div style={{fontSize:12,color:S.muted,marginBottom:"0.75rem"}}>Hash function: h(x) = x mod {size} &nbsp;|&nbsp; Linear probing on collision</div>
      <div style={{display:"flex",gap:6}}>
        <input value={input} onChange={e=>setInput(e.target.value)} placeholder="Add key" style={{width:80,padding:"4px 8px",borderRadius:4,border:`1px solid ${S.faint}`,background:"#0a0a18",color:S.text,fontSize:13}}/>
        <button onClick={addKey} style={{padding:"4px 12px",borderRadius:4,border:"none",background:S.accent,color:"#000",cursor:"pointer",fontSize:13}}>Insert</button>
        <button onClick={()=>setKeys([50,700,76,85,92,73,101])} style={{padding:"4px 12px",borderRadius:4,border:`1px solid ${S.faint}`,background:"transparent",color:S.muted,cursor:"pointer",fontSize:13}}>Reset</button>
      </div>
    </div>
  );
}

function AVLDiagram(){
  const steps=[
    {label:"Insert 10,5,15",desc:"Balanced — all BFs are 0",tree:[[10,200,40],[5,130,100],[15,270,100]],edges:[[200,40,130,100],[200,40,270,100]]},
    {label:"Insert 16",desc:"BF at 15 = −1, still balanced",tree:[[10,200,40],[5,130,100],[15,270,100],[16,310,160]],edges:[[200,40,130,100],[200,40,270,100],[270,100,310,160]]},
    {label:"Insert 17",desc:"BF at 15 = −2! RR case → LEFT ROTATE at 15",tree:[[10,200,40],[5,130,100],[16,270,100],[15,220,160],[17,320,160]],edges:[[200,40,130,100],[200,40,270,100],[270,100,220,160],[270,100,320,160]]},
    {label:"After rotation",desc:"Rebalanced ✓ All BFs in range [−1,0,1]",tree:[[10,200,40],[5,130,100],[16,270,100],[15,220,160],[17,320,160]],edges:[[200,40,130,100],[200,40,270,100],[270,100,220,160],[270,100,320,160]]},
  ];
  const [idx,setIdx]=useState(0);
  const s=steps[idx];
  return(
    <div style={{padding:"1rem",background:S.cardInner,borderRadius:8,border:`1px solid ${S.cardBorder}`}}>
      <div style={{display:"flex",gap:6,marginBottom:"0.75rem",flexWrap:"wrap"}}>
        {steps.map((st,i)=>(
          <button key={i} onClick={()=>setIdx(i)} style={{padding:"4px 10px",borderRadius:20,border:`1px solid ${i===idx?S.accent:S.faint}`,background:i===idx?S.accentDim:"transparent",color:i===idx?S.accent:S.muted,cursor:"pointer",fontSize:12}}>{st.label}</button>
        ))}
      </div>
      <svg width="400" height="200" style={{display:"block",margin:"0 auto"}}>
        {s.edges.map((e,i)=><line key={i} x1={e[0]} y1={e[1]} x2={e[2]} y2={e[3]} stroke={S.faint} strokeWidth={1.5}/>)}
        {s.tree.map((n,i)=>(
          <g key={i}>
            <circle cx={n[1]} cy={n[2]} r={18} fill={S.sidebarActive} stroke={i===0?"#fdcb6e":S.accent} strokeWidth={i===0?2:1.5}/>
            <text x={n[1]} y={n[2]+5} textAnchor="middle" fill={i===0?"#fdcb6e":S.accent} fontSize={13} fontFamily="monospace">{n[0]}</text>
          </g>
        ))}
      </svg>
      <div style={{textAlign:"center",fontSize:12,color:idx===2?"#fdcb6e":S.muted,marginTop:"0.5rem"}}>{s.desc}</div>
    </div>
  );
}

const DIAGRAMS = [
  {id:"bigo",label:"Big-O Growth",icon:"📈",comp:<BigODiagram/>,desc:"Compare how O(1), O(log n), O(n), O(n²) grow with input size"},
  {id:"bubble",label:"Bubble Sort",icon:"🔵",comp:<BubbleSortDiagram/>,desc:"Step through bubble sort interactively — watch adjacent pairs swap"},
  {id:"stackqueue",label:"Stack & Queue",icon:"📦",comp:<StackQueueDiagram/>,desc:"Interactive LIFO stack and FIFO queue — push, pop, enqueue, dequeue"},
  {id:"bst",label:"BST Insert",icon:"🌳",comp:<BSTDiagram/>,desc:"Build a binary search tree — insert values and see inorder output"},
  {id:"avl",label:"AVL Rotations",icon:"⚖️",comp:<AVLDiagram/>,desc:"Watch AVL tree rebalance after RR insertion imbalance"},
  {id:"hash",label:"Hash Table",icon:"#️⃣",comp:<HashTableDiagram/>,desc:"See linear probing in action — add keys and watch collisions resolve"},
];

// ─── PAST PAPERS DATA ──────────────────────────────────────────────────────
const BIGO_FORMULA={head:["Expression","Complexity","Notes"],rows:[["Two sequential loops (both n)","O(n)","Add, drop constants"],["Outer O(n), inner j*=3","O(n log n)","Log inner × linear outer"],["Outer i+=3, inner j-- from n","O(n²)","Both effectively O(n)"],["Outer i<n, inner j<n","O(n²)","Classic nested loops"],["Single loop, no nesting","O(n)","Linear scan"],["Binary halving (j/=2)","O(log n)","Logarithmic"]]};
const SORT_FORMULA={head:["Algorithm","Best","Average","Worst","Space"],rows:[["Bubble Sort","O(n)","O(n²)","O(n²)","O(1)"],["Selection Sort","O(n²)","O(n²)","O(n²)","O(1)"],["Insertion Sort","O(n)","O(n²)","O(n²)","O(1)"],["Quick Sort","O(n log n)","O(n log n)","O(n²)*","O(log n)"],["Heap Sort","O(n log n)","O(n log n)","O(n log n)","O(1)"]]};
const FACT_FORMULA={head:["Method","Time","Space","Notes"],rows:[["Recursive","O(n)","O(n)","n frames on call stack"],["Iterative","O(n)","O(1)","Only loop variable"],["Preferred in production","Iterative","—","No stack overflow risk"]]};
const DSA_FORMULA={head:["Structure","Operation","Complexity","Notes"],rows:[["Stack (push/pop)","Add/remove top","O(1)","LIFO"],["Queue (en/dequeue)","Add rear/remove front","O(1)","FIFO"],["Circular Queue wrap","(idx+1) % cap","O(1)","Key modulo trick"],["BST insert/search","Compare + go L/R","O(log n) avg","O(n) skewed"],["BST inorder","L→Root→R","O(n)","Produces sorted output"],["AVL Balance Factor","h(L)−h(R)","—","Must be −1,0,+1"]]};

const PAPERS_DATA={
  apr25:{title:"Test 1 — April 2025",info:"ADP470S · 75 Marks · 3 April 2025",questions:[
    {n:1,title:"Big-O Code Analysis",marks:15,tag:"Big-O Notation",body:`Determine the Big-O expression for each of the following code excerpts:\n\n(a) int sum = 0;\nfor (int i = 0; i < n; i++) { sum = sum + a[i]; }\nfor (int j = 0; j < n; j++) { sum = sum + a[j]; }          [3]\n\n(b) int prod = 1;\nfor (int i = 1; i < n; i++) {\n  for (int j = i; j < n; j = j * 3) { prod = prod * j; }\n}                                                              [3]\n\n(c) int sum = 0;\nfor (i=0; i<=n-1; i+=3) {\n  for (j=n-1; j>0; j--) { sum = sum + (i * j); }\n}                                                              [3]`,formula:BIGO_FORMULA,answer:`(a) O(n)\nTwo sequential loops, each O(n). O(n)+O(n)=O(2n)=O(n)\n\n(b) O(n log n)\nOuter: O(n). Inner j*=3 → runs log₃(n) times → O(log n)\nNested: O(n) × O(log n) = O(n log n)\n\n(c) O(n²)\nOuter i+=3 runs n/3 times → O(n) [drop constant]\nInner j from n down → O(n)\nNested: O(n) × O(n) = O(n²)`},
    {n:2,title:"Factorial: Recursive & Iterative",marks:20,tag:"Recursion",body:`2.1  Demonstrate how recursive factorial executes.\n     Provide a full trace for n=5. Discuss time complexity.    [10]\n\n2.2  Report on the space complexity of both recursive and\n     iterative factorial. Which is preferable and why?         [10]`,formula:FACT_FORMULA,answer:`2.1 RECURSIVE TRACE for fact(5):\nfact(5) → 5 × fact(4)\nfact(4) → 4 × fact(3)\nfact(3) → 3 × fact(2)\nfact(2) → 2 × fact(1)\nfact(1) → 1 ← BASE CASE\n\nUnwinding: 2×1=2, 3×2=6, 4×6=24, 5×24=120\nTime: O(n) — makes n recursive calls\n\n2.2 SPACE:\nRecursive: O(n) — n frames stacked simultaneously\nIterative: O(1) — single loop variable only\nPreferred: Iterative — no stack overflow risk`},
    {n:3,title:"Sorting Algorithms",marks:40,tag:"Sorting",body:`3.1  Bubble Sort on {90,23,5,109,12} — show passes [8]\n3.2  Bubble Sort Big-O expression                  [4]\n3.3  Quick Sort on {90,23,5,109,12}               [8]\n3.4  Quick Sort Big-O expression                   [4]\n3.5  Heap Sort on {90,23,5,109,12}                [8]\n3.6  Heap Sort Big-O expression                    [4]`,formula:SORT_FORMULA,answer:`BUBBLE SORT {90,23,5,109,12}:\nPass 1: compare adjacent, swap if wrong order\n[90,23,5,109,12]→[23,90,5,109,12]→[23,5,90,109,12]→[23,5,90,12,109] ✓\nPass 2: [5,23,12,90,109] ✓\nPass 3: [5,12,23,90,109] ✓\nBig-O: Best O(n), Avg O(n²), Worst O(n²)\n\nQUICK SORT {90,23,5,109,12} pivot=12:\nleft={5}, right={90,23,109}\n→ [5|12|90,23,109]\nSort right, pivot=109: [23,90|109]\nSort {23,90}, pivot=90: [23|90]\nFinal: [5,12,23,90,109] ✓\nBig-O: Best/Avg O(n log n), Worst O(n²)\n\nHEAP SORT {90,23,5,109,12}:\nBuild max-heap: [109,90,5,23,12]\nExtract: swap 109↔12→heapify→[90,23,5,12|109]\nRepeat until sorted: [5,12,23,90,109] ✓\nBig-O: ALL cases O(n log n). Space O(1)`},
  ]},
  jun23:{title:"Test 1 — June 2023",info:"ADP470S · 80 Marks · 8 June 2023",questions:[
    {n:1,title:"Big-O & Factorial",marks:20,tag:"Big-O / Recursion",body:`1.1 Recursive factorial explanation        [2]\n1.2 Iterative factorial explanation        [4]\n1.3 Performance comparison (time & space)  [5]\n1.4 Code: two sequential for loops         [3]\n1.5 Code: outer O(n), inner j=j*3         [3]\n1.6 Code: outer i+=3, inner j--            [3]`,formula:BIGO_FORMULA,answer:`1.1 RECURSIVE: Base case n≤1→return 1; else return n*fact(n-1)\n1.2 ITERATIVE: result=1; for i=2..n: result*=i; return result\n1.3 Time: both O(n). Space: recursive O(n) stack, iterative O(1). Iterative preferred.\n1.4 O(n) — two O(n) loops sequential, drop constant\n1.5 O(n log n) — outer O(n), inner j*=3 → O(log n)\n1.6 O(n²) — outer O(n/3)=O(n), inner O(n), nested`},
    {n:2,title:"Queue Array Implementation",marks:20,tag:"Data Structures",body:`Implement a queue using ARRAY.\nOperations needed:\n2.1 push (enqueue)    [5]\n2.2 pop (dequeue)     [5]\n2.3 isEmpty           [5]\n2.4 peek              [5]`,formula:null,answer:`public class Queue {\n  private int[] arr;\n  private int front, rear, size, capacity;\n\n  public Queue(int cap) {\n    capacity=cap; arr=new int[cap];\n    front=0; rear=-1; size=0;\n  }\n\n  public void enqueue(int x) {\n    if(size==capacity) throw new RuntimeException("Full");\n    rear = (rear+1) % capacity;  // circular!\n    arr[rear]=x; size++;\n  }\n\n  public int dequeue() {\n    if(isEmpty()) throw new RuntimeException("Empty");\n    int val=arr[front];\n    front = (front+1) % capacity;  // circular!\n    size--; return val;\n  }\n\n  public boolean isEmpty() { return size==0; }\n  public int peek() { return arr[front]; }\n}\nAll ops: O(1)`},
    {n:3,title:"Quick Sort",marks:20,tag:"Sorting",body:`3.1 Explain Quick Sort. Use {90,23,5,109,12,22,67,34}  [12]\n3.2 Explain time performance using asymptotic notation  [8]`,formula:SORT_FORMULA,answer:`STRATEGY: Pick pivot (last), partition, recurse.\n\n{90,23,5,109,12,22,67,34} pivot=34:\nleft={23,5,12,22}, right={90,109,67}\n→ [23,5,12,22|34|90,109,67]\n\nSort left {23,5,12,22} pivot=22:\nleft={5,12}, right={23} → [5,12,22,23]\n\nSort right {90,109,67} pivot=67:\nleft={}, right={90,109} → [67,90,109]\n\nFINAL: [5,12,22,23,34,67,90,109] ✓\n\nBIG-O:\nBest: O(n log n) — pivot halves each time\nAvg:  O(n log n) — expected with random data\nWorst: O(n²) — sorted array + last-element pivot\nSpace: O(log n) call stack`},
    {n:4,title:"Heap Sort",marks:20,tag:"Sorting",body:`4.1 Explain Heap Sort. Use {90,23,5,109,12,22,67,34}  [12]\n4.2 Explain time performance using asymptotic notation  [8]`,formula:SORT_FORMULA,answer:`PHASE 1 Build Max-Heap from {90,23,5,109,12,22,67,34}:\nHeapify from last non-leaf upward.\nResult: [109,90,67,23,12,22,5,34]\nRoot 109 = maximum ✓\n\nPHASE 2 Extract max repeatedly:\n• Swap 109↔34: [34,...|109], heapify→[90,34,67,...]\n• Swap 90↔5: heapify→[67,...]\n...continue until...\nFINAL: [5,12,22,23,34,67,90,109] ✓\n\nBIG-O: ALL cases O(n log n). Space O(1).\nKEY ADVANTAGE: No worst case — always guaranteed O(n log n)!`},
  ]},
  mar24:{title:"Test 1 — March 2024",info:"ADP470S · 50 Marks · 7 March 2024",questions:[
    {n:1,title:"Factorial — Trace & Analysis",marks:20,tag:"Recursion",body:`1.1 TRACE recursive factorial for n=5       [5]\n1.2 TRACE iterative factorial for n=5       [5]\n1.3 Big-O time & space comparison           [6]\n1.4 What is an algorithm?                   [4]`,formula:FACT_FORMULA,answer:`1.1 RECURSIVE TRACE fact(5):\nfact(5)→5×fact(4)→5×4×fact(3)→5×4×3×fact(2)→5×4×3×2×fact(1)\nfact(1)=1 ← base case\nUnwinding: 2,6,24,120\n\n1.2 ITERATIVE TRACE:\nresult=1\ni=2: 1×2=2\ni=3: 2×3=6\ni=4: 6×4=24\ni=5: 24×5=120 ✓\n\n1.3 Time: both O(n). Space: recursive O(n), iterative O(1).\nPreferred: Iterative (no stack overflow).\n\n1.4 ALGORITHM: A finite sequence of well-defined, unambiguous\nsteps that takes inputs, produces outputs, and terminates.`},
    {n:2,title:"Quick Sort & Heap Sort",marks:30,tag:"Sorting",body:`2.1 Trace Quick Sort & Heap Sort on {7,5,15,20,16,17,8,3}  [14]\n2.2-2.7 Complexity questions (best/avg/worst each)          [6]\n2.8 What are the characteristics of an algorithm?           [5]\n2.9 Time complexity vs space complexity difference?         [5]`,formula:SORT_FORMULA,answer:`QUICK SORT {7,5,15,20,16,17,8,3} pivot=3:\n3 is min, all others go right.\n[3|5,7,8,15,16,17,20] (after recursive sorts)\nFINAL: [3,5,7,8,15,16,17,20] ✓\n\nHEAP SORT:\nBuild max-heap: [20,16,17,5,7,15,8,3]\nExtract 20→17→16→15→8→7→5→3\nFINAL: [3,5,7,8,15,16,17,20] ✓\n\n2.2 Quick Best: O(n log n)  2.3 Heap Best: O(n log n)\n2.4 Quick Avg: O(n log n)   2.5 Heap Avg: O(n log n)\n2.6 Quick Worst: O(n²)      2.7 Heap Worst: O(n log n) ← always!\n\n2.8 CHARACTERISTICS: Input,Output,Definiteness,Finiteness,Effectiveness\n\n2.9 Time = how execution time grows with n.\nSpace = how memory usage grows with n.`},
  ]},
  mid21:{title:"Midyear Exam 2021",info:"ADP470S · 100 Marks (ANY 5 of 6) · 21 June 2021",questions:[
    {n:1,title:"Insertion Sort vs Selection Sort",marks:20,tag:"Sorting",body:`1.1 Compare & contrast with code/pseudocode         [10]\n    Performance for: Best / Average / Worst case    [3+3+4]`,formula:SORT_FORMULA,answer:`INSERTION SORT:\n• Traverse arr[1..n], compare key with predecessors\n• Shift larger elements right, insert key in correct position\n• Stable sort\n\nSELECTION SORT:\n• Find minimum in unsorted portion, swap to front\n• Repeat for each position\n• Not stable\n\nBest: Insertion O(n) [nearly sorted], Selection O(n²) [always scans]\nAvg:  Both O(n²)\nWorst: Both O(n²)\n\nKey difference: Insertion is better for nearly-sorted data`},
    {n:2,title:"Factorial",marks:20,tag:"Recursion",body:`2.1 Implement recursive factorial              [5]\n2.2 Implement iterative factorial              [5]\n2.3 Compare Big-O time & space. Which preferred? [10]`,formula:FACT_FORMULA,answer:`RECURSIVE:\nint factRec(int n){\n  if(n<=1) return 1;\n  return n * factRec(n-1);\n}\n\nITERATIVE:\nint factIter(int n){\n  int r=1;\n  for(int i=2;i<=n;i++) r*=i;\n  return r;\n}\n\nTime: both O(n). Space: recursive O(n), iterative O(1).\nPreferred: ITERATIVE (no stack overflow, less memory)`},
    {n:3,title:"Binary Search Tree",marks:20,tag:"Trees",body:`3.1 Static array BST: insert & traversal operations\n    Explain insert performance with Big-O          [15+5]`,formula:null,answer:`Static Array BST — index relationships:\nparent(i) = (i-1)/2\nleft(i)   = 2*i+1\nright(i)  = 2*i+2\n\nINSERT:\nvoid insert(int[] tree, int val){\n  int i=0;\n  while(tree[i]!=0){\n    if(val<tree[i]) i=2*i+1; else i=2*i+2;\n  }\n  tree[i]=val;\n}\n\nINORDER TRAVERSAL:\nvoid inorder(int[] tree, int i){\n  if(i>=tree.length||tree[i]==0) return;\n  inorder(tree,2*i+1);\n  System.out.print(tree[i]);\n  inorder(tree,2*i+2);\n}\n\nInsert Big-O: O(log n) balanced, O(n) skewed worst case`},
    {n:4,title:"Stack — Linked Fruit",marks:20,tag:"Data Structures",body:`Stack using LINKED representation for Fruit objects.\nFruit has: fruit_id, name, unit_price, volume_sold\nPush 4 fruits, pop and print all.\nImplement: push, pop, isEmpty, peek               [20]`,formula:null,answer:`class Fruit{\n  int fruit_id; String name;\n  double unit_price, volume_sold;\n  Fruit next;\n}\n\nclass FruitStack{\n  private Fruit top=null;\n  void push(Fruit f){ f.next=top; top=f; }\n  Fruit pop(){\n    if(isEmpty()) throw new RuntimeException("Empty");\n    Fruit f=top; top=top.next; return f;\n  }\n  Fruit peek(){ return top; }\n  boolean isEmpty(){ return top==null; }\n}\n\n// Demo:\nFruitStack s=new FruitStack();\ns.push(new Fruit(1,"Apple",2.50,100));\ns.push(new Fruit(2,"Banana",1.20,200));\ns.push(new Fruit(3,"Mango",5.00,50));\ns.push(new Fruit(4,"Orange",3.00,80));\nwhile(!s.isEmpty()) System.out.println(s.pop().name);\n// Output: Orange,Mango,Banana,Apple (LIFO!)`},
    {n:5,title:"Circular Queue — Mouse Events",marks:20,tag:"Data Structures",body:`Circular queue for MouseEvent objects.\nEvent has: event_id, event_time, event_type\nEnqueue 5 events, then dequeue all.\nImplement: Enqueue, Dequeue, isEmpty, isFull      [20]`,formula:DSA_FORMULA,answer:`class CircularQueue{\n  private MouseEvent[] arr;\n  private int front,rear,size,cap;\n  CircularQueue(int c){\n    cap=c;arr=new MouseEvent[c];front=0;rear=-1;size=0;\n  }\n  void enqueue(MouseEvent e){\n    if(isFull()) throw new RuntimeException("Full");\n    rear=(rear+1)%cap; arr[rear]=e; size++;\n  }\n  MouseEvent dequeue(){\n    if(isEmpty()) throw new RuntimeException("Empty");\n    MouseEvent e=arr[front];\n    front=(front+1)%cap; size--; return e;\n  }\n  boolean isEmpty(){ return size==0; }\n  boolean isFull(){ return size==cap; }\n}\n\nKEY: (rear+1)%capacity and (front+1)%capacity wrap pointers!\nAll operations: O(1)`},
    {n:6,title:"BST & AVL Trees",marks:20,tag:"Trees",body:`6.1 BST operations: Find,Insert,Delete,isEmpty,\n    preorder,inorder,postorder                    [10]\n6.2 Draw BST inserting {10,5,15,16,17,18,19,20}  [4]\n6.3 Draw AVL tree same values, show rotations     [6]`,formula:null,answer:`6.1 TRAVERSALS:\n• Preorder  (N→L→R): for copying/serializing\n• Inorder   (L→N→R): produces SORTED output!\n• Postorder (L→R→N): for deleting tree\n\nBST Rules: left<root<right at every node\n\n6.2 PLAIN BST {10,5,15,16,17,18,19,20}:\n    10\n   /  \\\n  5    15\n          \\\n          16\n            \\  ← degenerate! Skewed right\n            17...\nSearch degrades to O(n)!\n\n6.3 AVL TREE:\nBalance Factor = height(L) - height(R), must be -1,0,+1\n\nInserting 17 causes BF(15)=-2 (RR case) → LEFT ROTATE at 15\n  Before: 15→16→17   After: 16 with 15 left, 17 right\n\nAVL guarantees O(log n) for all operations always.`},
  ]},
  test21:{title:"Test 1 — May 2021",info:"ADP470S · 80 Marks · 10 May 2021",questions:[
    {n:1,title:"BST Student Tree",marks:20,tag:"Trees",body:`Implement a BST where STUDENT NAME is the key.\nStudent has: studentId, name, overallMark\nImplement insert and inorder traversal.          [20]`,formula:null,answer:`class StudentNode{\n  String name,studentId; double mark;\n  StudentNode left,right;\n  StudentNode(String n,String id,double m){\n    name=n;studentId=id;mark=m;\n  }\n}\nclass StudentBST{\n  private StudentNode root;\n  void insert(String name,String id,double mark){\n    root=insertRec(root,name,id,mark);\n  }\n  StudentNode insertRec(StudentNode node,String name,String id,double mark){\n    if(node==null) return new StudentNode(name,id,mark);\n    int c=name.compareTo(node.name);\n    if(c<0) node.left=insertRec(node.left,name,id,mark);\n    else if(c>0) node.right=insertRec(node.right,name,id,mark);\n    return node;\n  }\n  void inorder(StudentNode n){\n    if(n==null) return;\n    inorder(n.left);\n    System.out.println(n.name+" "+n.mark+"%");\n    inorder(n.right);\n  }\n}\n// Inorder produces alphabetical order!`},
    {n:2,title:"BST Traversal & Circular Queue",marks:20,tag:"Trees / Queues",body:`2.1 Explain BST INSERT and INORDER TRAVERSAL      [10]\n2.2 Explain CIRCULAR QUEUE algorithm              [10]`,formula:DSA_FORMULA,answer:`2.1 BST INSERT:\n• Compare new value with current node\n• Go left if smaller, right if larger\n• Insert at first null position\n• Time: O(log n) balanced, O(n) worst case\n\nINORDER (L→Root→R): Always produces SORTED sequence!\nTime: O(n) — visits every node exactly once.\n\n2.2 CIRCULAR QUEUE:\n• FIFO: first in, first out\n• Uses % modulo to wrap front/rear pointers\n• rear = (rear+1)%cap on enqueue\n• front = (front+1)%cap on dequeue\n• Avoids wasted space of linear queue\n• All operations: O(1)`},
    {n:3,title:"Stack — Student Objects",marks:20,tag:"Data Structures",body:`Linked stack for Student objects (studentId,name,overallMark)\nPush: John/21034569/67, Ayanda/23245432/98, Khaya/21435423/76\nPop and print all.                                [20]`,formula:null,answer:`class StudentStack{\n  private Student top=null;\n  void push(Student s){ s.next=top; top=s; }\n  Student pop(){\n    if(isEmpty()) throw new RuntimeException("Empty!");\n    Student s=top; top=top.next; return s;\n  }\n  boolean isEmpty(){ return top==null; }\n}\n\nstack.push(new Student("John","21034569",67));\nstack.push(new Student("Ayanda","23245432",98));\nstack.push(new Student("Khaya","21435423",76));\n\nwhile(!stack.isEmpty()){\n  Student s=stack.pop();\n  System.out.println(s.name+" - "+s.overallMark+"%");\n}\n// Output (LIFO):\n// Khaya - 76.0%\n// Ayanda - 98.0%\n// John - 67.0%`},
    {n:4,title:"Factorial + Big-O",marks:20,tag:"Recursion",body:`4.1 Implement recursive factorial               [5]\n4.2 Implement iterative factorial               [5]\n4.3 Big-O comparison: time & space, which preferred? [10]`,formula:FACT_FORMULA,answer:`// RECURSIVE:\nint factRec(int n){\n  if(n<=1) return 1;\n  return n*factRec(n-1);\n}\n// ITERATIVE:\nint factIter(int n){\n  int r=1;\n  for(int i=2;i<=n;i++) r*=i;\n  return r;\n}\n\nBIG-O:\nTime: Both O(n) — equal\nSpace: Recursive O(n) vs Iterative O(1)\n\nPreferred: ITERATIVE\n• No stack overflow for large n\n• Constant memory regardless of input\n• Slightly faster (no function call overhead)`},
  ]},
  asgn23:{title:"Assignment 1 — 2023",info:"ADP470S · 100 Marks · Due 18 May 2023",questions:[
    {n:1,title:"Fibonacci + Big-O Analysis",marks:20,tag:"Recursion / Big-O",body:`1.1 Recursive Fibonacci explanation              [2]\n1.2 Iterative Fibonacci explanation             [4]\n1.3 Performance comparison                      [5]\n1.4 Code: for(i<2n,i+=2) + for(j<n)            [3]\n1.5 Code: outer i<n, inner j*=2                [3]\n1.6 Code: outer i+=2, inner j--                [3]`,formula:BIGO_FORMULA,answer:`1.1 fib(n)=fib(n-1)+fib(n-2); base: fib(0)=0,fib(1)=1\n    Problem: redundant calls → O(2ⁿ) time!\n\n1.2 Keep only 2 previous values in loop → O(n) time, O(1) space\n\n1.3 Recursive: O(2ⁿ) time, O(n) space. Iterative: O(n) time, O(1) space.\n    Iterative wins by massive margin!\n\n1.4 Loop1: i+=2 runs n times → O(n). Loop2: O(n). Sequential → O(n)\n1.5 Outer O(n), inner j*=2 → O(log n). Nested → O(n log n)\n1.6 Outer i+=2 → O(n/2)=O(n). Inner O(n). Nested → O(n²)`},
    {n:2,title:"Bubble Sort",marks:20,tag:"Sorting",body:`2.1 Show Bubble Sort on {8,3,6,3,1,5}. Each pass.  [10]\n2.2 Time performance with asymptotic notation        [10]`,formula:SORT_FORMULA,answer:`BUBBLE SORT {8,3,6,3,1,5}:\nPass 1: compare adjacent, swap if left>right\n[8,3,6,3,1,5]→[3,8,6,3,1,5]→[3,6,8,3,1,5]→\n[3,6,3,8,1,5]→[3,6,3,1,8,5]→[3,6,3,1,5,8] ✓8 placed\n\nPass 2:[3,6,3,1,5,8]→[3,3,6,1,5,8]→[3,3,1,6,5,8]→[3,3,1,5,6,8] ✓6 placed\nPass 3:[3,3,1,5,6,8]→[3,1,3,5,6,8]→[1,3,3,5,6,8] ✓\n\nBIG-O:\nBest: O(n) — with swapped flag, already sorted\nAvg:  O(n²)\nWorst: O(n²) — reverse sorted\nSpace: O(1)`},
    {n:3,title:"Quick Sort",marks:20,tag:"Sorting",body:`3.1 Quick Sort on {8,3,6,3,1,5,2,9,7}             [12]\n3.2 Asymptotic time performance                    [8]`,formula:SORT_FORMULA,answer:`QUICK SORT {8,3,6,3,1,5,2,9,7} pivot=7:\nleft={3,6,3,1,5,2}, mid={7}, right={8,9}\n→[3,6,3,1,5,2|7|8,9]\n\nSort {3,6,3,1,5,2} pivot=2:\nleft={1}, mid={2}, right={3,6,3,5}\n→[1,2,3,3,5,6]\n\nFINAL: [1,2,3,3,5,6,7,8,9] ✓\n\nBIG-O:\nBest: O(n log n) — pivot always halves\nAvg:  O(n log n)\nWorst: O(n²) — sorted+last-element pivot\nSpace: O(log n)`},
    {n:4,title:"Heap Sort",marks:20,tag:"Sorting",body:`4.1 Heap Sort on {8,3,6,3,1,5,2,9,7}             [12]\n4.2 Asymptotic time performance                    [8]`,formula:SORT_FORMULA,answer:`HEAP SORT {8,3,6,3,1,5,2,9,7}:\n\nPhase 1 — Build Max-Heap:\nTree: 8 is root, children 3,6, etc.\nHeapify upward from index 3:\n→ 9>3 → swap. Then heapify root: 9>8 → swap\nMax-Heap: [9,8,6,3,1,5,2,3,7]\n\nPhase 2 — Extract:\n• Swap 9↔7, heapify→[8,7,6,3,1,5,2,3|9]\n• Swap 8↔3, heapify→[7,3,6,3,1,5,2|8,9]\n...continue...\nFINAL: [1,2,3,3,5,6,7,8,9] ✓\n\nBIG-O: ALL cases O(n log n). Space O(1) in-place.\nNo worst case — GUARANTEED performance!`},
    {n:5,title:"Big-O Theory",marks:20,tag:"Big-O Notation",body:`5.1 Dominant terms & Big-O for 5 expressions     [10]\n5.2 Characteristics of an algorithm              [5]\n5.3 Purpose of Big-O notation                    [5]`,formula:BIGO_FORMULA,answer:`5.1:\n5000n+0.001n³+0.025n²  → dominant n³ → O(n³)\n500n+0.5n^1.7          → dominant n^1.7 → O(n^1.7)\n0.3n²log n+600log n²   → dominant n²log n → O(n²log n)\n8n log₃n+2n log₂n     → both O(n log n) → O(n log n)\n100n+0.01n²            → dominant n² → O(n²)\n\n5.2 CHARACTERISTICS:\n1.Input 2.Output 3.Definiteness 4.Finiteness 5.Effectiveness\n\n5.3 PURPOSE:\nDescribes worst-case growth rate as n→∞.\nAllows algorithm comparison independent of hardware.\nFocus on growth, drop constants and lower terms.`},
  ]},
  nov20:{title:"Nov Test — 2020",info:"ADP470S · 100 Marks · 20 November 2020",questions:[
    {n:1,title:"Binary Trees",marks:42,tag:"Trees",body:`1.1 Algorithm: check if two binary trees are identical  [22]\n1.2 Expression tree of (5-y²)/(3y)*2+2 — convert to postfix [10]\n1.3 Given two traversals, reconstruct unique binary tree  [10]`,formula:null,answer:`1.1 IDENTICAL TREES:\nbool areIdentical(Node a, Node b){\n  if(a==null && b==null) return true;\n  if(a==null || b==null) return false;\n  return (a.data==b.data) &&\n         areIdentical(a.left,b.left) &&\n         areIdentical(a.right,b.right);\n}\nTime: O(n) | Space: O(h)\n\n1.2 POSTFIX via postorder traversal of expression tree:\nPostorder (L→R→Root) gives postfix!\nResult: 5 y 2 ^ - 3 y * / 2 * 2 +\n\n1.3 RECONSTRUCT FROM PREORDER + INORDER:\n1. Preorder[0] = ROOT\n2. Find root in Inorder → splits into left/right subtrees\n3. Recurse on both halves`},
    {n:2,title:"Quick Sort vs Bubble Sort",marks:38,tag:"Sorting",body:`Sort S1: 10,7,8,9,1,5,15,6,2,20,23,11,18,13 (n=14)\nSort S2: same + 66,22,34,33,3 (n=19)\n\nCode both algorithms. Count comparisons. Fill table:\n             S1        S2\nBubble Sort  _         _\nQuick Sort   _         _`,formula:SORT_FORMULA,answer:`BUBBLE SORT:\nfor(i=0;i<n-1;i++)\n  for(j=0;j<n-i-1;j++){\n    comparisons++;\n    if(arr[j]>arr[j+1]) swap;\n  }\n\nQUICK SORT — count comparisons in partition:\nvoid quickSort(int[] a, int lo, int hi){\n  if(lo<hi){ int p=partition(a,lo,hi); quickSort(a,lo,p-1); quickSort(a,p+1,hi); }\n}\n\nEXPECTED RESULTS:\nBubble S1 (n=14): ~91 comparisons [n(n-1)/2]\nBubble S2 (n=19): ~171 comparisons\nQuick S1:  ~45-55 comparisons [O(n log n)]\nQuick S2:  ~60-75 comparisons\n\nCONCLUSION: Use Quick Sort for both — significantly fewer comparisons.`},
    {n:3,title:"Hash Table — Linear Probing",marks:10,tag:"Hashing",body:`h(x) = x mod 7\nKeys: 50, 700, 76, 85, 92, 73, 101\n\nUsing LINEAR PROBING, fill the hash table:\n[0] [1] [2] [3] [4] [5] [6]\n _   _   _   _   _   _   _`,formula:null,answer:`h(50) =1 → [1]free ✓\nh(700)=0 → [0]free ✓\nh(76) =6 → [6]free ✓\nh(85) =1 → [1]TAKEN→try[2]free ✓\nh(92) =1 → [1][2]TAKEN→try[3]free ✓\nh(73) =3 → [3]TAKEN→try[4]free ✓\nh(101)=3 → [3][4]TAKEN→try[5]free ✓\n\nFINAL TABLE:\n[0]=700 [1]=50 [2]=85 [3]=92 [4]=73 [5]=101 [6]=76\n\nLinear Probing: try (h+i)%n for i=1,2,3...\nProb: PRIMARY CLUSTERING — long probe sequences slow inserts`},
  ]},
};

// ─── QUESTION CARD ─────────────────────────────────────────────────────────
function QuestionCard({q}){
  const [open,setOpen]=useState(false);
  const [marked,setMarked]=useState(null);
  const c=qColor(q.n);
  return(
    <div style={{border:`1px solid ${S.cardBorder}`,borderRadius:10,overflow:"hidden",marginBottom:"1rem",background:S.card}}>
      <div style={{padding:"1rem 1.25rem"}}>
        <div style={{display:"flex",alignItems:"flex-start",justifyContent:"space-between",marginBottom:"0.75rem",gap:8}}>
          <div style={{display:"flex",alignItems:"center",gap:10}}>
            <span style={{background:c,color:"#000",fontWeight:700,fontSize:12,padding:"3px 9px",borderRadius:4,whiteSpace:"nowrap"}}>Q{q.n}</span>
            <span style={{fontWeight:500,fontSize:15,color:S.text}}>{q.title}</span>
          </div>
          <div style={{display:"flex",alignItems:"center",gap:8,flexShrink:0}}>
            <span style={{fontSize:12,color:S.muted}}>[{q.marks} marks]</span>
            {marked===true&&<span style={{fontSize:11,background:"#00c9a720",color:S.accent,padding:"2px 8px",borderRadius:4}}>✓ Got it</span>}
            {marked===false&&<span style={{fontSize:11,background:"#e1705520",color:"#e17055",padding:"2px 8px",borderRadius:4}}>✗ Review</span>}
          </div>
        </div>
        <div style={{display:"inline-block",fontSize:11,color:S.accent,background:S.accentDim,padding:"2px 8px",borderRadius:4,marginBottom:"0.75rem"}}>{q.tag}</div>
        <pre style={{fontFamily:"monospace",fontSize:13,color:S.muted,whiteSpace:"pre-wrap",margin:"0 0 1rem",lineHeight:1.65}}>{q.body}</pre>
        {q.formula&&<FormulaTable data={q.formula}/>}
        <button onClick={()=>setOpen(o=>!o)} style={{padding:"8px 18px",borderRadius:6,border:"none",background:open?S.faint:S.accent,color:open?S.text:"#000",fontWeight:600,fontSize:13,cursor:"pointer"}}>
          {open?"🔼 Hide Solution":"🐧 Show Solution"}
        </button>
      </div>
      {open&&(
        <div style={{borderTop:`1px solid ${S.cardBorder}`,background:S.cardInner,padding:"1.25rem"}}>
          <div style={{fontSize:12,fontWeight:600,color:S.accent,letterSpacing:1,marginBottom:"0.75rem"}}>✓ MODEL ANSWER</div>
          <pre style={{fontFamily:"monospace",fontSize:12.5,color:S.text,whiteSpace:"pre-wrap",margin:"0 0 1rem",lineHeight:1.7}}>{q.answer}</pre>
          <div style={{display:"flex",gap:8}}>
            <button onClick={()=>setMarked(true)} style={{fontSize:12,padding:"6px 14px",borderRadius:5,border:`1px solid ${marked===true?S.accent:S.faint}`,background:marked===true?S.accentDim:"transparent",color:marked===true?S.accent:S.muted,cursor:"pointer"}}>✓ Got it</button>
            <button onClick={()=>setMarked(false)} style={{fontSize:12,padding:"6px 14px",borderRadius:5,border:`1px solid ${marked===false?"#e17055":S.faint}`,background:marked===false?"#e1705520":"transparent",color:marked===false?"#e17055":S.muted,cursor:"pointer"}}>✗ Need more practice</button>
          </div>
        </div>
      )}
    </div>
  );
}

// ─── NOTES VIEW ────────────────────────────────────────────────────────────
function NotesView(){
  const [selTopic,setSelTopic]=useState("bigo");
  const [openSec,setOpenSec]=useState({});
  const topic=NOTES[selTopic];
  const toggle=i=>setOpenSec(o=>({...o,[i]:!o[i]}));
  return(
    <div style={{display:"flex",gap:16}}>
      <div style={{width:160,flexShrink:0}}>
        {TOPICS_NAV.map(t=>(
          <button key={t.id} onClick={()=>{setSelTopic(t.id);setOpenSec({});}} style={{width:"100%",textAlign:"left",padding:"8px 10px",borderRadius:6,border:"none",background:selTopic===t.id?S.sidebarActive:"transparent",cursor:"pointer",marginBottom:2,fontSize:12,color:selTopic===t.id?S.text:S.muted,borderLeft:`3px solid ${selTopic===t.id?S.accent:"transparent"}`}}>
            <span style={{marginRight:6}}>{t.icon}</span>{t.label}
          </button>
        ))}
      </div>
      <div style={{flex:1}}>
        <h3 style={{margin:"0 0 1rem",fontSize:18,fontWeight:600,color:topic.color||S.accent}}>{topic.title}</h3>
        {topic.sections.map((sec,i)=>(
          <div key={i} style={{marginBottom:"0.75rem",border:`1px solid ${S.cardBorder}`,borderRadius:8,overflow:"hidden"}}>
            <button onClick={()=>toggle(i)} style={{width:"100%",display:"flex",justifyContent:"space-between",alignItems:"center",padding:"11px 14px",background:S.cardInner,border:"none",cursor:"pointer",textAlign:"left"}}>
              <span style={{fontWeight:500,fontSize:14,color:S.text}}>{sec.h}</span>
              <span style={{color:S.muted,fontSize:16}}>{openSec[i]?"▲":"▼"}</span>
            </button>
            {openSec[i]&&(
              <div style={{padding:"1rem",background:S.card}}>
                <pre style={{fontFamily:"monospace",fontSize:13,color:S.muted,whiteSpace:"pre-wrap",margin:0,lineHeight:1.7}}>{sec.body}</pre>
              </div>
            )}
          </div>
        ))}
      </div>
    </div>
  );
}

// ─── DIAGRAMS VIEW ─────────────────────────────────────────────────────────
function DiagramsView(){
  const [sel,setSel]=useState("bigo");
  const d=DIAGRAMS.find(x=>x.id===sel);
  return(
    <div>
      <div style={{display:"flex",gap:6,flexWrap:"wrap",marginBottom:"1.25rem"}}>
        {DIAGRAMS.map(d=>(
          <button key={d.id} onClick={()=>setSel(d.id)} style={{padding:"6px 12px",borderRadius:20,border:`1px solid ${sel===d.id?S.accent:S.faint}`,background:sel===d.id?S.accentDim:"transparent",color:sel===d.id?S.accent:S.muted,cursor:"pointer",fontSize:13}}>
            {d.icon} {d.label}
          </button>
        ))}
      </div>
      <div style={{marginBottom:"0.75rem"}}>
        <h3 style={{margin:"0 0 4px",fontSize:16,fontWeight:600,color:S.text}}>{d.icon} {d.label}</h3>
        <p style={{margin:0,fontSize:13,color:S.muted}}>{d.desc}</p>
      </div>
      {d.comp}
    </div>
  );
}

// ─── MEMORY AIDS VIEW ──────────────────────────────────────────────────────
function MemoryView(){
  return(
    <div>
      <p style={{color:S.muted,fontSize:13,marginTop:0,marginBottom:"1.25rem"}}>Mnemonics, shortcuts and memory tricks for the June exam.</p>
      <div style={{display:"grid",gridTemplateColumns:"repeat(auto-fill,minmax(280px,1fr))",gap:12}}>
        {MEMORY_AIDS.map((aid,i)=>(
          <div key={i} style={{border:`1px solid ${S.cardBorder}`,borderRadius:10,overflow:"hidden",background:S.card}}>
            <div style={{padding:"10px 14px",background:S.cardInner,borderBottom:`1px solid ${S.cardBorder}`,display:"flex",justifyContent:"space-between",alignItems:"flex-start"}}>
              <div>
                <div style={{fontWeight:600,fontSize:14,color:aid.color}}>{aid.title}</div>
                <div style={{fontSize:11,color:S.muted,marginTop:2}}>{aid.sub}</div>
              </div>
            </div>
            <pre style={{fontFamily:"monospace",fontSize:12,color:S.muted,whiteSpace:"pre-wrap",margin:0,padding:"12px 14px",lineHeight:1.65}}>{aid.content}</pre>
          </div>
        ))}
      </div>
    </div>
  );
}

// ─── SCOPE VIEW ────────────────────────────────────────────────────────────
function ScopeView(){
  const pri=n=>[null,"#fd79a8","#e17055","#fdcb6e","#0984e3","#00c9a7"][n];
  const star=n=>"★".repeat(n)+"☆".repeat(5-n);
  return(
    <div>
      <div style={{padding:"1rem",background:S.cardInner,borderRadius:8,border:`1px solid ${S.cardBorder}`,marginBottom:"1.25rem"}}>
        <div style={{fontWeight:600,color:S.accent,marginBottom:6}}>📋 June Exam Format</div>
        <div style={{display:"grid",gridTemplateColumns:"1fr 1fr",gap:"0.5rem",fontSize:13,color:S.muted}}>
          <div>• Answer ANY <strong style={{color:S.text}}>5 of 6</strong> questions</div>
          <div>• Each question: <strong style={{color:S.text}}>20 marks</strong></div>
          <div>• Total: <strong style={{color:S.text}}>100 marks</strong></div>
          <div>• Duration: <strong style={{color:S.text}}>3 hours</strong></div>
          <div>• No identical answers allowed</div>
          <div>• OO language: Java or Python</div>
        </div>
      </div>
      <div style={{overflowX:"auto"}}>
        <table style={{width:"100%",borderCollapse:"collapse",fontSize:13}}>
          <thead>
            <tr style={{background:S.cardInner}}>
              {["Topic","Typical Marks","Appears In","Priority","Exam Tip"].map((h,i)=>(
                <th key={i} style={{padding:"10px 12px",color:S.text,fontWeight:600,textAlign:"left",borderBottom:`1px solid ${S.cardBorder}`,whiteSpace:"nowrap"}}>{h}</th>
              ))}
            </tr>
          </thead>
          <tbody>
            {SCOPE_DATA.map((row,i)=>(
              <tr key={i} style={{borderBottom:`1px solid ${S.faint}`,background:i%2===0?"transparent":"#0a0a14"}}>
                <td style={{padding:"9px 12px",color:S.text,fontWeight:500}}>{row.topic}</td>
                <td style={{padding:"9px 12px",color:S.accent,fontFamily:"monospace",whiteSpace:"nowrap"}}>{row.marks}</td>
                <td style={{padding:"9px 12px",color:S.muted,fontSize:12}}>{row.papers}</td>
                <td style={{padding:"9px 12px",whiteSpace:"nowrap"}}>
                  <span style={{color:pri(row.priority),fontSize:13}}>{star(row.priority)}</span>
                </td>
                <td style={{padding:"9px 12px",color:S.muted,fontSize:12,maxWidth:220}}>{row.tip}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      <div style={{marginTop:"1.25rem",padding:"1rem",background:S.cardInner,borderRadius:8,border:`1px solid ${S.cardBorder}`}}>
        <div style={{fontWeight:600,color:"#fdcb6e",marginBottom:8}}>⚡ Top 5 Things to Know for June</div>
        {["Factorial: recursive trace, iterative code, time O(n) vs space O(n)/O(1) comparison","Sorting: Bubble trace + Big-O, Quick Sort pivot/partition steps, Heap Sort 2-phase process","Big-O: 3 code snippet patterns (sequential loops, nested, geometric inner loop)","Data Structures: Stack push/pop (LIFO), Circular Queue with (i+1)%cap trick (FIFO)","BST: insert rule, inorder=sorted, traversal definitions; AVL: balance factor and rotation types"].map((tip,i)=>(
          <div key={i} style={{display:"flex",gap:10,marginBottom:8,alignItems:"flex-start"}}>
            <span style={{color:"#fdcb6e",fontWeight:700,flexShrink:0}}>{i+1}.</span>
            <span style={{color:S.muted,fontSize:13}}>{tip}</span>
          </div>
        ))}
      </div>
    </div>
  );
}

// ─── MAIN APP ──────────────────────────────────────────────────────────────
const NAV=[
  {id:"papers",label:"Past Papers",icon:"📄"},
  {id:"notes",label:"Notes",icon:"📝"},
  {id:"diagrams",label:"Diagrams",icon:"🎨"},
  {id:"memory",label:"Memory Aids",icon:"🧠"},
  {id:"scope",label:"Exam Scope",icon:"🎯"},
];

export default function App(){
  const [nav,setNav]=useState("papers");
  const [paper,setPaper]=useState("apr25");
  const p=PAPERS_DATA[paper];

  return(
    <div style={{display:"flex",minHeight:"100vh",background:S.bg,fontFamily:"system-ui,-apple-system,sans-serif",color:S.text}}>
      <h2 className="sr-only">ADP470S Study App</h2>

      {/* SIDEBAR */}
      <div style={{width:210,minWidth:210,background:S.sidebar,borderRight:`1px solid ${S.cardBorder}`,display:"flex",flexDirection:"column",position:"sticky",top:0,height:"100vh",overflowY:"auto"}}>
        <div style={{padding:"1rem",borderBottom:`1px solid ${S.cardBorder}`}}>
          <div style={{fontWeight:700,fontSize:15,color:S.accent}}>ADP470S</div>
          <div style={{fontSize:11,color:S.muted,marginTop:2}}>Advanced Dev Practice</div>
        </div>

        {/* Nav tabs */}
        <div style={{display:"flex",borderBottom:`1px solid ${S.cardBorder}`,padding:"6px 6px 0"}}>
          {NAV.map(n=>(
            <button key={n.id} onClick={()=>setNav(n.id)} title={n.label} style={{flex:1,padding:"7px 2px",border:"none",background:"transparent",cursor:"pointer",fontSize:16,borderBottom:`2px solid ${nav===n.id?S.accent:"transparent"}`,color:nav===n.id?S.accent:S.faint,marginBottom:-1}}>
              {n.icon}
            </button>
          ))}
        </div>
        <div style={{padding:"6px 8px 2px",fontSize:10,color:S.faint,fontWeight:600,letterSpacing:1,textTransform:"uppercase",marginTop:4}}>
          {NAV.find(n=>n.id===nav)?.label}
        </div>

        {/* Sidebar list content */}
        <div style={{padding:"0 6px",flex:1,overflowY:"auto"}}>
          {nav==="papers"&&PAPERS.map(pp=>(
            <button key={pp.id} onClick={()=>setPaper(pp.id)} style={{width:"100%",display:"flex",flexDirection:"column",alignItems:"flex-start",padding:"8px 8px",borderRadius:6,border:"none",background:paper===pp.id?S.sidebarActive:"transparent",cursor:"pointer",marginBottom:2,textAlign:"left",borderLeft:`3px solid ${paper===pp.id?S.accent:"transparent"}`}}>
              <span style={{fontSize:12,color:paper===pp.id?S.text:S.muted,fontWeight:paper===pp.id?500:400}}>{pp.label}</span>
              <span style={{fontSize:11,color:S.faint,marginTop:1}}>{pp.sub}</span>
            </button>
          ))}
          {nav==="notes"&&TOPICS_NAV.map(t=>(
            <button key={t.id} style={{width:"100%",textAlign:"left",padding:"8px 8px",borderRadius:6,border:"none",background:"transparent",cursor:"pointer",marginBottom:2,fontSize:12,color:S.muted}}>
              {t.icon} {t.label}
            </button>
          ))}
          {nav==="diagrams"&&DIAGRAMS.map(d=>(
            <button key={d.id} style={{width:"100%",textAlign:"left",padding:"8px 8px",borderRadius:6,border:"none",background:"transparent",cursor:"pointer",marginBottom:2,fontSize:12,color:S.muted}}>
              {d.icon} {d.label}
            </button>
          ))}
          {nav==="memory"&&MEMORY_AIDS.map((m,i)=>(
            <div key={i} style={{padding:"7px 8px",fontSize:11,color:S.muted,borderBottom:`1px solid ${S.faint}`}}>{m.title}</div>
          ))}
          {nav==="scope"&&SCOPE_DATA.slice(0,8).map((s,i)=>(
            <div key={i} style={{padding:"6px 8px",fontSize:11,color:S.muted}}>{s.topic}</div>
          ))}
        </div>

        <div style={{padding:"0.75rem",borderTop:`1px solid ${S.cardBorder}`,fontSize:12,color:S.muted,display:"flex",justifyContent:"space-between"}}>
          <span>June Exam Prep</span>
          <span style={{color:S.accent}}>CPUT</span>
        </div>
      </div>

      {/* MAIN CONTENT */}
      <div style={{flex:1,overflowY:"auto",padding:"1.5rem"}}>
        <div style={{maxWidth:820}}>
          {nav==="papers"&&(
            <>
              <div style={{marginBottom:"1.25rem",display:"flex",alignItems:"center",gap:10,flexWrap:"wrap"}}>
                <span style={{fontSize:12,background:S.accentDim,color:S.accent,padding:"3px 8px",borderRadius:4,fontWeight:600}}>ADP470S</span>
                <span style={{fontWeight:600,fontSize:18,color:S.text}}>{p.title}</span>
                <span style={{fontSize:12,color:S.muted}}>{p.info}</span>
                <span style={{marginLeft:"auto",fontSize:12,background:"#00c9a715",color:S.accent,border:`1px solid ${S.accent}50`,padding:"3px 10px",borderRadius:20}}>{p.questions.length} questions</span>
              </div>
              {p.questions.map(q=><QuestionCard key={q.n} q={q}/>)}
            </>
          )}
          {nav==="notes"&&(
            <>
              <h2 style={{margin:"0 0 1.25rem",fontSize:20,fontWeight:600,color:S.text}}>📝 Notes & Theory</h2>
              <NotesView/>
            </>
          )}
          {nav==="diagrams"&&(
            <>
              <h2 style={{margin:"0 0 1.25rem",fontSize:20,fontWeight:600,color:S.text}}>🎨 Visual Study Diagrams</h2>
              <DiagramsView/>
            </>
          )}
          {nav==="memory"&&(
            <>
              <h2 style={{margin:"0 0 0.25rem",fontSize:20,fontWeight:600,color:S.text}}>🧠 Memory Aids</h2>
              <MemoryView/>
            </>
          )}
          {nav==="scope"&&(
            <>
              <h2 style={{margin:"0 0 1.25rem",fontSize:20,fontWeight:600,color:S.text}}>🎯 Exam Scope</h2>
              <ScopeView/>
            </>
          )}
        </div>
      </div>
    </div>
  );
}
