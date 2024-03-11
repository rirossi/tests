package string;

import java.util.*;

public class LongestValidParenthesis {

    public static void main(String[] argv) {
        System.out.println("Template Test");
        System.out.println(longestParenthesisQ("(()"));
        System.out.println("Done.");
    }

    public static int longestParenthesisQ(final String input) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int ans = 0;
        for (int i = 0; i < input.length(); i++)
            //
            if (input.charAt(i) == '(') stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i);
                else ans = Math.max(ans, i - stack.peek());
            }
        return ans;

    }

    public static int longestParenthesis(final String input) {

        int longestSoFar = 0;
        int open = 0;
        int close = 0;

        for (int i = 0; i < input.length(); ++i) {
            if (input.charAt(i) == '(') {
                open ++;
            } else {
                close ++;
            }

            if (open == close) {
                longestSoFar = Math.max(longestSoFar, open + close);
            }

            if (close > open) {
                open = close = 0;
            }
        }

        longestSoFar = 0;

        for (int i = input.length()-1; i >= 0; --i) {

            if (input.charAt(i) == '(') {
                open ++;
            } else {
                close ++;
            }

            if (open == close) {
                longestSoFar = Math.max(longestSoFar, open + close);
            }

            if (open > close) {
                open = close = 0;
            }
        }

        return longestSoFar;

    }

}
