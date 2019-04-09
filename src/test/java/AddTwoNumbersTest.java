import addtwonumbers.AddTwoNumbers;
import addtwonumbers.ListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AddTwoNumbersTest {

    @Test
    public void should_cal_right_when_two_inputs_have_same_length_and_no_carry() {
        // Given 456 + 123 = 579
        ListNode l1 = new ListNode(6);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(1);
        // When
        AddTwoNumbers add = new AddTwoNumbers();
        ListNode result = add.addTwoNumbers(l1, l2);
        // Then
        assertEquals(9, result.val);
        assertEquals(7, result.next.val);
        assertEquals(5, result.next.next.val);
        assertEquals(null, result.next.next.next);
    }

    @Test
    public void should_cal_right_when_two_inputs_length_is_not_same_and_no_carry() {
        // Given 456 + 23 = 479
        ListNode l1 = new ListNode(6);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(2);
        // When
        AddTwoNumbers add = new AddTwoNumbers();
        ListNode result = add.addTwoNumbers(l1, l2);
        // Then
        assertEquals(9, result.val);
        assertEquals(7, result.next.val);
        assertEquals(4, result.next.next.val);
        assertEquals(null, result.next.next.next);
    }

    @Test
    public void should_cal_right_when_two_inputs_length_is_same_and_have_carry() {
        // Given 56 + 84 = 140
        ListNode l1 = new ListNode(6);
        l1.next = new ListNode(5);
        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(8);
        // When
        AddTwoNumbers add = new AddTwoNumbers();
        ListNode result = add.addTwoNumbers(l1, l2);
        // Then
        assertEquals(0, result.val);
        assertEquals(4, result.next.val);
        assertEquals(1, result.next.next.val);
        assertEquals(null, result.next.next.next);
    }

    @Test
    public void should_cal_right_when_two_inputs_length_is_not_same_and_have_carry() {
        // Given 456 + 84 = 540
        ListNode l1 = new ListNode(6);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(8);
        // When
        AddTwoNumbers add = new AddTwoNumbers();
        ListNode result = add.addTwoNumbers(l1, l2);
        // Then
        assertEquals(0, result.val);
        assertEquals(4, result.next.val);
        assertEquals(5, result.next.next.val);
        assertEquals(null, result.next.next.next);
    }
}
