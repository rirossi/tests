package arrays;
import java.util.*;
import java.util.stream.IntStream;

public class LeapGame {

    public static boolean canWin(int leap, int[] game) {
        return canWin(0, leap, game);
    }

    public static boolean canWin(int start, int leap, int[] game) {
        // step backward from 0
        if (start < 0) {
            return false;
        }

        // previous step failed
        if (game[start] == 1) {
            return false;
        }

        // overboard
        if (leap + start > game.length - 1) {
            return true;
        }

        // we are at the end and is not 1
        if (start == game.length -1) {
            return true;
        }

        // disable this combination
        game[start] = 1;

        return canWin(start -1, leap, game) ||
                canWin(start + 1, leap, game) ||
                canWin(start + leap, leap, game);



    }

    private static int[] subarray(int index, int[] array) {
        int[] newArray = new int[array.length - index];

        System.arraycopy(array, index, newArray, 0, newArray.length);

        return newArray;
    }

    public static void main(String[] args) {

        int[] game = { 0, 0, 1, 0, 1, 1, 0, 1, 0 };
        int leap = 3;

        System.out.println( (canWin(leap, game)) ? "YES" : "NO" );


    }
}
