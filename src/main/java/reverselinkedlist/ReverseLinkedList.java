package reverselinkedlist;

import base.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preP = null;
        ListNode curP = head;
        ListNode nxtP;
        while(curP != null) {
            nxtP = curP.next;
            curP.next = preP;
            preP = curP;
            curP = nxtP;
        }
        return preP;
    }

    public ListNode reverseListRecursively(ListNode head) {
        return reverse(head, null);
    }

    private ListNode reverse(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return reverse(next, head);
    }

}
