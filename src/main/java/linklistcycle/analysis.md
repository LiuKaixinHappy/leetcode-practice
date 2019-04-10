# 141. Linked List Cycle

## 要求

- 输入：链表
- 输出：是否存在环

## 分析
使用快慢指针，如果快指针追上慢指针，则存在环。

时间复杂度：O(n)，空间复杂度：O(1)

## 特殊情况及边界（测试用例）
考虑元素个数，尤其是>2和<2，决定快指针是否为空。

- 空
- 1个元素
- 2个元素
- 多个元素

上述两种类型的情况其实可以用添加哨兵的方式解决：设置一个dummyHead

## 实现

```java
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
```

## 总结

1. 快慢指针判断环是很巧妙的思路。