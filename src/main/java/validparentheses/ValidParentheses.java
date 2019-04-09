package validparentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();

        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (!map.containsKey(cur)) {
                stack.push(cur);
            } else if (!stack.empty() && map.get(cur) == stack.peek()) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.empty();
    }
}
