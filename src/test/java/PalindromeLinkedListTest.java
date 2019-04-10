import base.ListNode;
import org.junit.Test;
import palindromelinkedlist.PalindromeLinkedList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class PalindromeLinkedListTest {
    @Test
    public void should_return_true_when_list_has_one_elem() {
        // Given
        ListNode head = new ListNode(1);
        PalindromeLinkedList judger = new PalindromeLinkedList();
        // When
        boolean result = judger.isPalindrome(head);
        // Then
        assertTrue(result);
    }

    @Test
    public void should_return_true_when_list_is_ull() {
        // Given
        ListNode head = null;
        PalindromeLinkedList judger = new PalindromeLinkedList();
        // When
        boolean result = judger.isPalindrome(head);
        // Then
        assertTrue(result);
    }

    @Test
    public void should_return_true_when_list_has_2_same_elements() {
        // Given
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        PalindromeLinkedList judger = new PalindromeLinkedList();
        // When
        boolean result = judger.isPalindrome(head);
        // Then
        assertTrue(result);
    }

    @Test
    public void should_return_false_when_list_has_2_diff_elements() {
        // Given
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        PalindromeLinkedList judger = new PalindromeLinkedList();
        // When
        boolean result = judger.isPalindrome(head);
        // Then
        assertFalse(result);
    }

    @Test
    public void should_return_true_when_list_has_3_elements_and_palindrome() {
        // Given
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        PalindromeLinkedList judger = new PalindromeLinkedList();
        // When
        boolean result = judger.isPalindrome(head);
        // Then
        assertTrue(result);
    }

    @Test
    public void should_return_true_when_list_has_3_elements_and_not_palindrome() {
        // Given
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        PalindromeLinkedList judger = new PalindromeLinkedList();
        // When
        boolean result = judger.isPalindrome(head);
        // Then
        assertFalse(result);
    }

    @Test
    public void should_return_true_when_list_has_4_elements_and_palindrome() {
        // Given
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        PalindromeLinkedList judger = new PalindromeLinkedList();
        // When
        boolean result = judger.isPalindrome(head);
        // Then
        assertTrue(result);
    }

    @Test
    public void should_return_true_when_list_has_4_elements_and_not_palindrome() {
        // Given
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(1);
        PalindromeLinkedList judger = new PalindromeLinkedList();
        // When
        boolean result = judger.isPalindrome(head);
        // Then
        assertFalse(result);
    }
}
