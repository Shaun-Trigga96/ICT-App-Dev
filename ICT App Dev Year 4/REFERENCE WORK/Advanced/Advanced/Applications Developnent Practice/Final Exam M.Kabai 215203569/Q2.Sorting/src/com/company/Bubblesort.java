package com.company;

public class Bubblesort {
    private int[] array;
    public Bubblesort(int[] array)
    {
        array = array;
    }
    private boolean less(int value1, int value2)
    {
        return value1 < value2;
    }
    /*this more() function is used for comparison which means when the value of the first argument
is greater than the value of the second argument then perform a swap.*/
    private boolean more(int v1, int v2)
    {
        return v1 > v2;
    }
    /*this function sorts*/
    public void sort()
    {
        int size = array.length;
        int i, j, temp;
        for (i = 0 ; i < ( size - 1 ); i++)
        {
            for (j = 0 ; j < size - i - 1; j++)
            {
                if (more(array[j], array[j+1]))
                {
                    /* values are swapped */
                    temp= array[j];
                    array[j]= array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

}
