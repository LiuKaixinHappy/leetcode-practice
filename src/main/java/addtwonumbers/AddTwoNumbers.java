package addtwonumbers;

import base.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode l1P = l1;
        ListNode l2P = l2;
        ListNode resultP = result;
        int carry = 0;
        int l1Val, l2Val;
        while (true) {
            if (l1P == null && l2P == null) {
                break;
            }
            l1Val = l1P == null ? 0 : l1P.val;
            l2Val = l2P == null ? 0 : l2P.val;
            int sum = l1Val + l2Val + carry;
            int units = sum % 10;
            resultP.next = new ListNode(units);
            carry = sum / 10;
            if (l1P != null) {
                l1P = l1P.next;
            }
            if (l2P != null) {
                l2P = l2P.next;
            }
            resultP = resultP.next;
        }
        if (carry > 0) {
            resultP.next = new ListNode(carry);
        }
        return result.next;
    }
}
