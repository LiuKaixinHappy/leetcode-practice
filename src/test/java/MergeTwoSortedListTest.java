import base.ListNode;
import mergetwosortedlist.MergeTwoSortedList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MergeTwoSortedListTest {
    @Test
    public void should_return_merged_list_when_input_lists_have_different_length() {
        // Given
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(5);

        MergeTwoSortedList merge = new MergeTwoSortedList();
        // When
        ListNode result = merge.mergeTwoLists(l1, l2);
        // Then
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(4, result.next.next.next.val);
        assertEquals(5, result.next.next.next.next.val);
    }

    @Test
    public void should_return_merged_list_when_input_lists_have_same_length() {
        // Given
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(5);
        l2.next.next = new ListNode(8);

        MergeTwoSortedList merge = new MergeTwoSortedList();
        // When
        ListNode result = merge.mergeTwoLists(l1, l2);
        // Then
        assertEquals(1, result.val);
        assertEquals(2, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(4, result.next.next.next.val);
        assertEquals(5, result.next.next.next.next.val);
        assertEquals(8, result.next.next.next.next.next.val);
    }

    @Test
    public void should_return_merged_list_when_input_lists_have_same_element() {
// Given
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);

        MergeTwoSortedList merge = new MergeTwoSortedList();
        // When
        ListNode result = merge.mergeTwoLists(l1, l2);
        // Then
        assertEquals(1, result.val);
        assertEquals(1, result.next.val);
        assertEquals(3, result.next.next.val);
        assertEquals(3, result.next.next.next.val);
        assertEquals(4, result.next.next.next.next.val);
    }

    @Test
    public void should_return_merged_list_when_input_lists_contains_null_list() {
        // Given
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(4);

        ListNode l2 = null;

        MergeTwoSortedList merge = new MergeTwoSortedList();
        // When
        ListNode result = merge.mergeTwoLists(l1, l2);
        // Then
        assertEquals(1, result.val);
        assertEquals(3, result.next.val);
        assertEquals(4, result.next.next.val);
    }
}
