package arrays;

import java.util.ArrayList;

public class Leaders {

    /**
     * Write a program to print all the LEADERS in the array. An element is a leader if it is greater than all the
     * elements to its right side. And the rightmost element is always a leader.
     */

    public static void main(String[] argv) {


        System.out.println("SubarrayProduct Test");

        int table[][] = new int[1][1];

        int[] array = {16, 17, 4, 3, 5, 2};

        leaders(array);
        System.out.println("Done.");
    }

    private static void leaders(int[] array) {

        int sum = 0;

        for (int i = array.length -1; i>=0; i--) {

            // Most right
            if (i == array.length -1) {
                System.out.println(String.format("%d ", array[i]));
            } else {
                // If current element is higher than all right
                if (array[i] > sum) {
                    System.out.println(String.format("%d ", array[i]));
                }
            }

            // increment the sum so far.
            sum += array[i];
        }
    }
}
