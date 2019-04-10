# 21. Merge Two Sorted Lists

## 要求

- 输入：两个升序链表
- 输出：合并后的链表，升序


例：
```
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
```
## 分析
边走边合并。

时间复杂度：O(n)，空间复杂度：O(1)

## 特殊情况及边界（测试用例）
考虑长度与元素重复两种情况
- 长度不相同时，保证正确
- 元素重复时，保证正确

## 实现

```java
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
```

## 总结

1. 循环链表时，最好不要以p.next是否为空作为终止条件，因为p可能为空。
2. 做这种原地操作时，一定要注意先保存原链表指针的next，再操作。