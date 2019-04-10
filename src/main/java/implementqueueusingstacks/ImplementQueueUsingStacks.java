package implementqueueusingstacks;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();
    int inTop = 0;

    /**
     * Initialize your data structure here.
     */
    public ImplementQueueUsingStacks() {
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (in.isEmpty()) {
            inTop = x;
        }
        in.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (out.isEmpty()) {
            return inTop;
        }
        return out.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }
}
