package minstack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    public void push(int x) {
        if (min >= x) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (!stack.empty()) {
            if (stack.pop() == min) {
                min = stack.pop();
            }
        }
    }

    public int top() {
        if (!stack.empty()) {
            return stack.peek();
        }
        return -1;
    }

    public int getMin() {
        return min;
    }
}
