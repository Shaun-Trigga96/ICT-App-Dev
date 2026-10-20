/**
 * Name: Thabiso
 * Surname: Matsaba
 * Student Number: 20296006
 * Date: 27 September 2026
 */
public class PartA_RecursiveAlgorithms {

        // Recursive factorial calculation
        public static long factorialRecursive(int n) {
            if (n < 0) throw new IllegalArgumentException("n must be non-negative");
            if (n == 0 || n == 1) return 1;
            return n * factorialRecursive(n - 1);
        }

        // Iterative factorial for comparison
        public static long factorialIterative(int n) {
            if (n < 0) throw new IllegalArgumentException("n must be non-negative");
            long result = 1;
            for (int i = 2; i <= n; i++) {
                result *= i;
            }
            return result;
        }

        // Counts how many times fibonacciRecursive() is called (reset before each test)
        private static long recursiveCallCount = 0;

        // Counts loop iterations performed by fibonacciIterative()
        private static long iterativeStepCount = 0;

        // Recursive Fibonacci calculation
        public static long fibonacciRecursive(int n) {
            recursiveCallCount++; // every invocation, including base cases, is counted
            if (n < 0) throw new IllegalArgumentException("n must be non-negative");
            if (n == 0) return 0;
            if (n == 1) return 1;
            return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
        }

        // Iterative Fibonacci for comparison
        public static long fibonacciIterative(int n) {
            if (n < 0) throw new IllegalArgumentException("n must be non-negative");
            if (n == 0) return 0;
            if (n == 1) return 1;

            long prev = 0, curr = 1;
            for (int i = 2; i <= n; i++) {
                iterativeStepCount++; // one step per loop iteration
                long next = prev + curr;
                prev = curr;
                curr = next;
            }
            return curr;
        }

        public static void run() {
            System.out.println("=== Part A: Recursive Algorithms ===");

            // Test factorial
            int n = 10;
            System.out.println("Factorial of " + n + " (recursive): " + factorialRecursive(n));
            System.out.println("Factorial of " + n + " (iterative): " + factorialIterative(n));

            // Test Fibonacci
            System.out.println("Fibonacci(" + n + ") (recursive): " + fibonacciRecursive(n));
            System.out.println("Fibonacci(" + n + ") (iterative): " + fibonacciIterative(n));

            // Second demonstration: count the work done for a larger n
            demonstrateCallCounts(30);

            System.out.println();
        }

        /**
         * Compares the number of recursive calls made by fibonacciRecursive(n)
         * with the number of loop steps made by fibonacciIterative(n).
         * Recursive calls = 2 * F(n+1) - 1, i.e. 2,692,537 for n = 30.
         */
        public static void demonstrateCallCounts(int n) {
            System.out.println("\n--- Work comparison for Fibonacci(" + n + ") ---");

            recursiveCallCount = 0;
            long recResult = fibonacciRecursive(n);
            System.out.println("Recursive result: " + recResult + " | recursive calls: "
                    + String.format("%,d", recursiveCallCount));

            iterativeStepCount = 0;
            long itResult = fibonacciIterative(n);
            System.out.println("Iterative result: " + itResult + " | loop steps: "
                    + String.format("%,d", iterativeStepCount));

            // Why the recursive version is impractical for larger n
            System.out.println("Note: recursive Fibonacci recomputes the same sub-problems, so its");
            System.out.println("calls grow as O(2^n) (roughly x1.6 per extra n). Fibonacci(50) would");
            System.out.println("need about 40 billion calls, while the iterative version needs only 49 steps.");
        }
    }

