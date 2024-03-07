package arrays;

public class RainWater {

    public static void main(String[] args) {
        System.out.println("RainWater Test");

        int[] array = { 3, 0, 2, 0, 4 };

        System.out.println(String.format("Result is %d", calculateWater(array)));
    }

    public static int calculateWater(int[] array)
    {
        int size = array.length;

        // To store the maximum water
        // that can be stored
        int result = 0;

        // Find Left Boundary
        for (int i = 1; i < size - 1; i++) {

            // Find maximum element on its left
            int left = array[i];
            for (int j = 0; j < i; j++) {
                left = Math.max(left, array[j]);
            }

            // Find maximum element on its right
            int right = array[i];
            for (int j = i + 1; j < size; j++) {
                right = Math.max(right, array[j]);
            }

            // Update maximum water value
            result += Math.min(left, right) - array[i];
        }
        return result;
    }

}


