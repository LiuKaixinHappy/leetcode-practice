import minstack.MinStack;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinStackTest {
    @Test
    public void should_return_minus_3_when_minus_3_is_the_min() {
        // Given
        MinStack minStack = new MinStack();
        // When
        minStack.push(1);
        minStack.push(2);
        minStack.push(-3);
        // Then
        assertEquals(-3, minStack.getMin());
        assertEquals(-3, minStack.top());
    }

    @Test
    public void should_return_minus_1_when_minus_3_is_the_pop() {
        // Given
        MinStack minStack = new MinStack();
        // When
        minStack.push(1);
        minStack.push(2);
        minStack.push(-3);
        // Then
        assertEquals(-3, minStack.getMin());
        minStack.pop();
        assertEquals(2, minStack.top());
        assertEquals(1, minStack.getMin());
    }

    @Test
    public void should_return_minus_3_when_minus_3_is_pushed_twice_and_pop_once() {
        // Given
        MinStack minStack = new MinStack();
        // When
        minStack.push(1);
        minStack.push(-3);
        minStack.push(2);
        minStack.push(-3);
        // Then
        assertEquals(-3, minStack.getMin());
        minStack.pop();
        assertEquals(2, minStack.top());
        assertEquals(-3, minStack.getMin());
    }
}
