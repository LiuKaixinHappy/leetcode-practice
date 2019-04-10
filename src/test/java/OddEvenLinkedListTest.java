import base.ListNode;
import oddevenlinkedlist.OddEvenLinkedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class OddEvenLinkedListTest {
    @Test
    public void should_return_null_when_input_is_null() {
        // Given
        OddEvenLinkedList oddEven = new OddEvenLinkedList();
        ListNode head = null;
        // When
        ListNode result = oddEven.oddEvenList(head);
        // Then
        assertNull(result);
    }

    @Test
    public void should_return_1_when_list_is_1() {
        // Given
        OddEvenLinkedList oddEven = new OddEvenLinkedList();
        ListNode head = new ListNode(1);
        // When
        ListNode result = oddEven.oddEvenList(head);
        // Then
        assertEquals(1, result.val);
    }

    @Test
    public void should_return_1_2_when_list_is_1_2() {
        // Given
        OddEvenLinkedList oddEven = new OddEvenLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        // When
        ListNode result = oddEven.oddEvenList(head);
        // Then
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
    }

    @Test
    public void should_return_1_3_2_when_list_is_1_2_3() {
        // Given
        OddEvenLinkedList oddEven = new OddEvenLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        // When
        ListNode result = oddEven.oddEvenList(head);
        // Then
        assertEquals(1, result.val);
        assertEquals(3, result.next.val);
        assertEquals(2, result.next.next.val);
    }

    @Test
    public void should_return_1_3_2_4when_list_is_1_2_3_4() {
        // Given
        OddEvenLinkedList oddEven = new OddEvenLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        // When
        ListNode result = oddEven.oddEvenList(head);
        // Then
        assertEquals(1, result.val);
        assertEquals(3, result.next.val);
        assertEquals(2, result.next.next.val);
        assertEquals(4, result.next.next.next.val);
    }

}
