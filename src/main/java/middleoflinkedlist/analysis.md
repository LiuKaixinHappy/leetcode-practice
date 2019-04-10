# 876. Middle of the Linked List

## 要求

- 输入：链表
- 输出：链表中间节点为首的链表

备注：
- 如果中间节点有两个，从第二个开始

## 分析
使用快慢指针，当快指针不为空（偶数个节点）且快指针的next不为空（奇数个节点）时，快指针移动两个节点，慢指针移动一个节点。

时间复杂度：O(n) 

空间复杂度：O(1)

## 特殊情况及边界（测试用例）
考虑元素个数

- 空
- 奇数个
- 偶数个

## 实现

```java
public ListNode middleNode(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while(fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
    }
    return slow;
}
```

## 总结
1. 快慢指针循环条件：奇数个节点，快指针的next不为空；偶数个节点，快指针不为空。
