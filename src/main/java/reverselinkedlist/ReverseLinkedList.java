package reverselinkedlist;

import base.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preP = null;
        ListNode curP = head;
        ListNode nxtP = head;
        while(curP != null) {
            nxtP = curP.next;
            curP.next = preP;
            preP = curP;
            curP = nxtP;
        }
        return preP;
    }
}
