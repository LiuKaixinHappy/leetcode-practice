package mergetwosortedlist;

import base.ListNode;

public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode dummyHead = new ListNode(0);
        ListNode dummyP = dummyHead;
        while(p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                dummyP.next = p1;
                p1 = p1.next;
            } else {
                dummyP.next = p2;
                p2 = p2.next;
            }
            dummyP = dummyP.next;
        }
        dummyP.next = p1 == null ? p2 : p1;
        return dummyHead.next;
    }
}
