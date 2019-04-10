# 328. Odd Even Linked List

#### 要求

将链表的奇数节点相连，再将偶数节点相连，置于奇数节点之后。

时间复杂度控制在O(n)，空间复杂度O(1)。

备注：
- 奇偶是指节点位置，不是节点中的数字。
- 第一个节点为奇数节点。

例：
```
Input: 1->2->3->4->5->NULL
Output: 1->3->5->2->4->NULL

Input: 2->1->3->5->6->4->7->NULL
Output: 2->3->6->7->1->5->4->NULL
```
#### 分析
使用奇数节点指针与偶数节点指针遍历链表，边遍历边更改指针。

时间复杂度：O(n) 

空间复杂度：O(1)

#### 特殊情况及边界（测试用例）
考虑元素个数

- 空
- 奇数个
- 偶数个

#### 实现

```java
public ListNode oddEvenList(ListNode head) {
    if (head == null) {
        return null;
    }
    ListNode evenHead = head.next;
    ListNode oddP = head;
    ListNode evenP = evenHead;
    while (evenP != null && evenP.next != null) {
        oddP.next = evenP.next;
        oddP = oddP.next;
        evenP.next = oddP.next;
        evenP = evenP.next;
    }
    oddP.next = evenHead;
    return head;
}
```
