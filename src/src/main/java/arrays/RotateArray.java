package arrays;

public class RotateArray {

    /**
     * Displays the array after N shift to the right.
     *  Input: Array[] = {1, 3, 5, 7, 9}, K = 2.
     *  Output: 7 9 1 3 5
     *
     * Solution: length - N % length as index to iterate over the result.
     */


    public static void main(String[] argv) {
        int[] array =  { 1, 3, 5, 7 , 9 };

        //  4 Size
        //  2 N
        //  0 1 2 3 4
        //  3 4 0 1 2
        int size = array.length;

        // for shift right size - M
        // for shift left would be 0 + N
        int start = size - 2;

        for (int i = start; i < start + array.length; i ++ ) {
            System.out.println(array[i % size]);
        }
    }
}
