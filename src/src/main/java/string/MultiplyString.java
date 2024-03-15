package string;

public class MultiplyString {

    /**
     * Solution : from most left to right iterate both arrays and add the result of the multiplication into the
     * i + j + 1 index. Iterate through the result array to carry over the rest.
     * @param argv
     */


    public static void main(String[] argv) {

        System.out.println(multiply2("123", "456"));
    }

    public static String multiply2(final String n1, final String n2) {

        int SIZE = n1.length() + n2.length();

        int[] result = new int[SIZE];

        // - - 9 1
        // iterate through n2 end to start
        for (int j = n2.length() - 1; j >= 0; j--) {

            // iterate through n1 end to start
            for (int i = n1.length() - 1; i >= 0; i--) {
                int value = Integer.parseInt("" + n1.charAt(i)) * Integer.parseInt("" + n2.charAt(j));
                int pos = i + j + 1;
                result[pos] += value;
            }
        }

        // Carries over the rest
        for (int i = result.length - 1; i > 0; i--) {

            int value = result[i];

            if (value >= 10) {
                result[i] = value % 10;
                result[i - 1] += value / 10;
            }
        }

        final StringBuffer buffer = new StringBuffer("");

        for (int i : result) {
                buffer.append(i);
        }

        while (buffer.length() != 0 && buffer.charAt(0) == '0')
        buffer.deleteCharAt(0);

        return buffer.toString();
    }


    public static String multiply(final String n1, final String n2) {

        int SIZE = n1.length() + n2.length();

        int[] result = new int[SIZE];


        /**
         *      99
         *      99
         *      ----------
         * r   88
         *     891
         *    891
         *     ======
         *    9801
         */


        // - - 9 1
        // iterate through n2 end to start
        for (int j = n2.length()-1; j>=0; j--) {

            int rest = 0;

            // iterate through n1 end to start
            for (int i = n1.length()-1; i>=0; i--) {

                int value = Integer.parseInt(""+n1.charAt(i)) * Integer.parseInt(""+n2.charAt(j));

                int pos = i + j + 1;

                int sum = result[pos] + value;
                // set the most right as the divident of current sum
                result[pos] = sum % 10;
                // add rest to left value if rest is available
                result[pos - 1] += sum / 10;
            }

            if (rest > 0) {
                result[0] = rest;
            }
        }

        final StringBuffer buffer = new StringBuffer("");
        for (int i : result) {
            buffer.append(i);
        }
        return buffer.toString();
    }


    public static String compute(int[][] matrix, int SIZE) {
        final StringBuffer sb = new StringBuffer("");
        int rest = 0;
        for (int col=SIZE-1; col>=0; col--) {

            int partial = rest;
            for (int line=SIZE-1; line>=0; line--) {
                partial += matrix[line][col];
            }
            int value = partial % 10;
            rest = partial / 10;
            sb.append(value);
        }

        final String resiult = sb.reverse().toString();
        return resiult.replaceFirst("^0+(?!$)", "");
    }


}
