package basiccalculator;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        return calculateRecursively(s, 0)[0];
    }

    private int[] calculateRecursively(String s, int start) {
        int number = 0;
        int result = 0;
        int sign = 1;
        int i = start;
        for (; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == ' ') {
                continue;
            } else if (Character.isDigit(cur)) {
                number = number * 10 + cur - '0';
            } else if (cur == '+') {
                result += sign * number;
                sign = 1;
                number = 0;
            } else if (cur == '-') {
                result += sign * number;
                sign = -1;
                number = 0;
            } else if (cur == '(') {
                int[] resultAndIndex = calculateRecursively(s, i + 1);
                result += sign * resultAndIndex[0];
                i = resultAndIndex[1];
            } else if (cur == ')') {
                break;
            }
        }
        if (number != 0) {
            result += sign * number;
        }
        return new int[]{result, i};
    }

    private int caluculateInteratively(String s) {
        int number = 0;
        int result = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur)) {
                number = number * 10 + cur - '0' ;
            } else if (cur == '+'){
                result += sign * number;
                sign = 1;
                number = 0;
            } else if (cur == '-') {
                result += sign * number;
                sign = -1;
                number = 0;
            } else if (cur == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                number = 0;
                sign = 1;
            } else if (cur == ')') {
                result += sign * number;
                number = 0;
                int lastSign = stack.pop();
                int lastResult = stack.pop();
                result = lastResult + lastSign * result;
            }
        }
        if (number != 0) {
            result += sign * number;
        }
        return result;
    }
}
