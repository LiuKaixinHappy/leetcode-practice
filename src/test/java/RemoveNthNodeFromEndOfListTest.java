import base.ListNode;
import org.junit.Test;
import removeNthNode.RemoveNthNodeFromEndOfList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class RemoveNthNodeFromEndOfListTest {
    @Test
    public void should_remove_the_2th_node_from_the_end_when_n_is_2() {
        // Given
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 2; i <= 5; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        // When
        RemoveNthNodeFromEndOfList rm = new RemoveNthNodeFromEndOfList();
        ListNode result = rm.removeNthFromEnd(head, 2);
        // Then
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(5, result.next.next.next.val);
    }

    @Test
    public void should_remove_the_1th_node_from_the_end_when_n_is_1() {
        // Given
        ListNode head = new ListNode(1);

        // When
        RemoveNthNodeFromEndOfList rm = new RemoveNthNodeFromEndOfList();
        ListNode result = rm.removeNthFromEnd(head, 1);
        // Then
        assertNull(result);
    }

    @Test
    public void should_remove_head_node_from_the_end_when_list_length_and_n_are_both_2() {
        // Given
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);

        // When
        RemoveNthNodeFromEndOfList rm = new RemoveNthNodeFromEndOfList();
        ListNode result = rm.removeNthFromEnd(head, 2);
        // Then
        assertEquals(2, result.val);
    }
}
