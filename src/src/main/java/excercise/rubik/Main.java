package excercise.rubik;

import java.util.Scanner;

public class Main {

    /**
     * Refs:
     * https://levelup.gitconnected.com/simulating-rubik-cube-actions-with-java-10cf44bc6014
     */
    public static void main(String[] args) {



        // Init screen
        RubikCube cube = new RubikCube();

        // Input from player
        Scanner scanner = new Scanner(System.in);
        char input;

        // The game logic starts here
        boolean isRunning = true;

        while (isRunning) {
            cube.print();
            // Get input from player and do something
            switch (input = scanner.nextLine().charAt(0)) {
                case 'a':
                    cube.turnRowToRight(1);
                    break;
            }
        }
    }
}
