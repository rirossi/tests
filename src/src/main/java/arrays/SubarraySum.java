package arrays;

public class SubarraySum {

    /**
     * Identify the sub array which sum is the highest.
     *
     * Go through array and keep count of the sum so far. If value goes under 0 reset buffer.
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("Subarray Test");

        int[] array = { 3, 0, 2, 0, 4 };

        System.out.println(String.format("Result is %d", calculateMax(array)));
    }

    public static int calculateMax(int[] array) {

        int intermediate = 0;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            intermediate = intermediate + array[i];

            // swap the result to a new max
            if (intermediate > result) {
                result = intermediate;
            }

            // Reset the iteration if negative
            if (intermediate < 0) {
                intermediate = 0;
            }
        }

        return result;
    }
}
