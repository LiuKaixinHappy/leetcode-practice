import implementqueueusingstacks.ImplementQueueUsingStacks;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImplementQueueUsingStacksTest {
    @Test
    public void should_return_1_when_push_1_push_2_pop_peek() {
        // Given
        ImplementQueueUsingStacks queue = new ImplementQueueUsingStacks();
        // When
        queue.push(1);
        queue.push(2);
        queue.pop();
        // Then
        assertEquals(2, queue.peek());
    }

    @Test
    public void should_return_2_when_push_1_push_2_peek() {
        // Given
        ImplementQueueUsingStacks queue = new ImplementQueueUsingStacks();
        // When
        queue.push(1);
        queue.push(2);
        // Then
        assertEquals(1, queue.peek());
    }

    @Test
    public void should_return_2_when_push_1_pop_push_2_peek() {
        // Given
        ImplementQueueUsingStacks queue = new ImplementQueueUsingStacks();
        // When
        queue.push(1);
        queue.pop();
        queue.push(2);
        // Then
        assertEquals(2, queue.peek());
    }
}
