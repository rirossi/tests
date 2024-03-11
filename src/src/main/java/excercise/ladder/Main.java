package excercise.ladder;

public class Main {

    /**
     * Given a Ladder of N steps, considering you can climb of either 1 step or 2 steps at the time,
     * calculate how many calculation you can get to the top.
     *
     * e.g.
     * 3 steps : 1,1,1 + 1,2 + 2,1
     * 4 steps : 1,1,1,1 + 2,1,1 + 1,2,1, + 1,1,2 + 2,2
     */

    public static void main(String[] argv) {

        int N = 10;

        System.out.println(getSteps(N));
        System.out.println(getStepsWithArray(N));

    }

    public static int getSteps(int count) {
        if (count <= 0) {
            return 0;
        }

        if (count <= 2) {
            return count;
        }

        return getSteps(count -1) + getSteps(count -2);
    }

    public static int getStepsWithArray(int count) {
        int[] array = new int[count];

        array[0] = 1;
        array[1] = 2;
        for (int i = 2; i < array.length; i++) {
            array[i] = array[i-1] + array[i-2];
        }

        return array[count-1];
    }
}
