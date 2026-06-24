package com.company;

public class Quicksort {
    private int[] arr;
    public Quicksort(int[] array) {
        arr = array;
    }
    /*swapping the values when the bigger number come before the smaller*/
    private void swap(int arr[], int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    private void quickSortUtil (int arr[], int low, int top)
    {
        if (top<=low)
            return;
        int pivot = arr[low];
        int start = low;
        int stop = top;
        while ( low < top)
        {
            while (arr[low] <= pivot && low < top)
            {
                low++;
            }
            while (arr[top] > pivot && low <= top)
            {
                top--;
            }
            if (low < top)
            {
                swap(arr,top,low);
            }
        }
        swap(arr, top, start); // upper is the pivot position
        quickSortUtil (arr, start, top - 1); // pivot -1 is the upper for left sub array.
        quickSortUtil (arr, top + 1, stop); // pivot + 1 is the lower for right sub array.
    }
    public void sort(){
        int size = arr.length;
        quickSortUtil (arr, 0, size - 1);
    }

}
