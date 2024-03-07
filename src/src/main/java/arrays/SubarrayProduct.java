package arrays;

public class SubarrayProduct {

    public static void main(String[] args) {
        System.out.println("SubarrayProduct Test");

        int[] array = { 1, -2, -3, 0, 7, -8, -2 };

        System.out.println(String.format("Result is %d", calculateMaxMultiply(array)));
    }

    /**
     * Time Complexity: O(N2)
     * Auxiliary Space: O(1)
     */
    public static int calculateMaxMultiply(int[] array) {

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            int current = array[i];
            for (int j = i + 1; i < array.length; i++) {
                current *= array[j];

                result = Math.max(current, result);
            }
        }

        return result;
    }
}
