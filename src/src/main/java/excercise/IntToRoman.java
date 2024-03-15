package excercise;

public class IntToRoman {

    public static void main(String[] argv) {
        System.out.println(intToRoman(19));
    }

    public static String intToRoman(int num) {

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        final StringBuffer buffer = new StringBuffer("");

        int i = 0;
        while (num > 0) {
            if (num >= values[i]) {
                num -= values[i];
                buffer.append(romanNumerals[i]);
            } else {
                i ++;
            }
        }

        return buffer.toString();
    }
}
