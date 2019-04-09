package removeNthNode;
import base.ListNode;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p1Pre = dummyHead;
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 0; i < n; i++) {
            p2 = p2.next;
        }
        while (p2 != null) {
            p1Pre = p1;
            p1 = p1.next;
            p2 = p2.next;
        }

        p1Pre.next = p1.next;
        return dummyHead.next;
    }
}
