package arrays;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PlatformRequiredForTrain {

    /**
     * Given the arrival and departure times of all trains that reach a railway station,
     * the task is to find the minimum number of platforms required for the railway station so that no train waits.
     * We are given two arrays that represent the arrival and departure times of trains that stop.
     *
     * Solution:
     * iterate N^2
     * and find for each train which one has the most number of overlap with overlap being
     * T1 arrives between T2 arrival and dept time.
     */

    public static void main(String[] argv) {

//        int arr[] = { 350, 450, 500 };
//        int dep[] = { 900, 400, 600 };

        int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
        int[] dep = { 910, 1200, 1120, 1130, 1900, 2000 };

        System.out.println(findPlatform(arr, dep));
    }

    public static int findPlatform(int arr[], int dep[]) {

        int result = 1;

        for (int i=0; i<arr.length; i++) {

            int platformNeeded = 1;

            for (int j=0; j<arr.length; j++) {
                if (i != j) {
                    // check how many overlaps this train has
                    // overlap: if j arrives before and depart before
                    if (arr[j] <= arr[i] && dep[j] >= arr[i]) {
                        platformNeeded++;
                    }
                }

                result = Math.max(result, platformNeeded);
            }
        }

        return result;
    }




}
