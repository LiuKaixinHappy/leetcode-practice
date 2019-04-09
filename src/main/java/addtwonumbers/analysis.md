# 2. Add Two Numbers

#### 要求

- 输入：两个非空链表
- 输出：链表，逆序存储输入链表中数字的和

备注：
- 输入链表非空，每个节点存储一个数字，是一个完整数字的逆序，如456，存为6->5->4
- 数字不会以0开头，除非是0

例：
```
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
```

#### 分析

有两种思路：
- 读出两个链表中的数字，求和，再存入链表。
    - 读数：O(n)
    - 求和：O(1)
    - 存入链表：O(n)
- 模拟列竖式计算两数和，从第一个节点开始计算两数合，计算后续节点时把进位带上。
    - 遍历两数：O(n)
    
两种思路的时间复杂度与空间复杂度均为O(n),但是思路1比思路2遍历次数多，所以时间复杂度更高。

空间复杂度主要在新建了一个链表存储结果。

思路1有一个局限：求和用了整数求和，限定了位数，如果超出整数范围则会出错，且数越大越复杂。

思路2完全模拟了人工计算两个数和的场景，是很好的抽象，因此用思路2。

#### 边界及特殊情况（思考测试用例）
主要考虑的有两数字的长度，以及是否存在进位，对应四种情况：
- A:l1与l2长度一致，无进位
- B:l1与l2长度一致，有进位
- C:l1与l2长度不一致，无进位
- D:l1与l2长度不一致，有进位

为了使代码最大限度不重复（步骤统一），可以把「长度不一致」当作长度一致，只不过值为0；可以把进位当作每一位都有进位，只不过有的进位为0。

需要注意情况，最后一位的进位如果大于0，说明结果比输入要多一位，要做特殊处理。
#### 实现

```java
public base.ListNode addTwoNumbers(base.ListNode l1, base.ListNode l2) {
        base.ListNode result = new base.ListNode(0);
        base.ListNode l1P = l1;
        base.ListNode l2P = l2;
        base.ListNode resultP = result;
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
            resultP.next = new base.ListNode(units);
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
            resultP.next = new base.ListNode(carry);
        }
        return result.next;
    }
```

#### 总结（接上一个练习）

1. 考虑各种情况，也就是TDD中的先思考测试用例，从最简单的一个下手，可能没有时间去重构，因此需要纵观测试用例，直接考虑普适情况。