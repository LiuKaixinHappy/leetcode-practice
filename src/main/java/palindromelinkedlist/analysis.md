# 234. Palindrome Linked List

## 要求

用链表实现对回文数的判断。

例：
```
Input: 1->2
Output: false

Input: 1->2->2->1
Output: true
```
## 分析
使用快慢指针，快指针每次移动2个节点，慢指针移动1个节点，并在移动时将链条顺序逆转。

时间复杂度：O(n) 

空间复杂度：O(1)

## 特殊情况及边界（测试用例）
考虑元素个数

- 奇数个
- 偶数个

## 实现

```java
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
```

## 总结
1. 特别注意空指针问题。
