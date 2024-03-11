package arrays;

import java.util.Arrays;

public class MedianArray {

    public static void main(String[] arfv) {
        System.out.println(mediane());
    }

    public static float mediane() {
        int[] a = {1, 3};
        int[] b = {2};
        int[] result = Arrays.copyOf(a, a.length + b.length);

        for (int i = a.length, j = 0; i<a.length + b.length; i++) {
            result[i] = b[j++];
        }

        Arrays.sort(result);

        if (result.length % 2 == 0) {
            int s = result.length / 2;
            float mediane = result[s] + result[s-1];

            return mediane / 2;
        } else {
            int mediane = result.length / 2;
            return result[mediane];
        }
    }
}
