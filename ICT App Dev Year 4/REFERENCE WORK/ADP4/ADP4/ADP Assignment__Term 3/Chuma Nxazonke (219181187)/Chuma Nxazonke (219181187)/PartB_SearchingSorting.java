/**
 * Name: Chuma
 * Surname: Nxazonke
 * Student No: 219181187
 */

import java.util.Arrays;
import java.util.Random;

public class PartB_SearchingSorting {

        // Selection Sort (Iterative)
        public static void selectionSort(int[] arr) {
            int n = arr.length;
            for (int i = 0; i < n - 1; i++) {
                int minIdx = i;
                for (int j = i + 1; j < n; j++) {
                    if (arr[j] < arr[minIdx]) {
                        minIdx = j;
                    }
                }
                int temp = arr[minIdx];
                arr[minIdx] = arr[i];
                arr[i] = temp;
            }
        }

        // Quick Sort (Recursive)
        public static void quickSort(int[] arr) {
            quickSort(arr, 0, arr.length - 1);
        }

        private static void quickSort(int[] arr, int low, int high) {
            if (low < high) {
                int pi = partition(arr, low, high);
                quickSort(arr, low, pi - 1);
                quickSort(arr, pi + 1, high);
            }
        }

        private static int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (arr[j] <= pivot) {
                    i++;
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            int temp = arr[i + 1];
            arr[i + 1] = arr[high];
            arr[high] = temp;
            return i + 1;
        }

        // Heap Sort
        public static void heapSort(int[] arr) {
            int n = arr.length;

            // Build max heap
            for (int i = n / 2 - 1; i >= 0; i--) {
                heapify(arr, n, i);
            }

            // Extract elements from heap one by one
            for (int i = n - 1; i > 0; i--) {
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                heapify(arr, i, 0);
            }
        }

        private static void heapify(int[] arr, int n, int i) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (left < n && arr[left] > arr[largest]) {
                largest = left;
            }

            if (right < n && arr[right] > arr[largest]) {
                largest = right;
            }

            if (largest != i) {
                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;

                heapify(arr, n, largest);
            }
        }

        // Binary Search (Iterative)
        public static int binarySearchIterative(int[] arr, int target) {
            int left = 0, right = arr.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (arr[mid] == target) return mid;
                if (arr[mid] < target) left = mid + 1;
                else right = mid - 1;
            }
            return -1;
        }

        // Binary Search (Recursive)
        public static int binarySearchRecursive(int[] arr, int target) {
            return binarySearchRecursive(arr, target, 0, arr.length - 1);
        }

        private static int binarySearchRecursive(int[] arr, int target, int left, int right) {
            if (left > right) return -1;

            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) return binarySearchRecursive(arr, target, mid + 1, right);
            return binarySearchRecursive(arr, target, left, mid - 1);
        }

        // Generate random array
        public static int[] generateRandomArray(int size) {
            Random rand = new Random();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = rand.nextInt(10000);
            }
            return arr;
        }

        // Copy array
        public static int[] copyArray(int[] arr) {
            return Arrays.copyOf(arr, arr.length);
        }

        public static void run() {
            System.out.println("=== Part B: Searching and Sorting ===");

            // Test sorting algorithms
            int[] testArr = generateRandomArray(20);
            System.out.println("Original array: " + Arrays.toString(testArr));

            int[] arr1 = copyArray(testArr);
            selectionSort(arr1);
            System.out.println("Selection Sort: " + Arrays.toString(arr1));

            int[] arr2 = copyArray(testArr);
            quickSort(arr2);
            System.out.println("Quick Sort: " + Arrays.toString(arr2));

            int[] arr3 = copyArray(testArr);
            heapSort(arr3);
            System.out.println("Heap Sort: " + Arrays.toString(arr3));

            // Test binary search
            int[] sortedArr = {1, 3, 5, 7, 9, 11, 13, 15};
            int target = 7;
            System.out.println("Binary Search (Iterative) for " + target + ": " + binarySearchIterative(sortedArr, target));
            System.out.println("Binary Search (Recursive) for " + target + ": " + binarySearchRecursive(sortedArr, target));

            System.out.println();
        }
    }

