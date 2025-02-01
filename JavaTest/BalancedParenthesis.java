package JavaTest;

import java.util.Stack;

public class BalancedParenthesis {

    public static void main(String[] args) {
        String input1 = "((Abc)((de)";
        String input2 = "(((abc)";

        System.out.println(removeUnbalanced(input1));

    }

    private static String removeUnbalanced(String input) {

        Stack<Integer> stack = new Stack<>();
        StringBuilder str = new StringBuilder(input);

        for (int i = 0; i < input.length(); i++) {

            char c = input.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    str.setCharAt(i, ' ');
                } else {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            str.setCharAt(stack.pop(), ' ');
        }

        return str.toString().replaceAll(" ", "");
    }
}
