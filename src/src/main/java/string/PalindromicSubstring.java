package string;

public class PalindromicSubstring {

    // Given a string str, the task is to find the longest substring which is a palindrome.
    public static void main(String[] argv) {
        System.out.println("PalindromicSubstring Test");
        System.out.println(palindrome("babad"));
        System.out.println("Done.");
    }

    private static String palindrome(final String text) {
        String MAX = "";
        // iterate through each char within input
        for (int i=0; i<=text.length(); i++) {
            // Iterate thought upper bound for string
            for (int j=i+1; j<=text.length(); j++) {

                final String subText = text.substring(i, j);

                // Validate palindrome
                if (isPalindrome(subText)) {
                    if (MAX.length() < subText.length()) {
                        MAX = subText;
                    }
                }
            }
        }

        return MAX;
    }

    private static boolean isPalindrome(final String text) {
        // Can be optimised with a single for.
        return new StringBuffer(text).reverse().toString().equals(text);

    }
}
