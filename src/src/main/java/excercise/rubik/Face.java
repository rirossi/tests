package excercise.rubik;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Face {

    private int[][] values;

    public Face(int value) {
        // OK but not elegant.
        // int[] defaultValue = {value, value, value};

        int[] defaultValue = IntStream
                .generate(() -> value)
                .limit(3).toArray();

        values = IntStream.range(0,3)
                .boxed()
                .map(index -> defaultValue.clone())
                .toArray(int[][]::new);
    }

    public void turnClockWise() {

        // Switch row and columns as per below
        // r1 -> c3
        // r2 -> c2
        // r3 -> c1
        values = IntStream.range(0, 3)
                .boxed()
                .map(integer -> getColumn(2 - integer))
                .toArray(int[][]::new);
    }

    public void turnAntiClockWise() {

        // Switch row and columns as per below
        // r1 -> c1 reversed
        // r2 -> c2 reversed
        // r3 -> c3 reversed
        values = IntStream.range(0, 3)
                .boxed()
                .map(integer -> getRow(integer))
                .toArray(int[][]::new);
    }

    private int[] reverse(int[] array) {
        int size = array.length;

        return IntStream.range(1, size)
                .boxed()
                .mapToInt(integer -> array[size - integer])
                .toArray();
    }

    public int[] getRow(int rowIndex) {
        check(rowIndex);

        return values[rowIndex];
    }

    public int[] getColumn(int index) {
        check(index);

        return new int[] { values[0][index-1], values[1][index-1], values[2][index-1] };
    }

    public void setRow(int row, int[] rowValue) {
        values[row] = rowValue;
    }

    private void check(int index) {
        if (index < 1 || index > 3) {
            throw new IllegalArgumentException();
        }
    }
}
