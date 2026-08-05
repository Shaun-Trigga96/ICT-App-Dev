package com.company;
i
public class binary {

        private int[] arr;
        public binary(int[] array)
        {
            arr = array;
        }
        private boolean less(int value1, int value2)
        {
            return value1 < value2;
        }
        private boolean more(int value1, int value2)
        {
            return value1 > value2;
        }
        public void sort()
        {
            int size = arr.length;
            int i, j, temp;
            for (i = 0 ; i < ( size - 1 ); i++)
            {
                for (j = 0 ; j < size - i - 1; j++)
                {
                    if (more(arr[j], arr[j+1]))
                    {
                        /* Swapping */
                        temp= arr[j];
                        arr[j]= arr[j+1];
                        arr[j+1] = temp;
                    }
                }
            }
        }
}

