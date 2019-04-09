package linklistcycle;

import base.ListNode;

public class LinkListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null) {
            fast = fast.next;
            if (fast == null) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
