import base.ListNode;
import middleoflinkedlist.MiddleOfLinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MiddleLinkedListTest {
    @Test
    public void should_return_null_when_input_is_null() {
        // Given
        MiddleOfLinkedList middle = new MiddleOfLinkedList();
        ListNode head = null;
        // When
        ListNode result = middle.middleNode(head);
        // Then
        assertNull(result);
    }

    @Test
    public void should_return_the_first_node_when_input_contains_one_elem() {
        // Given
        MiddleOfLinkedList middle = new MiddleOfLinkedList();
        ListNode head = new ListNode(1);
        // When
        ListNode result = middle.middleNode(head);
        // Then
        assertEquals(1, result.val);
    }

    @Test
    public void should_return_the_second_node_when_input_contains_2_elem() {
        // Given
        MiddleOfLinkedList middle = new MiddleOfLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        // When
        ListNode result = middle.middleNode(head);
        // Then
        assertEquals(2, result.val);
        assertNull(result.next);
    }

    @Test
    public void should_return_the_middle_node_when_input_has_odd_elements() {
        // Given
        MiddleOfLinkedList middle = new MiddleOfLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        // When
        ListNode result = middle.middleNode(head);
        // Then
        assertEquals(2, result.val);
        assertEquals(3, result.next.val);
        assertNull(result.next.next);
    }

    @Test
    public void should_return_the_middle_node_when_input_has_even_elements() {
        // Given
        MiddleOfLinkedList middle = new MiddleOfLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        // When
        ListNode result = middle.middleNode(head);
        // Then
        assertEquals(3, result.val);
        assertEquals(4, result.next.val);
        assertNull(result.next.next);
    }
}
