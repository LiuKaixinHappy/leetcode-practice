import base.ListNode;
import org.junit.Test;
import reverselinkedlist.ReverseLinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ReversedLinkedListTest {
    @Test
    public void should_return_null_when_input_is_null() {
        // Given
        ReverseLinkedList reverse = new ReverseLinkedList();
        // When
        ListNode result = reverse.reverseList(null);
        // Then
        assertNull(result);
    }

    @Test
    public void should_return_the_head_when_input_contains_only_one_elem() {
        // Given
        ReverseLinkedList reverse = new ReverseLinkedList();
        // When
        ListNode result = reverse.reverseList(new ListNode(1));
        // Then
        assertEquals(1, result.val);
        assertNull(result.next);
    }

    @Test
    public void should_return_the_reversed_list_when_input_contains_more_than_one_elem() {
        // Given
        ReverseLinkedList reverse = new ReverseLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        // When
        ListNode result = reverse.reverseList(head);
        // Then
        assertEquals(2, result.val);
        assertEquals(1, result.next.val);
        assertNull(result.next.next);
    }
}
