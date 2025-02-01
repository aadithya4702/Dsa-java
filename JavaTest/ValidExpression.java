package JavaTest;

import java.util.Stack;

public class ValidExpression {

    public static void main(String[] args) {
        String s = "(3+5*(2-1)";

        System.out.println(checkExpValid(s));
        System.out.println(ValidExpressionStep(s));
    }

    private static boolean ValidExpressionStep(String s) {
        String maString = "[0-9+\\-*/() ]+";

        if (!s.matches(maString)) {
            return false;

        }
        if (!isParenthesisBal(s)) {
            return false;
        }
        return true;
    }

    private static boolean isParenthesisBal(String s) {
        Stack<Character> c = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                c.push(ch);
            } else if (ch == ')') {
                if (c.isEmpty()) {
                    return false;
                }
                c.pop();
            }
        }
        return c.isEmpty();
    }

    private static boolean checkExpValid(String s) {
        Stack<Character> stk = new Stack<>();
        boolean lastWasOperator = true; // To check if an operator appears at the beginning

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Check Parentheses
            if (c == '(') {
                stk.push(c);
                lastWasOperator = true; // '(' should be followed by a number or another '('
            } else if (c == ')') {
                if (stk.isEmpty() || stk.peek() != '(') {
                    return false; // No matching '('
                }
                stk.pop();
                lastWasOperator = false; // ')' should be followed by an operator or another ')'
            }

            // Check Operators
            if (c == '*' || c == '/' || c == '-' || c == '+') {
                // If operator is at the start or right after an opening parenthesis, it's
                // invalid
                if (lastWasOperator) {
                    return false;
                }

                // If operator is at the last position, it's invalid
                if (i == s.length() - 1) {
                    return false;
                }

                lastWasOperator = true;
            } else if (Character.isDigit(c)) {
                lastWasOperator = false; // Number should be followed by operator or ')'
            }
        }

        // Stack should be empty at the end (ensures all '(' are matched)
        return stk.isEmpty() && !lastWasOperator;
    }
}
