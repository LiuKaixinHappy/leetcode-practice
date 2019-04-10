package oddevenlinkedlist;

import base.ListNode;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode evenHead = head.next;
        ListNode oddP = head;
        ListNode evenP = evenHead;
        while (evenP != null && evenP.next != null) {
            oddP.next = evenP.next;
            oddP = oddP.next;
            evenP.next = oddP.next;
            evenP = evenP.next;
        }
        oddP.next = evenHead;
        return head;
    }
}
