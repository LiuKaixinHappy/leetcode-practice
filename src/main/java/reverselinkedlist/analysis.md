# 206. Reverse Linked List

## 要求

- 输入：链表
- 输出：反向链表

备注：用递归与迭代分别实现
## 分析
- 迭代：

    设置三个指针，遍历链表，先记录cur的next，然后cur的next指向pre，另pre=cur，cur=next，直到cur=null，返回pre。

- 递归：
    重复的点在于旧链条和新节点，新节点指向旧链条，直到就旧链条为null，新节点就是新链条的head。

时间复杂度O(n)，空间复杂度O(1)。

## 特殊情况及边界（测试用例）
考虑元素个数
- 空
- 一个元素
- 两个以上元素

## 实现
- 迭代
```java
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
```
- 递归
```java
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
```

## 总结

1. 涉及多个指针的，先在纸上画，画完再写程序。
2. 涉及多个指针的，要注意元素个数对其的影响。