package palindromelinkedlist;

import base.ListNode;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode preS = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode nxt = slow.next;
            slow.next = preS;
            preS = slow;
            slow = nxt;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while(slow != null && preS != null) {
            if (preS.val != slow.val) {
                return false;
            }
            preS = preS.next;
            slow = slow.next;
        }
        return true;
    }
}
