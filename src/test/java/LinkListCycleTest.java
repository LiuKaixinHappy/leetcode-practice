import base.ListNode;
import linklistcycle.LinkListCycle;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LinkListCycleTest {
    @Test
    public void should_return_false_when_1_element_without_cycle() {
        // Given
        ListNode head = new ListNode(0);
        LinkListCycle judger = new LinkListCycle();
        // When
        boolean result = judger.hasCycle(head);
        // Then
        assertFalse(result);
    }

    @Test
    public void should_return_true_when_1_element_with_cycle() {
        // Given
        ListNode head = new ListNode(0);
        head.next = head;
        LinkListCycle judger = new LinkListCycle();
        // When
        boolean result = judger.hasCycle(head);
        // Then
        assertTrue(result);
    }

    @Test
    public void should_return_false_when_2_element_without_cycle() {
        // Given
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        LinkListCycle judger = new LinkListCycle();
        // When
        boolean result = judger.hasCycle(head);
        // Then
        assertFalse(result);
    }

    @Test
    public void should_return_true_when_2_element_with_cycle() {
        // Given
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = head;
        LinkListCycle judger = new LinkListCycle();
        // When
        boolean result = judger.hasCycle(head);
        // Then
        assertTrue(result);
    }

    @Test
    public void should_return_true_when_3_element_with_cycle() {
        // Given
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = head.next;
        LinkListCycle judger = new LinkListCycle();
        // When
        boolean result = judger.hasCycle(head);
        // Then
        assertTrue(result);
    }

    @Test
    public void should_return_false_when_null() {
        // Given
        ListNode head = null;
        LinkListCycle judger = new LinkListCycle();
        // When
        boolean result = judger.hasCycle(head);
        // Then
        assertFalse(result);
    }
}
