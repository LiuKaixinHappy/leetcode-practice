# 19. Remove Nth Node From End of List

## 要求

- 输入：链表，移除位数n
- 输出：移除后的链表

备注：n一定合法

要求：用一次遍历

例：
```
Given linked list: 1->2->3->4->5, and n = 2.

After removing the second node from the end, the linked list becomes 1->2->3->5.
```
## 分析
设置两个间隔为n的指针，一起移动，知道其中一个移动到末尾(null)。

时间复杂度：O(n)，空间复杂度：O(1)

## 特殊情况及边界（测试用例）
本以为没有坑，但是忽略了下面两个特殊情况：
- 链表只有1个元素，移除；
- 链表有两个元素，移除head；

上述两种类型的情况其实可以用添加哨兵的方式解决：设置一个dummyHead

## 实现

```java
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
```

## 总结

1. 解决链表问题时考虑只有一个元素及head被移除的情况，通常需要添加哨兵