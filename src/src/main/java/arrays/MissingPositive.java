package arrays;

import java.util.Arrays;

/**
 * Given an unsorted integer array nums. Return the smallest positive integer that is not present in nums.
 *
 * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
 */
public class MissingPositive {

    public static void main(String[] args) {
        System.out.println("Missing Positive Test");

        int[] array = {0, 2, 2, 1, 1};

        System.out.println(String.format("Result is %d", calculateFirstPositiveMissing(array)));
    }

    public static int calculateFirstPositiveMissing(int[] nums) {
        int[] positive = Arrays.stream(nums)
                .filter(value -> value > 0)
                .distinct()
                .sorted()
                .toArray();

        if (positive.length == 0 || positive[0] > 1) {
            return 1;
        }

        for (int i= 0; i<positive.length -1; i++) {
            int next = i + 1;
            if (positive[i] + 1 != positive[next]) {
                return positive[i] + 1;
            }
        }

        return positive[positive.length - 1] + 1;
    }
}
