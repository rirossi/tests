package excercise.sudoku;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] argv) {
        final char[][] board= new char[][]{
                {'5','3','.','.','.','.','.','3','.'},
                {'6','.','.','1','9','5','.','.','3'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','.'},
                {'.','.','.','.','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','5','.','.','2','8','.'},
                {'.','.','.','.','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println("Sudoku Test");
        System.out.println(check(board));
        System.out.println("Done.");
    }

    public static boolean check(char[][] board) {
        int[] found = new int[9];
        Arrays.fill(found, 0);

        // check all line
        for (int i = 0; i<9; i++) {
            if(!check(board[i])) {
                return false;
            }
        }

        for (int i = 0; i<9; i++) {
            if(!check(readColumn(board, i))) {
                return false;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j=0; j < 3; j++ ) {
                if (!check(readSquare(board, i * 3, j * 3))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static char[] readColumn(char[][] board, int index) {
        IntStream.range(0, 9)
                .boxed()
                .map(i -> board[i][index])
                .collect(Collectors.toList());
        char[] array = new char[9];

        for (int i = 0; i< 9; i++) {
            array[i] = board[i][index];
        }

        return array;
    }

    public static char[] readSquare(char[][] board, int startI, int startJ) {
        int index = 0;
        char[] array = new char[9];
        for (int i = startI; i< startI + 3; i++) {
            for (int j = startJ; j< startJ + 3; j++) {
                array[index++] = board[i][j];
            }
        }

        return array;
    }

    public static boolean check(char[] line) {
        int[] found = new int[9];
        Arrays.fill(found, 0);

        for (int index = 0; index < 9; index ++) {
            char cell = line[index];
            if (cell!= '.') {
                int value = Integer.valueOf(Character.valueOf(cell).toString());
                if (found[value-1] == 1) {
                    return false;
                } else {
                    found[value-1] = 1;
                }
            }
        }

        return true;
    }
}
