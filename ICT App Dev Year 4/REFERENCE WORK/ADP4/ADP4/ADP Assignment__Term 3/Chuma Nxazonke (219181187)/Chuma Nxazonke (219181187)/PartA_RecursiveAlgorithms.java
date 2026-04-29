/**
 * Name: Chuma
 * Surname: Nxazonke
 * Student No: 219181187
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

        // Recursive Fibonacci calculation
        public static long fibonacciRecursive(int n) {
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

            System.out.println();
        }
    }

