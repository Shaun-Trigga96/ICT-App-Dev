package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] array = {10,7,8,9,1,5,15,6,2,20,23,11,18,13};
        int[] array2 = {10, 7, 8, 9, 1, 5,15,6,2,20,23,11,18,13,66,22,34,33,3};

        /*calling bubblesort constructor*/
        Bubblesort bubblesort = new Bubblesort(array);
        bubblesort.sort();

        for(int i=0;i<array.length ;i++) {
            System.out.print(array[i] );
        }
        for(int i=0;i<array2.length ;i++){
        System.out.println(array2.length);
        }

        /*calling quicksort constructor*/
        Quicksort quicksort = new Quicksort(array);
        quicksort.sort();

        for(int i=0;i<array.length ;i++) {
            System.out.print(array[i] + " ");
        }
        for(int i=0;i<array.length ;i++){
            System.out.println(array2.length);
        }
        System.out.println(array.length + "\n"+ array2.length);
    }
}
